package com.student.sqlone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.sqlone.repository.StudentDAO;
import com.student.sqlone.model.Student;

//@RestController
@Controller
public class StudentController {

    
	/*
    @Autowired
    public StudentDAO studentdao;
    Student student = new Student();
	*/
	
	/*
    @RequestMapping(value="/")
    public ModelAndView index () {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("index");
    return modelAndView;
	}
	*/
    
    /*
    @GetMapping("/")
    String index() {
        return "index";
	}
	*/
    
    /*
    @RequestMapping("/getstudentInfo")
    public List<Student> studentInformation() {
        List<Student> students = dao.isData(); 
        dao.saveStudent(student);
        return students;
    }
	*/
    
    /*
    @PostMapping("/newstudent")
    @ResponseBody
    public Student studentForm(@RequestParam("name")
      String name,
      @RequestParam("age")
      int age,
      @RequestParam("standard")
      int standard,
      @RequestParam("section")
      String section) {
		student.setName(name);
		student.setAge(age);
		student.setStandard(standard);
		student.setSection(section);
		Student studentsave = studentdao.saveStudent(student);
       return studentsave; 
       //return studentdao.getLastStudent();

        //model.addAttribute("student", student);
        //return "createstudentsuccess";
        
    }
	*/

    /*@PostMapping("/newstudent")
    public void studentSubmit() {
    	studentdao.getStudent(student);
        return student;
    }
	*/
}