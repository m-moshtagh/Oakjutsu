package com.dogigiri.designpatterns.mosh.iterator.exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductCollection implements Iterable<Product> {
    private final List<Product> products = new ArrayList<>();

    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public Iterator<Product> iterator() {
        return new ProductIterator(this);
    }


    private static class ProductIterator implements Iterator<Product> {

        private final ProductCollection productCollection;
        private int index;

        public ProductIterator(ProductCollection productCollection) {
            this.productCollection = productCollection;
        }

        @Override
        public boolean hasNext() {
            return index < productCollection.products.size();
        }

        @Override
        public Product next() {
            Product product = productCollection.products.get(index++);
            if (product == null)
                throw new NoSuchElementException();
            return product;
        }
    }

}
