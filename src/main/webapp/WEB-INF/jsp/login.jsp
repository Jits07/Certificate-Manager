<html>
<head>
<%@ page isELIgnored="false" %>
<title>Login </title>
</head>
<body>
    <form action="login_welcome" >
        Name : <input name= "username" type="text" /><br>
        Password : <input name= "password" type= "password" /> <br>
        <input type="submit" />
        
    </form>
    <p><font color="red">${errorMessage}</font></p>
</body>
</html>