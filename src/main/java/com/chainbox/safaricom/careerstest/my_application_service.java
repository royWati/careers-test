package com.chainbox.safaricom.careerstest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class my_application_service {

    @Autowired
    private my_application_interface app_interface;

    public List<tb_application> getApplications(){
        List<tb_application> applications=new ArrayList<>();
        app_interface.findAll().forEach(applications::add);

        return applications;
    }

    public List<tb_application> add_application(tb_application application){
        app_interface.save(application);

        return getApplications();
    }
}
