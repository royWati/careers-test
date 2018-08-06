package com.chainbox.safaricom.careerstest.Controller;


import com.chainbox.safaricom.careerstest.Entities.tb_job_applicants;
import com.chainbox.safaricom.careerstest.ResponseMessages.Success;
import com.chainbox.safaricom.careerstest.ResponseMessages.UpdateResponse;
import com.chainbox.safaricom.careerstest.Services.application_service;
import com.chainbox.safaricom.careerstest.Services.jobApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class jobApplicants {

    @Autowired
    private jobApplicantService job_service;

    @Autowired
    private application_service call_application_service;

    @RequestMapping(value = "applications/add",method = RequestMethod.POST)

    public List<Success> addApplicant(@RequestBody tb_job_applicants applicants){

        return job_service.add_applicant(applicants);
    }


    @RequestMapping(value = "/applications/all",method = RequestMethod.GET)

    public List<tb_job_applicants> getAllApplicants(){

        return job_service.all_applicants();
    }



    @RequestMapping(value = "applications/update/", method = RequestMethod.PUT)
    public List<UpdateResponse> update_user_information(@RequestBody tb_job_applicants applicants){

        return job_service.update_user_information(applicants);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "applications/delete/{id}")
    public List<Success> deleteApplicant(@PathVariable int id){
        return job_service.deleteApplicant(id);
    }


    @RequestMapping(method = RequestMethod.GET,value = "applications/getone/{id}")
    public List<tb_job_applicants> getOneApplication(@PathVariable int id){
        return job_service.get_one_job_applicant(id);
    }



}
