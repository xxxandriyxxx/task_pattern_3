package com.epam.model.decorator.impl;

import com.epam.model.decorator.BouquetDecorator;
import com.epam.model.enums.DeliveryMethod;

public class DeliveryDeco extends BouquetDecorator {

    public DeliveryDeco(DeliveryMethod deliveryMethod) {
        setToName(" + DeliveryDecorator (" + deliveryMethod.name() + ")");
        setAdditionalPrice(deliveryMethod.getPrice());
        setNewDeliveryMethod(deliveryMethod);
    }
}
