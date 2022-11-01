/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entity.*;
import entity.TouristDestination;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import utils.DBUtil;

/**
 *
 * @author Pc
 */
public class TouristDestinationModel {

    private List<TouristDestination> listtourist = new ArrayList<>();

    public List<TouristDestination> getListTourist() {
        return this.listtourist;
    }

    public void readTourist() throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListCity().size(); i++) {
            for (int j = 0; j < root.getListCity().get(i).getListTourist().size(); j++) {
                this.listtourist.add(root.getListCity().get(i).getListTourist().get(j));
            }
        }
    }

    public TouristDestination searchTouristByName(String name) throws IOException, JAXBException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListCity().size(); i++) {
            for (int j = 0; j < root.getListCity().get(i).getListTourist().size(); j++) {
                if (root.getListCity().get(i).getListTourist().get(j).getName().contains(name)) {
                    return root.getListCity().get(i).getListTourist().get(j);
                }
            }
        }
        return null;
    }
}
