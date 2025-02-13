package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private double price; // Обычная цена товара

    public SimpleProduct(String name, double price) {
        super(name);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false; // Обычный товар не является специальным
    }
}
