package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static class Main {

        public static void main(String[] args) {
            ProductBasket Basket = new ProductBasket(); // Создаем корзину с вместимостью 5 продуктов

            Product product1 = new Product("Яблоки", 100);
            Product product2 = new Product("Бананы", 110);
            Product product3 = new Product("Мандарины", 150);
            Product product4 = new Product("Лимоны", 90);
            Product product5 = new Product("Киви", 180);
            Product product6 = new Product("Лайм", 250);

            System.out.println("-----------------------------------");

            Basket.addProduct(product1);
            Basket.addProduct(product2);
            Basket.addProduct(product3);
            Basket.addProduct(product4);
            Basket.addProduct(product5);
            Basket.addProduct(product6);

            Basket.printBasket();

            // Проверяем наличие продуктов в корзине
            System.out.println("-----------------------------------");

            System.out.println("Есть ли в корзине Бананы? " + Basket.containsProduct("Бананы"));
            System.out.println("Есть ли в корзине Апельсины? " + Basket.containsProduct("Апельсины"));
            System.out.println("-----------------------------------");
            System.out.print("Содержимое корзины после очистки: ");
            Basket.clearBasket();
        }
    }
}
