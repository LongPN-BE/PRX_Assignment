<%-- 
    Document   : header
    Created on : Nov 2, 2022, 11:18:14 PM
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
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css">

    <link rel="stylesheet" href="css/style.css">
</head>

<c:set value="${sessionScope.USER}" var="user" />
<c:set value="${sessionScope.ROLE}" var="role" />
<body>

    <!-- header-start -->
    <header>
        <div class="header-area ">
            <div id="sticky-header" class="main-header-area">
                <div class="container-fluid">
                    <div class="header_bottom_border">
                        <div class="row align-items-center">
                            <div class="col-xl-2 col-lg-2">
                                <div class="logo">
                                    <a href="home.jsp">
                                        <img src="img/logo.png" alt="">
                                    </a>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6">
                                <div class="main-menu  d-none d-lg-block">
                                    <nav>
                                        <ul id="navigation">
                                            <li><a class="active" href="home.jsp">home</a></li>
                                            <li><a href="about.jsp">About</a></li>
                                            <li><a class="" href="destination.jsp">Destination</a></li>
                                            <li><a href="tours.jsp">Tours</a></li>
                                            
                                            <!--User != null thì hiện-->
                                             <c:if test="${not empty user}">
                                            <li><a href="page_management.jsp">Page Management</a></li>
                                            </c:if>
                                            <!--User != null thì hiện-->
                                            <p>${user}</p>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                            <div class="col-xl-4 col-lg-4 d-none d-lg-block">
                                <div class="social_wrap d-flex align-items-center justify-content-end">
                                    <div class="number">
                                        <p> <i class="fa fa-phone"></i> 10(256)-928 256</p>
                                    </div>
                                    <div class="social_links d-none d-xl-block">
                                        <ul>
                                            
                                            <c:if test="${empty user}">
                                            <li><a href="login.jsp" class="genric-btn success radius">Login</a></li>
                                            </c:if>
                                            <c:if test="${not empty user}">
                                            <li>
                                            <form action="LogoutServlet" method="post">
                                            <button type="submit" class="genric-btn danger radius" >Logout</button>
                                            </form>
                                            </li>
                                            </c:if>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </header>
</body>

</html>
