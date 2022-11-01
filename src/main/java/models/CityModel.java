/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entity.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import utils.DBUtil;

/**
 *
 * @author Pc
 */
public class CityModel {

    private List<City> listCity = new ArrayList<>();

    public List<City> getListCity() {
        return this.listCity;
    }

    public void readCity() throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListCity().size(); i++) {
            this.listCity.add(root.getListCity().get(i));
        }
    }

    public City searchCityByName(String name) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListCity().size(); i++) {
            if (root.getListCity().get(i).getName().contains(name)) {
                return root.getListCity().get(i);
            }
        }
        return null;
    }

    public boolean updateCity(City city) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListCity().size(); i++) {
            if (root.getListCity().get(i).getId().equals(city.getId())) {
                root.getListCity().get(i).setName(city.getName());
                root.getListCity().get(i).setDescription(city.getDescription());
                db.marshaller(root);
                return true;
            }
        }
        return false;
    }

//    public boolean createCity(City city) throws IOException, JAXBException {
//        // đọc file input.xml
//        DBUtil db = new DBUtil();
//        Root root = db.unmarshaller();
//        boolean check = false;
//        for (int i = 0; i < root.getListCity().size(); i++) {
//            if (root.getListCity().get(i).getName().equals(city.getName())) {
//                check = true;
//            }
//        }
//        if (check) {
//            String id = String.valueOf(root.getListCity().get(root.getListCity().size()).getId() + 1);
//            city.setId(id);
//            root.getListCity().add(city);
//            db.marshaller(root);
//        }
//        return false;
//    }
    public boolean deleteCity(String id) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListCity().size(); i++) {
            if (root.getListCity().get(i).getId().equals(id)) {
                root.getListCity().remove(i);
                db.marshaller(root);
                return true;
            }
        }
        return false;
    }
}
