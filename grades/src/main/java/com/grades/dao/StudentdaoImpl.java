package com.grades.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.grades.model.Student;
import com.grades.model.StudentRowMapper;

@Transactional
@Repository
public class StudentdaoImpl implements Studentdao {
 
 @Autowired
 private JdbcTemplate jdbcTemplate;

 @Override
 public List<Student> getAllStudents() {
  String query = "SELECT * from students";
  RowMapper<Student> rowMapper = new StudentRowMapper();
  List<Student> list = jdbcTemplate.query(query, rowMapper);
  
  return list;
 }
 
 @Override
 public List<Student> orderAllStudentsByLastname() {
  String query = "SELECT * from students ORDER BY lastname ASC";
  RowMapper<Student> rowMapper = new StudentRowMapper();
  List<Student> list = jdbcTemplate.query(query, rowMapper);
  
  return list;
 }
 
 @Override
 public List<Student> orderAllStudentsByGrade() {
  String query = "SELECT * from students ORDER BY grade DESC";
  RowMapper<Student> rowMapper = new StudentRowMapper();
  List<Student> list = jdbcTemplate.query(query, rowMapper);
  
  return list;
 }
 
 @Override
 public List<Student> filterAllStudentsByFirstname(String fn) {
  String query = "SELECT * from students WHERE firstname = ? ";
  RowMapper<Student> rowMapper = new StudentRowMapper();
  List<Student> list = jdbcTemplate.query(query, rowMapper, fn );
  
  return list;
 }
 
 @Override
 public List<Student> filterAllStudentsByLastname(String ln) {
  String query = "SELECT * from students WHERE lastname = ? ";
  RowMapper<Student> rowMapper = new StudentRowMapper();
  List<Student> list = jdbcTemplate.query(query, rowMapper, ln );
  
  return list;
 }
 
 @Override
 public List<Student> filterAllStudentsByMingrade(float gr) {
  String query = "SELECT * from students WHERE grade >= ? ";
  RowMapper<Student> rowMapper = new StudentRowMapper();
  List<Student> list = jdbcTemplate.query(query, rowMapper, gr );
  
  return list;
 }

 @Override
 public Student findStudentById(int id) {
  String query = "SELECT * FROM students WHERE id = ?";
  RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
  Student student = jdbcTemplate.queryForObject(query, rowMapper, id);
  
  return student;
 }
 


 @Override
 public void addStudent(Student student) {
  String query = "INSERT INTO students(id, firstname, lastname, grade, birth_date, classroom_id) VALUES(?, ?, ?, ?, ?, ?)";
  jdbcTemplate.update(query, student.getId(), student.getFirstname(), student.getLastname(), student.getGrade(), student.getBirth_date(), student.getClassroom_id());
  
 }

 @Override
 public void updateStudent(Student student) {
  String query = "UPDATE students SET firstname=?, lastname=?, grade=?, birth_date=?, classroom_id=? WHERE id=?";
  jdbcTemplate.update(query, student.getFirstname(), student.getLastname(), student.getGrade(), student.getBirth_date(), student.getClassroom_id(), student.getId());
  
 }

 @Override
 public void deleteStudent(int id) {
  String query = "DELETE FROM students WHERE id=?";
  jdbcTemplate.update(query, id);
 }
 
 @Override
 public Student viewStudent(int id) {
  String query = "SELECT * FROM students WHERE id = ?";
  RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
  Student student = jdbcTemplate.queryForObject(query, rowMapper, id);
  return student;

 }

}

