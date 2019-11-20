package com.grades.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grades.dao.StudentdaoImpl;
import com.grades.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
 
 @Autowired
 private StudentdaoImpl studentDao;

 @Override
 public List<Student> getAllStudents() {
  return studentDao.getAllStudents();
 }
 
 @Override
 public List<Student> orderAllStudentsByLastname() {
  return studentDao.orderAllStudentsByLastname();
 }
 
 @Override
 public List<Student> orderAllStudentsByGrade() {
  return studentDao.orderAllStudentsByGrade();
 }
 
 @Override
 public List<Student> filterAllStudentsByFirstname(String fn) {
  return studentDao.filterAllStudentsByFirstname(fn);
 }
 
 @Override
 public List<Student> filterAllStudentsByLastname(String ln) {
  return studentDao.filterAllStudentsByLastname(ln);
 }
 
 @Override
 public List<Student> filterAllStudentsByMingrade(float gr) {
  return studentDao.filterAllStudentsByMingrade(gr);
 }

 @Override
 public Student findStudentById(int id) {
  return studentDao.findStudentById(id);
 }

 @Override
 public void addStudent(Student student) {
  studentDao.addStudent(student);
 }

 @Override
 public void updateStudent(Student student) {
  studentDao.updateStudent(student);
 }

 @Override
 public void deleteStudent(int id) {
  studentDao.deleteStudent(id);
 }
 
 @Override
 public Student viewStudent(int id) {
  return studentDao.viewStudent(id);
 }

}