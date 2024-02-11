package com.solvd.demoautotesting.web.vek21.helpers.models;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final String name;
    private final BigDecimal cost;

    public Product(String name, BigDecimal cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product products = (Product) object;
        return Objects.equals(name, products.name) && Objects.equals(cost, products.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }
}
