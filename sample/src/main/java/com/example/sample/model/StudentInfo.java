/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sample.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SOMANADH PHANI
 */
@Entity
@Table(name = "student_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentInfo.findAll", query = "SELECT s FROM StudentInfo s")
    , @NamedQuery(name = "StudentInfo.findById", query = "SELECT s FROM StudentInfo s WHERE s.id = :id")
    , @NamedQuery(name = "StudentInfo.findByStName", query = "SELECT s FROM StudentInfo s WHERE s.stName = :stName")
    , @NamedQuery(name = "StudentInfo.findByStFatherName", query = "SELECT s FROM StudentInfo s WHERE s.stFatherName = :stFatherName")
    , @NamedQuery(name = "StudentInfo.findByStClgName", query = "SELECT s FROM StudentInfo s WHERE s.stClgName = :stClgName")
    , @NamedQuery(name = "StudentInfo.findByStCourse", query = "SELECT s FROM StudentInfo s WHERE s.stCourse = :stCourse")
    , @NamedQuery(name = "StudentInfo.findByIdAndfindByStFatherName", query = "SELECT s FROM StudentInfo s WHERE s.stName = :stName And s.stFatherName = :stFatherName")})
public class StudentInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "st_name")
    private String stName;
    @Size(max = 50)
    @Column(name = "st_father_name")
    private String stFatherName;
    @Size(max = 50)
    @Column(name = "st_clg_name")
    private String stClgName;
    @Size(max = 50)
    @Column(name = "st_course")
    private String stCourse;

    public StudentInfo() {
    }

    public StudentInfo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentInfo)) {
            return false;
        }
        StudentInfo other = (StudentInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "spring.rest.datajpa.datajpa.model.StudentInfo[ id=" + id + " ]";
    }

    public void setStId(int stId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
