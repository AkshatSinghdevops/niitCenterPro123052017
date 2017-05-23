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


<!--  
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
						
						<form action="validate" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="User Name"
										 type="text" id="userID" name="userID">
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









	
	Please login with your credentials
	<br> ${message}
	<%-- <c:url var="action" value="/validate"></c:url> --%>
	<c:url var="action" value="j_spring_security_check"></c:url>
	<%-- <c:url var="action" value="/login"></c:url> --%>

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
	</form>-->
	
	
	<div class="panel panel-default col-sm-8 col-sm-offset-2">

		<div class="row panel-heading"><h3><span class="glyphicon glyphicon-dashboard"></span>  <b>Login DEtails</b></h3></div>

		<div class="panel-body">

<c:url var="addAction" value="j_spring_security_check?${_csrf.parameterName}=${_csrf.token}"></c:url>
 <form action="${addAction}" method="post">
 
UserID: <input class="form-control" type="text" name="username" ><br>
<br>
Password: <input class="form-control" type="text" name="password">
<br>

 <!-- (AFTER ADDING THIS IT GOT STARTING GETTING INTO METHOD--> 
<input type="submit"  value="LOGIN" class="btn btn-primary" >										
<br>

 </form>
 
</div>
</div>

</body>
</html>