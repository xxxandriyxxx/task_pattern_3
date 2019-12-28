package com.epam.bouquet.impl;

import com.epam.bouquet.enums.Flower;

public class StandardWeddingBouquet extends StandardBouquet {

    public StandardWeddingBouquet() {
        super("StandardWeddingBouquet");
        flowers.put(Flower.ROSE, 11);
        flowers.put(Flower.DAISY, 10);
        setPrice();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
