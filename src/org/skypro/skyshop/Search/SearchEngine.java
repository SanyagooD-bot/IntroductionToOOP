package org.skypro.skyshop.Search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables;

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        String lowerCaseQuery = query.toLowerCase();
        return searchables.stream()
                .filter(searchable -> searchable.getSearchTerm().contains(lowerCaseQuery))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        String lowerCaseSearch = search.toLowerCase();
        return searchables.stream()
                .max((s1, s2) -> {
                    int count1 = countOccurrences(s1.getSearchTerm(), lowerCaseSearch);
                    int count2 = countOccurrences(s2.getSearchTerm(), lowerCaseSearch);
                    return Integer.compare(count1, count2);
                })
                .orElseThrow(() -> new BestResultNotFound("Не найдено подходящего результата для запроса: " + search));
    }

    private int countOccurrences(String term, String search) {
        int count = 0;
        int index = term.indexOf(search);
        while (index != -1) {
            count++;
            index = term.indexOf(search, index + 1);
        }
        return count;
    }
}

