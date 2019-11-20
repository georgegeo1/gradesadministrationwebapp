package com.grades.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student> {

 @Override
 public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
  Student student = new Student();
  student.setId(rs.getInt("id"));
  student.setFirstname(rs.getString("firstname"));
  student.setLastname(rs.getString("lastname"));
  student.setGrade(rs.getFloat("grade"));
  student.setBirth_date(rs.getDate("birth_date"));
  student.setClassroom_id(rs.getInt("classroom_id"));
  return student;
 }

}