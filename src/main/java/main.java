/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.*;
import models.*;

import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBException;


/**
 *
 * @author Pc
 */
public class main {

    public static void main(String[] args) throws IOException, JAXBException {
        CityModel cityModel = new CityModel();
        cityModel.readCity();
        List<City> cities = cityModel.getListCity();
        System.out.println(cities);
        System.out.println("Search City: " + cityModel.searchCityByName("Ho Chi Minh"));
        
        TourModel tourModel = new TourModel();
        tourModel.readTour();
        List<Tour> tours = tourModel.getListTour();
        System.out.println(tours);
        
        TourTypeModel tourtypeModel = new TourTypeModel();
        tourtypeModel.readTourType();
        List<TourType> tourTypes = tourtypeModel.getListTourType();
        System.out.println(tourTypes);

        TouristDestinationModel touristModel = new TouristDestinationModel();
        touristModel.readTourist();
        List<TouristDestination> tourist = touristModel.getListTourist();
        System.out.println(tourist);
    }
}
