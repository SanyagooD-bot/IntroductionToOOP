package org.skypro.skyshop.product;

import org.skypro.skyshop.Article.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов.");
        }
        this.name = name;
    }

    @Override
    public String getSearchTerm() {
        return name.toLowerCase();
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
}


