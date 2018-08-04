package com.chainbox.safaricom.careerstest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class tb_application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;

    public tb_application(String name) {
        this.name = name;
    }

    public tb_application(int id,String name){
        this.id = id;
        this.name = name;
    }

    public tb_application() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
