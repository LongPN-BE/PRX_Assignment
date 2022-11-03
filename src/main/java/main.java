/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entity.*;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import models.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Pc
 */
public class main {

    public static void main(String[] args) throws IOException, JAXBException, ParserConfigurationException, SAXException {
        CityModel cmodel = new CityModel();
        TourTypeModel ttmodel = new TourTypeModel();
        TouristDestinationModel tdmodel = new TouristDestinationModel();
        
        City city = new City();
        cmodel.createCity(city);
        
        
//        cmodel.readCity();
//        System.out.println(cmodel.getListCity());


//        System.out.println("-----------");
//        for (int i = 0; i < rumodel.getList().size(); i++) {
//            System.out.println(" Role :" + rmodel.searchRoleByID(rumodel.getList().get(i).getRoleid()));
//            System.out.println("User Match : " + umodel.searchUserByID(rumodel.getList().get(i).getUserid()));
//
//        }
    }
}
