package com.mmi.profiles.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date", nullable = true)
    private Date endDate;

    @Column(name = "current_company")
    private boolean currentCompany;

    @Column(name = "position")
    private String position;

    @Column(name = "job_description")
    private String job_description;

    @ManyToOne
    @JoinColumn(name = "person")
    private Personal person;
}
