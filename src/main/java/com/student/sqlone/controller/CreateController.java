package com.student.sqlone.controller;

import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestBody;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import javax.validation.Valid;

import com.student.sqlone.repository.StudentDAO;
import com.student.sqlone.model.Student;



@RestController
@RequestMapping(value = "/newstudent")
class CreateController{

    @Autowired
    public StudentDAO studentdao;
    Student student = new Student();
    
    @RequestMapping(method = RequestMethod.POST)
    public Student studentForm( /*@RequestBody Student studentrequest*/
      @RequestParam("name")
      String name,
      @RequestParam("age")
      int age,
      @RequestParam("standard")
      int standard,
      @RequestParam("section")
      String section
      )  {
      // When String value in Integer fields it generates following exception
      //org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

      student.setName(name);  
      
      if (age == (int)age ){
          if (age>=1){
              student.setAge(age);
          } else{
              throw new InputMismatchException("Age is less than one Exception");
          }

      } else {
          try {
              throw new Exception( "In Age Parameter Please Enter Number only" );
          } catch (Exception e) {
              e.printStackTrace();
          }
          //return "In Age Section Please Enter Number only";
      }

      if (standard == (int) standard) {
            if (standard>=1 && standard<13){
                student.setStandard(standard);
            } else {
                throw new InputMismatchException("Standard Out of Range Exception");
            }
      } else {
          try {
              throw new Exception( "In Standard Parameter Please Enter Number only" );
          } catch (Exception e) {
              e.printStackTrace();
          }
          //return "In Standard Section Please Enter Number only";
      }

    student.setSection(section);

    if(student == null )
    {
        try {
            throw  new Exception("Empty Request");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    if(studentrequest == null )
    {
         throw  new Exception("Empty Request");
    }
    Student studentsave = studentdao.saveStudent(studentrequest);
	*/
		
    Student studentsave = studentdao.saveStudent(student);
       return studentsave; 

    }
}