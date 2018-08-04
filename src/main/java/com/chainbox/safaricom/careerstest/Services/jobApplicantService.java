package com.chainbox.safaricom.careerstest.Services;

import com.chainbox.safaricom.careerstest.Entities.tb_job_applicants;
import com.chainbox.safaricom.careerstest.Repositories.applicants;
import com.chainbox.safaricom.careerstest.ResponseMessages.Success;
import com.chainbox.safaricom.careerstest.ResponseMessages.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class jobApplicantService {

    @Autowired
    private applicants appli_interface;

    public List<Success> add_applicant(tb_job_applicants applicants){
        List<Success> response=new ArrayList<>();

        appli_interface.save(applicants);
        if(all_applicants().size()==20){
            Success success=new Success(5000,"Application is closed");
            response.add(success);
        }else {
            Success success=new Success(2000,"Application submitted successfully");
            response.add(success);
        }
        return response;
    }

    public List<tb_job_applicants> all_applicants(){
        List<tb_job_applicants> applicants=new ArrayList<>();
        appli_interface.findAll().forEach(applicants::add);
        return applicants;

    }

    public List<tb_job_applicants> get_one_job_applicant(Integer job_applicant_id){
        List<tb_job_applicants> applicants=new ArrayList<>();
        List<tb_job_applicants> applicants_filtered=null;
        appli_interface.findAll().forEach(applicants::add);
        applicants_filtered=applicants.stream().filter(tb_products -> tb_products.getId()==job_applicant_id).collect(Collectors.toList());
        return  applicants_filtered;

    }

    public List<UpdateResponse> update_user_information(tb_job_applicants applicants){
        appli_interface.save(applicants);

        List<Success> response=new ArrayList<>();
        Success success=new Success(6000,"user updated successfully");

        UpdateResponse updateResponse=new UpdateResponse(response,
                get_one_job_applicant(applicants.getId()));

        List<UpdateResponse> data=new ArrayList<>();
        data.add(updateResponse);

        return data;
    }

    public List<Success> deleteApplicant(int applicant_id){

        appli_interface.deleteById(applicant_id);
        List<Success> successes=new ArrayList<>();

        Success success=new Success(3000,"application deleted");

        successes.add(success);

        return successes;
    }
}
