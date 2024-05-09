package com.example.Repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.Model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;



@Repository
public class Dao {
    
    @Autowired
    DataSource dataSource;

    @Autowired
    Person personObj;

    public void insertData(int id,String name){
        try {

            Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO info (id, name) VALUES (?, ?)");
        statement.setInt(1, id);
        statement.setString(2,name); 
        statement.executeUpdate();
            statement.close();
            connection.close();

            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public String updateName(int id,String newName){
       try {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE info SET name = ? WHERE id = ?");
        statement.setString(1, newName);
        statement.setInt(2, id);
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            return newName;
        }
       } catch (Exception e) {
        // TODO: handle exception
       }
       return null;

    }

    public Person deleted(int id){
        try {
            personObj.setId(id);
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM info WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close(); 
        

            connection.close();
        
       
            Connection connection1 = dataSource.getConnection();
            PreparedStatement statement1 = connection1.prepareStatement("SELECT name FROM info WHERE id = ?");
            statement1.setInt(1, id);
        
            ResultSet res = statement1.executeQuery();
        
            while(res.next()){
                String str = res.getString("name");
                personObj.setName(str);
            }
            res.close();
            statement1.close(); 
        
        } catch (Exception e) {
            // TODO: handle exception
        }
        return personObj;
    }

    public List<Person> getData(){
        List<Person> ans = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM info");
            ResultSet res = statement.executeQuery();
            while(res.next()){
                Person obj1 = new Person();
                int id = res.getInt("id");
                String name = res.getString("name");
                obj1.setId(id);
                obj1.setName(name);
                ans.add(obj1);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return ans;
    }

}
