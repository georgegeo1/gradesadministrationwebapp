package com.grades.Controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.grades.model.Student;
import com.grades.service.StudentServiceImpl;

@RestController
public class StudentRESTController {
 
 @Autowired
 private StudentServiceImpl studentService;
 
 @GetMapping("/api/students")
 public List<Student> getAllStudents(){
  return studentService.getAllStudents();
 }
 
 @GetMapping("/api/students/{studentId}")
 public Student getStudentById(@PathVariable int studentId) {
  return studentService.findStudentById(studentId);
 }
 
 @PostMapping("/api/students")
 public ResponseEntity<Void> addStudent(@RequestBody Student newStudent, UriComponentsBuilder builder){
  studentService.addStudent(newStudent);
  
  if(newStudent == null) {
   return ResponseEntity.noContent().build();
  }
  
  HttpHeaders headers = new HttpHeaders();
  headers.setLocation(builder.path("/api/students/{id}").buildAndExpand(newStudent.getId()).toUri());
  return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
 }
 
 @PutMapping("/api/students")
 public ResponseEntity<Student> updateStudent(@RequestBody Student student){
  Student s = studentService.findStudentById(student.getId());
  
  if(s == null) {
   return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
  }
  
  s.setFirstname(student.getFirstname());
  s.setLastname(student.getLastname());
  s.setGrade(student.getGrade());
  s.setBirth_date(student.getBirth_date());
  s.setClassroom_id(student.getClassroom_id());
  
  studentService.updateStudent(s);
  return new ResponseEntity<Student>(s, HttpStatus.OK);
 }
 
 @DeleteMapping("/api/students/{studentId}")
 public ResponseEntity<Student> deleteStudent(@PathVariable int studentId){
  Student s = studentService.findStudentById(studentId);
  
  if(s == null) {
   return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
  }
  
  studentService.deleteStudent(studentId);
  return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
 }
}
