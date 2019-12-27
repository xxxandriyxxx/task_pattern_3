package com.epam.bouquet;

import com.epam.bouquet.enums.Flower;
import com.epam.decorator.enums.DeliveryMethod;
import com.epam.decorator.enums.PackagingMethod;

import java.util.HashMap;

public interface Bouquet {

    String getName();

    double getCost();

    HashMap<Flower, Integer> getFlowers();

    PackagingMethod getPackagingMethod();

    void setPackagingMethod(PackagingMethod packagingMethod);

    DeliveryMethod getDeliveryMethod();

    void setDeliveryMethod(DeliveryMethod deliveryMethod);
}
