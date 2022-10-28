/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entity.City;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import utils.DBUtil;

/**
 *
 * @author Pc
 */
public class CityModel {

    private List<City> cities = new ArrayList<>();

    public List<City> getCities() {
        return cities;
    }

    public void readListCities() throws ParserConfigurationException, SAXException, IOException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Document doc = db.connect();
        doc.getDocumentElement().normalize();
        // in phần tử gốc ra màn hình
        NodeList nodeCities = doc.getElementsByTagName("city");
        // duyệt các phần tử
        for (int i = 0; i < nodeCities.getLength(); i++) {
            City city = new City();
            Node nNode = nodeCities.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                city.setId(eElement.getElementsByTagName("id")
                        .item(0).getTextContent());
                city.setName(eElement.getElementsByTagName("name")
                        .item(0).getTextContent());
                city.setDescription(eElement.getElementsByTagName("description")
                        .item(0).getTextContent());
            }
            this.cities.add(city);
        }
    }

}