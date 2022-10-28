/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
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
public class Tour{
    private String id;
    private String name;
    private String startDate;
    private String endDate;
    private String days;
    private String content;
    private String img;

    private List<TourDetail> listTourDetails;
}
