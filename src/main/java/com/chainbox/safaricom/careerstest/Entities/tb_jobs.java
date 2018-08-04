package com.chainbox.safaricom.careerstest.Entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;


@Entity
@Table
public class tb_jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public int id;
    public String job_name;
    public String description;
    public String job_type;
    public String years_of_exprience;
    public String status;

    @DateTimeFormat
    public String interview_start_date;

    @DateTimeFormat
    public String interview_end_time;

    public tb_jobs() {
    }

    public tb_jobs(String job_name, String description, String job_type, String years_of_exprience, String status, String interview_start_date, String interview_end_time) {
        this.job_name = job_name;
        this.description = description;
        this.job_type = job_type;
        this.years_of_exprience = years_of_exprience;
        this.status = status;
        this.interview_start_date = interview_start_date;
        this.interview_end_time = interview_end_time;
    }

    public tb_jobs(int id){
        this.id=id;
    }

    public tb_jobs(int id,String job_name, String description, String job_type, String years_of_exprience, String status, String interview_start_date, String interview_end_time) {
        this.id = id;
        this.job_name = job_name;
        this.description = description;
        this.job_type = job_type;
        this.years_of_exprience = years_of_exprience;
        this.status = status;
        this.interview_start_date = interview_start_date;
        this.interview_end_time = interview_end_time;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getYears_of_exprience() {
        return years_of_exprience;
    }

    public void setYears_of_exprience(String years_of_exprience) {
        this.years_of_exprience = years_of_exprience;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInterview_start_date() {
        return interview_start_date;
    }

    public void setInterview_start_date(String interview_start_date) {
        this.interview_start_date = interview_start_date;
    }

    public String getInterview_end_time() {
        return interview_end_time;
    }

    public void setInterview_end_time(String interview_end_time) {
        this.interview_end_time = interview_end_time;
    }
}
