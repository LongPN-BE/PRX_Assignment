/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.*;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import models.*;
import models.extra.RoleUserModel;
import org.xml.sax.SAXException;

/**
 *
 * @author Pc
 */
public class main {

    public static void main(String[] args) throws IOException, JAXBException, ParserConfigurationException, SAXException {
        TourTypeModel tt2model = new TourTypeModel();
        TourModel t1moModel = new TourModel();
        TourDetailModel tdmoModel = new TourDetailModel();
        
//        TourType tourType = new TourType();
//        tourType.setName("Couple Parent");
//        tourType.setDescription("Đii đi vui lắm");
//        System.out.println(tt2model.createTourType(tourType));
        
//        Tour tour = new Tour();
//        tour.setName("Đà Lạt - Phan Thiếtt 1");
//        tour.setContent("Đi để đii luôn đi");
//        tour.setDays("5 days");
//        tour.setStartDate("5/11/2022");
//        tour.setEndDate("10/11/2022");
//        tour.setImg("url01");
//        System.out.println(t1moModel.createTour(tour, "3"));
//        
//        TourDetail detail =new TourDetail();
//        detail.setCityid("1");
//        System.out.println(tdmoModel.createTourDetail(detail, "0"));


    }
}
