<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
	
	function validateRole() {
		//Validating role id for empty
  		var rid = document.forms[0].id.value;
		if (rid == "") {
		    alert("Role Id should be entered");
			return false;
		}else{}
	  //Validating Role Name for empty
	    var rname = document.forms[0].name.value;
		if (rname == "") {
			alert("Role Name should be entered");
			return false;
		}else{}
	 }
</script>
</head>
<body>
	<div>
		<div>
			<h1>Create Roles</h1>
		</div>
	</div>
	<form:form class="form-horizontal" method="POST" action="/createRole"
		modelAttribute="role" onsubmit="return validateRole()">
		<spring:bind path="id">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Role Id</label>
				<div class="col-sm-10">
					<form:input path="id" type="number" class="form-control " id="id"
						placeholder=" " value=" "/>
					<form:errors path="id" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="name">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Role Name</label>
				<div class="col-sm-10">
					<form:input path="name" type="text" class="form-control " id="name"
						placeholder=" " value=" " />
					<form:errors path="name" class="control-label" />
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