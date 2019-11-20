package com.grades.service;

import java.util.List;

import com.grades.model.Classroom;

public interface ClassroomService {
 public List<Classroom> getAllClassrooms();
 
 public Classroom findClassroomById(int id);
 
 public void addClassroom(Classroom classroom);
 
 public void updateClassroom(Classroom classroom);
 
 public void deleteClassroom(int id);
 
}
