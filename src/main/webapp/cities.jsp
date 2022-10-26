<%-- 
    Document   : cities
    Created on : Oct 25, 2022, 3:41:46 PM
    Author     : Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1>List City</h1>
<c:set value="${requestScope.CITIES}" var="list"/> 

<c:if test="${not empty list}">

    <table border="1">
        <thead>
            <tr>
                <th>No.</th>
                <th>ID</th>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${list}" varStatus="counter">
                <tr>
                    <td>${counter.count}</td>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</c:if>

<c:if test="${empty list}">
    <h2>
        No Employee is Existed!!
    </h2>
</c:if>