<%-- 
    Document   : home.jsp
    Created on : Oct 25, 2022, 3:37:35 PM
    Author     : Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Web Tourist</title>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <%@include file="slider.jsp" %>
        <%@include file="list_cities.jsp" %>
        <%@include file="list_destination.jsp" %>
        <%@include file="endingpage.jsp" %>
        <%@include file="list_tours.jsp" %>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
    
</html>
