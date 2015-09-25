<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Happy Blogging</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
		
	</style>
</head>
<body>
<h1>
	Add a blog
</h1>

<c:url var="addAction" value="/blog/add" ></c:url>

<form:form action="${addAction}" commandName="blog">
<table>
	<c:if test="${!empty blog.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="description">
				<spring:message text="description"/>
			</form:label>
		</td>
		<td>
			<form:input path="description" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty blog.name}">
				<input type="submit"
					value="<spring:message text="Edit Blog"/>" />
			</c:if>
			<c:if test="${empty blog.name}">
				<input type="submit"
					value="<spring:message text="Add Blog"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Blogs List</h3>
<c:if test="${!empty listBlogs}">
	<table class="tg">
	<tr>
		<th width="80">Blog ID</th>
		<th width="120">Blog Name</th>
		<th width="120">Description</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listBlogs}" var="blog">
		<tr>
			<td>${blog.id}</td>
			<td>${blog.name}</td>
			<td>${blog.description}</td>
			<td><a href="<c:url value='/edit/${blog.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${blog.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
