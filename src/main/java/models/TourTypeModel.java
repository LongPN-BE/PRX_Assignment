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
public class TourTypeModel {

    private List<TourType> listTourType = new ArrayList<>();

    public List<TourType> getListTourType() {
        return listTourType;
    }

    public void readTourType() throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            this.listTourType.add(root.getListTourType().get(i));
        }
    }

    public TourType searchTourTypeByName(String name) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            if (root.getListTourType().get(i).getName().contains(name)) {
                return root.getListTourType().get(i);
            }
        }
        return null;
    }

    public TourType searchTourTypeByID(String id) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            if (root.getListTourType().get(i).getId().contains(id)) {
                return root.getListTourType().get(i);
            }
        }
        return null;
    }

    public boolean updateTourType(TourType tourType) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            if (root.getListTourType().get(i).getId().contains(tourType.getId())) {
                root.getListTourType().get(i).setName(tourType.getName());
                root.getListTourType().get(i).setDescription(tourType.getDescription());
                db.marshaller(root);
                return true;
            }
        }
        return false;
    }

    public boolean createTourType(TourType tourType) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        boolean check = true;
        int lastindex = 0;
        for (int i = 0; i < root.getListTourType().size(); i++) {
            if (root.getListTourType().get(i).getName().equals(tourType.getName())) {
                check = false;
            }
            lastindex = i;
        }
        if (true) {
            int id = Integer.parseInt(root.getListTourType().get(lastindex).getId()) + 1;
            tourType.setId(String.valueOf(id));
            List<Tour> listtour = new ArrayList<>();
            tourType.setListTour(listtour);
            root.getListTourType().add(tourType);
            db.marshaller(root);
            return true;
        }
        return false;
    }

    public boolean deleteTourType(String id) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            if (root.getListTourType().get(i).getId().contains(id)) {
                root.getListTourType().remove(i);
                db.marshaller(root);
                return true;
            }
        }
        return false;
    }
}
