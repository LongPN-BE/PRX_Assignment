/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entity.TourType;
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
public class TourTypeModel {

    private List<TourType> listTourType = new ArrayList<>();

    public List<TourType> getListTourType() {
        return listTourType;
    }

    public void readTourTypes() throws ParserConfigurationException, SAXException, IOException {
        // đọc file input.xml
        DBUtil db = new DBUtil();
        Document doc = db.connect();
        doc.getDocumentElement().normalize();
        // in phần tử gốc ra màn hình
        NodeList nodeTourTypes = doc.getElementsByTagName("tourtype");
        // duyệt các phần tử
        for (int i = 0; i < nodeTourTypes.getLength(); i++) {
            TourType tourtype = new TourType();
            Node nNode = nodeTourTypes.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                tourtype.setId(eElement.getElementsByTagName("id")
                        .item(0).getTextContent());
                tourtype.setName(eElement.getElementsByTagName("name")
                        .item(0).getTextContent());
                tourtype.setDescription(eElement.getElementsByTagName("description")
                        .item(0).getTextContent());

            }
            this.listTourType.add(tourtype);
        }
    }
}
