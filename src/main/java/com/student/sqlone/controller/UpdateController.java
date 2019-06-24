package com.student.sqlone.controller;

import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.sqlone.repository.StudentDAO;
import com.student.sqlone.model.Student;

@RestController
@RequestMapping(value = "/updatestudent")
class UpdateController{

    @Autowired
    public StudentDAO studentdao;
    Student student = new Student();
    
    @RequestMapping(method = RequestMethod.PUT)
    public Student studentUpdate(
    	@RequestParam("id") 
    	int id,
        @RequestParam(value = "name", required = false) 
        String name,
        @RequestParam(value ="age", required = false)
        Integer age,
        @RequestParam(value = "standard", required = false)
        Integer standard,
        @RequestParam(value = "section", required = false)
        String section) {
		student.setId(id);
        student.setName(name);
        if(age!=null&&age>=1)
            student.setAge(age);
        else {
            throw new InputMismatchException("Age should be 1 at least");
        }
        if(standard!=null && standard > 0 && standard < 13)
            student.setStandard(standard);
        else {
            throw new InputMismatchException("Standard should be between 1 and 12");
        }

        student.setSection(section);
		Student studentupdate = studentdao.updateStudent(student);
       return studentupdate; 
    }
}