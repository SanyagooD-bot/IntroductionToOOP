package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final double FIXED_PRICE = 99.99; // Фиксированная цена

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return FIXED_PRICE; // Возвращаем фиксированную цену
    }

    @Override
    public boolean isSpecial() {
        return true; // Товар с фиксированной ценой является специальным
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIXED_PRICE + " руб.";
    }
}

