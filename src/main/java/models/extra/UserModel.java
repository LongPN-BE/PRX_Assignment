/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.extra;

import entity.extra.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
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
public class UserModel {

    DBUtil db = new DBUtil();

    private List<User> listuser = new ArrayList<>();

    public List<User> getListUser() {
        return this.listuser;
    }

    public void initData() throws IOException, ParserConfigurationException, SAXException {
        // đọc file input.xml
        Document doc = db.domUser();
        doc.getDocumentElement().normalize();
        NodeList nodeListStudent = doc.getElementsByTagName("user");
        for (int i = 0; i < nodeListStudent.getLength(); i++) {
            User user = new User();
            Node nNode = nodeListStudent.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                user.setId(eElement.getAttribute("id"));
                user.setUsername(eElement.getAttribute("username"));
                user.setPassword(eElement.getAttribute("password"));
            }
            this.listuser.add(user);
        }
    }

    public User searchUserByID(String id) throws IOException, ParserConfigurationException, SAXException {
        if (this.listuser.isEmpty()) {
            this.initData();
        }
        for (User user : listuser) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public String checkaccount(String username, String password) throws IOException, ParserConfigurationException, SAXException {
        if (this.listuser.isEmpty()) {
            this.initData();
        }
        for (User user : listuser) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user.getId();
            }
        }
        return null;
    }
}
