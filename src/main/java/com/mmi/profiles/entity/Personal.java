package com.mmi.profiles.entity;

import javax.persistence.*;

@Entity
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "picture_path")
    private String picturePath;

    @Column(name = "about_me")
    private String aboutMe;

    @Column(name = "interests")
    private String interests;

    @JoinColumn(name = "user_id")
    @OneToOne
    private User userId;

    public Personal(String name, String surname, String picturePath, String interests, String aboutMe, User userId) {
        this.name = name;
        this.surname = surname;
        this.picturePath = picturePath;
        this.aboutMe = aboutMe;
        this.interests = interests;
        this.userId = userId;
    }

    public Personal(){

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

    public int getId() {
        return id;
    }

    public User getUserId() {
        return userId;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public String getInterests() {
        return interests;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
