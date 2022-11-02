<%-- 
    Document   : tours
    Created on : Nov 3, 2022, 2:47:48 AM
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


<c:set value="${sessionScope.TOURS}" var="list" />

<body>

    <!-- ================ recent tours   ================= -->

    <div class="recent_trip_area">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="section_title text-center mb_70">
                        <h3>Recent Tours</h3>
                    </div>
                </div>
            </div>

            <c:if test="${not empty list}">
                <div class="row">


                    <c:forEach var="item" items="${list}" varStatus="counter">

                        <div class="col-lg-4 col-md-6">
                            <div class="single_trip">
                                <div class="thumb">
                                    <img src="img/trip/${item.img}.png" alt="">
                                </div>
                                <div class="info">
                                    <a href="#">
                                        <h2>${item.name}</h2>
                                    </a>
                                    <div class="date">
                                        <span>Start: ${item.startDate}</span> <span>End: ${item.endDate}</span>
                                    </div>
                                    <a href="#">
                                        <h4>${item.content}</h4>
                                    </a>
                                    <a href="contact.jsp" class="genric-btn danger radius" >Register</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    
                </div>
            </c:if>



        </div>
    </div>
    <!-- ================ recent tours   ================= -->

</body>

</html>