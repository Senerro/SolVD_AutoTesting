package com.solvd.demoautotesting.web.catalog_onliner.helpers.service;

import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.Laptop;
import org.apache.commons.lang3.StringUtils;

public class LaptopService {
    public static Laptop getLaptop(String name, String price){
        String numericText = StringUtils.strip(price, "р");
        String clearPrice = numericText.replace(" ", "");
        return new Laptop(name, price);
    }
}
