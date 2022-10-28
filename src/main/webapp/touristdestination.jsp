<%-- 
    Document   : touristdestination
    Created on : Oct 28, 2022, 8:10:33 PM
    Author     : Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<h1>List Tourist Destination</h1>
<c:set value="${sessionScope.TOURISTDESTINATIONS}" var="list"/> 

<c:if test="${not empty list}">

    <table border="1">
        <thead>
            <tr>
                <th>No.</th>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Image</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${list}" varStatus="counter">
            <tr>
                <td>${counter.count}</td>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.description}</td>
                <td>${item.img}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</c:if>

<c:if test="${empty list}">
    <h2>
        No Tourist Destination is Existed!!
    </h2>
</c:if>
