package com.grades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.text.SimpleDateFormat;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.grades.model.Student;

public class StudentRESTControllerTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   @Test
   public void getAllStudents() throws Exception {
      String uri = "/api/students";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();  
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Student[] studentlist = super.mapFromJson(content, Student[].class);
      assertTrue(studentlist.length > 0);
   }
   @Test
   public void addStudent() throws Exception {
      String uri = "/api/students";
      Student student = new Student();
      student.setFirstname("Paul");
      student.setLastname("Morrison");
      student.setGrade(15);
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      student.setBirth_date(formatter.parse("14/08/2000"));
      student.setClassroom_id(6);
      String inputJson = super.mapToJson(student);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(201, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Student successfully added");
   }
   @Test
   public void updateStudent() throws Exception {
      String uri = "/api/students";
      Student student = new Student();
      student.setId(8);
      student.setFirstname("Chris");
      student.setLastname("Edison");
      student.setGrade(12);
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      student.setBirth_date(formatter.parse("20/09/1996"));
      student.setClassroom_id(6);
      String inputJson = super.mapToJson(student);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Student successsfully updated ");
   }
   @Test
   public void deleteStudent() throws Exception {
      String uri = "/api/students/6";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Student successsfully deleted");
   }
}
