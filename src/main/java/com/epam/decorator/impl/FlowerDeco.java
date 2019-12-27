package com.epam.decorator.impl;

import com.epam.bouquet.enums.Flower;
import com.epam.decorator.BouquetDecorator;

public class FlowerDeco extends BouquetDecorator {

    public FlowerDeco(Flower flower, int number) {
        setToName(" + additionalFlower (" + flower.name() + ", " + number + " pcs)");
        setAdditionalFlower(flower,number);
        setAdditionalPrice(flower.getPrice() * number);
    }
}
