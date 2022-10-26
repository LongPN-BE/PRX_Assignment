/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entity.*;
import javax.xml.bind.JAXBException;
import utils.DBUtil;

/**
 *
 * @author Pc
 */
public class RootModel {
    private DBUtil until = null;
    private Root root = null;

    public Root getRoot() throws JAXBException{
      return until.unMarshaller();
    }

//    private List<TourType> tourtypes;
//    private List<Tour> tours;
//    private List<TouristDestination> touristdestinations;
//    private List<TourDetail> tourdetail;
}
