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
    private int institutionName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "endDate", nullable = true)
    private Date endDate;

    @Column(name = "completed")
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "person")
    private Personal person;
}
