<%-- 
    Document   : cities
    Created on : Oct 25, 2022, 3:41:46 PM
    Author     : Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<h1>List City</h1>
<c:set value="${sessionScope.CITIES}" var="list"/> 

<c:if test="${not empty list}">

    <table border="1">
        <thead>
            <tr>
                <th>No.</th>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${list}" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.description}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</c:if>

<c:if test="${empty list}">
    <h2>
        No City is Existed!!
    </h2>
</c:if>