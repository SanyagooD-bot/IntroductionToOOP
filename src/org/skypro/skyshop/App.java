package org.skypro.skyshop;

import java.util.List;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static class Main {
        public static void main(String[] args) {
            Product simpleProduct = new SimpleProduct("Молоко", 81.0);
            Product discountedProduct = new DiscountedProduct("Хлеб", 55.0, 25);
            Product fixPriceProduct = new FixPriceProduct("Кофе");

            // Создаем корзину и добавляем товары
            ProductBasket basket = new ProductBasket();
            basket.addProduct(simpleProduct);
            basket.addProduct(discountedProduct);
            basket.addProduct(fixPriceProduct);

            // Выводим содержимое корзины
            System.out.println("Содержимое корзины:");
            basket.printBasket();

            // Удаляем существующий продукт
            System.out.println("\nУдаляем продукт 'Хлеб':");
            List<Product> removedProducts = basket.removeProductsByName("Хлеб");
            if (!removedProducts.isEmpty()) {
                System.out.println("Удаленные продукты:");
                for (Product product : removedProducts) {
                    System.out.println(product);
                }
            } else {
                System.out.println("Список пуст.");
            }

            // Выводим содержимое корзины после удаления
            System.out.println("\nСодержимое корзины после удаления:");
            basket.printBasket();

            // Удаляем несуществующий продукт
            System.out.println("\nУдаляем продукт 'Вода':");
            removedProducts = basket.removeProductsByName("Вода");
            if (!removedProducts.isEmpty()) {
                System.out.println("Удаленные продукты:");
                for (Product product : removedProducts) {
                    System.out.println(product);
                }
            } else {
                System.out.println("Список пуст.");
            }

            // Выводим содержимое корзины после удаления
            System.out.println("\nСодержимое корзины после удаления:");
            basket.printBasket();
        }
    }

}
