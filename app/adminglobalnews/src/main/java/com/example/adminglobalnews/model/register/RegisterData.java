package com.example.adminglobalnews.model.register;

public class RegisterData {
    private String id;
    private String name;
    private String mobile;
    private String otp;
    private String email;
    private String password;
    private String address;
    private String created_at;
    private String updated_at;

    public RegisterData(String id, String name, String mobile, String otp, String email, String password, String address, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.otp = otp;
        this.email = email;
        this.password = password;
        this.address = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
