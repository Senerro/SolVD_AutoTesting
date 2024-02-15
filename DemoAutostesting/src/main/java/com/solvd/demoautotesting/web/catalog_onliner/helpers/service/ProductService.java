package com.solvd.demoautotesting.web.catalog_onliner.helpers.service;

import com.solvd.demoautotesting.web.catalog_onliner.helpers.models.Product;

import java.util.List;

public class ProductService {
    public static Product getProduct(String name, String price) {
        String clearPrice = price.replaceAll("[^0-9,]", "").replace(",",".");
        return new Product(name, clearPrice);
    }

    public static boolean productListsEquals(List<Product> firstList, List<Product> secondList) {
        if (firstList.size() != secondList.size())
            return false;
        for (int i = 0; i < firstList.size(); i++)
            if (!(firstList.get(i).equals(secondList.get(i))))
                return false;
        return true;
    }
}
