package com.chainbox.safaricom.careerstest.Entities;

import javax.persistence.*;

@Entity
@Table
public class Applications {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public int applicant_id;
    public int job_id;

    public Applications(int id, int applicant_id, int job_id) {
        this.id = id;
        this.applicant_id = applicant_id;
        this.job_id = job_id;
    }

    public Applications(int applicant_id, int job_id) {
        this.applicant_id = applicant_id;
        this.job_id = job_id;
    }

    public Applications() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(int applicant_id) {
        this.applicant_id = applicant_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }
}
