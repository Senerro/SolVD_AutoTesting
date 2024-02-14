package com.solvd.demoautotesting.web.catalog_onliner.helpers.service;

import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.Laptop;
import org.apache.commons.lang3.StringUtils;

public class LaptopService {
    public static Laptop getLaptop(String name, String price){
        String clearPrice = price.replaceAll("[^0-9,]", "").replace(",",".");
        return new Laptop(name, clearPrice);
    }
}
