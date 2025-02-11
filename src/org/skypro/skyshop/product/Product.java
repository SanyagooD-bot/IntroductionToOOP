package org.skypro.skyshop.product;

public abstract class Product {
    private String name; // Название товара

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Абстрактный метод для получения цены
    public abstract double getPrice();

    @Override
    public String toString() {
        return name + ": " + getPrice() + " руб.";
    }

    public boolean isSpecial() {
        return false;
    }
}



