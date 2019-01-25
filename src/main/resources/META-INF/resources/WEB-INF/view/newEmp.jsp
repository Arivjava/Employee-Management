<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">


	function validateEmp() {

		var eid = document.forms[0].empId.value;
		if (eid == "") {
		    //Validating employee id for empty
			alert("Employee Id should be entered");
			return false;
		} else if (isNaN(eid)) {
		    //Validating employee id for Non numeric field 
			alert("Employee Id should be numeric");
			return false;
		}else{
		}
		
		//Validating name field for empty
	    var ename = document.forms[0].empName.value;
		if (ename == "") {
			alert("Employee Name should be entered");
			return false;
		}	
		
		var hdate = document.forms[0].hireDate.value;
	    // Validating year for format 'yyyy' 
	    if ( hdate.substring(6).length > 4) { 
	        alert("Entered invalid year, enter only 'yyyy' for year ");
	        return false; 
	    } 
	    
	    var salary = document.forms[0].salary.value;
	    var regexp = /^\d+(\.\d{1,2})?$/;
	    // Validating salary for format '99999.99' 
	    if(!regexp.test(salary)) {
	     alert("Entered invalid salary, enter only '99999.99' format "); 
	     return false ;
	    }  
	    	    
	}
</script>
</head>
<body>
	<div>
		<div>
			<h1>Add Employee</h1>
		</div>
	</div>
	<form:form name ="emp" class="form-horizontal" method="POST" action="/createEmployee"
		modelAttribute="employee" onsubmit="return validateEmp()">
		<spring:bind path="empId">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Employee Id</label>
				<div class="col-sm-10">
					<form:input path="empId" type="number" class="form-control " id="id"
						placeholder=" " value=" " />
					<form:errors path="empId" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="empName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Employee Name</label>
				<div class="col-sm-10">
					<form:input path="empName" type="text" class="form-control " id="name"
						placeholder=" " />
					<form:errors path="empName" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		
		<spring:bind path="hireDate">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Hire Date</label>
				<div class="col-sm-10">
					<form:input path="hireDate" type="date" class="form-control "
						id="location" placeholder="Delivery Date" />
					<form:errors path="hireDate" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="salary">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Salary</label>
				<div class="col-sm-10">
					<form:input path="salary" type="text" class="form-control " id="name"
						placeholder=" " />
					<form:errors path="salary" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
			<spring:bind path="mgrId">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Manager </label>
				<div class="col-sm-10">
					<form:select path="mgrId">
						<form:options items="${managerList}" />
						</form:select>
					<form:errors path="mgrId" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="depId">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Department </label>
				<div class="col-sm-10">
						<form:select path="depId">
						<form:options items="${departmentList}" />
						</form:select>
					<form:errors path="depId" class="control-label" />
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