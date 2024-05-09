package com.example.servicce;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Model.Person;
import com.example.Repository.Dao;
import java.util.Map;
import java.util.List;



@Service
public class Servicce {
    
       @Autowired
        private Dao daoObj;

        @Autowired
        Person obj;

        public Person insertData(int id,String name){

            daoObj.insertData(id, name);
            obj.setId(id);
            obj.setName(name);
            return obj;
            
        }

        public Person updateName(int id,String newName){
            daoObj.updateName(id, newName);
            obj.setId(id);
            obj.setName(newName);
            return obj;
        }

        public boolean deleteRow(int id){
            daoObj.deleted(id);
            return true;
        }

        public List<Person> getData(){
            return daoObj.getData();
        }

}
