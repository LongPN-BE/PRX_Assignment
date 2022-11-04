<%-- 
    Document   : new_destination
    Created on : Nov 3, 2022, 5:03:34 AM
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

    <c:set value="${sessionScope.CITIES}" var="listCities" />

    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <div class="popular_destination_area">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-6">
                        <div class="section_title text-center">
                            <h3>Edit Destination</h3>
                        </div>
                    </div>
                </div>
                <form action="UpdateTouristDestinationServlet" method="GET">
                    <input name="destinationID" type="text" class="form-control" placeholder="" value="${TOURDES.id}" hidden>
                    <div class="form-group">
                        <label for="exampleFormControlInput1">Destination name</label>
                        <input name="txtName" type="text" class="form-control" placeholder="" value="${TOURDES.name}">
                    </div>
                    <div class="form-group">
                        <label>City</label>
                        <select name="" class="form-control">
                            <c:forEach var="item" items="${listCities}" varStatus="counter">
                                <option>${item.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">Description</label>
                        <textarea name="txtDes" class="form-control" id="exampleFormControlTextarea1" rows="3">${TOURDES.name}</textarea>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlInput1">Destination name</label>
                        <input name="txtImg" type="text" class="form-control" placeholder="" value="${TOURDES.name}">
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