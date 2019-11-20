package com.grades.Controller;

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

import com.grades.model.Classroom;
import com.grades.service.ClassroomServiceImpl;

@RestController
public class ClassroomRESTController {
 
 @Autowired
 private ClassroomServiceImpl classroomService;
 
 @GetMapping("/api/classrooms")
 public List<Classroom> getAllClassrooms(){
  return classroomService.getAllClassrooms();
 }
 
 @GetMapping("/api/classrooms/{classroomId}")
 public Classroom getClassroomById(@PathVariable int classroomId) {
  return classroomService.findClassroomById(classroomId);
 }
 
 @PostMapping("/api/classrooms")
 public ResponseEntity<Void> addClassroom(@RequestBody Classroom newClassroom, UriComponentsBuilder builder){
  classroomService.addClassroom(newClassroom);
  
  if(newClassroom == null) {
   return ResponseEntity.noContent().build();
  }
  
  HttpHeaders headers = new HttpHeaders();
  headers.setLocation(builder.path("/api/classrooms/{id}").buildAndExpand(newClassroom.getClassid()).toUri());
  return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
 }
 
 @PutMapping("/api/classrooms")
 public ResponseEntity<Classroom> updateClassroom(@RequestBody Classroom classroom){
  Classroom c = classroomService.findClassroomById(classroom.getClassid());
  
  if(c == null) {
   return new ResponseEntity<Classroom>(HttpStatus.NOT_FOUND);
  }
  
  c.setClassname(classroom.getClassname());

  classroomService.updateClassroom(c);
  return new ResponseEntity<Classroom>(c, HttpStatus.OK);
 }
 
 @DeleteMapping("/api/classrooms/{classroomId}")
 public ResponseEntity<Classroom> deleteClassroom(@PathVariable int classroomId){
  Classroom c = classroomService.findClassroomById(classroomId);
  
  if(c == null) {
   return new ResponseEntity<Classroom>(HttpStatus.NOT_FOUND);
  }
  
  classroomService.deleteClassroom(classroomId);
  return new ResponseEntity<Classroom>(HttpStatus.NO_CONTENT);
 }
}
