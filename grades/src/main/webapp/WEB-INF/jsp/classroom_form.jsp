<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Students</title>
 <link href="http://localhost:8090/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="http://localhost:8090/webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="http://localhost:8090/webjars/jquery/3.0.0/js/jquery.min.js" ></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
  
  <meta charset="utf-8">  
  <meta name="viewport" content="width=device-width, initial-scale=1">  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
  <a class="navbar-brand" style="color:white;">Grades Administration System</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
      <button type="button" class="btn btn-outline-dark btn-lg" >
        <a class="nav-link" href="/student/list">Students <span class="sr-only">(current)</span></a>
      </li> </button><button type="button" class="btn btn-outline-dark btn-lg">
      <li class="nav-item">
        <a class="nav-link" href="/classroom/list">Classrooms</a>
      </li></button><button type="button" class="btn btn-outline-dark btn-lg">
      <li class="nav-item">
        <a class="nav-link" href="/student/add">Add Student</a>
      </li> </button>
      <button type="button" class="btn btn-outline-dark btn-lg">
      <li class="nav-item">
        <a class="nav-link" href="/classroom/add">Add Classroom</a>
      </li> </button>
    </ul>
  </div>
</nav>
 <div class="container">
  <spring:url value="/classroom/save" var="saveURL" />
  <h2>Classroom</h2>
  <form:form modelAttribute="classroom_form" method="post" action="${saveURL}" cssClass="form">
   <form:hidden path="classid"/>
   <div class="form-group">
    <label for="classname">Classroom Name</label>
    <form:input required="required" style="width: 350px; height: 30px;" path="classname" cssClass="form-control" id="classname" placeholder="Enter Classroom Name"/>
   </div>
   
   <button type="submit" class="btn btn-primary">Save</button>
   
  </form:form>
 </div>
</body>
</html>