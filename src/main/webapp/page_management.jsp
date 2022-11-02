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
    <c:set value="${sessionScope.TOURIST}" var="listDes" />
    <c:set value="${sessionScope.CITIES}" var="listCities" />
    <c:set value="${sessionScope.TOURS}" var="listTours" />

    <body>
<header>
            <%@include file="header.jsp" %>
        </header>
        
        <div class="popular_destination_area">
            <div class="container">
                <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="section_title text-center">
                        <h3>Manager</h3>
                    </div>
                </div>
            </div>
                <h1 class="align-text-center">Cities</h1>
                <c:if test="${not empty listCities}">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Name</th>
                                <th scope="col">Description</th>
                                <th scope="col"></th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${listCities}" varStatus="counter">
                                <tr>
                                    <th scope="row">${item.id}</th>
                                    <td>${item.name}</td>
                                    <td>${item.description}</td>
                                    <td><a href="#" class="genric-btn warning radius">Edit</a></td>
                                    <td><a href="#" class="genric-btn danger radius">Delete</a></td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                    <a href="#" class="genric-btn info radius">Add</a>
                </c:if>

                <c:if test="${empty listCities}">
                    <h2>
                        No City is Existed!!
                    </h2>
                </c:if>
                
            </div>
        </div>
        

        <div class="popular_destination_area">
            <div class="container">
                <h1 class="align-text-center">Destinations</h1>
                <c:if test="${not empty listDes}">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Name</th>
                                <th scope="col">Description</th>
                                <th scope="col"></th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${listDes}" varStatus="counter">
                                <tr>
                                    <th scope="row">${item.id}</th>
                                    <td>${item.name}</td>
                                    <td>${item.description}</td>
                                    <td><a href="#" class="genric-btn warning radius">Edit</a></td>
                                    <td><a href="#" class="genric-btn danger radius">Delete</a></td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                    <a href="new_destination.jsp" class="genric-btn info radius">Add</a>
                </c:if>

                <c:if test="${empty listDes}">
                    <h2>
                        No Destinations is Existed!!
                    </h2>
                </c:if>
            </div>
        </div>
        
        

        <div class="popular_destination_area">
            <div class="container">
                <h1 class="align-text-center">Tours</h1>
                <c:if test="${not empty listTours}">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Name</th>
                                <th scope="col">Days</th>
                                <th scope="col">Start</th>
                                <th scope="col">End</th>
                                <th scope="col">Content</th>
                                <th scope="col"></th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${listTours}" varStatus="counter">
                                <tr>
                                    <th scope="row">${item.id}</th>
                                    <td>${item.name}</td>
                                    <td>${item.days}</td>
                                    <td>${item.startDate}</td>
                                    <td>${item.endDate}</td>
                                    <td>${item.content}</td>
                                    <td>
				<a href="#" class="genric-btn warning radius">Edit</a></td>
                                    <td><a href="#" class="genric-btn danger radius">Delete</a></td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                    <a href="#" class="genric-btn info radius">Add</a>
                </c:if>

                <c:if test="${empty listDes}">
                    <h2>
                        No Destinations is Existed!!
                    </h2>
                </c:if>

            </div>
        </div>
        
        
        
<footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>

    </html>