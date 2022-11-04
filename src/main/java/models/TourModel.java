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

    public boolean updateTour(Tour tour, String tourtypeID) throws IOException, JAXBException {
        // đọc file input.xml
        Root root = db.unmarshaller();
        int tourtypeplace = 0;
        for (int i = 0; i < root.getListTourType().size(); i++) {
            if (root.getListTourType().get(i).getId().equals(tourtypeID)) {
                tourtypeplace = i;
            }
        }
        for (int i = 0; i < root.getListTourType().get(tourtypeplace).getListTour().size(); i++) {
            if (root.getListTourType().get(tourtypeplace).getListTour().get(i).getId().contains(tour.getId())) {
                root.getListTourType().get(tourtypeplace).getListTour().get(i).setName(tour.getName());
                root.getListTourType().get(tourtypeplace).getListTour().get(i).setContent(tour.getContent());
                root.getListTourType().get(tourtypeplace).getListTour().get(i).setDays(tour.getDays());
                root.getListTourType().get(tourtypeplace).getListTour().get(i).setStartDate(tour.getStartDate());
                root.getListTourType().get(tourtypeplace).getListTour().get(i).setEndDate(tour.getEndDate());
                root.getListTourType().get(tourtypeplace).getListTour().get(i).setImg(tour.getImg());
                db.marshaller(root);
                return true;
            }

        }
        return false;
    }

    public boolean createTour(Tour tour, String tourtypeID) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        boolean check = true;
        int tourtypeplace = 0;
        int lastindex = 0;
        int id = 0;
        for (int i = 0; i < root.getListTourType().size(); i++) {
            if (root.getListTourType().get(i).getId().equals(tourtypeID)) {
                tourtypeplace = i;
            }
        }
        for (int j = 0; j < root.getListTourType().get(tourtypeplace).getListTour().size(); j++) {
            if (root.getListTourType().get(tourtypeplace).getListTour().get(j).getName().equals(tour.getName())) {
                check = false;
            }
        }
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                this.listtour.add(root.getListTourType().get(i).getListTour().get(j));
                lastindex = j;
            }
        }
        if (check) {
            id = Integer.parseInt(this.listtour.get(lastindex).getId()) + 3;
            tour.setId(String.valueOf(id));
            List<TourDetail> listtourdetail = new ArrayList<>();
            tour.setListTourDetail(listtourdetail);
            root.getListTourType().get(tourtypeplace).getListTour().add(tour);
            db.marshaller(root);
            return true;
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
