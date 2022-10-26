/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.City;
import entity.Root;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import models.RootModel;

/**
 *
 * @author Pc
 */
public class DBUtil {
    private static final String resource = "/data.xml";
    public Root unMarshaller() throws JAXBException {
        File f = new File(resource);
        JAXBContext jAXBContext;
        jAXBContext = JAXBContext.newInstance(Root.class);
        Unmarshaller u = jAXBContext.createUnmarshaller();
        Root root = (Root) u.unmarshal(f);
        return root;
    }

    public Root marshaller(Root root) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Root.class);
        javax.xml.bind.Marshaller m = jc.createMarshaller();
        m.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(root, new File(resource));
        return root;
    }
}
