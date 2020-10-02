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
<title>Ingresar</title>
</head>
<body>
    <div class="container col-12 ">
        <div class=" d-flex justify-content-center col-12 mt-3 ">

            <form class="col-3 mb-5 pb-4 text-center text-light bg-dark" method="POST" action="/login">
                <c:if test="${logoutMessage != null}">
                    <h6 class="text-success"><c:out value="${logoutMessage}"></c:out></h6>
                </c:if>
                <c:if test="${errorMessage != null}">
                  <h6 class="text-danger">  <c:out value="${errorMessage}"></c:out> </h6>
                </c:if>
                <h1>Login</h1>
                <p>
                    <label class="form-label" for="username">Usuario</label>
                    <input class="form-control" type="text" id="username" name="username"/>
                </p>
                <p>
                    <label class="form-label" for="password">Password</label>
                    <input class="form-control" type="password" id="password" name="password"/>
                </p>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input class="btn btn-primary" type="submit" value="Ingresar"/>
                <a class="btn btn-info text-light" href="/registration">Registrarse</a>
            </form>
            
        </div>
    </div>
</body>
</html>