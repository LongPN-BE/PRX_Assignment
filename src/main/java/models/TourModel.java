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

    DBUtil db = new DBUtil();

    private List<Tour> listtour = new ArrayList<>();

    public List<Tour> getListTour() {
        return this.listtour;
    }

    public void readTour() throws IOException, JAXBException {
        // đọc file input.xml
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                this.listtour.add(root.getListTourType().get(i).getListTour().get(j));
            }
        }
    }

    public Tour searchTourByName(String name) throws IOException, JAXBException {
        // đọc file input.xml
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                if (root.getListTourType().get(i).getListTour().get(j).getName().contains(name)) {
                    return root.getListTourType().get(i).getListTour().get(j);
                }
            }
        }
        return null;
    }

    public Tour searchTourByID(String id) throws IOException, JAXBException {
        // đọc file input.xml
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                if (root.getListTourType().get(i).getListTour().get(j).getId().contains(id)) {
                    return root.getListTourType().get(i).getListTour().get(j);
                }
            }
        }
        return null;
    }

    public boolean updateTour(Tour tour) throws IOException, JAXBException {
        // đọc file input.xml
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                if (root.getListTourType().get(i).getListTour().get(j).getId().contains(tour.getId())) {
                    root.getListTourType().get(i).getListTour().get(j).setName(tour.getName());
                    root.getListTourType().get(i).getListTour().get(j).setContent(tour.getContent());
                    root.getListTourType().get(i).getListTour().get(j).setDays(tour.getDays());
                    root.getListTourType().get(i).getListTour().get(j).setStartDate(tour.getStartDate());
                    root.getListTourType().get(i).getListTour().get(j).setEndDate(tour.getEndDate());
                    root.getListTourType().get(i).getListTour().get(j).setImg(tour.getImg());
                    db.marshaller(root);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean createTour(Tour tour) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        boolean check = false;
        int tourtypeplace = 0;
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                if (root.getListTourType().get(i).getListTour().get(j).getId().contains(tour.getId())) {
                    tourtypeplace = i;
                }
                
            }
        }
        if (check) {
            String id = String.valueOf(root.getListTourType().get(tourtypeplace).getListTour().get(root.getListTourType().get(tourtypeplace).getListTour().size()).getId() + 1);
            tour.setId(id);
            root.getListTourType().get(tourtypeplace).getListTour().add(tour);
            db.marshaller(root);
        }
        return false;
    }
    public boolean deleteTour(String id) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                if (root.getListTourType().get(i).getListTour().get(j).getId().contains(id)) {
                    root.getListTourType().get(i).getListTour().remove(j);
                    db.marshaller(root);
                    return true;
                }
            }
        }
        return false;
    }
}
