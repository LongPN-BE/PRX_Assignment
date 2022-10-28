<%-- 
    Document   : tours
    Created on : Oct 25, 2022, 3:42:13 PM
    Author     : Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<h1>List Tour</h1>
<c:set value="${sessionScope.TOURS}" var="list"/> 

<c:if test="${not empty list}">

    <table border="1">
        <thead>
            <tr>
                <th>No.</th>
                <th>ID</th>
                <th>Name</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Days</th>
                <th>Content</th>
                <th>Image</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${list}" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.startDate}</td>
                    <td>${item.endDate}</td>
                    <td>${item.days}</td>
                    <td>${item.content}</td>
                    <td>${item.img}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</c:if>

<c:if test="${empty list}">
    <h2>
        No Tour is Existed!!
    </h2>
</c:if>

