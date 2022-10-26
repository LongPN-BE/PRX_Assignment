/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.City;
import entity.Root;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import models.CityModel;

/**
 *
 * @author Pc
 */
@WebServlet(name = "DispatcherServlet", urlPatterns = "/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
    
    private static final String HOMEPAGE = "home.jsp";
    
    public List<City> listCity() throws JAXBException {
        File f = new File("data.xml");
        JAXBContext jAXBContext;
        jAXBContext = JAXBContext.newInstance(Root.class);
        Unmarshaller u = jAXBContext.createUnmarshaller();
        Root root = (Root) u.unmarshal(f);
        return root.getListCities();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        CityModel model = new CityModel();
//        String url = HOMEPAGE;
//        String button = request.getParameter("button");
        try {
//            if (button.isEmpty() || button.equals("")) {
//
//            }
            List<City> listCity = null;
            listCity = model.getCities();
//            HttpSession session = request.getSession();
//            session.setAttribute("CITIES", listCity() );
            out.print(listCity.get(0).getName());
            
        } catch (JAXBException ex) {
            Logger.getLogger(DispatcherServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch(Exception ex){
            
        }
//        finally {
//            request.getRequestDispatcher(url).forward(request, response);
//            out.close();
//        }
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
