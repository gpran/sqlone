package com.student.sqlone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestParam;

import com.student.sqlone.repository.StudentDAO;
import com.student.sqlone.model.Student;

@RestController
class StudentRestController{

	@Autowired
    public StudentDAO dao;

   
    //Use Javadoc to show method implementation
    @RequestMapping("/getstudentInfo")
    public List<Student> studentInformation() {
        List<Student> students = dao.isData(); 
        return students;
    }

}