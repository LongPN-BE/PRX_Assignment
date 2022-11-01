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

    public TourType searchTourType(String name) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListTourType().size(); i++) {
            if(root.getListTourType().get(i).getName().contains(name)){
                return root.getListTourType().get(i);
            }
        }
        return null;
    }
}
