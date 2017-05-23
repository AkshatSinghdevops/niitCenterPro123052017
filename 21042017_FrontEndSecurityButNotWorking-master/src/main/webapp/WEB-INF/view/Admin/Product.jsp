<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="resource/css/mystyle.css">
<link rel="stylesheet" href="resource/img/im.jpg">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="resource/css/mystyle.css">
<link rel="stylesheet" href="resource/img/im.jpg">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container"    style="padding:20px;">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Manage Product</h3>
					</div>
					<div class="panel-body">
						
							<div class="alert alert-danger">
								<div class="text-center">
								Fill Product Details
							</div></div>
						
						<form action="saveProduct" method="POST"  enctype="multipart/form-data">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Product Id"
										 type="text" id="id" name="id" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Product Name"  type="text"  
									 id="name" name ="name">
								</div>
								
								<div class="form-group">
									<input class="form-control" placeholder="Product Description"  type="text"  
									 id="description" name ="description">
								</div>
								
								<div class="form-group">
									<input class="form-control" placeholder="Product Price"  type="text"  
									 id="price" name ="price">
								</div>
								
								<div class="form-group">
									<input class="form-control" placeholder="Category_id"  type="text"  
									 id="category_id" name ="category_id">
								</div>
								
								<div class="form-group">
									<input class="form-control" placeholder="Supplier_id"  type="text"  
									 id="supplier_id" name ="supplier_id">
								</div>
								
								<div class="form-group">
									<input class="form-control" placeholder="Image"  type="file"  
									 id="image" name ="image">
								</div>
								
								<input class="btn btn-lg btn-success btn-block" type="submit" value="Create Product">
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<br>
	<br>
	<br>
	<br>
	<br>
	
	         <center><h1> Product details</h1></center>
	          
	<table class="table">
	<thead>
	<tr>
	<td>ID</td>
	<td>Name</td>
	<td>Description</td>
	<td>Price</td>
	<td>Category-Id</td>
	<td>Supplier-Id</td>
	<td>Image</td>
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="product" items="${productList}">
	
	<tr>
	<td>${product.id}</td>
	<td>${product.name}</td>
	<td>${product.description}</td>
	<td>${product.price}</td>
	<td>${product.category_id}</td>
	<td>${product.supplier_id}</td>
	<td>${product.image}</td>
	</tr>
	</c:forEach>
	</tbody>
	
	</table>
	
	
</body>
</html> --%>




<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Product</title>
</head>
<body>
	<h1>Add a Product</h1>
	<c:url var="addAction" value="/manage_product_add?${_csrf.parameterName}=${_csrf.token}"></c:url>
	<form:form action="${addAction}" commandName="product"
		enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td><form:label path="id">
						<spring:message text="ID" />
					</form:label></td>
				<c:choose>
					<c:when test="${!empty product.id}">
						<td><form:input path="ID" value="" disabled="true" readonly="true" />
						</td>
					</c:when>
					<c:otherwise>
						<td><form:input path="id" pattern=".{5,20}" required="true"
								title="id should contains 5 to 20 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
				<form:input path="id" hidden="true" />
				
				
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			<tr>
				<td> Price </td>
				<td><form:input path="price" required="true" /></td>
			</tr>
			<tr>
				<td>Description></td>
				<td><form:input path="description" required="true" /></td>
			</tr>
			<tr>
				<td>Supplier</td>
				<td><form:select path="supplier.name" items="${supplierList}"
						itemValue="name" itemLabel="name" /></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><form:select path="category.name" items="${categoryList}"
						itemValue="name" itemLabel="name" /></td>
			</tr>
			<tr>
				<td align="left"><form:label path="image">
						<spring:message text=" File" />
					</form:label></td>
				<td align="left"><form:input type="file" name="file" path="image" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty product.name}">
						<input type="submit" value="<spring:message text="Edit Product"/>" />
					</c:if> <c:if test="${empty product.name}">
						<input type="submit" value="<spring:message text="Add Product"/>" />
					</c:if></td>
			</tr>
		</table>
		
		<input type="hidden" 
             name="${_csrf.parameterName}" 
             value="${_csrf.token}" />
	</form:form>
	<br>
 --%>
		 
		
		<%-- <form action="manage-products-add">
			<input type="text" name="id"> <br>
			<input type="text" name="name"><br>
			<input type="text" name="Price"><br>
			<input type="text" name="category_id"><br>
			<input type="text" name="supplier_id"><br>
			<input type="text" name="image"><br>
 			<input type="text" name="description"><br>
			<input type="submit" value="Add">
			<input type="submit" value="Edit">
			<input type="submit" value="Remove">
			<form action="UploadServlet" enctype="multipart/form-data">
				<input type="file" name="file" size="50" />
				<br />
				<input type="submit" value="Upload File" />
			</form>
		</form> --%>

		<br>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- <div class="space"></div>
