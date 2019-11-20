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
import com.grades.model.Classroom;
import com.grades.service.ClassroomServiceImpl;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {

 @Autowired
 private ClassroomServiceImpl classroomService;
 
 @RequestMapping(value= {"/", "/list"}, method=RequestMethod.GET)
 public ModelAndView getAllClassrooms() {
  ModelAndView model = new ModelAndView();
  List<Classroom> list = classroomService.getAllClassrooms(); 
  model.addObject("classroom_list", list);
  model.setViewName("classroom_list");
  return model;
 }
 
 @RequestMapping(value="/update/{classid}", method=RequestMethod.GET)
 public ModelAndView editClassroom(@PathVariable int classid) {
  ModelAndView model = new ModelAndView(); 
  Classroom classroom = classroomService.findClassroomById(classid);
  model.addObject("classroom_form", classroom);  
  model.setViewName("classroom_form");
  return model;
 }
 
 @RequestMapping(value="/add", method=RequestMethod.GET)
 public ModelAndView addClassroom() {
  ModelAndView model = new ModelAndView(); 
  Classroom classroom = new Classroom();
  model.addObject("classroom_form", classroom);
  model.setViewName("classroom_form");
  return model;
 }
 
 @RequestMapping(value="/save", method=RequestMethod.POST)
 public ModelAndView saveOrUpdate(@ModelAttribute("classroom_form") Classroom classroom) {
  if(classroom.getClassid() != 0) {
   classroomService.updateClassroom(classroom);
  } else {
   classroomService.addClassroom(classroom);
  }
  
  return new ModelAndView("redirect:/classroom/list");
 }
 
 @RequestMapping(value="/delete/{classid}", method=RequestMethod.GET)
 public ModelAndView deleteClassroom(@PathVariable("classid") int classid) {
  classroomService.deleteClassroom(classid);
  return new ModelAndView("redirect:/classroom/list");
 }


}

