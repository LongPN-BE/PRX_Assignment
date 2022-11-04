<%-- Document : new_destination Created on : Nov 3, 2022, 5:03:34 AM Author : ncda --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
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

    <c:set value="${sessionScope.TOURTYPES}" var="listCities" />
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <div class="popular_destination_area">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-6">
                        <div class="section_title text-center">
                            <h3>Edit Tour</h3>
                        </div>
                    </div>
                </div>



                <form action="UpdateTourServlet" method="GET">
                    <input name="TourID" type="text" class="form-control" placeholder="" value="${TOUR.id}" hidden>
                    <div class="form-group">
                        <label>Tour name</label>
                        <input type="text" name="txtName" class="form-control" placeholder="" value="${TOUR.name}">
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">Content</label>
                        <textarea name="txtContent" class="form-control" rows="3" name="">${TOUR.content}</textarea>
                    </div>
                    <div class="form-group">
                        <label>Tour type</label>
                        <select name="tourType" class="form-control">
                            <c:forEach var="item" items="${listCities}" varStatus="counter">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Days</label>
                        <input type="text" name="txtDays" class="form-control" placeholder="" value="${TOUR.days}">
                    </div>
                    <div class="form-group">
                        <label>Start Date</label>
                        <input type="date" name="txtStartDate" class="form-control" id="" value="${TOUR.startDate}">
                    </div>
                    <div class="form-group">
                        <label>End Date</label>
                        <input type="date" name="txtEndDate" class="form-control" id="" value="${TOUR.endDate}">
                    </div>
                    <div class="form-group">
                        <label>Image</label>
                        <input type="text" name="txtImg" class="form-control" id="" value="${TOUR.img}">
                    </div>
                    <button type="submit" class="genric-btn success radius">Submit</button>
                </form>
            </div>
        </div>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>


</html>