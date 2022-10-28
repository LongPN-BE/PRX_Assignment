/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entity.City;
import entity.TouristDestination;
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
public class TouristDestinationModel {
    private List<TouristDestination> touristdestinations = new ArrayList<>();

    public List<TouristDestination> getTouristDestinations() {
        return this.touristdestinations;
    }

    public void readListTouristDestinations() throws ParserConfigurationException, SAXException, IOException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Document doc = db.connect();
        doc.getDocumentElement().normalize();
        // in phần tử gốc ra màn hình
        NodeList nodeTouristDestinations = doc.getElementsByTagName("touristdestination");
        // duyệt các phần tử
        for (int i = 0; i < nodeTouristDestinations.getLength(); i++) {
            TouristDestination touristdestination = new TouristDestination();
            Node nNode = nodeTouristDestinations.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                touristdestination.setId(eElement.getElementsByTagName("id")
                        .item(0).getTextContent());
                touristdestination.setName(eElement.getElementsByTagName("name")
                        .item(0).getTextContent());
                touristdestination.setDescription(eElement.getElementsByTagName("description")
                        .item(0).getTextContent());
                touristdestination.setImg(eElement.getElementsByTagName("img")
                        .item(0).getTextContent());

            }
            this.touristdestinations.add(touristdestination);
        }
    }
}
