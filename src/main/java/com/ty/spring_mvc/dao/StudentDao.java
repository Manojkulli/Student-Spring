package com.ty.spring_mvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.spring_mvc.dto.Student;

@Repository
public class StudentDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public Student save(Student student){
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		
		return student;
	}
	
public Student update(Student student){
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		
		return student;
	}

public Student delete(Student student,int id){
	
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Student student1=entityManager.find(Student.class, id);
	entityTransaction.begin();
	entityManager.remove(student1);
	entityTransaction.commit();
	
	return student;
}

public Student find(int id){
	
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	Student student=entityManager.find(Student.class, id);
	
	
	return student;
}
}
