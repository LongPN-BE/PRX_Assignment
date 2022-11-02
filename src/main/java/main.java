/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import models.extra.RoleModel;
import models.extra.RoleUserModel;
import models.extra.UserModel;
import org.xml.sax.SAXException;

/**
 *
 * @author Pc
 */
public class main {

    public static void main(String[] args) throws IOException, JAXBException, ParserConfigurationException, SAXException {
        RoleUserModel rumodel = new RoleUserModel();
        RoleModel rmodel = new RoleModel();
        UserModel umodel = new UserModel();
        rumodel.initData();
        rmodel.initData();
        umodel.initData();
//        System.out.println(umodel.searchUserByID("u01"));
        System.out.println(rumodel.login("mrnam2", "123456"));
        
        System.out.println(umodel.checkaccount("mrnam2", "123456"));
        System.out.println(rumodel.getList());


//        System.out.println("-----------");
//        for (int i = 0; i < rumodel.getList().size(); i++) {
//            System.out.println(" Role :" + rmodel.searchRoleByID(rumodel.getList().get(i).getRoleid()));
//            System.out.println("User Match : " + umodel.searchUserByID(rumodel.getList().get(i).getUserid()));
//
//        }
    }
}
