package com.epam.model;

import com.epam.model.bouquet_catalogue.Bouquet;
import com.epam.model.enums.*;
import com.epam.model.factory.Store;
import com.epam.model.factory.impl.FlowerStore1;
import com.epam.model.factory.impl.FlowerStore2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BusinessLogic implements Model {

    private Store store;

    @Override
    public List<String> getStores() {
        List<String> storesNames = new ArrayList<>();
        storesNames.add("Store 1");
        storesNames.add("Store 2");
        return storesNames;
    }

    @Override
    public Bouquet orderBouquet(int storeNumber, BaseBouquetType baseBouquetType, HashMap<Flower,
            Integer> additionalFlowers, PackagingMethod packagingMethod, DeliveryMethod deliveryMethod,
                                DiscountCard discountCard) {
        try {
            setStore(storeNumber);
            return store.order(baseBouquetType, additionalFlowers, packagingMethod, deliveryMethod, discountCard);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Bouquet getBouquet(int storeNumber, BaseBouquetType baseBouquetType) {
        try {
            setStore(storeNumber);
            return store.getBouquet(baseBouquetType);
        } catch (Exception e) {
            return null;
        }
    }

    private void setStore(int storeNumber) {
        if (storeNumber == 1) {
            store = new FlowerStore1();
        } else if (storeNumber == 2) {
            store = new FlowerStore2();
        }
    }

    @Override
    public List<Flower> getFlowers() {
        return new ArrayList<>(Arrays.asList(Flower.values()));
    }

    @Override
    public BaseBouquetType getDefaultBaseBouquetType() {
        return BaseBouquetType.EMPTY;
    }

    @Override
    public List<BaseBouquetType> getBaseBouquetTypes() {
        return new ArrayList<>(Arrays.asList(BaseBouquetType.values()));
    }

    @Override
    public PackagingMethod getDefaultPackagingMethod() {
        return PackagingMethod.WITHOUT_PACKAGING;
    }

    @Override
    public List<PackagingMethod> getPackagingMethods() {
        return new ArrayList<>(Arrays.asList(PackagingMethod.values()));
    }

    @Override
    public DeliveryMethod getDefaultDeliveryMethod() {
        return DeliveryMethod.WITHOUT_DELIVERY;
    }

    @Override
    public List<DeliveryMethod> getDeliveryMethods() {
        return new ArrayList<>(Arrays.asList(DeliveryMethod.values()));
    }

    @Override
    public DiscountCard getDefaultDiscountCard() {
        return DiscountCard.NO_CARD;
    }

    @Override
    public List<DiscountCard> getDiscountCards() {
        return new ArrayList<>(Arrays.asList(DiscountCard.values()));
    }
}