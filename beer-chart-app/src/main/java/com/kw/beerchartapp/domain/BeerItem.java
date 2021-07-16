package com.kw.beerchartapp.domain;

import com.kw.beerchartapp.EbcColorCode;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BeerItem {
    private int id;
    private String name;
    private String style;
    private double abv;
    private LocalDate bottlingDate;
    private int ebc;
    private int ibu;
    private String description;
    private String colorCode;

    public static BeerItem withColorCode(BeerItem beerItem) {
        beerItem.setColorCode(EbcColorCode.ofCode(beerItem.getEbc()).htmlCode);
        return beerItem;
    }
}
