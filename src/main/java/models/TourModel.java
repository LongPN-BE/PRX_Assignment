/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entity.Tour;
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
public class TourModel {

    private List<Tour> tours = new ArrayList<>();

    public List<Tour> getTours() {
        return this.tours;
    }

    public void readTours() throws SAXException, ParserConfigurationException, IOException {
        Tour tour = null;
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Document doc = db.connect();
        doc.getDocumentElement().normalize();
        // đọc tất cả các phần tử có tên thẻ là "student"
        NodeList nodeTours = doc.getElementsByTagName("tour");
        // duyệt các phần tử
        for (int i = 0; i < nodeTours.getLength(); i++) {
            tour = new Tour();
            Node nNode = nodeTours.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                tour.setId(eElement.getElementsByTagName("id")
                        .item(0).getTextContent());
                tour.setName(eElement.getElementsByTagName("name")
                        .item(0).getTextContent());
                tour.setStartDate(eElement.getElementsByTagName("startDate")
                        .item(0).getTextContent());
                tour.setEndDate(eElement.getElementsByTagName("endDate")
                        .item(0).getTextContent());
                tour.setDays(eElement.getElementsByTagName("days")
                        .item(0).getTextContent());
                tour.setContent(eElement.getElementsByTagName("content")
                        .item(0).getTextContent());
                tour.setImg(eElement.getElementsByTagName("img")
                        .item(0).getTextContent());
            }
            this.tours.add(tour);

        }
    }
}
