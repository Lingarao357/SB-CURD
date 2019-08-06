/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sample.dto;

/**
 *
 * @author swathi
 */
public class StudentDto {

    public StudentDto() {
    }

    public StudentDto(int Id,String stName, String stFatherName, String stClgName, String stCourse) {
        this.stId=stId;
        this.stName = stName;
        this.stFatherName = stFatherName;
        this.stClgName = stClgName;
        this.stCourse = stCourse;
    }
    
    
    private int stId;
    private String stName;

    private String stFatherName;

    private String stClgName;

    private String stCourse;
    
    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStFatherName() {
        return stFatherName;
    }

    public void setStFatherName(String stFatherName) {
        this.stFatherName = stFatherName;
    }

    public String getStClgName() {
        return stClgName;
    }

    public void setStClgName(String stClgName) {
        this.stClgName = stClgName;
    }

    public String getStCourse() {
        return stCourse;
    }

    public void setStCourse(String stCourse) {
        this.stCourse = stCourse;
    }
    
    
    

}
