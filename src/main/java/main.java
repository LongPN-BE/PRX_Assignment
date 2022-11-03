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

//        City city = new City();
//        city.setName("Demo Create");
//        city.setDescription("Demo Create");
//
//        System.out.println(cmodel.createCity(city));
//        cmodel.readCity();
//        System.out.println(cmodel.getListCity());

        TouristDestination tourist = new TouristDestination();
        tourist.setName("Demo create");
        tourist.setDescription("Demo create");
        tourist.setImg("Demo create");

        System.out.println(tdmodel.createTourist(tourist, "4"));

        System.out.println(tdmodel.getListTourist());


    }
}
