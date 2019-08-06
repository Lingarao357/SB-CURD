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
public class PersonalDto {

    public PersonalDto() {
    }

    public PersonalDto(Integer pid, String name, String email, String number, String address) {
        this.pid = pid;
        this.name = name;
        this.email = email;
        this.number = number;
        this.address = address;
    }

    private Integer pid;
    private String name;
    private String email;
    private String number;
    private String address;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
