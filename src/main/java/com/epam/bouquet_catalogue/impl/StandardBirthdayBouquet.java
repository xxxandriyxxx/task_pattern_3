package com.epam.bouquet_catalogue.impl;

import com.epam.bouquet_catalogue.enums.Flower;

public class StandardBirthdayBouquet extends EmptyBouquet {

    public StandardBirthdayBouquet() {
        name = "StandardBirthdayBouquet";
        flowers.put(Flower.TULIP, 9);
        flowers.put(Flower.IRIS, 5);
        flowers.put(Flower.POPPY, 3);
        setPrice();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}