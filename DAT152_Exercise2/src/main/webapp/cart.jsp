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
    <h1>Cart</h1>
    <table border="2">
    <tr>
    <th><fmt:message key="name"/></th>
    <th><fmt:message key="description"/></th>
    <th><fmt:message key="price"/></th>
    <th><fmt:message key="quantity"/></th>
    <th><fmt:message key="total"/></th>
    </tr>
    <c:forEach items="${choosen}" var="p">
    <tr>
    <td width="100">${p.pName}</td>
    <c:forEach items="${p.description}" var="d">
                    <c:choose>
                       <c:when test="${d.langCode==pageContext.response.locale}">
                              <td><dat152:shorttext>${d.text}</dat152:shorttext>  </td>
                       </c:when>
                    </c:choose>
                </c:forEach>
    <td>${p.priceInEuro}<fmt:message key="currency"/></td>
    <td>${p.qty}</td>
    <td>${p.qty*p.priceInEuro}<fmt:message key="currency"/></td>
    </tr>
    </c:forEach>
    <tr>
    <td colspan="4" style="text-align-last:end;"><fmt:message key="price"/></td>
     
    <td>
    
    ${total}<fmt:message key="currency"/>
   
    </td>
    
    </tr>
    </table>
<p><a href="index.jsp"><fmt:message key="home"/></a> <a href="Product"><fmt:message key="products" /></a></p>
<p> <dat152:copyright since="2019"/> HVL<p>
</fmt:bundle>
</body>
</html>