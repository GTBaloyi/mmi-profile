package com.mmi.profiles.model;

import java.util.*;

public class AllDetailsModel {
    private String name;

    private String surname;

    private String picturePath;

    private String aboutMe;

    private String interests;

    private String username;

    private List<EducationDetailsModel> education;

    public AllDetailsModel(String name, String surname, String picturePath, String aboutMe, String interests, String username, List<EducationDetailsModel> education) {
        this.name = name;
        this.surname = surname;
        this.picturePath = picturePath;
        this.aboutMe = aboutMe;
        this.interests = interests;
        this.username = username;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<EducationDetailsModel> getEducation() {
        return education;
    }

    public void setEducation(List<EducationDetailsModel> education) {
        this.education = education;
    }
}
