package com.chainbox.safaricom.careerstest.Controller;

import com.chainbox.safaricom.careerstest.Entities.Applications;
import com.chainbox.safaricom.careerstest.ResponseMessages.ApplicationResponse;
import com.chainbox.safaricom.careerstest.ResponseMessages.Success;
import com.chainbox.safaricom.careerstest.Services.application_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobApplications {

    @Autowired
    private application_service call_service;

    @RequestMapping(value = "/job-applications/add", method= RequestMethod.POST)
    public List<Success> addApplication(@RequestBody  Applications applications){

        return call_service.saveJobApplication(applications);
    }


    @RequestMapping(value = "/job-applications/all", method=RequestMethod.GET)
    public List<ApplicationResponse> getAllApplications(){
        return call_service.getAllApplications();
    }

    @RequestMapping(value = "job-applications/{id}",method = RequestMethod.GET)

    public List<ApplicationResponse> getSingleApplication(@PathVariable int id){
        return call_service.getSingleApplication(id);
    }

    @RequestMapping(value = "job-applications/{id}/deselect-job/{job_id}",method = RequestMethod.PUT)

    public List<ApplicationResponse> deSelectJob(@PathVariable int id,@PathVariable int job_id){
        return call_service.deselectJob(id,job_id);
    }


    @RequestMapping(value = "job-applications/raw",method = RequestMethod.GET)

    public List<Applications> raw(){
        return call_service.rawData();
    }
}
