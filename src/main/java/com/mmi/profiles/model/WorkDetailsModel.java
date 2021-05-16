package com.mmi.profiles.model;

import com.mmi.profiles.entity.Personal;

import java.sql.Date;

public class WorkDetailsModel {
    private int id;
    private String companyName;
    private Date startDate;
    private Date endDate;
    private boolean currentCompany;
    private String position;
    private String job_description;

    public WorkDetailsModel(int id, String companyName, Date startDate, Date endDate, boolean currentCompany, String position, String job_description) {
        this.id = id;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentCompany = currentCompany;
        this.position = position;
        this.job_description = job_description;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isCurrentCompany() {
        return currentCompany;
    }

    public String getPosition() {
        return position;
    }

    public String getJob_description() {
        return job_description;
    }
}
