package com.example.controller;

import java.util.Optional;

import javax.swing.text.html.Option;
import javax.xml.crypto.Data;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Person;
import com.example.servicce.Servicce;

import java.util.List;





@RestController
public class Controler {
    
        @Autowired
        Servicce servicce;

    @PostMapping("/gt")
    public Person insertData(@RequestParam("id") int id, @RequestParam("nm") String name){
        return servicce.insertData(id, name);
    }

    @PutMapping("/update")
    public Person updateName(@RequestParam("id") int id,@RequestParam("newnm") String newName){

        return servicce.updateName(id, newName);
    }

    @DeleteMapping("/del")
public ResponseEntity<Void> deleteRow(@RequestParam("id") int id) {
    servicce.deleteRow(id);
    return ResponseEntity.noContent().build();
}

    @GetMapping("/get-all")
    public List<Person> getData(){
        return servicce.getData();
    }

}
