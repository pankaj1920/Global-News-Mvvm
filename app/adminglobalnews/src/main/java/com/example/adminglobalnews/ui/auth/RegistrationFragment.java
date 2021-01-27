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
import android.widget.Toast;

import com.example.adminglobalnews.R;
import com.example.adminglobalnews.databinding.FragmentRegistrationBinding;
import com.example.adminglobalnews.model.register.RegisterModel;
import com.example.adminglobalnews.network.BaseClient;
import com.example.adminglobalnews.network.NewsApi;
import com.example.adminglobalnews.viewmodel.RegisterViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistrationFragment extends Fragment {

    FragmentRegistrationBinding binding;
    NavDirections action;
    EditText registerName, registerMobile, registerEmail, registerPassword, registerAddress;
    Button registerBtn;
    String name, mobile, email, password, address;
    RegisterViewModel viewModel;


    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_registration, container, false);
        binding = FragmentRegistrationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        registerName = binding.registerName;
        registerMobile = binding.registerMobile;
        registerEmail = binding.registerEmail;
        registerPassword = binding.registerPassword;
        registerAddress = binding.registerAddress;
        registerBtn = binding.registerBtn;


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = registerName.getText().toString().trim();
                mobile = registerMobile.getText().toString().trim();
                email = registerEmail.getText().toString().trim();
                password = registerPassword.getText().toString().trim();
                address = registerAddress.getText().toString().trim();


                viewModel.register(name, mobile, email, password, address);
//                signUp();
            }
        });

        observerViewModel();
    }

    private void observerViewModel() {

        viewModel.getRegisterResponse().observe(getViewLifecycleOwner(), new Observer<RegisterModel>() {
            @Override
            public void onChanged(RegisterModel registerModel) {

                if (registerModel.getStatus().equals("1")) {
                    Toast.makeText(getContext(), registerModel.getMessage(), Toast.LENGTH_SHORT).show();
                    action = RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment();
                    Navigation.findNavController(getView()).navigate(action);
                } else {
                    Toast.makeText(getContext(), "Something went wrong " + registerModel.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}