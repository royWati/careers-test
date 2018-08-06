package com.chainbox.safaricom.careerstest.Controller;


import com.chainbox.safaricom.careerstest.Entities.tb_jobs;
import com.chainbox.safaricom.careerstest.ResponseMessages.Success;
import com.chainbox.safaricom.careerstest.ResponseMessages.UpdateResponse;
import com.chainbox.safaricom.careerstest.Services.JobsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Jobs {

    @Autowired
    private JobsServices call_service;

    @RequestMapping(value = "/jobs/add",method = RequestMethod.POST)

    public List<Success> addApplicant(@RequestBody tb_jobs job){

        return call_service.add_job(job);
    }

    @RequestMapping(value = "/jobs/all",method = RequestMethod.GET)
    public List<tb_jobs> getAllApplicants(){

        return call_service.all_jobs();
    }

    @RequestMapping(value = "jobs/update/", method = RequestMethod.PUT)
    public List<UpdateResponse> update_user_information(@RequestBody tb_jobs jobs){

        return call_service.update_job(jobs);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "jobs/delete/{id}")
    public List<Success> deleteApplicant(@PathVariable int id){
        return call_service.deleteJob(id);
    }

}
