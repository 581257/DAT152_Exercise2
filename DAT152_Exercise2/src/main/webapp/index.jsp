<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib uri="dat152-libs" prefix="dat152"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Beste Firma AS</title>
</head>
<body>
    <p> <jsp:include page="chooseLanguage.jsp"/></p> 
    
    <fmt:bundle basename="dat152.languages.Messages">
    
    <h3> Beste Firma AS</h3>
    <img src="cup.jpg" alt="cup">
    <p> <fmt:message key="greeting" /> <a href="Product" ><fmt:message key="products" /> </a></p>
    
    
    <p> <dat152:copyright since="2019"/> HVL<p> 
    </fmt:bundle>
</body>
</html>