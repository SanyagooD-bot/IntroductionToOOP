package org.skypro.skyshop.Search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        // Сравниваем по длине имен (от большего к меньшему)
        int lengthComparison = Integer.compare(s2.getName().length(), s1.getName().length());
        if (lengthComparison != 0) {
            return lengthComparison;
        }
        // Если длины равны, сравниваем по именам в натуральном порядке
        return s1.getName().compareTo(s2.getName());
    }
}
