package com.grades.model;


//Model class of the classroom entity

public class Classroom {
	
 protected int classid;
 protected String classname;
 
//Constructor
 
 public Classroom() {}
 
 public Classroom(String classname) {
	 super();
     this.classname = classname;
 }
 
 public Classroom(int classid, String classname) {
	 super();
     this.classid = classid;
     this.classname = classname;
 }

 // Getters - setters
 public int getClassid() {
     return classid;
 }
 public String getClassname() {
     return classname;
 }
    
 public void setClassid(int classid) {
     this.classid = classid;
 }
 public void setClassname(String classname) {
     this.classname = classname;
 }


}

