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
<title>Show</title>
</head>
<body>
    <div>
    <h1><c:out value="${show.name}"></c:out> </h1>
    <h2>Cadena: <c:out value="${show.network}"></c:out></h2>
    
    
    </div>
    <table class="table table-dark">
        <thead class="thead-light">
            <tr>
                <th>Nombre</th>
                <th>Rating</th>
              
            </tr>
        </thead>
        <tbody>
           <c:forEach items="${ratings}" var="programa">
              <tr>
               <td><c:out value="${programa.getUsers().getUsername()}"></c:out> </td>
                <td><c:out value="${programa.getRating()}"></c:out> </td>
              
               
              </tr>
           </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-success" href="/shows/${show.id}/edit">Editar</a>
    <a class="btn btn-info" href="/home">Volver</a>
	            
	            <form:form class="bg-dark px-5 text-light pb-3 col-3" method="POST" action="/shows/${show.id}/rating" modelAttribute="showUser">
            
                <p>
                 <form:label class="form-label" path="rating">Calificar:</form:label>
                <form:select path="rating">
                <option value=1>1</option>
                <option value=2>2</option>
                <option value=3>3</option>
                <option value=4>4</option>
                <option value=5>5</option>
                </form:select>                   
                </p>          		
                <input class="btn btn-info btn" type="submit" value="calificar"/>

             </form:form> 
	
	
   
</body>
</html>