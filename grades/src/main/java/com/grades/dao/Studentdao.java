package com.grades.dao;

import java.util.List;

import com.grades.model.*;

public interface Studentdao {
 
 public List<Student> getAllStudents();
 
 public List<Student> orderAllStudentsByLastname();
 
 public List<Student> orderAllStudentsByGrade();
 
 public List<Student> filterAllStudentsByFirstname(String fn);
 
 public List<Student> filterAllStudentsByLastname(String ln);
 
 public List<Student> filterAllStudentsByMingrade(float gr);
 
 public Student findStudentById(int id);
 
 public void addStudent(Student student);
 
 public void updateStudent(Student student);
 
 public void deleteStudent(int id);
 
 public Student viewStudent(int id);
}
