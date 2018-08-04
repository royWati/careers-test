package com.chainbox.safaricom.careerstest.Services;

import com.chainbox.safaricom.careerstest.Entities.tb_jobs;
import com.chainbox.safaricom.careerstest.Repositories.jobs_interface;
import com.chainbox.safaricom.careerstest.ResponseMessages.Success;
import com.chainbox.safaricom.careerstest.ResponseMessages.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobsServices {

    @Autowired
    private jobs_interface jobs_interface_interface;

    public List<Success> add_job(tb_jobs job){
        List<Success> response=new ArrayList<>();

        jobs_interface_interface.save(job);
        if(all_jobs().size()==20){
            Success success=new Success(5000,"Application is closed");
            response.add(success);
        }else {
            Success success=new Success(2000,"Application submitted successfully");
            response.add(success);
        }
        return response;
    }

    public List<tb_jobs> all_jobs(){
        List<tb_jobs> jobs=new ArrayList<>();
        jobs_interface_interface.findAll().forEach(jobs::add);
        return jobs;

    }

    public List<tb_jobs> get_one_job(Integer job_id){
        List<tb_jobs> jobs=new ArrayList<>();
        List<tb_jobs> jobs_filtered=null;
        jobs_interface_interface.findAll().forEach(jobs::add);
        jobs_filtered=jobs.stream().filter(tb_products -> tb_products.getId()==job_id).collect(Collectors.toList());
        return  jobs_filtered;

    }

    public List<UpdateResponse> update_job(tb_jobs job){
        jobs_interface_interface.save(job);

        List<Success> response=new ArrayList<>();
        Success success=new Success(6000,"job updated successfully");

        UpdateResponse updateResponse=new UpdateResponse(response,
                get_one_job(job.getId()));

        List<UpdateResponse> data=new ArrayList<>();
        data.add(updateResponse);

        return data;
    }

    public List<Success> deleteJob(int job_id){

        jobs_interface_interface.deleteById(job_id);
        List<Success> successes=new ArrayList<>();

        Success success=new Success(3000,"job deleted");

        successes.add(success);

        return successes;
    }

}
