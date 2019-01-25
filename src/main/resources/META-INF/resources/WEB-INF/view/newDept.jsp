<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">


	function validateDept() {

		var did = document.forms[0].id.value;
		if (did == "") {
		    //Validating Department id for empty
			alert("Department Id should be entered");
			return false;
		}else {}
		 		
		var dname = document.forms[0].name.value;
		if (dname == "") {
		    //Validating Department name for empty
			alert("Department name should be entered");
			return false;
		}else{}
		 
		//Validating location for empty
	    var loc = document.forms[0].location.value;
		if (loc == "") {
			alert("location should be entered");
			return false;
		}else{}
		 
	  }
</script>
</head>
<body>
	<div>
		<div>
			<h1>Create Department</h1>
		</div>
	</div>
	
	<form:form class="form-horizontal" method="POST" action="/createDepartment"
		modelAttribute="department" onsubmit="return validateDept()">
		<spring:bind path="id">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Id</label>
				<div class="col-sm-10">
					<form:input path="id" type="number" class="form-control " id="id"
						placeholder=" " value=" " />
					<form:errors path="id" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="name">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<form:input path="name" type="text" class="form-control " id="name"
						placeholder=" " />
					<form:errors path="name" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="location">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Location</label>
				<div class="col-sm-10">
					<form:input path="location" type="text" class="form-control "
						id="location" placeholder=" " />
					<form:errors path="location" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn-lg btn-primary pull-right">Submit</button>
			</div>
		</div>
		<br>
		<a href="/esystem">Home</a>
	</form:form>
</body>
</html>