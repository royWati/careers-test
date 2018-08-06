package com.chainbox.safaricom.careerstest.ResponseMessages;

import com.chainbox.safaricom.careerstest.Entities.tb_job_applicants;
import com.chainbox.safaricom.careerstest.Entities.tb_jobs;

import java.util.ArrayList;
import java.util.List;

public class ApplicationResponse {


    public List<tb_job_applicants> applicant_information;
    public ArrayList<tb_jobs> jobsApplied;
    public int application_id;
    public ApplicationResponse(int application_id,List<tb_job_applicants> applicant_information, ArrayList<tb_jobs> jobsApplied) {
        this.application_id = application_id;
        this.applicant_information = applicant_information;
        this.jobsApplied = jobsApplied;

    }

    public List<tb_job_applicants> getApplicant_information() {
        return applicant_information;
    }

    public void setApplicant_information(List<tb_job_applicants> applicant_information) {
        this.applicant_information = applicant_information;
    }

    public ArrayList<tb_jobs> getJobsApplied() {
        return jobsApplied;
    }

    public void setJobsApplied(ArrayList<tb_jobs> jobsApplied) {
        this.jobsApplied = jobsApplied;
    }

    public int getApplication_id() {
        return application_id;
    }

    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }
}
