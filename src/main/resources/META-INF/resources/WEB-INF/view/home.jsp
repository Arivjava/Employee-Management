<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<body>
    <div>
        <div>
            <h1>Employee Management</h1>             
            <strong><a href="${contextPath}/newDept">Add Department</a></strong>
            <br>  
            <br>
            <strong><a href="${contextPath}/newRole">Add Role</a></strong>
            <br>
            <br> 
            <strong><a href="${contextPath}/newSkill">Add Skill</a></strong>
            <br>
            <br> 
            <strong><a href="${contextPath}/newProject">Add Project</a></strong>
            <br> 
            <br>
            <strong><a href="${contextPath}/newEmp">Add Employee</a></strong>
            <br>
            <br>
            <strong><a href="${contextPath}/newAllocation">Add Allocation</a></strong>
            <br>
            <br>
            <strong><a href="${contextPath}/displayAllocation">Display Allocation</a></strong>
            <br>
            
        </div>
    </div>
</body>
</html>