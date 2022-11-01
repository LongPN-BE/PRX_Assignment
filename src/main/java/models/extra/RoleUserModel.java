/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.extra;

import entity.extra.LoginResponse;
import entity.extra.Role;
import entity.extra.RoleUser;
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
public class RoleUserModel {

    DBUtil db = new DBUtil();
    RoleModel rmodel = new RoleModel();
    UserModel umodel = new UserModel();

    private List<RoleUser> listroleuser = new ArrayList<>();

    public List<RoleUser> getList() {
        return this.listroleuser;
    }

    public void initData() throws IOException, JAXBException, ParserConfigurationException, SAXException {
        // đọc file input.xml
        Document doc = db.domRole();
        doc.getDocumentElement().normalize();
        NodeList nodeListStudent = doc.getElementsByTagName("userrole");
        for (int i = 0; i < nodeListStudent.getLength(); i++) {
            RoleUser roleuser = new RoleUser();
            Node nNode = nodeListStudent.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                roleuser.setId(eElement.getAttribute("id"));
                roleuser.setUserid(eElement.getAttribute("userid"));
                roleuser.setRoleid(eElement.getAttribute("roleid"));
            }
            this.listroleuser.add(roleuser);
        }
    }

    public RoleUser searchRoleByID(String id) throws IOException, JAXBException, ParserConfigurationException, SAXException {
        if (this.listroleuser.isEmpty()) {
            this.initData();
        }
        for (RoleUser role : listroleuser) {
            if (role.getId().equals(id)) {
                return role;
            }
        }
        return null;
    }

    public LoginResponse login(String username, String password) throws IOException, SAXException, JAXBException, ParserConfigurationException {
        umodel.initData();
        rmodel.initData();
        if (this.listroleuser.isEmpty()) {
            this.initData();
        }
        String uid = umodel.checkLogin(username, password);
        for (int i = 0; i < this.getList().size(); i++) {
            if (this.listroleuser.get(i).getUserid().equals(uid)) {
                LoginResponse response = new LoginResponse();
                Role role = rmodel.searchRoleByID(this.listroleuser.get(i).getRoleid());
                response.setRolename(role.getName());
                response.setUsername(username);
                return response;
            }
        }
        return null;
    }
}
