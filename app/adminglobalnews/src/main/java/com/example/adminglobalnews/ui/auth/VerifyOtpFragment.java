package com.example.adminglobalnews.ui.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.adminglobalnews.R;
import com.example.adminglobalnews.databinding.FragmentVerifyOtpBinding;


public class VerifyOtpFragment extends Fragment {

    FragmentVerifyOtpBinding binding;
    EditText loginOtp;
    Button LoginVerifyOtp;
    NavDirections action;
    String otp;

    public VerifyOtpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentVerifyOtpBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loginOtp = binding.loginOtp;
        LoginVerifyOtp = binding.LoginVerifyOtp;

        LoginVerifyOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otp = loginOtp.getText().toString().trim();
            }
        });

    }
}