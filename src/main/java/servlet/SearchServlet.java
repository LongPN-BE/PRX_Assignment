/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import models.*;
import entity.*;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Pc
 */
@WebServlet(name = "SearchServlet", urlPatterns = "/SearchServlet")
public class SearchServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String button = request.getParameter("txtValueSearch");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            CityModel cityModel = new CityModel();
            cityModel.readCity();
            List<City> cities = cityModel.getListCity();
            HttpSession session = request.getSession();
            session.setAttribute("CITIES", cities);

            TourModel tourModel = new TourModel();
            tourModel.readTour();
            List<Tour> tours = tourModel.getListTour();
            session.setAttribute("TOURS", tours);

            TourTypeModel tourtypeModel = new TourTypeModel();
            tourtypeModel.readTourType();
            List<TourType> tourTypes = tourtypeModel.getListTourType();
            session.setAttribute("TOURTYPES", tourTypes);

            TouristDestinationModel touristModel = new TouristDestinationModel();
            touristModel.readTourist();
            List<TouristDestination> tourist = touristModel.getListTourist();
            session.setAttribute("TOURIST", tourist);
            
        } catch (JAXBException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            response.sendRedirect("home.jsp");
            out.close();
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
