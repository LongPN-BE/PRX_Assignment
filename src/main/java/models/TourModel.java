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
public class TourModel {

    private List<Tour> listtour = new ArrayList<>();

    public List<Tour> getListTour() {
        return this.listtour;
    }

    public void readTour() throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                this.listtour.add(root.getListTourType().get(i).getListTour().get(j));
            }
        }
    }

    public Tour searchTour(String name) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                if(root.getListTourType().get(i).getListTour().get(j).getName().contains(name)){
                  return root.getListTourType().get(i).getListTour().get(j);
                }
            }
        }
        return null;
    }
}
