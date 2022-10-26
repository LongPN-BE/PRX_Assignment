/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Pc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "tourtype")
@XmlAccessorType(XmlAccessType.FIELD)
public class TourType implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String description;

    @XmlElementWrapper(name = "tours")
    @XmlElement(name = "tour")
    private List<Tour> listTours;
}
