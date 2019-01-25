<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
	function validateProj() {
		//Validating Project id for empty
		alert("proj id"+document.forms[0].projectId.value);
		var pid = document.forms[0].projectId.value;
		if (pid == "") {
		    alert("Project Id should be entered");
			return false;
		}else{}
		//Validating Project Name for empty
	    var pname = document.forms[0].projectName.value;
		if (pname == "") {
			alert("Project Name should be entered");
			return false;
		}else{}	
		//Validating Client name for empty
		var cid = document.forms[0].clientName.value;
		if (cid == "") {
		    alert("Client name should be entered");
			return false;
		}else{}
	   // Validating year for format 'yyyy' 
		var ddate = document.forms[0].deadLine.value;
	    if ( ddate.substring(6).length > 4) { 
	        alert("Entered invalid year, enter only 'yyyy' for year ");
	        return false; 
	    }else{}
	  }
</script>
</head>
<body>
	<div>
		<div>
			<h1>Create Projects</h1>
		</div>
	</div>
	<form:form name="proj" class="form-horizontal" method="POST" action="/createProject"
		modelAttribute="project" onsubmit="return validateProj()">
		<spring:bind path="projectId">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Project Id</label>
				<div class="col-sm-10">
					<form:input path="projectId" type="number" class="form-control " id="id"
						placeholder=" " value=" " />
					<form:errors path="projectId" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="projectName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Project Name</label>
				<div class="col-sm-10">
					<form:input path="projectName" type="text" class="form-control " id="name"
						placeholder=" " value=" " />
					<form:errors path="projectName" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="clientName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Client Name</label>
				<div class="col-sm-10">
					<form:input path="clientName" type="text" class="form-control " id="name"
						placeholder=" " value=" "/>
					<form:errors path="clientName" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="deadLine">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Location</label>
				<div class="col-sm-10">
					<form:input path="deadLine" type="date" class="form-control "
						id="location" placeholder="Delivery Date" />
					<form:errors path="deadLine" class="control-label" />
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