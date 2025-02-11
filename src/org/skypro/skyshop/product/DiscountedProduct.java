package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final double basePrice; // Базовая цена
    private final int discount; // Скидка в процентах (от 0 до 100)

    public DiscountedProduct(String name, double basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return basePrice * (1 - discount / 100.0); // Цена с учетом скидки
    }

    @Override
    public boolean isSpecial() {
        return true; // Товар со скидкой является специальным
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " руб. (скидка " + discount + "%)";
    }
}
