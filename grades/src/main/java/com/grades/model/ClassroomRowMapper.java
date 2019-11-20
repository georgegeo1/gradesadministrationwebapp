package com.grades.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ClassroomRowMapper implements RowMapper<Classroom> {

 @Override
 public Classroom mapRow(ResultSet rs, int rowNum) throws SQLException {
  Classroom classroom = new Classroom();
  classroom.setClassid(rs.getInt("classid"));
  classroom.setClassname(rs.getString("classname"));
  return classroom;
 }

}
