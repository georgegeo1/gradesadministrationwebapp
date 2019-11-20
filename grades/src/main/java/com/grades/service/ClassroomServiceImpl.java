package com.grades.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grades.dao.ClassroomdaoImpl;
import com.grades.model.Classroom;

@Service
public class ClassroomServiceImpl implements ClassroomService {
 
 @Autowired
 private ClassroomdaoImpl classroomDao;

 @Override
 public List<Classroom> getAllClassrooms() {
  return classroomDao.getAllClassrooms();
 }

 @Override
 public Classroom findClassroomById(int id) {
  return classroomDao.findClassroomById(id);
 }

 @Override
 public void addClassroom(Classroom classroom) {
  classroomDao.addClassroom(classroom);
 }

 @Override
 public void updateClassroom(Classroom classroom) {
  classroomDao.updateClassroom(classroom);
 }

 @Override
 public void deleteClassroom(int id) {
  classroomDao.deleteClassroom(id);
 }

}
