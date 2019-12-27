package com.epam.decorator.impl;

import com.epam.decorator.BouquetDecorator;
import com.epam.decorator.enums.DeliveryMethod;

public class Delivery extends BouquetDecorator {

    public Delivery(DeliveryMethod deliveryMethod) {
        setToName(" + Delivery (" + deliveryMethod.name() + ")");
        setAdditionalPrice(deliveryMethod.getPrice());
        setNewDeliveryMethod(deliveryMethod);
    }
}
