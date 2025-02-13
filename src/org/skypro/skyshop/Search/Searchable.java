package org.skypro.skyshop.Search;

public interface Searchable {
    // Метод для получения термина поиска
    String getSearchTerm();

    // Метод для получения типа контента
    String getContentType();

    // Метод для получения имени объекта
    String getName();

    // Метод для преобразования объекта в строку (по умолчанию)
    default String getStringRepresentation() {
        return getName() + " — " + getContentType();
    }
}
