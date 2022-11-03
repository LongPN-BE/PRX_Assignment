<%-- 
    Document   : cities
    Created on : Oct 25, 2022, 3:41:46 PM
    Author     : Pc
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

<c:set value="${sessionScope.CITIES}" var="list" />

<body>
    <!-- popular_destination_area_start  -->
    <div class="popular_destination_area">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="section_title text-center mb_70">
                        <h3>Popular Cities</h3>
                        <p>Suffered alteration in some form, by injected humour or good day randomised booth anim 8-bit
                            hella wolf moon beard words.</p>
                    </div>
                </div>
            </div>

            <c:if test="${not empty list}">
                <div class="row">

                    <c:forEach var="item" items="${list}" varStatus="counter">
                        <div class="col-lg-4 col-md-6">
                            <div class="single_destination">
                                <div class="thumb">
                                    <img src="img/destination/${counter.count}.png" alt="">
                                </div>
                                <div class="content">
                                    <p class="d-flex align-items-center">${item.name}
                                        <a href="#">${item.description} </a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </c:if>


            <c:if test="${empty list}">
                <h2>
                    No City is Existed!!
                </h2>
            </c:if>


        </div>
    </div>
</body>

</html>