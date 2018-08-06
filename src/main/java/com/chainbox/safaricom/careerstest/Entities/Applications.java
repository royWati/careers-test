package com.chainbox.safaricom.careerstest.Entities;

import javax.persistence.*;

@Entity
@Table
public class Applications {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public int applicant_id;
    public int job_1;
    public int job_2;
    public int job_3;

    public Applications(int id, int applicant_id, int job_1, int job_2, int job_3) {
        this.id = id;
        this.applicant_id = applicant_id;
        this.job_1 = job_1;
        this.job_2 = job_2;
        this.job_3 = job_3;
    }

    public Applications(int applicant_id,int job_1, int job_2, int job_3) {
        this.applicant_id = applicant_id;
        this.job_1 = job_1;
        this.job_2 = job_2;
        this.job_3 = job_3;
    }

    public Applications(int applicant_id, int job_1) {
        this.applicant_id = applicant_id;
        this.job_1 = job_1;
    }

    public Applications(int applicant_id, int job_1, int job_2) {
        this.applicant_id = applicant_id;
        this.job_1 = job_1;
        this.job_2 = job_2;
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

    public int getJob_1() {
        return job_1;
    }

    public void setJob_1(int job_1) {
        this.job_1 = job_1;
    }

    public int getJob_2() {
        return job_2;
    }

    public void setJob_2(int job_2) {
        this.job_2 = job_2;
    }

    public int getJob_3() {
        return job_3;
    }

    public void setJob_3(int job_3) {
        this.job_3 = job_3;
    }
}
