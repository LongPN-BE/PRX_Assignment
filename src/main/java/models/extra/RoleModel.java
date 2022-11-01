/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.extra;

import entity.extra.Role;
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
public class RoleModel {

    DBUtil db = new DBUtil();

    private List<Role> listrole = new ArrayList<>();

    public List<Role> getList() {
        return this.listrole;
    }

    public void initData() throws IOException, JAXBException, ParserConfigurationException, SAXException {
        // đọc file input.xml
        Document doc = db.domRole();
        doc.getDocumentElement().normalize();
        NodeList nodeListStudent = doc.getElementsByTagName("role");
        for (int i = 0; i < nodeListStudent.getLength(); i++) {
            Role role = new Role();
            Node nNode = nodeListStudent.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                role.setId(eElement.getAttribute("id"));
                role.setName(eElement.getAttribute("name"));
            }
            this.listrole.add(role);
        }
    }

    public Role searchRoleByID(String id) throws IOException, JAXBException, ParserConfigurationException, SAXException {
        if (this.listrole.isEmpty()) {
            this.initData();
        }
        for (Role role : listrole) {
            if (role.getId().equals(id)) {
                return role;
            }
        }
        return null;
    }
}
