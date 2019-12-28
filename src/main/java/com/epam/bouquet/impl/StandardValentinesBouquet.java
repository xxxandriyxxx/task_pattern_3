package com.epam.bouquet.impl;

import com.epam.bouquet.enums.Flower;

public class StandardValentinesBouquet extends EmptyBouquet {

    public StandardValentinesBouquet() {
        name = "StandardValentinesBouquet";
        flowers.put(Flower.SNOWDROP, 15);
        flowers.put(Flower.BLUEBELL, 10);
        setPrice();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
