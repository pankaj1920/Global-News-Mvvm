package com.example.adminglobalnews.ui.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminglobalnews.R;
import com.example.adminglobalnews.databinding.FragmentLoginBinding;
import com.example.adminglobalnews.model.login.MobileLoginModel;
import com.example.adminglobalnews.viewmodel.LoginViewModel;


public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    TextView registerTxt;
    Button loginBtn;
    EditText loginEdt;
    NavDirections action;
    String loginId;
    LoginViewModel loginViewModel;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false);
        binding = FragmentLoginBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        registerTxt = binding.registerTxt;
        loginBtn = binding.loginBtn;
        loginEdt = binding.loginEdt;


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginId = loginEdt.getText().toString();

                if (loginId.matches("[0-9]+")){
                    loginViewModel.mobileLogin(loginId);
                }else{
                    action = LoginFragmentDirections.actionLoginFragmentToVerifyPasswordFragment(loginId);
                    Navigation.findNavController(getView()).navigate(action);
                }
            }
        });

        registerTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action = LoginFragmentDirections.actionLoginFragmentToRegistrationFragment();
                Navigation.findNavController(getView()).navigate(action);
            }
        });

        observeViewModel();

    }

    private void observeViewModel() {

        loginViewModel.getMobileLoginResponse().observe(getViewLifecycleOwner(), new Observer<MobileLoginModel>() {
            @Override
            public void onChanged(MobileLoginModel mobileLoginModel) {
                if (mobileLoginModel.getStatus().equals("1")){
                    Toast.makeText(getContext(),mobileLoginModel.getMessage(), Toast.LENGTH_SHORT).show();
                    action = LoginFragmentDirections.actionLoginFragmentToVerifyOtpFragment(loginId);
                    Navigation.findNavController(getView()).navigate(action);

                }else {
                    Toast.makeText(getContext(), "Something went wrong "+ mobileLoginModel.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}