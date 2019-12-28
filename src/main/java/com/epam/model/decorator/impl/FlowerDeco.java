package com.epam.model.decorator.impl;

import com.epam.model.enums.Flower;
import com.epam.model.decorator.BouquetDecorator;

public class FlowerDeco extends BouquetDecorator {

    public FlowerDeco(Flower flower, int number) {
        setToName(" + additionalFlower (" + flower.name() + ", " + number + " pcs)");
        setAdditionalFlower(flower,number);
        setAdditionalPrice(flower.getPrice() * number);
    }
}
