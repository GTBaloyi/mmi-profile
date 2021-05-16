package com.mmi.profiles.model;

public class PersonalDetailsModel {


    private String name;

    private String surname;

    private String picturePath;

    private String aboutMe;

    private String interests;

    private String username;

    public PersonalDetailsModel(String name, String surname, String picturePath, String aboutMe, String interests,String username) {
        this.name = name;
        this.surname = surname;
        this.picturePath = picturePath;
        this.aboutMe = aboutMe;
        this.interests = interests;
        this.username = username;
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
}
