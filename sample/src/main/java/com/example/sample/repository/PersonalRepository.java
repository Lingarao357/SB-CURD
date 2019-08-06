/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sample.repository;

import com.example.sample.dto.PersonalDto;
import com.example.sample.dto.StudentDto;
import com.example.sample.model.PersonalInfo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author swathi
 */
@Repository
public class PersonalRepository {

@Autowired
    EntityManager entityMgr;

    @Transactional
    public int addServiceTypeInDB(PersonalDto dto) {
        System.out.println("hello-1");
        try {

            PersonalInfo personalInfo = new PersonalInfo();
            personalInfo.setName(dto.getName());
            personalInfo.setEmail(dto.getEmail());
            personalInfo.setNumber(dto.getNumber());
            personalInfo.setAddress(dto.getAddress());

            entityMgr.persist(personalInfo);
            entityMgr.flush();
            return personalInfo.getPid();
        } catch (Exception e) {
            System.out.println("error :-" + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    public List<PersonalInfo> getAllInformation() {

        TypedQuery<PersonalInfo> tQuery = null;
        List<PersonalInfo> list = null;
        try {
            tQuery = entityMgr.createQuery("SELECT p FROM PersonalInfo p", PersonalInfo.class);
            return tQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Transactional
    public int update(PersonalDto dto) {

        Query query = null;
        try {
            query = entityMgr.createQuery("update PersonalInfo p set p.name=:name,p.email=:email,p.number=:number,p.address=:address where p.pid=:pid");

            query.setParameter("name", dto.getName());
            query.setParameter("email", dto.getEmail());
            query.setParameter("number", dto.getNumber());
            query.setParameter("address", dto.getAddress());
            query.setParameter("pid", dto.getPid());

            return query.executeUpdate();
        } catch (Exception e) {

            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Transactional
    public int delete(int Id) {

        Query query = null;
        try {
            query = entityMgr.createQuery("delete from PersonalInfo p where p.pid=:pid");
            query.setParameter("pid", Id);

            return query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

public List<Object> getJoinInfo(){
   
    Query query = null;
        List<Object> list = null;
        try {
            query = entityMgr.createQuery("SELECT s,p FROM StudentInfo s INNER JOIN PersonalInfo p ON s.stName=p.name", Object.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    } 
}
    

