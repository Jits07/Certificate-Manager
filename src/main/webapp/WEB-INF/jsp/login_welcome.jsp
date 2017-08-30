
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html>
<head>
<%@ page isELIgnored="false" %>
<title>Welcome </title>
</head>
<body>
Welcome ${username}.your userid is ${userid}. You are now authenticated.<br>

<a href="upload-user-${userid}" > Upload</a>
<a href="view-user-${userid}" > View </a>

</body>
</html>