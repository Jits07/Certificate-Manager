<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  

<html>  
<head>  
<%@ page isELIgnored="false" %>
<title>Upload File</title>  
</head>  
<body>  
  
 <center>  
  <h3>Please select a file to upload !</h3>  
  <br />  
  <form:form action = "upload-user-${userid}-add" enctype = "multipart/form-data">  
   <table>  
    <tr>  
     <td>Upload File: </td>  
     <td><input type="file" name="upload" />  
     </td>  
     <td style="color: red; font-style: italic;"><form:errors  
       path="upload" />  
       
     </td>  
    </tr>  
    <tr>  
     <td> </td>  
     <td><input type="submit" value="Upload" />  
     </td>  
     <td> </td>  
    </tr>  
   </table>  
  </form:form>  
 </center> 
<p><font color="red">${userid}</font></p>
</body>  
</html>  
