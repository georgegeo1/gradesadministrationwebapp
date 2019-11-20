package com.grades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.grades.model.Classroom;

public class ClassroomRESTControllerTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   @Test
   public void getAllClassrooms() throws Exception {
      String uri = "/api/classrooms";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();  
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Classroom[] classroomlist = super.mapFromJson(content, Classroom[].class);
      assertTrue(classroomlist.length > 0);
   }
   @Test
   public void addClassroom() throws Exception {
      String uri = "/api/classrooms";
      Classroom classroom = new Classroom();
      classroom.setClassname("Calculus");
      String inputJson = super.mapToJson(classroom);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(201, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Classroom successfully added");
   }
   @Test
   public void updateClassroom() throws Exception {
      String uri = "/api/classrooms";
      Classroom classroom = new Classroom();
      classroom.setClassid(8);
      classroom.setClassname("Diffential Equations");
      String inputJson = super.mapToJson(classroom);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Classroom successsfully updated");
   }
   @Test
   public void deleteClassroom() throws Exception {
      String uri = "/api/classrooms/6";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Classroom successsfully deleted");
   }
}
