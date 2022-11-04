<%-- 
    Document   : PageManagement
    Created on : Nov 3, 2022, 4:30:23 AM
    Author     : ncda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/nice-select.css">
        <link rel="stylesheet" href="css/flaticon.css">
        <link rel="stylesheet" href="css/gijgo.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/slick.css">
        <link rel="stylesheet" href="css/slicknav.css">
        <link rel="stylesheet"
            href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">

        <link rel="stylesheet" href="css/style.css">
    </head>


    
    <body>
        
        <header>
            <%@include file="header.jsp" %>
        </header>
        <div style="background: #f5f6fa"> 
            
        <%@include file="table_cities.jsp" %>

        <%@include file="table_des.jsp" %>
        
        <%@include file="table_tours.jsp" %>
        
        
        <%@include file="table_tourtype.jsp" %>
        
        </div>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>

    </html>