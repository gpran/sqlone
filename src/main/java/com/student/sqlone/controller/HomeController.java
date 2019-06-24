    package com.student.sqlone.controller;
    import org.springframework.web.bind.annotation.RequestMapping;  
    import org.springframework.web.bind.annotation.RestController;  
    @RestController  
    public class HomeController {  
       @RequestMapping(value = "/hello")
        //@RequestMapping(value = "/hello", method = RequestMethod.GET)    
        public String hello(){  
            return"Hello!";  
        }
          
    }  