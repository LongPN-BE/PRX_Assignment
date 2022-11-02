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
        <%@include file="cities.jsp" %>
        <%@include file="touristdestination.jsp" %>
        
        --
        <%@include file="tours.jsp" %>
        <%@include file="tourtypes.jsp" %>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
    
</html>
