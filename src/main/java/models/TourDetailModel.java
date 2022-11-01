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
    private List<TourDetail> listtourdetail = new ArrayList<>();

    public List<TourDetail> getListTourDetail() {
        return this.listtourdetail;
    }

    public void readTourDetail() throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            for (int j = 0; j < root.getListTourType().get(i).getListTour().size(); j++) {
                for (int k = 0; k < root.getListTourType().get(i).getListTour().get(j).getListTourDetail().size(); k++) {
                    this.listtourdetail.add(root.getListTourType().get(i).getListTour().get(j).getListTourDetail().get(k));
                }
            }
        }
    }
}
