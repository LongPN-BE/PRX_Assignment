<%-- Document : table_cities Created on : Nov 3, 2022, 5:19:26 PM Author : ncda --%>

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


            <c:set value="${sessionScope.TOURIST}" var="listDes" />

            <body>

                <div class="popular_destination_area">
                    <div class="container">
                        <h2>Destination</h2>
                        <div class="row">
                            <div class="col-1">
                                <div class="form-group">
                                    <!--		Show Numbers Of Rows 		-->
                                    <select class="form-control" name="state" id="maxRows">
                                        <option value="5000">Show ALL Rows</option>
                                        <option value="5">5</option>
                                        <option value="10">10</option>
                                        <option value="15">15</option>
                                        <option value="20">20</option>
                                        <option value="50">50</option>
                                        <option value="70">70</option>
                                        <option value="100">100</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <c:if test="${not empty listDes}">
                            <table class="table table-class" id="table-id">
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

                        </c:if>
                        <c:if test="${empty listDes}">
                            <h3>
                                No Destination is Existed!!
                            </h3>
                        </c:if>
                        <div class="row">
                            <div class="col-11">
                                <a href="#" class="genric-btn info radius">Add</a>
                            </div>
                            <div class="col-1">
                                <div class='pagination-container'>
                                    <nav>
                                        <ul class="pagination">

                                            <li data-page="prev">
                                                <span>
                                                    < <span class="sr-only">(current)
                                                </span></span>
                                            </li>
                                            <!--	Here the JS Function Will Add the Rows -->
                                            <li data-page="next" id="prev">
                                                <span> > <span class="sr-only">(current)</span></span>
                                            </li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                        <!--		Start Pagination -->

                    </div>
                </div>
                <!-- 		End of Container -->



                <script src="js/main.js"></script>
            </body>

            </html>