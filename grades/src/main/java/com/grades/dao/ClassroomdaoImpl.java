package com.grades.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.grades.model.Classroom;
import com.grades.model.ClassroomRowMapper;

@Transactional
@Repository
public class ClassroomdaoImpl implements Classroomdao {
 
 @Autowired
 private JdbcTemplate jdbcTemplate;

 @Override
 public List<Classroom> getAllClassrooms() {
  String query = "SELECT * from classrooms";
  RowMapper<Classroom> rowMapper = new ClassroomRowMapper();
  List<Classroom> list = jdbcTemplate.query(query, rowMapper);
  
  return list;
 }

 @Override
 public Classroom findClassroomById(int id) {
  String query = "SELECT * FROM classrooms WHERE classid = ?";
  RowMapper<Classroom> rowMapper = new BeanPropertyRowMapper<Classroom>(Classroom.class);
  Classroom classroom = jdbcTemplate.queryForObject(query, rowMapper, id);
  
  return classroom;
 }

 @Override
 public void addClassroom(Classroom classroom) {
  String query = "INSERT INTO classrooms(classid, classname) VALUES(?, ?)";
  jdbcTemplate.update(query, classroom.getClassid(), classroom.getClassname());
  
 }

 @Override
 public void updateClassroom(Classroom classroom) {
  String query = "UPDATE classrooms SET classname=? WHERE classid=?";
  jdbcTemplate.update(query, classroom.getClassname(), classroom.getClassid());
  
 }

 @Override
 public void deleteClassroom(int id) {
  String query = "DELETE FROM classrooms WHERE classid=?";
  jdbcTemplate.update(query, id);
 }

}


