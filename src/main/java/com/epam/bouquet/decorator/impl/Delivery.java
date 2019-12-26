package com.epam.bouquet.decorator.impl;

import com.epam.bouquet.decorator.BouquetDecorator;
import com.epam.bouquet.decorator.DeliveryMethod;

public class Delivery extends BouquetDecorator {

    public Delivery(DeliveryMethod deliveryMethod) {
        setAdditionalPrice(deliveryMethod.getPrice());
        setToName(" + Delivery (" + deliveryMethod.name() + ")");
    }
}
