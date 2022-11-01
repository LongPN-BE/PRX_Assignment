/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Root;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Pc
 */
public class DBUtil {

//    public Document connect() throws SAXException, ParserConfigurationException, IOException {
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        Document doc = db.parse("E:/Semester 8/PRX301/prxassignment/PRX_Assignment/data.xml");
//        return doc;
//    }
    public Root unmarshaller() throws JAXBException {
        File f = new File("data.xml");
        JAXBContext jAXBContext;
        jAXBContext = JAXBContext.newInstance(Root.class);
        Unmarshaller u = jAXBContext.createUnmarshaller();
        Root root = (Root) u.unmarshal(f);
        return root;
    }

    public boolean marshaller(Root root) throws JAXBException {
        File f = new File("data.xml");
        JAXBContext jAXBContext;
        jAXBContext = JAXBContext.newInstance(Root.class);
        Unmarshaller u = jAXBContext.createUnmarshaller();
        root = (Root) u.unmarshal(f);
        return true;
    }
}
