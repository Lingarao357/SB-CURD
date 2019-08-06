/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sample.model;

/**
 *
 * @author swathi
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SOMANADH PHANI
 */
@Entity
@Table(name = "personal_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalInfo.findAll", query = "SELECT p FROM PersonalInfo p")
    , @NamedQuery(name = "PersonalInfo.findByPid", query = "SELECT p FROM PersonalInfo p WHERE p.pid = :pid")
    , @NamedQuery(name = "PersonalInfo.findByName", query = "SELECT p FROM PersonalInfo p WHERE p.name = :name")
    , @NamedQuery(name = "PersonalInfo.findByEmail", query = "SELECT p FROM PersonalInfo p WHERE p.email = :email")
    , @NamedQuery(name = "PersonalInfo.findByNumber", query = "SELECT p FROM PersonalInfo p WHERE p.number = :number")
    , @NamedQuery(name = "PersonalInfo.findByAddress", query = "SELECT p FROM PersonalInfo p WHERE p.address = :address")})
public class PersonalInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private Integer pid;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "number")
    private String number;
    @Size(max = 50)
    @Column(name = "address")
    private String address;

    public PersonalInfo() {
    }

    public PersonalInfo(Integer pid) {
        this.pid = pid;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonalInfo)) {
            return false;
        }
        PersonalInfo other = (PersonalInfo) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "spring.rest.datajpa.datajpa.model.PersonalInfo[ pid=" + pid + " ]";
    }
    
     public void setPid(int pid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

    
    

