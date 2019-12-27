package com.epam.decorator.impl;

import com.epam.decorator.BouquetDecorator;
import com.epam.decorator.enums.DeliveryMethod;

public class DeliveryDeco extends BouquetDecorator {

    public DeliveryDeco(DeliveryMethod deliveryMethod) {
        setToName(" + DeliveryDeco (" + deliveryMethod.name() + ")");
        setAdditionalPrice(deliveryMethod.getPrice());
        setNewDeliveryMethod(deliveryMethod);
    }
}
