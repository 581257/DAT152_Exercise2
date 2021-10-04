
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="dat152-libs" prefix="dat152"%>
    
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
                <c:choose> 
                    <c:when test="${pageContext.response.locale==no_NO}">
                <p> <fmt:message key="price"/>: ${p.priceInEuro}</p>
                    </c:when>
                </c:choose>
                <c:forEach items="${p.description}" var="d">
                    <c:choose>
                       <c:when test="${d.langCode== pageContext.response.locale}">
                             <p> <fmt:message key="description"/>: ${d.text}</p>   
                             <p> <dat152:shorttext>${d.text}</dat152:shorttext></p>                  
                       </c:when>
                    </c:choose>
                </c:forEach>
                <form action="Product" method="post">
                    <p><input type="hidden" name="pno" value="${p.pno}"/></p>
                    <p><input type="submit" value="<fmt:message key="add"/>" /></p>
                </form>
             </c:forEach>
          <p>   ${pageContext.response.locale}</p>
    
    
        <p><a href="index.jsp"><fmt:message key="home"/></a> <a href="Cart"><fmt:message key="cart" /></a></p>
        <p> <dat152:copyright since="2019"/> HVL<p> 
    </fmt:bundle>

</body>
</html>