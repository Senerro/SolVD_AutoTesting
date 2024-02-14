package com.solvd.demoautotesting.web.catalog_onliner.helpers.models;

import java.math.BigDecimal;

public class Laptop {
    private final String name;
    private final BigDecimal price;

    public Laptop(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Laptop(String name, String strPrice){
        this(name, BigDecimal.valueOf(Double.parseDouble(strPrice)));
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
