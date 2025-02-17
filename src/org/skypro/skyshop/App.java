package org.skypro.skyshop;

import org.skypro.skyshop.Search.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Search.SearchEngine;
import org.skypro.skyshop.Search.BestResultNotFound;
import org.skypro.skyshop.basket.ProductBasket;

import java.util.List;
import java.util.Set;

public class App {

    public static class Main {
        public static void main(String[] args) {
            // Создаем товары
            Product simpleProduct = new SimpleProduct("Молоко", 80.0);
            Product discountedProduct = new DiscountedProduct("Хлеб", 50.0, 10);
            Product fixPriceProduct = new FixPriceProduct("Сок");

            // Создаем статьи
            Article article1 = new Article("Польза молока", "Молоко полезно для здоровья.");
            Article article2 = new Article("Рецепты с хлебом", "Хлеб можно использовать в различных блюдах.");
            Article article3 = new Article("Соки для детей", "Соки — это вкусно и полезно.");

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
            if (removedProducts != null && !removedProducts.isEmpty()) {
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
            if (removedProducts != null && !removedProducts.isEmpty()) {
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

            // Создаем поисковый движок
            SearchEngine searchEngine = new SearchEngine();
            searchEngine.add(simpleProduct);
            searchEngine.add(discountedProduct);
            searchEngine.add(fixPriceProduct);
            searchEngine.add(article1);
            searchEngine.add(article2);
            searchEngine.add(article3);

            // Демонстрация поиска
            System.out.println("\nРезультаты поиска по запросу 'молоко':");
            Set<Searchable> results = searchEngine.search("молоко");
            for (Searchable result : results) {
                System.out.println(result.getStringRepresentation());
            }

            System.out.println("\nРезультаты поиска по запросу 'хлеб':");
            results = searchEngine.search("хлеб");
            for (Searchable result : results) {
                System.out.println(result.getStringRepresentation());
            }

            System.out.println("\nРезультаты поиска по запросу 'сок':");
            results = searchEngine.search("сок");
            for (Searchable result : results) {
                System.out.println(result.getStringRepresentation());
            }

            // Демонстрация поиска лучшего результата
            try {
                Searchable bestMatch = searchEngine.findBestMatch("молоко");
                System.out.println("\nНайден лучший результат: " + bestMatch.getStringRepresentation());
            } catch (BestResultNotFound e) {
                System.out.println(e.getMessage());
            }

            try {
                Searchable bestMatch = searchEngine.findBestMatch("несуществующий запрос");
                System.out.println("\nНайден лучший результат: " + bestMatch.getStringRepresentation());
            } catch (BestResultNotFound e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
