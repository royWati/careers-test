package com.chainbox.safaricom.careerstest.Services;

import com.chainbox.safaricom.careerstest.Entities.Applications;
import com.chainbox.safaricom.careerstest.Entities.tb_job_applicants;
import com.chainbox.safaricom.careerstest.Entities.tb_jobs;
import com.chainbox.safaricom.careerstest.Repositories.application_interface;
import com.chainbox.safaricom.careerstest.ResponseMessages.ApplicationResponse;
import com.chainbox.safaricom.careerstest.ResponseMessages.Success;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class application_service {


    @Autowired
    private application_interface applicationInterface;
    @Autowired
    private JobsServices jobsServices;
    @Autowired
    private jobApplicantService applicant_service;

    public List<ApplicationResponse> getAllApplications(){


        List<Applications> applications=new ArrayList<>();

        List<ApplicationResponse> responses=new ArrayList<>();

        applicationInterface.findAll().forEach(applications::add);

        for(int i=0;i<applications.size();i++){

            int application_id=applications.get(i).getId();
            List<tb_job_applicants> job_applicants= new ArrayList<>();
            ArrayList<tb_jobs> jobs=new ArrayList<>();
           applicant_service.
                   get_one_job_applicant(applications.get(i).applicant_id).
                   forEach(job_applicants::add);

           jobsServices.get_one_job(applications.get(i).job_1).forEach(jobs::add);
           jobsServices.get_one_job(applications.get(i).job_2).forEach(jobs::add);
           jobsServices.get_one_job(applications.get(i).job_3).forEach(jobs::add);

           ApplicationResponse response=new ApplicationResponse(application_id,job_applicants,jobs);

           responses.add(response);
        }

        return responses;
    }

    public List<Success> saveJobApplication(Applications applications){
        applicationInterface.save(applications);

        List<Success> response=new ArrayList<>();
        Success success=new Success(2000,"application submitted successfully. Good luck");
        response.add(success);
        return response;
    }

    public List<ApplicationResponse> getSingleApplication(int application_id) {
        List<Applications> load_applications = new ArrayList<>();
        List<Applications> application_filtered = null;
        applicationInterface.findAll().forEach(load_applications::add);
        application_filtered = load_applications.stream().filter(Applications -> Applications.getId() == application_id).collect(Collectors.toList());

        List<ApplicationResponse> responseList=new ArrayList<>();

        for (int i = 0; i < application_filtered.size(); i++) {

            int app_id = application_filtered.get(i).getId();
            List<tb_job_applicants> job_applicants = new ArrayList<>();
            ArrayList<tb_jobs> jobs = new ArrayList<>();
            applicant_service.
                    get_one_job_applicant(application_filtered.get(i).applicant_id).
                    forEach(job_applicants::add);

            jobsServices.get_one_job(application_filtered.get(i).job_1).forEach(jobs::add);
            jobsServices.get_one_job(application_filtered.get(i).job_2).forEach(jobs::add);
            jobsServices.get_one_job(application_filtered.get(i).job_3).forEach(jobs::add);

            ApplicationResponse response = new ApplicationResponse(app_id, job_applicants, jobs);

            responseList.add(response);
        }

            return responseList;
    }

    public List<ApplicationResponse> deselectJob(int application_id,int job_id){


        List<Applications> applications=new ArrayList<>();
        List<Applications> filter_applications=new ArrayList<>();

        applicationInterface.findAll().forEach(applications::add);



        filter_applications = filter_applications.stream().
                filter(Applications -> Applications.getId() == application_id).
                collect(Collectors.toList());

        System.out.println(filter_applications.toString());

        for(int i=0;i<filter_applications.size();i++){

            Applications apps=new Applications();
            int job_1=filter_applications.get(i).job_1;
            int job_2=filter_applications.get(i).job_2;
            int job_3=filter_applications.get(i).job_3;

            if(job_1==job_id){
                System.out.println("job 1 found missing");
                apps.setJob_2(job_2);
                apps.setJob_3(job_3);
            }else if(job_2==job_id){

                System.out.println("job 2 found missing");
                apps.setJob_1(job_1);
                apps.setJob_3(job_3);
            }else if(job_3==job_id){

                System.out.println("job 3 found missing");
                apps.setJob_1(job_1);
                apps.setJob_2(job_2);
            }

            apps.setId(application_id);

            applicationInterface.save(apps);
        }

        return getSingleApplication(application_id);
    }



   /* public List<Applications> rawData(){

    }*/
}
