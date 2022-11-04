/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.*;
import entity.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phien
 */
@WebServlet(name = "DeleteServlet", urlPatterns = {"/DeleteServlet"})
public class DeleteServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String tourId = request.getParameter("tourID");
        String cityId = request.getParameter("cityID");
        String tourDetailId = request.getParameter("txtTourDetailID");
        String tourTypeId = request.getParameter("txtTourTypeID");
        String tourDesId = request.getParameter("tourDestinationID");
        boolean check = false;
        try {
            if (tourId != null) {
                TourModel tourModel = new TourModel();
                check = tourModel.deleteTour(tourId);
            } else if (cityId != null) {
                CityModel cityModel = new CityModel();
                check = cityModel.deleteCity(cityId);
            } else if (tourDetailId != null) {
                TourDetailModel tourDetailModel = new TourDetailModel();
                check = tourDetailModel.deleteTourDetail(tourDetailId);
            } else if (tourTypeId != null) {
                TourTypeModel tourTypeModel = new TourTypeModel();
                check = tourTypeModel.deleteTourType(tourTypeId);
            } else if (tourDesId != null) {
                TouristDestinationModel destinationModel = new TouristDestinationModel();
                check = destinationModel.deleteTourType(tourDesId);
            }
        } catch (Exception e) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            request.getRequestDispatcher("page_management.jsp").forward(request, response);
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
