package com.chainbox.safaricom.careerstest.Entities;


import javax.persistence.*;

@Entity
@Table
public class tb_education_level {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public int id;
    @Column
    public String education_level;

    public tb_education_level() {
    }

    public tb_education_level(String education_level) {
        this.education_level = education_level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEducation_level() {
        return education_level;
    }

    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }
}
