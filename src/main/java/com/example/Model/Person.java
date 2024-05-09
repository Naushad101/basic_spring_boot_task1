package com.example.Model;

import org.springframework.stereotype.Component;

@Component
public class Person {
    int id;
    String name;
    public Person(){

    }
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Person(int id,String name){
        this.id=id;
        this.name=name;
    }

    
}
