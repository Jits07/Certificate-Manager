<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<%@ page isELIgnored="false" %>

	<h2>certificates for ${username}</h2>

	<table border="1px" bordercolor="black" width=80% align="center">
                <tr>
                    <td>User</td>
                     <td>CertID</td>
                      <td>CN</td>
                       <td>IssuerCN</td>
                        <td>SignAlgo</td>
                    <td>Status</td>
                     <td>Version</td>
                     <td>Action</td>
                   <!--  <td>Action</td> -->
                </tr>
                <c:forEach items="${lists}" var="element">

                    <tr>
                        <td><c:out value="${element.get(user)}" /></td>
                        <td><c:out value="${element.get(certid)}" /></td>
                        <td><c:out value="${element.get(CN)}" /></td>
                        <td><c:out value="${element.get(issuer)}" /></td>
                        <td><c:out value="${element.get(algo)}" /></td>
                        <td><c:out value="${element.get(validity)}" /></td>
                        <td><c:out value="${element.get(version)}" /></td>
						<td><a href="delete-${userid}-${element.get(certid)} ">Delete </a>
						<a href="download-${userid}-${element.get(certid)} ">Download </a>
						
						 </td>
                        
                        
                        <%-- <td><a
                            href="<c:url value="editEmployee.htm">  
                    <c:param name="emp_id" value="${element.id}"/>  
        </c:url>  
    ">Edit</a>
                            <a
                            href="<c:url value="deleteEmployee.htm">  
                    <c:param name="emp_id" value="${element.id}"/>  
        </c:url>  
    ">Delete</a>

                        </td> --%>
                    </tr>

                </c:forEach>
            </table>
</body>
</html>