package org.skypro.skyshop.Article;

import org.skypro.skyshop.Search.Searchable;

public final class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String getSearchTerm() {
        return (title + " " + text).toLowerCase(); // Поиск по названию и тексту статьи (в нижнем регистре)
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }
}
