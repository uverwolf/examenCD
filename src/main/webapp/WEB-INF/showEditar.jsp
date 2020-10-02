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
<title>Editar <c:out value="${show.name }"></c:out> </title>
</head>
<body>
    <div class="container col-12 ">
        <div class=" row row-cols-1  justify-content-center col-12 mt-3 ">
    
           
            <p class="text-center"><form:errors path="show.*"/></p>
            <form:form class="bg-dark px-5 text-light pb-3 col-3" method="POST" action="/shows/${show.id}/edit" modelAttribute="show">
            <h1>Editar  <c:out value="${show.name}"/></h1>
                <p>
                    <form:label class="form-label" path="name">Nombre:</form:label>
                    <form:input class="form-control" value="${show.name}" path="name"/>
                </p>
                <p>
                    <form:label class="form-label" path="network">Cadena:</form:label>
                    <form:input class="form-control" value="${show.network }" path="network"/>
                </p>   
                            		
                <input class="btn btn-info btn" type="submit" value="Actualizar"/>
               	<a href="/shows/${show.id}/delete">Eliminar</a>
             </form:form>
       	 </div>

       	 </div>
    </div>
</body>
</html>