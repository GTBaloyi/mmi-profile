package com.mmi.profiles.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "institution_name")
    private String institutionName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "completed")
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "person")
    private Personal person;

    public Education(){

    }

    public Education(String qualification, String institutionName, Date startDate, Date endDate, boolean completed, Personal person) {
        this.qualification = qualification;
        this.institutionName = institutionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.completed = completed;
        this.person = person;
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

    public Personal getPerson() {
        return person;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setPerson(Personal person) {
        this.person = person;
    }
}
