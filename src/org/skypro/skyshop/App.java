package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
public class App {

    public static class Main {
        public static void main(String[] args) {
            // Создаем товары
            Product simpleProduct = new SimpleProduct("Яйца",130);
            Product discountedProduct = new DiscountedProduct("Хлеб", 50.0, 10); // Скидка 10%
            Product fixedPriceProduct = new FixPriceProduct("Молоко");

            // Создаем корзину и добавляем товары
            ProductBasket basket = new ProductBasket();
            basket.addProduct(simpleProduct);
            basket.addProduct(discountedProduct);
            basket.addProduct(fixedPriceProduct);

            // Выводим содержимое корзины
            basket.printBasket();
        }
    }
}
