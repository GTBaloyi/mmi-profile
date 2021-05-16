package com.mmi.profiles.model;

import com.mmi.profiles.entity.Education;
import com.mmi.profiles.entity.Work;

public class AllDetailsModel {
    private String name;

    private String surname;

    private String picturePath;

    private String aboutMe;

    private String interests;

    private String username;

    private WorkDetailsModel work;

    private EducationDetailsModel education;

    public AllDetailsModel(String name, String surname, String picturePath, String aboutMe, String interests, String username, WorkDetailsModel work, EducationDetailsModel education) {
        this.name = name;
        this.surname = surname;
        this.picturePath = picturePath;
        this.aboutMe = aboutMe;
        this.interests = interests;
        this.username = username;
        this.work = work;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public String getInterests() {
        return interests;
    }

    public String getUsername() {
        return username;
    }

    public WorkDetailsModel getWork() {
        return work;
    }

    public EducationDetailsModel getEducation() {
        return education;
    }
}
