/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entity.City;
import java.util.List;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Pc
 */
public class CityModel {

    private RootModel root = new RootModel();
    private List<City> cities;
    
    public List<City> getCities() throws JAXBException{
       return this.root.getRoot().getListCities();
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
    
}
