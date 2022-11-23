package com.ty.spring_mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.spring_mvc.dao.StudentDao;
import com.ty.spring_mvc.dto.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;
	
	public void saveStudent(Student student){
		dao.save(student);
		
	}
}
