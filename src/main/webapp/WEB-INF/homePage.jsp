<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<title>Home</title>
</head>
<body>
    <div class="container">
        <div class="row border border-danger">
            <h1 class="col-6">Bienvenido <c:out value="${currentUser.username}"></c:out></h1>
    		
            <form class="col-6 " id="logoutForm" method="POST" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input class="btn btn-danger" type="submit" value="Logout!" />
            </form>
            <h4 class="col-7">Programas TV</h4>
        </div>
        <div class="row border border-success">
        <table class="table table-dark">
         <thead class="thead-light">
            <tr>
                <th>Nombre</th>
                <th>Cadena</th>
                <th>Rating</th>
            </tr>
          </thead>
         <tbody>
           <c:forEach items="${programas}" var="shows">
              <tr>
               <td><a href="/shows/${shows.id}"><c:out value="${shows.name}"/> </a> </td>
               <td><c:out value="${shows.network}"></c:out> </td>
               <td><c:out value="${shows.average}"></c:out> </td>
               
               
              </tr>
           </c:forEach>
           </tbody>
   		 </table>
   		 <a class="btn btn-info" href="/shows/new">Crear un programa</a>
        </div>
    </div>

</body>
</html>