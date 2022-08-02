package com.payments.b2b.app_base.network

import com.base.app.model.ErrorResponse
import com.base.app.model.State
import com.google.gson.Gson
import com.payments.b2b.app_base.listner_base.BaseIRepoListener
import com.payments.b2b.app_base.utils_base.BaseConstants
import com.payments.b2b.app_base.utils_base.Print
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException

/**
 * A repository which provides resource from local database as well as remote end point.
 *
 * [RESULT] represents the type for database.
 * [REQUEST] represents the type for network.
 */

abstract class NetworkBoundRepository<RESULT>(
    var iRepositoryListener: BaseIRepoListener?,
    private val isShowProgress: Boolean = true,
) {
    fun asFlow() = flow<State<RESULT>> {

        // Emit Loading State

        if (iRepositoryListener?.isNetworkConnected()!!) {

            if (isShowProgress) {
                iRepositoryListener?.showLoader()
            }

            // Emit Database content first
            // Fetch latest posts from remote
            val apiResponse: Response<RESULT>

            // Parse body
            val remoteData: RESULT?

            withContext(Dispatchers.IO) {

                apiResponse = fetchData()
                remoteData = apiResponse.body()
            }
            iRepositoryListener?.hideLoader()

            // Check for response validation
            if (apiResponse.isSuccessful && remoteData != null) {
                // Save posts into the persistence storage
                if (apiResponse.code() == BaseConstants.InternalHttpCode.SUCCESS || apiResponse.code() == BaseConstants.InternalHttpCode.ACCEPTED) {
                    emit(State.success(remoteData))
                    Print.log("Success => (NetworkBoundRepository) : ${apiResponse.message()}")
                } else {
                    emit(State.error(apiResponse.message()))
                    iRepositoryListener?.showErrorMessage(apiResponse.message())
                    Print.log("Error => (NetworkBoundRepository) : ${apiResponse.message()}")
                }
            } else if (apiResponse.code() == BaseConstants.InternalHttpCode.UNAUTHORIZED_CODE) {
                Print.log("UNAUTHORIZED Access")
            } else {
                // Something went wrong! Emit Error state.
                Print.log("Error Body : " + apiResponse.errorBody())
                Print.log("Body : " + apiResponse.body())
                val error: ErrorResponse? = getObjectFromJsonString(
                    apiResponse.errorBody().toString(),
                    ErrorResponse::class.java
                )

                error?.message?.let {
                    iRepositoryListener?.showErrorMessage(apiResponse.message())
                    Print.log("Something => (NetworkBoundRepository) : ${error.message!!}")
                    emit(State.error(error.message!!))
                }
            }
        }
    }.catch { e ->
        // Exception occurred! Emit error
        withContext(Dispatchers.Main) {
            iRepositoryListener?.hideLoader()
            e.message?.let { iRepositoryListener?.showErrorMessage(it) }
            emit(State.error(e.message!!))
            Print.log("Exception => (NetworkBoundRepository) : ${e.message!!}")
            e.printStackTrace()
        }
    }

    protected abstract suspend fun fetchData(): Response<RESULT>
}


private fun <T> getObjectFromJsonString(jsonString: String, classType: Class<T>): T? {
    try {
        val gson = Gson()
        return gson.fromJson(jsonString, classType)
    } catch (e: IOException) {
        e.printStackTrace()
    } catch (e: NullPointerException) {
        e.printStackTrace()
    }

    return null
}
