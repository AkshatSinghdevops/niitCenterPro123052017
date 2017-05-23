<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="resource/css/mystyle.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 
<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please sign in</h3>
					</div>
					<div class="panel-body">
						
							<div class="alert alert-danger">
								<div class="text-center">
								Login Here
							</div></div>
							
							<c:url var="action" value="/validate"></c:url>
	                         <c:url var="action" value="j_spring_security_check"></c:url>
	                           <c:url var="action" value="/Login"></c:url>
	                           <%-- 	<form name="Login" action="${action}" method="GET"> --%>
						
						<form action="validate" >
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="User Name"
										 type="text" id="id" name="id">
								</div>
 
								<div class="form-group">
									<input class="form-control" placeholder="Password"  type="password" value="" 
									 id="password" name ="password">
								</div>
 
								<input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
 
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>









	<%-- 
	Please login with your credentials
	<br> ${message}
	<c:url var="action" value="/validate"></c:url>
	<c:url var="action" value="j_spring_security_check"></c:url>
	<c:url var="action" value="/Login"></c:url>

	<form name="Login" action="${action}" method="GET">

		<div class="input-group margin-bottom-sm">
			<span class="input-group-addon"><i
				class="fa fa-envelope-o fa-fw"></i></span> <input class="form-control"
				type="text" name="id" placeholder="User ID">
		</div>
		<div class="input-group">
			<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
			<input class="form-control" type="password" name="password"
				placeholder="Password">
		</div>

	<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit"
			class="btn btn-default" value="Login">
	</form>
	
	
  --%>


</body>
</html>