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

    DBUtil db = new DBUtil();

    private List<TouristDestination> listtourist = new ArrayList<>();

    public List<TouristDestination> getListTourist() {
        return this.listtourist;
    }

    public void readTourist() throws IOException, JAXBException {
        // đọc file input.xml
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListCity().size(); i++) {
            for (int j = 0; j < root.getListCity().get(i).getListTourist().size(); j++) {
                this.listtourist.add(root.getListCity().get(i).getListTourist().get(j));
            }
        }
    }

    public TouristDestination searchTouristByName(String name) throws IOException, JAXBException {
        // đọc file input.xml
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

    public TouristDestination searchTouristByID(String id) throws IOException, JAXBException {
        // đọc file input.xml
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListCity().size(); i++) {
            for (int j = 0; j < root.getListCity().get(i).getListTourist().size(); j++) {
                if (root.getListCity().get(i).getListTourist().get(j).getId().contains(id)) {
                    return root.getListCity().get(i).getListTourist().get(j);
                }
            }
        }
        return null;
    }

    public boolean createTourist(TouristDestination touristDestination, String cityID) throws IOException, JAXBException {
        // đọc file input.xml
        Root root = db.unmarshaller();
        int numCity = 0;
        for (int i = 0; i < root.getListCity().size(); i++) {
            if (root.getListCity().get(i).getId().equals(cityID)) {
                numCity = i;
            }
        }
        boolean check = true;
        int lastindex = 0;
        if (root.getListCity().get(numCity).getListTourist() != null) {
            for (int i = 0; i < root.getListCity().get(numCity).getListTourist().size(); i++) {
                if (root.getListCity().get(numCity).getListTourist().get(i).getName().equals(touristDestination.getName())) {
                    check = false;
                }
                lastindex = i;
            }
            if (check) {
                int id = Integer.parseInt(root.getListCity().get(numCity).getListTourist().get(lastindex).getId()) + 1;
                touristDestination.setId(String.valueOf(id));
                root.getListCity().get(numCity).getListTourist().add(touristDestination);
                db.marshaller(root);
                return true;
            }
        } else {
            List<TouristDestination> listtourist = new ArrayList<>();
            listtourist.add(touristDestination);
            root.getListCity().get(numCity).setListTourist(listtourist);
            db.marshaller(root);
            return true;
        }
        return false;
    }

    public boolean updateTourist(TouristDestination touristDestination) throws IOException, JAXBException {
        // đọc file input.xml
        Root root = db.unmarshaller();
        for (int i = 0; i < root.getListCity().size(); i++) {
            for (int j = 0; j < root.getListCity().get(i).getListTourist().size(); j++) {
                if (root.getListCity().get(i).getListTourist().get(j).getId().contains(touristDestination.getId())) {
                    root.getListCity().get(i).getListTourist().get(j).setName(touristDestination.getName());
                    root.getListCity().get(i).getListTourist().get(j).setDescription(touristDestination.getDescription());
                    root.getListCity().get(i).getListTourist().get(j).setImg(touristDestination.getImg());
                    db.marshaller(root);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteTourType(String id) throws IOException, JAXBException {
        // đọc file input.xml
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
