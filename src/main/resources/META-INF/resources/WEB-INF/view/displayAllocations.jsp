<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript">
	function validateDis() {
  		var eid = document.forms[0].id.value;
			if (eid == "") {
			    //Validating employee id for empty
				alert("Employee Id should be entered");
				return false;
			} 
	}
</script>
</head>
<body>
	<div>
		<div>
			<h1>List Employee Allocations </h1>
		</div>
	</div>
	<form:form class="form-horizontal" method="GET" action="/displayAllocation" onsubmit="validateDis()">

		<div class="form-group">
			<div class="form-group">
				<label class="col-sm-2 control-label">Enter Employee Id</label>
				<div class="col-sm-10">
					<input name="id" type="number" class="form-control " id="id"
						placeholder=" " value=" "/>
				</div>
			</div>
		    <div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn-lg btn-primary pull-right">Submit</button>
			</div>
			<br>
			<a href="/esystem">Home</a>
			<br>
			<br>
			<c:out value="${msg}" />
		</div>
	</form:form>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

</style>
</head>
	<c:choose>
		<c:when test="${empty result}">
		<td> </td>
		</c:when>
		<c:otherwise>
		<table border="1" style="width:50%" >
		<tr>
		<th>Client Name</th>
		<th>Project Name</th>
		<th>From Date</th>
		<th>To Date</th>
		<th>Role Title</th>
		</tr>
		<c:forEach var="item" items="${ result}">
		<tr>
		<td>${item.clientName }</td>
		<td>${item.projectName }</td>
		<td>${item.fromDate }</td>
		<td>${item.toDate }</td>
		<td>${item.roleTitle }</td>
		</tr>
		</c:forEach>
		</table>
		</c:otherwise>
	</c:choose>
</body>
</html>