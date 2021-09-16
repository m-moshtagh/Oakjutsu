package com.dogigiri.core.collections.list;

import java.util.ArrayList;
import java.util.List;

public class ListOfDemo {
    public static void main(String[] args) {
        List<String> anime = List.of("bleach", "Naruto", "Gintama");
        anime.add("asd");
        System.out.println(anime); // throws ImmutableCollectionException

        List<String> manga = new ArrayList<>();
        manga.add("bleach");
        manga.add("vagabond");
        List<String> strings = List.copyOf(manga);
        strings.add("attack on titan");
        System.out.println(strings); // throws ImmutableCollectionException
    }
}

