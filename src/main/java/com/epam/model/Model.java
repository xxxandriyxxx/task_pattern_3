package com.epam.model;

import com.epam.model.bouquet_catalogue.Bouquet;
import com.epam.model.enums.*;

import java.util.HashMap;
import java.util.List;

public interface Model extends Observable {

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
}
