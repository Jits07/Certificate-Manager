<html>
<head>
<%@ page isELIgnored="false" %>
<title> Home Page </title>
</head>
<body>
<script >
function login() {
	document.location.href = "login";
	
}

</script>

    <form action="home">
   <a href = "login" >Login</a>
	<a href = "register" >Register</a>
	
    </form>
   <p><font color="green">${registerd}</font></p>
</body>
</html>