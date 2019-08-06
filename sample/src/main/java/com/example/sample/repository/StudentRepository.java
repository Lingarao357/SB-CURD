/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sample.repository;

import com.example.sample.dto.StudentDto;
import com.example.sample.model.StudentInfo;
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
public class StudentRepository {

    @Autowired
    EntityManager entityMgr;

    @Transactional
    public int addServiceTypeInDB(StudentDto dto) {
        System.out.println("hello-1");
        try {

            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setStName(dto.getStName());
            studentInfo.setStFatherName(dto.getStFatherName());
            studentInfo.setStClgName(dto.getStClgName());
            studentInfo.setStCourse(dto.getStCourse());

            entityMgr.persist(studentInfo);
            entityMgr.flush();
            return studentInfo.getId();
        } catch (Exception e) {
            System.out.println("error :-" + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public List<StudentInfo> getAllStudents() {

        TypedQuery<StudentInfo> tQuery = null;
        List<StudentInfo> list = null;
        try {
            tQuery = entityMgr.createQuery("SELECT s FROM StudentInfo s", StudentInfo.class);
            return tQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Transactional
    public int update(StudentDto dto) {

        Query query = null;
        try {
            query = entityMgr.createQuery("update StudentInfo s set s.stName=:Name,s.stFatherName=:FatherName,s.stClgName=:ClgName,s.stCourse=:Course where s.id=:Id");

            query.setParameter("Name", dto.getStName());
            query.setParameter("FatherName", dto.getStFatherName());
            query.setParameter("ClgName", dto.getStClgName());
            query.setParameter("Course", dto.getStCourse());
            query.setParameter("Id", dto.getStId());

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
            query = entityMgr.createQuery("delete from StudentInfo s where s.id=:Id");
            query.setParameter("Id", Id);

            return query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public List<StudentInfo> FindByName(String stName) {

        TypedQuery<StudentInfo> tQuery = null;
        List<StudentInfo> list = null;
        Query query = null;
        try {
            query = entityMgr.createQuery("select s from StudentInfo s where s.stName=:stName");

            query.setParameter("stName", stName);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public List<StudentInfo> StudentById(int Id) {

        TypedQuery<StudentInfo> tQuery = null;
        List<StudentInfo> list = null;
        Query query = null;
        try {
            query = entityMgr.createQuery("select s from StudentInfo s where s.id=:Id");

            query.setParameter("Id", Id);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public List<StudentInfo> StudentById1(int id) {
        Query query = null;
        try {
            query = entityMgr.createNamedQuery("StudentInfo.findById");

            query.setParameter("id", id);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();

    }

    public List<StudentInfo> FindByName1(String stName) {
        Query query = null;
        try {
            query = entityMgr.createNamedQuery("StudentInfo.findByStName");

            query.setParameter("stName", stName);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<StudentInfo> FindByNameAndFatherName1(String stName, String stFatherName) {
        Query query = null;
        try {
            query = entityMgr.createNamedQuery("StudentInfo.findByIdAndfindByStFatherName");

            query.setParameter("stName", stName);
            query.setParameter("stFatherName", stFatherName);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<StudentInfo> FindByNameAndFatherName(String stName, String stFatherName) {
        Query query = null;
        try {

            query = entityMgr.createQuery("SELECT s FROM StudentInfo s WHERE s.stName = :stName And s.stFatherName = :stFatherName");
            query.setParameter("stName", stName);
            query.setParameter("stFatherName", stFatherName);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
