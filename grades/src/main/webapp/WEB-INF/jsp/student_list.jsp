<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Student List</title>
 <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
 <br>
  <h2>Student List</h2>
  <br>
  <br><div class="row"><div class="col-sm">
    <form action="/student/filterbyfirstname" method="GET">
    <input type="text" name="fn" placeholder="Filter By First Name...">
    <button type="submit" style="background-color:orange;color:white;width:100px;height:80;display:inline-block;"><i class="fa fa-search"></i></button>
    </form></div><div class="col-sm">
    <form action="/student/filterbylastname" method="GET">
    <input type="text" name="ln" placeholder="Filter By Last Name...">
    <button type="submit" style="background-color:orange;color:white;width:100px;height:80;display:inline-block;"><i class="fa fa-search"></i></button>
    </form></div>
    <div class="col-sm">
    <form action="/student/filterbymingrade" method="GET">
    <input type="number" min="0" step="0.01" name="gr" placeholder="Filter By Min Grade...">
    <button type="submit" style="background-color:orange;color:white;width:100px;height:80;display:inline-block;"><i class="fa fa-search"></i></button>
    </form></div></div>
    <br>
  <table class="table table-striped">
   <thead>
    <tr>
     <th scope="row">Student Id</th>
     <th scope="row">First Name</th>
     <th scope="row">Last Name</th>
     <th scope="row">Grade</th>
     <th scope="row">Birth Date</th>
     <th scope="row">Classroom ID</th>
     <th scope="row">Edit</th>
     <th scope="row">Delete</th>
     <th scope="row">View</th>
    </tr>
   </thead>
   <tbody>
    <c:forEach items="${student_list}" var="student" >
     <tr>
      <td>${student.id }</td>
      <td>${student.firstname }</td>
      <td>${student.lastname }</td>
      <td>${student.grade }</td>
      <td>${student.birth_date }</td>
      <td>${student.classroom_id }</td>
      <td>
       <spring:url value="/student/update/${student.id}" var="updateURL" />
       <a class="btn btn-success" href="${updateURL}" role="button">Update</a>
      </td>
      <td>
       <spring:url value="/student/delete/${student.id}" var="deleteURL" />
       <a class="btn btn-danger" href="${deleteURL}" role="button">Delete</a>
      </td><td>
      <spring:url value="/student/view/${student.id}" var="viewURL" />
       <a class="btn btn-info" href="${viewURL}" role="button">View</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <!--  
  <spring:url value="/student/add" var="addURL" />
  <a class="btn btn-primary" href="${addURL}" role="button">Add New Student</a>-->
  <spring:url value="/student/orderbylastname" var="orderbynameURL" />
  <a class="btn btn-info" href="${orderbynameURL}" role="button">Order By Last Name</a>
  <spring:url value="/student/orderbygrade" var="orderbygradeURL" />
  <a class="btn btn-info" href="${orderbygradeURL}" role="button">Order By Grade</a>
  <br>
  <br>
  

  
 </div>
</body>
</html>