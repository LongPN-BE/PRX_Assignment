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

    public boolean updateTourDetail(TourDetail tourDetail, String tourID, String tourtypeID) throws IOException, JAXBException {
        Root root = db.unmarshaller();
        int placeTourType = 0;
        int placetour = 0;
        for (int i = 0; i < root.getListTourType().size(); i++) {
            if (root.getListTourType().get(i).equals(tourtypeID)) {
                placeTourType = i;
            }
        }
        for (int i = 0; i < root.getListTourType().get(placeTourType).getListTour().size(); i++) {
            if (root.getListTourType().get(placeTourType).getListTour().get(i).equals(tourtypeID)) {
                placetour = i;
            }
        }
        for (int i = 0; i < root.getListTourType().get(placeTourType).getListTour().get(placetour).getListTourDetail().size(); i++) {
            if (root.getListTourType().get(placeTourType).getListTour().get(placetour).getListTourDetail().get(i).equals(tourtypeID)) {
                root.getListTourType().get(placeTourType).getListTour().get(placetour).getListTourDetail().get(i).setCityid(tourDetail.getCityid());
                db.marshaller(root);
                return true;
            }
        }
        return false;
    }

    public boolean createTourDetail(TourDetail tourDetail, String tourID, String tourtypeID) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        boolean check = false;
        int placeTourType = 0;
        int placetour = 0;
        int lastindex = 0;
        for (int i = 0; i < root.getListTourType().size(); i++) {
            if (root.getListTourType().get(i).equals(tourtypeID)) {
                placeTourType = i;
            }
        }
        for (int i = 0; i < root.getListTourType().get(placeTourType).getListTour().size(); i++) {
            if (root.getListTourType().get(placeTourType).getListTour().get(i).equals(tourtypeID)) {
                placetour = i;
            }
        }
        for (int i = 0; i < root.getListTourType().get(placeTourType).getListTour().get(placetour).getListTourDetail().size(); i++) {
            lastindex = i;
        }
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                for (int k = 0; k < root.getListTourType().get(i).getListTour().get(j).getListTourDetail().size(); k++) {
                    if (root.getListTourType().get(i).getListTour().get(j).getListTourDetail().get(k).getId().equals(tourDetail.getId())) {
                        check = true;
                    }
                }
            }
        }
        if (check) {
            int id;
            if (lastindex != 0) {
                id = Integer.parseInt(root.getListTourType().get(placeTourType).getListTour().get(placetour).getListTourDetail().get(lastindex).getId()) + 1;
            } else {
                id = lastindex;
            }
            tourDetail.setId(String.valueOf(id));
            root.getListTourType().get(placeTourType).getListTour().get(placetour).getListTourDetail().add(tourDetail);
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
