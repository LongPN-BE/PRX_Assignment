
import entity.City;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.bind.*;
import models.CityModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pc
 */
public class main {
        public static void main(String[] args){
            try {
                System.out.println("Hello");
                
                CityModel model = new CityModel();
                List<City> cities = model.getCities();
                System.out.println(cities.get(0).toString());
            } catch (JAXBException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
