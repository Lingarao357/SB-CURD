/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sample.controller;

import com.example.sample.dto.StudentDto;
import com.example.sample.model.StudentInfo;
import com.example.sample.repository.StudentRepository;
import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author swathi
 */
@RestController

@RequestMapping("/student")

public class StudentController {

    @Autowired
    private StudentRepository repositoryTest;

    @GetMapping(path = "/get", produces = {"application/json;charset=UTF-8", "application/xml"})
    public ResponseEntity<Object> getData() {

        System.out.println("hello");
        List<StudentInfo> list = repositoryTest.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping(path = "/create",
            produces = {"application/json;charset=UTF-8", "application/xml"})
    public ResponseEntity<Object> create(@Valid @RequestBody StudentDto dto, Errors errors) throws IOException {

        try {

            if (errors.hasErrors()) {

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid data");
            } else {
                System.out.println("hello");
                repositoryTest.addServiceTypeInDB(dto);

                return ResponseEntity.status(HttpStatus.CREATED).body("created");
            }
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error:-" + e.getMessage());
        }

    }

    @PutMapping(path = "/update",
            produces = {"application/json;charset=UTF-8", "application/xml"})
    public ResponseEntity<Object> update(@Valid @RequestBody StudentDto dto, Errors errors) {

        try {

            if (errors.hasErrors()) {

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid data");
            } else {
                System.out.println("hello");
                repositoryTest.update(dto);

                return ResponseEntity.status(HttpStatus.CREATED).body("updated");
            }
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error:-" + e.getMessage());
        }
    }

    @DeleteMapping(path = "{Id}/delete",
            produces = {"application/json;charset=UTF-8", "application/xml"})
    public ResponseEntity delete(@PathVariable("Id") int id) {

        try {
            System.out.println("hello");
            System.out.println("deleting Id=" + id);

            int b = repositoryTest.delete(id);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body("deleted");

        } catch (Exception e) {
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("deleted");
    }

    @GetMapping(path = "{stName}/find", produces = {"application/json;charset=UTF-8", "application/xml"})
    public ResponseEntity FindByName(@PathVariable("stName") String stName) {
        System.out.println("hello");
        List<StudentInfo> list = repositoryTest.FindByName(stName);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(path = "{Id}/get", produces = {"application/json;charset=UTF-8", "application/xml"})
    public ResponseEntity StudentById(@PathVariable("Id") int id) {
        System.out.println("hello");
        List<StudentInfo> list = repositoryTest.StudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(path = "{Id}/get1", produces = {"application/json;charset=UTF-8", "application/xml"})
    public ResponseEntity StudentById1(@PathVariable("Id") int id) {
        System.out.println("hello");
        List<StudentInfo> list = repositoryTest.StudentById1(id);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(path = "{stName}/find1", produces = {"application/json;charset=UTF-8", "application/xml"})
    public ResponseEntity FindByName1(@PathVariable("stName") String stName) {
        System.out.println("hello");
        List<StudentInfo> list = repositoryTest.FindByName1(stName);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(path = "{Name}/find2/{FatherName}", produces = {"application/json", "application/xml"})
    public ResponseEntity FindByNameAndFatherName1(@PathVariable("Name") String Name, @PathVariable("FatherName") String FatherName) {
        System.out.println("hello");
        List<StudentInfo> list = repositoryTest.FindByNameAndFatherName1(Name, FatherName);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(path = "{Name}/find3/{FatherName}", produces = {"application/json", "application/xml"})
    public ResponseEntity FindByNameAndFatherName(@PathVariable("Name") String Name, @PathVariable("FatherName") String FatherName) {
        System.out.println("hello");
        List<StudentInfo> list = repositoryTest.FindByNameAndFatherName(Name, FatherName);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
