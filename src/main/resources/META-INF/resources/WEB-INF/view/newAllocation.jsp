<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">


	function validateAlloc() {

		var eid = document.forms[0].empId.value;
		if (eid == "") {
		    //Validating Emp id for empty
			alert("Employee ID should be entered");
			return false;
		}else {}
		
		//Validating Project Id for empty
	    var pid = document.forms[0].projId.value;
		if (pid == "") {
			alert("Project ID should be entered");
			return false;
		}else{}	
		
		
		var fromdate = document.forms[0].fromDate.value;
	    // Validating year for format 'yyyy' 
	    if ( fromdate.substring(6).length > 4) { 
	        alert("Entered invalid from year, enter only 'yyyy' for year ");
	        return false; 
	    }else{}
	    
		var todate = document.forms[0].toDate.value;
	    // Validating year for format 'yyyy' 
	    if ( todate.substring(6).length > 4) { 
	        alert("Entered invalid to year, enter only 'yyyy' for year ");
	        return false; 
	    }{}
	  }
</script>
</head>
<body>
	<div>
		<div>
			<h1>Allocation</h1>
		</div>
	</div>
	<form:form class="form-horizontal" method="POST" action="/createAllocation"
		modelAttribute="allocation" onsubmit="return validateAlloc()">
		<spring:bind path="empId">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Employee Id</label>
				<div class="col-sm-10">
					<form:input path="empId" type="number" class="form-control " id="id"
						placeholder=" " />
					<form:errors path="empId" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="projId">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Project Id</label>
				<div class="col-sm-10">
					<form:input path="projId" type="number" class="form-control " id="name"
						placeholder=" " />
					<form:errors path="projId" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
	 	
		<spring:bind path="roleId">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Role</label>
				<div class="col-sm-10">
					<form:select path="roleId">
						<form:options items="${roleList}" />
						</form:select>
					<form:errors path="roleId" class="control-label" />
				</div>
			</div>
		</spring:bind>
				
		<spring:bind path="fromDate">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">From Date</label>
				<div class="col-sm-10">
					<form:input path="fromDate" type="date" class="form-control "
						id="location" placeholder="Delivery Date" />
					<form:errors path="fromDate" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="toDate">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">To Date</label>
				<div class="col-sm-10">
					<form:input path="toDate" type="date" class="form-control " id="name"
						placeholder=" " />
					<form:errors path="toDate" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="amt">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Daily Wages</label>
				<div class="col-sm-10">
					<form:input path="amt" type="number" class="form-control " id="name"
						placeholder=" " />
					<form:errors path="amt" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
	 
		
		<div class="form-group">
			<br> 
			
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn-lg btn-primary pull-right">Submit</button>
			</div>
			
			<br>
			<a href="/esystem">Home</a>
		</div>
	</form:form>
</body>
</html>