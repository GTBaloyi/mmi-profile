package com.mmi.profiles.model;

import org.springframework.web.multipart.MultipartFile;

public class RegisterUserModel {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private MultipartFile profilePicture;



    public RegisterUserModel(String firstName, String lastName,String username, String password,  MultipartFile profilePicture) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public MultipartFile getProfilePicture() {
        return profilePicture;
    }
}
