package com.dogigiri.core.collections.collection;

import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * in order to create unmodifiable map we can use of() function. which is a factory method for collection API
 * We can also create an immutable collection from real collection using copyOf() function.
 */
public class ImmutableCollectionsDemo {
    public static void main(String[] args) {
        var immutableList = List.of(1, 2, 3);
        var immutableSet = Set.of(1, 2, 3);
        var immutableMap = Map.of(1, "Naruto", 2, "Hatake");
        var immutableMapEntry = Map.ofEntries(Map.entry(1, "nice"), Map.entry(2, "noice"));
        LoggerFactory.getLogger(ImmutableCollectionsDemo.class)
                .info("{} {} {} {}",immutableMap, immutableList,immutableSet, immutableMapEntry);
    }
}