<div class="container">
	<h2 class="heading-one">Add New Product</h2>
	<c:if test="${not empty error}">
		<div class="alert alert-danger">
			<strong>Error!</strong> ${error}
		</div>
	</c:if>
	<c:if test="${not empty duplicateProduct}">
		<div class="alert alert-danger">
			<strong>Error!</strong> ${duplicateProduct}
		</div>
	</c:if>
	<c:if test="${not empty success}">
		<div class="alert alert-success">
			<strong>Success!</strong> ${success }
		</div>
	</c:if>
	<spring:url
		value="/admin/addProduct?${_csrf.parameterName}=${_csrf.token}"
		var="addProduct"></spring:url>
	<form:form action="${addProduct }" method="POST" commandName="product"
		enctype="multipart/form-data" id="product-form">
		
		<div class="form-group">
			<form:label path="id">Product Id:</form:label>
			<form:input path="id" class="form-control"></form:input>
		</div>
		<div class="form-group">
			<form:label path="name">Product Name:</form:label>
			<form:input path="name" class="form-control"></form:input>
		</div>
		<div class="form-group">
			<form:label path="description">Description:</form:label>
			<form:textarea path="description" class="form-control" />
		</div>
		<div class="form-group">
			<form:label path="price">Price:</form:label>
			<form:input path="price" class="form-control"></form:input>
		</div>
		<div class="form-group">
			<form:label path="category_id">Category</form:label>
			<form:select path="category_id" class="form-control">
				<c:forEach var="category" items="${categoryList}">
				
					<form:option value="${category.id}">${category.name}</form:option>
				</c:forEach>
			</form:select>
			
			
			<form:input path="category_id" class="form-control"></form:input>
		</div>
		
		
		
		
		
		
		<div class="form-group">
			<form:label path="supplier_id">Supplier</form:label>
			<form:select path="supplier_id" class="form-control">
				<c:forEach items="${supplierList }" var="supplier">
					<form:option value="${supplier.id }">${supplier.name} </form:option>
				</c:forEach>
			</form:select>
			
			<form:input path="supplier_id" class="form-control"></form:input>
		</div>
		<div class="form-group">
			<form:label path="image">Upload Image</form:label>
			<form:input path="image" type="file" class="form-control input-sm" />
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<input type="submit" class="btn btn-success" value="Add Product">
		<input type="reset" class="btn btn-secondary" value="Reset">
	</form:form>
</div>
		
		
		
		
		
		 --%>
		
		
<!-- ============================================================================================= -->		
<spring:url value="/resources/images/" var="imag"></spring:url>
<style type="text/css">
.panel-default>.panel-heading {
    color: #f7f4f4;
    background-color: #3c48a5;
    border-color: #118ef9;
}
</style>


</head>
<body>
${msg}<br>
${message}<br>

<div class="container">

	<div class="panel panel-default col-sm-8 col-sm-offset-2">

		<div class="row panel-heading"><h3><span class="glyphicon glyphicon-dashboard"></span>  <b>ProDuct DeTaiLs</b></h3></div>

		<div class="panel-body">
		
		 <c:url var="addAction" value="/add_Product_Value?${_csrf.parameterName}=${_csrf.token}"></c:url> 
		  
			<form:form method="post" action="${addAction}"  modelAttribute="product" enctype="multipart/form-data" >

				
					<div class="row">
						<div class="col-sm-3">
							<form:label path="">
								<spring:message text="Product Id" />
							</form:label>
						</div>
						<div class="col-sm-9">
							<form:input path="id"  class="form-control" />
							
						</div>
					</div>
				
				<br>
				<div class="row">
					<div class="col-sm-3">
						<form:label path="">Product Name</form:label>
					</div>
					<div class="col-sm-9">
						<form:input path="name" cssClass="form-control" required="" />
						<span><form:errors path="name" cssClass="error" /></span>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-3">
						<form:label path="description">Product Description</form:label>
					</div>
					<div class="col-sm-9">
						<form:input path="description" class="form-control" />
						<span><form:errors path="description" cssClass="error" /></span>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-3">
						<form:label path="">Product Suppliers</form:label>
					</div>
					<div class="col-sm-9">
						<form:select path="supplier_id" cssClass="form-control">

							<c:forEach items="${supplierList}" var="supplier">

								<form:option value="${supplier.id }">${supplier.id}</form:option>

							</c:forEach>

						</form:select>
					</div>
				</div>
				
				<br>

				
				<div class="row">
					<div class="col-sm-3">
						<form:label path="">Product Category</form:label>
					</div>
					<div class="col-sm-9">
						<form:select path="category_id" cssClass="form-control">

							<c:forEach items="${categoryList}" var="category">

								<form:option value="${category.id }">${category.id}</form:option>

							</c:forEach>

						</form:select>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-3">
						<form:label path="">Product Price</form:label>
					</div>
					<div class="col-sm-9">
						<form:input path="price" class="form-control" />
						<span><form:errors path="price" cssClass="error" /></span>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-3">
						<form:label path="file">
							<spring:message text="Choose Image" />
						</form:label>
					</div>
					<div class="col-sm-9">
						<form:input path="file" type="file" cssClass="form-control"
							required="required" />
					</div>
				</div>
				<br>
					
					
					<input type="submit" name=action value="save" class="btn btn-primary"/>
					
					 <input type="Submit" name=action value="renew" class="btn btn-primary"/> 
					 
			</form:form>
		</div>
	</div>
	
<!-- ============================================================================================= -->






		<!-- Show Products -->
		<div class="h2">Product List</div>
		
			<table class="table table-striped">
				<tr>
					<th>Product ID</th>
					<th>Product Image</th>
					<th>Product Description</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Category</th>
					<th>Supplier</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.id}</td>
					 <td><img src="resources/images/${product.id}.jpg" width="30"/></td> 
						
						<td>${product.description}</td>
						<td>${product.name}</td>
						<td>${product.price}</td>
						<td>${product.category.name}</td>
						<td>${product.supplier.name}</td>

						<td><a href="<c:url value='manage-product-edit/${product.id}' />" class="btn btn-info">Edit</a> 
						<a href="<c:url value='manage-product-delete/${product.id}' />" class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		

	</div>


</body>
</html>