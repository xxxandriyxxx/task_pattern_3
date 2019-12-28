package com.epam.model.bouquet_catalogue;

import com.epam.model.enums.Flower;
import com.epam.model.enums.DeliveryMethod;
import com.epam.model.enums.PackagingMethod;

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
