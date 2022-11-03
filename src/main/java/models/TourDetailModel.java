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
public class TourDetailModel {

    DBUtil db = new DBUtil();

    private List<TourDetail> listtourdetail = new ArrayList<>();

    public List<TourDetail> getListTourDetail() {
        return this.listtourdetail;
    }

    public void readTourDetail() throws IOException, JAXBException {
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                for (int k = 0; k < root.getListTourType().get(i).getListTour().get(j).getListTourDetail().size(); k++) {
                    this.listtourdetail.add(root.getListTourType().get(i).getListTour().get(j).getListTourDetail().get(k));
                }
            }
        }
    }

    public TourDetail searchTourDetailById(String id) throws IOException, JAXBException {
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                for (int k = 0; k < root.getListTourType().get(i).getListTour().get(j).getListTourDetail().size(); k++) {
                    if (root.getListTourType().get(i).getListTour().get(j).getListTourDetail().get(k).getId().equals(id)) {
                        return root.getListTourType().get(i).getListTour().get(j).getListTourDetail().get(k);
                    }
                }
            }
        }
        return null;
    }

    public boolean updateTourDetail(TourDetail tourDetail) throws IOException, JAXBException {
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                for (int k = 0; k < root.getListTourType().get(i).getListTour().get(j).getListTourDetail().size(); k++) {
                    if (root.getListTourType().get(i).getListTour().get(j).getListTourDetail().get(k).getId().equals(tourDetail.getId())) {
                        root.getListTourType().get(i).getListTour().get(j).getListTourDetail().get(k).setCityid(tourDetail.getCityid());
                        db.marshaller(root);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean createTourDetail(TourDetail tourDetail, String tourID) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        boolean check = false;
        int tourtype = 0;
        int tour = 0;
        int lastindex = 0;
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                for (int k = 0; k < root.getListTourType().get(i).getListTour().get(j).getListTourDetail().size(); k++) {
                    if (root.getListTourType().get(i).getListTour().get(j).getListTourDetail().get(k).getId().equals(tourDetail.getId())) {
                        tour = i;
                        tour = j;
                        check = true;
                    }
                    lastindex = j;
                }
            }
        }
        if (check) {
            int id;
            if (lastindex != 0) {
                id = Integer.parseInt(root.getListTourType().get(tourtype).getListTour().get(tour).getListTourDetail().get(lastindex).getId()) + 1;
            } else {
                id = lastindex;
            }
            tourDetail.setId(String.valueOf(id));
            root.getListTourType().get(tourtype).getListTour().get(tour).getListTourDetail().add(tourDetail);
            db.marshaller(root);
        }
        return false;
    }

    public boolean deleteTourDetail(String id) throws IOException, JAXBException {
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                for (int k = 0; k < root.getListTourType().get(i).getListTour().get(j).getListTourDetail().size(); k++) {
                    if (root.getListTourType().get(i).getListTour().get(j).getListTourDetail().get(k).getId().equals(id)) {
                        root.getListTourType().get(i).getListTour().get(j).getListTourDetail().remove(k);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
