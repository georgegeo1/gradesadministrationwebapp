package com.grades.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.grades.model.Student;
import com.grades.service.StudentServiceImpl;

@Controller
@RequestMapping("/student")

public class StudentController {

 @Autowired
 private StudentServiceImpl studentService;
 
 @RequestMapping(value= {"/", "/list"}, method=RequestMethod.GET)
 public ModelAndView getAllStudents() {
  ModelAndView model = new ModelAndView();
  List<Student> list = studentService.getAllStudents();
  
  model.addObject("student_list", list);
  model.setViewName("student_list");
  return model;
 }
 
 @RequestMapping(value= {"/orderbylastname"}, method=RequestMethod.GET)
 public ModelAndView orderAllStudentsByLastname() {
  ModelAndView model = new ModelAndView();
  List<Student> list = studentService.orderAllStudentsByLastname();
  
  model.addObject("student_list", list);
  model.setViewName("student_list");
  return model;
 }
 
 @RequestMapping(value= {"/orderbygrade"}, method=RequestMethod.GET)
 public ModelAndView orderAllStudentsByGrade() {
  ModelAndView model = new ModelAndView();
  List<Student> list = studentService.orderAllStudentsByGrade();
  
  model.addObject("student_list", list);
  model.setViewName("student_list");
  return model;
 }
 
 @RequestMapping(value= {"/filterbyfirstname"}, method=RequestMethod.GET)
 public ModelAndView filterAllStudentsByFirstname(@RequestParam(value= "fn") String fn) {
  ModelAndView model = new ModelAndView();
  List<Student> list = studentService.filterAllStudentsByFirstname(fn);
  
  model.addObject("student_list", list);
  model.setViewName("student_list");
  return model;
 }
 
 @RequestMapping(value= {"/filterbylastname"}, method=RequestMethod.GET)
 public ModelAndView filterAllStudentsByLastname(@RequestParam(value= "ln") String ln) {
  ModelAndView model = new ModelAndView();
  List<Student> list = studentService.filterAllStudentsByLastname(ln);
  
  model.addObject("student_list", list);
  model.setViewName("student_list");
  return model;
 }
 
 @RequestMapping(value= {"/filterbymingrade"}, method=RequestMethod.GET)
 public ModelAndView filterAllStudentsByMingrade(@RequestParam(value= "gr") float gr) {
  ModelAndView model = new ModelAndView();
  List<Student> list = studentService.filterAllStudentsByMingrade(gr);
  
  model.addObject("student_list", list);
  model.setViewName("student_list");
  return model;
 }
 
 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
 public ModelAndView editStudent(@PathVariable int id) {
  ModelAndView model = new ModelAndView(); 
  Student student = studentService.findStudentById(id);
  model.addObject("student_form", student);  
  model.setViewName("student_form");
  return model;
 }
 
 @RequestMapping(value="/add", method=RequestMethod.GET)
 public ModelAndView addStudent() {
  ModelAndView model = new ModelAndView(); 
  Student student = new Student();
  model.addObject("student_form", student);
  model.setViewName("student_form");
  return model;
 }
 
 @RequestMapping(value="/save", method=RequestMethod.POST)
 public ModelAndView saveOrUpdate(@ModelAttribute("student_form") Student student) {
  if(student.getId() != 0) {
   studentService.updateStudent(student);
  } else {
   studentService.addStudent(student);
  }
  
  return new ModelAndView("redirect:/student/list");
 }
 
 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
 public ModelAndView deleteStudent(@PathVariable("id") int id) {
  studentService.deleteStudent(id);
  
  return new ModelAndView("redirect:/student/list");
 }
 
 @RequestMapping(value="/view/{id}", method=RequestMethod.GET)
 public ModelAndView viewStudent(@PathVariable int id) {
  ModelAndView model = new ModelAndView(); 
  Student s = studentService.findStudentById(id);
  model.addObject("view_details", s);  
  model.setViewName("view_details");
  return model;
 }

}
