package com.epam.controller;

import com.epam.model.bouquet_catalogue.Bouquet;
import com.epam.model.enums.*;
import com.epam.view.Observer;

import java.util.HashMap;
import java.util.List;

public interface Controller {

    List<String> getStores();

    Bouquet orderBouquet(int storeNumber, BaseBouquetType baseBouquetType, HashMap<Flower, Integer> additionalFlowers,
                         PackagingMethod packagingMethod, DeliveryMethod deliveryMethod, DiscountCard discountCard);

    Bouquet getBouquet(int storeNumber, BaseBouquetType baseBouquetType);

    List<Flower> getFlowers();

    BaseBouquetType getDefaultBaseBouquetType();

    List<BaseBouquetType> getBaseBouquetTypes();

    PackagingMethod getDefaultPackagingMethod();

    List<PackagingMethod> getPackagingMethods();

    DeliveryMethod getDefaultDeliveryMethod();

    List<DeliveryMethod> getDeliveryMethods();

    DiscountCard getDefaultDiscountCard();

    List<DiscountCard> getDiscountCards();

    void registerObserver(Observer observer);
}
