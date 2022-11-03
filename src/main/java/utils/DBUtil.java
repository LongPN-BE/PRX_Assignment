/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Root;
import entity.extra.*;
import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

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
    private static final String pathLong = "E:/Semester 8/PRX301/prxassignment/PRX_Assignment/";

    private static final String pathAnh = "/Users/apple/Desktop/PRX_Assignment/PRX_Assignment/";

    private static final String pathPhien = "";

    public Root unmarshaller() throws JAXBException {
        File f = new File(pathLong + "data.xml");
        JAXBContext jAXBContext;
        jAXBContext = JAXBContext.newInstance(Root.class);
        Unmarshaller u = jAXBContext.createUnmarshaller();
        Root root = (Root) u.unmarshal(f);
        return root;
    }

    public boolean marshaller(Root root) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Root.class);
        javax.xml.bind.Marshaller m = jc.createMarshaller();
        m.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(root, new File(pathLong + "data.xml"));
        return true;
    }

    public Document domRole() throws ParserConfigurationException, SAXException, IOException {
        File inputFile = new File(pathLong + "hrroles.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        return doc;
    }

    public Document domUser() throws ParserConfigurationException, SAXException, IOException {
        File inputFile = new File(pathLong + "hrusers.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        return doc;
    }

    public Document domUserRole() throws ParserConfigurationException, SAXException, IOException {
        File inputFile = new File(pathLong + "hrroleuser.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        return doc;
    }
}
