/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sample.controller;

import com.example.sample.dto.PersonalDto;
import com.example.sample.model.PersonalInfo;
import com.example.sample.repository.PersonalRepository;
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

@RequestMapping("/personal")
public class PersonalController {
 
    @Autowired
    private PersonalRepository repositoryTest;
    
    @PostMapping(path = "/create",
            produces = {"application/json;charset=UTF-8", "application/xml"})
    public ResponseEntity<Object> create(@Valid @RequestBody PersonalDto dto, Errors errors) throws IOException {

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

    @GetMapping(path = "/get", produces = {"application/json;charset=UTF-8", "application/xml"})
    public ResponseEntity<Object> getData() {

        System.out.println("hello");
        List<PersonalInfo> list = repositoryTest.getAllInformation();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    
    @PutMapping(path = "/update",
            produces = {"application/json;charset=UTF-8", "application/xml"})
    public ResponseEntity<Object> update(@Valid @RequestBody PersonalDto dto, Errors errors) {

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

    
    @GetMapping(path = "/get", produces = {"application/json;charset=UTF-8", "application/xml"})
    public ResponseEntity<Object> getData1() {

        System.out.println("hello");
        List<Object> list = repositoryTest.getJoinInfo();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    

}
