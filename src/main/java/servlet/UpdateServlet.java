/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.*;
import entity.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phien
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String tourId = request.getParameter("tourID");
        String cityId = request.getParameter("cityID");
        String tourDetailId = request.getParameter("tourDetailID");
        String tourTypeId = request.getParameter("tourTypeID");
        String tourDesId = request.getParameter("tourDestinationID");

//        List<City> listCity = cityModel.getListCity();
        try {
            if (!tourId.isEmpty()) {
//                List<TourType> listTourType = tourTypeModel.getListTourType();
                TourModel tourModel = new TourModel();
                Tour tour = tourModel.searchTourByID(tourId);
                request.setAttribute("TOUR", tour);
//                request.setAttribute("LISTTYPE", listTourType);
            } else if (!cityId.isEmpty()) {
                CityModel cityModel = new CityModel();
                City city = cityModel.searchCityByName(cityId);
                request.setAttribute("CITY", city);
            } else if (!tourDetailId.isEmpty()) {
                TourDetailModel tourDetailModel = new TourDetailModel();
                TourDetail tourDetail = tourDetailModel.searchTourDetailById(tourDetailId);
                request.setAttribute("TOURDETAIL", tourDetail);
//                request.setAttribute("LISTCITY", listCity);
            } else if (!tourTypeId.isEmpty()) {
                TourTypeModel tourTypeModel = new TourTypeModel();
                TourType tourType = tourTypeModel.searchTourTypeByID(tourTypeId);
                request.setAttribute("TOURTYPE", tourType);
            } else if (!tourDesId.isBlank()) {
                TouristDestinationModel destinationModel = new TouristDestinationModel();
                TouristDestination touristDestination = destinationModel.searchTouristByID(tourDesId);
                request.setAttribute("TOURDES", touristDestination);
//                request.setAttribute("LISTCITY", listCity);
            }
        } catch (Exception e) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            request.getRequestDispatcher("").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
