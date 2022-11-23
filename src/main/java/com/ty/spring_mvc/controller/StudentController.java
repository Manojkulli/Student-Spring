package com.ty.spring_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.spring_mvc.dto.Student;
import com.ty.spring_mvc.service.StudentService;

@Controller
public class StudentController {

	@RequestMapping("login")
	public ModelAndView getIndex() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.jsp");
		return modelAndView;
	}

	@RequestMapping("signup")
	public ModelAndView signup() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signup.jsp");
		modelAndView.addObject("student", new Student());
		return modelAndView;
	}

	@Autowired
	StudentService service;
	
	@RequestMapping("savestudent")
	public ModelAndView saveStudent(@ModelAttribute Student student) {

		service.saveStudent(student);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.jsp");
		return modelAndView;

	}
}
