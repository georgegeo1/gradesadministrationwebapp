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
  <spring:url value="/student/save" var="saveURL" />
  <h2>Student</h2>
  <form:form modelAttribute="student_form" method="post" action="${saveURL}" cssClass="form">
   <form:hidden path="id"/>
   <div class="form-group">
    <label for="firstname">First Name</label>
    <form:input required="required" style="width: 350px; height: 30px;" path="firstname" cssClass="form-control" id="firstname" placeholder="Enter First Name"/>
   </div>
   <div class="form-group">
    <label for="lastname">Last Name</label>
    <form:input required="required" style="width: 350px; height: 30px;" path="lastname" cssClass="form-control" id="lastname" placeholder="Enter Last Name" />
   </div>
   <div class="form-group">
    <label for="grade">Grade</label>
    <form:input required="required" style="width: 350px; height: 30px;" path="grade" type="number" min="0" step="0.01" max="20" cssClass="form-control" id="grade" placeholder="0.00"/>
   </div>
   <div class="form-group">
    <label for="birth_date">Birth Date</label>
	  
  		<form:input required="required" style="width: 350px; height: 30px;" path="birth_date" cssClass="form-control" id="birth_date" placeholder="dd/MM/yyyy" />
	 
   </div>
   
   <div class="form-group">
    <label for="classroom_id">Classroom ID</label>
   
    <form:input required="required" style="width: 350px; height: 30px;" path="classroom_id" type="number" min="0" step="1" cssClass="form-control" id="classroom_id" placeholder="Enter Classroom Id"/>
   </div>
   <button type="submit" class="btn btn-primary">Save</button>
   
  </form:form>
 </div>
</body>
</html>