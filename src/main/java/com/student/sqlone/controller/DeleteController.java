package com.student.sqlone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.sqlone.repository.StudentDAO;
import com.student.sqlone.model.Student;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@RestController
@RequestMapping(value = "/deletestudent")
class DeleteController{

    @Autowired
    public StudentDAO studentdao;

    
    @RequestMapping(method = RequestMethod.DELETE)
    public Student studentDelete (
    	@RequestParam("id") 
    	int id) throws Exception {

		Student studentdelete = studentdao.deleteStudent(id);
        //return JSON Message to endpoint if studentdelete is null
        //done
        if (studentdelete == null){
            throw new Exception("Student Not Found by this ID: "+id);
        } else {
            return studentdelete;
        }

    }
}