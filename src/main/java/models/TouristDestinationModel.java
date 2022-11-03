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
        CityModel cmodel = new CityModel();
        int numCity = cmodel.searchLocationCityByID(cityID);
        boolean check = true;
        for (int i = 0; i < root.getListCity().get(numCity).getListTourist().size(); i++) {
            if (root.getListCity().get(numCity).getListTourist().get(i).getName().equals(touristDestination.getName())) {
                check = false;
            }
        }
        if (check) {
            String id = String.valueOf(root.getListCity().get(numCity).getListTourist().get(root.getListCity().get(numCity).getListTourist().size()).getId() + 1);
            touristDestination.setId(id);
            root.getListCity().get(numCity).getListTourist().add(touristDestination);
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
