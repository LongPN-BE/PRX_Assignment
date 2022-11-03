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

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City  implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String description;

    @XmlElementWrapper(name = "touristdestinations")
    @XmlElement(name = "touristdestination")
    private List<TouristDestination> listTourist;

    public City(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    
}
