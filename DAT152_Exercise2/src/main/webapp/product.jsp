
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beste Firma AS</title>
</head>
<body>


    <p> <jsp:include page="chooseLanguage.jsp"/></p>     
    <fmt:bundle basename="dat152.languages.Messages">
             <c:forEach items="${products}" var="p">
                <h3>  ${p.pName} </h3>
                <p> <fmt:message key="price"/>: ${p.priceInEuro}</p>
                <c:forEach items="${p.description}" var="d">
                    <c:choose>
                       <c:when test="${d.langCode==lang}">
                             <p> <fmt:message key="description"/>: funker ikke hvis jeg endrer underveis ${d.text}</p>
                       </c:when>
                    </c:choose>
                </c:forEach>
                <form action="Product" method="post">
                    <p><input type="hidden" name="pno" value="${p.pno}"/></p>
                    <p><input type="submit" value="<fmt:message key="add"/>" /></p>
                </form>
             </c:forEach>
    </fmt:bundle>
    
    <p> linker til hjem og cart</p>p> 


</body>
</html>