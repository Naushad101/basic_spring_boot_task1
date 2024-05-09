package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Repository.Dao;
import com.example.controller.Controler;
import com.example.servicce.Servicce;
 import com.example.Model.*;

 
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SampleApplicationTests {
 
    //create mocks that are needed to support testing of class to be tested
    @Mock
    Dao daoObj;
 
    @Mock
    Servicce servicce;
 
    //create class instances that need to be tested in the test class
    @InjectMocks
    Controler controler;
 
    @Test
    void contextLoads() {
    }
 
 
    @Test
    void saveDataTest(){
        Person expectedResult = new Person(1, "Supriya");
        when(servicce.insertData(1,"supriya")).thenReturn(expectedResult);
        Person actualResult = controler.insertData(1,"supriya");
        assertEquals(expectedResult, actualResult);
    }
 
    @Test
    void getAllTest(){
        List<Person> expectedResult = new ArrayList<>();
        expectedResult.add(new Person(1, "Jayesh"));
        expectedResult.add(new Person(2, "Naushad"));
        when(servicce.getData()).thenReturn(expectedResult);
        List<Person> actualResult = controler.getData();
        assertEquals(expectedResult, actualResult);
    }
 
    @Test
    void updateNameTest(){
        Person expectedResult = new Person();
        expectedResult.setId(1);
        expectedResult.setName("Sup");
        when(controler.updateName(1, "Sup")).thenReturn(expectedResult);
        Person actualResult = controler.updateName(1, "Sup");
        assertEquals(expectedResult, actualResult);
    }
 
 
 
@Test
void deleteDataTest(){
	ResponseEntity<Void> expectedResult = controler.deleteRow(1);
	verify(servicce).deleteRow(1);
	assertEquals(HttpStatus.NO_CONTENT, expectedResult.getStatusCode());
   
}
 
 
}
 
