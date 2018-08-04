package com.chainbox.safaricom.careerstest.ResponseMessages;

import com.chainbox.safaricom.careerstest.Entities.tb_job_applicants;

import java.util.List;

public class UpdateResponse {

    public List<Success> successes;
    public List applicants;

    public UpdateResponse(List<Success> successes, List applicants) {
        this.successes = successes;
        this.applicants = applicants;
    }
}
