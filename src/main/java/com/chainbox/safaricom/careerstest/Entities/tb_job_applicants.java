package com.chainbox.safaricom.careerstest.Entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class tb_job_applicants {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    public int id;
    public String first_name;
    public String last_name;
    public String email;
    public String phone;
    public String education_level;
    public int years_of_experience;



    public tb_job_applicants() {
    }

    public tb_job_applicants(int id){
        this.id=id;
    }

    public tb_job_applicants(String first_name, String last_name, String email, String phone, String education_level, int years_of_experience) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.education_level = education_level;
        this.years_of_experience = years_of_experience;
    }

    public tb_job_applicants(int id,String first_name, String last_name, String email, String phone, String education_level, int years_of_experience) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.education_level = education_level;
        this.years_of_experience = years_of_experience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducation_level() {
        return education_level;
    }

    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }

    public int getYears_of_experience() {
        return years_of_experience;
    }

    public void setYears_of_experience(int years_of_experience) {
        this.years_of_experience = years_of_experience;
    }
}
