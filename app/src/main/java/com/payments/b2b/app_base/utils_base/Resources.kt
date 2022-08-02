package com.applaunch.talent.utils.extensions

import android.content.res.Resources
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

fun Resources.drawable(@DrawableRes id: Int) =
    ResourcesCompat.getDrawable(this, id, null)

fun Resources.color(@ColorRes id: Int) =
    ResourcesCompat.getColor(this, id, null)

