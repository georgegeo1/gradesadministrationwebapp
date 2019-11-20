package com.grades.model;

import java.text.SimpleDateFormat;
import java.util.Date;
//Model class of the student entity

import org.springframework.format.annotation.DateTimeFormat;

public class Student {
	
 protected int id;
 protected String firstname;
 protected String lastname;
 protected float grade;
 @DateTimeFormat(pattern = "dd/MM/yyyy")
 protected Date birth_date;
 protected int classroom_id;
 
//Constructor
 
 public Student() {}
 
 public Student(String firstname, String lastname, float grade, Date birth_date, int classroomid) {
	 super();
     this.firstname = firstname;
     this.lastname = lastname;
     this.grade = grade;
     this.birth_date = birth_date;
     this.classroom_id = classroomid;
 }
 

 public Student(int id, String firstname, String lastname, float grade, Date birth_date, int classroomid) {
	 super();
     this.id = id;
     this.firstname = firstname;
     this.lastname = lastname;
     this.grade = grade;
     this.birth_date = birth_date;
     this.classroom_id = classroomid;
 }


 // Getters - setters
 public int getId() {
     return id;
 }
 public String getFirstname() {
     return firstname;
 }
 public String getLastname() {
     return lastname;
 }
 public float getGrade() {
     return grade;
 }
 public Date getBirth_date() {
     return birth_date;
 }
 public int getClassroom_id() {
     return classroom_id;
 }
    
 public void setId(int id) {
     this.id = id;
 }
 public void setFirstname(String firstname) {
     this.firstname = firstname;
 }
 public void setLastname(String lastname) {
     this.lastname = lastname;
 }
 public void setGrade(float grade) {
     this.grade = grade;
 }
 public void setBirth_date(Date birthdate) {
     this.birth_date = birthdate;
 }
 public void setClassroom_id(int classroomid) {
     this.classroom_id = classroomid;
 }
 

}

