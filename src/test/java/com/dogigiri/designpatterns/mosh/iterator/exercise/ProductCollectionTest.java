package com.dogigiri.designpatterns.mosh.iterator.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductCollectionTest {
    ProductCollection products;

    @BeforeEach
    void setProducts() {
        products = new ProductCollection();
        products.add(new Product(1, "tea"));
        products.add(new Product(2, "coffee"));
        products.add(new Product(3, "juice"));
    }

    @Test
    @DisplayName(value = "Test Iterator productCollection")
    void iteratorTest() {
        assertThat(products.iterator()).toIterable().hasSize(3);
    }
}