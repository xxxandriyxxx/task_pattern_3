package com.epam.model.bouquet_catalogue.impl;

import com.epam.model.enums.Flower;

public class StandardWeddingBouquet extends EmptyBouquet {

    public StandardWeddingBouquet() {
        name = "StandardWeddingBouquet";
        flowers.put(Flower.ROSE, 11);
        flowers.put(Flower.DAISY, 10);
        setPrice();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
