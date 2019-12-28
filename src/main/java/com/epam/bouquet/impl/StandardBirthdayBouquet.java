package com.epam.bouquet.impl;

import com.epam.bouquet.enums.Flower;

public class StandardBirthdayBouquet extends StandardBouquet {

    public StandardBirthdayBouquet() {
        super("StandardBirthdayBouquet");
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
