package org.skypro.skyshop.product;

import org.skypro.skyshop.Article.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String getSearchTerm() {
        return name.toLowerCase(); // Поиск по имени товара (в нижнем регистре)
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract double getPrice();

    public abstract boolean isSpecial();

    // Остальные методы класса Product...
}


