package com.mmi.profiles.model;

import com.mmi.profiles.entity.Personal;

import javax.persistence.*;
import java.sql.Date;

public class EducationDetailsModel {
    private int id;
    private String username;
    private String qualification;
    private String institutionName;
    private Date startDate;
    private Date endDate;
    private boolean completed;

    public EducationDetailsModel(int id,String username, String qualification, String institutionName, Date startDate, Date endDate, boolean completed) {
        this.id = id;
        this.username = username;
        this.qualification = qualification;
        this.institutionName = institutionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getQualification() {
        return qualification;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getUsername() {
        return username;
    }
}
