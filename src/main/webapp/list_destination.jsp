<%-- 
    Document   : touristdestination
    Created on : Oct 28, 2022, 8:10:33 PM
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


<c:set value="${sessionScope.TOURIST}" var="list" />

<body>
    <div class="popular_places_area">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="section_title text-center mb_70">
                        <h3>Popular Places</h3>
                        <p>Suffered alteration in some form, by injected humour or good day randomised booth anim 8-bit
                            hella wolf moon beard words.</p>
                    </div>
                </div>
            </div>
            <c:if test="${not empty list}">
                <div class="row">

                    <c:forEach var="item" items="${list}" varStatus="counter">
           <!--Form lấy thông tin đem qua destination_detail.jsp-->             
                        <form class="col-lg-4 col-md-6">
                            <div class="single_place">
                                <div class="thumb">
                                    <img src="img/place/${item.img}.png" alt="">
                                    <a href="#" class="prise">${item.id}</a>
                                </div>
                                <div class="place_info">
                                    <a href="destination_details.html">
                                        <h3>${item.name}</h3>
                                    </a>
                                    <p>${item.description}</p>
                                    <div class="rating_days d-flex justify-content-between">
                                        <span class="d-flex justify-content-center align-items-center">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <a href="#">(20 Reviews)</a>
                                        </span>
                                        <div class="days">
                                                <button type="submit" class="genric-btn info radius">Info</button>
                                            </div>
                                    </div>
                                </div>
                            </div>
                        </form> 
                    </c:forEach>

                </div>



        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="more_place_btn text-center">
                    <a class="boxed-btn4" href="destination.jsp">More Places</a>
                </div>
            </div>
        </div>
        </c:if>

        <c:if test="${empty list}">
            <h2>
                No Tourist Destination is Existed!!
            </h2>
        </c:if>

    </div>
</body>

</html>