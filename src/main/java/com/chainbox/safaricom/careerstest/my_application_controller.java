package com.chainbox.safaricom.careerstest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class my_application_controller {

    @Autowired
    private my_application_service service;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public List<tb_application> add_my_application(@RequestBody tb_application application){

        return service.add_application(application);
    }
}
