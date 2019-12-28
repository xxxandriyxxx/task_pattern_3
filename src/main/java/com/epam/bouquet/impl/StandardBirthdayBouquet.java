package com.epam.bouquet.impl;

import com.epam.bouquet.Bouquet;
import com.epam.bouquet.enums.Flower;
import com.epam.decorator.enums.DeliveryMethod;
import com.epam.decorator.enums.PackagingMethod;

import java.util.HashMap;
import java.util.Map;

public class StandardBirthdayBouquet implements Bouquet {

    private String name;
    private double price;
    private HashMap<Flower, Integer> flowers;
    private PackagingMethod packagingMethod;
    private DeliveryMethod deliveryMethod;

    public StandardBirthdayBouquet() {
        name = "StandardBirthdayBouquet";
        flowers = new HashMap<>();
        flowers.put(Flower.TULIP, 9);
        flowers.put(Flower.IRIS, 5);
        flowers.put(Flower.POPPY, 3);
        for (Map.Entry<Flower, Integer> entry : flowers.entrySet()) {
            price += entry.getKey().getPrice() * entry.getValue();
        }
        packagingMethod = PackagingMethod.WITHOUT_PACKAGING;
        deliveryMethod = DeliveryMethod.WITHOUT_DELIVERY;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCost() {
        return price;
    }

    @Override
    public HashMap<Flower, Integer> getFlowers() {
        return flowers;
    }

    @Override
    public PackagingMethod getPackagingMethod() {
        return packagingMethod;
    }

    @Override
    public void setPackagingMethod(PackagingMethod packagingMethod) {
        this.packagingMethod = packagingMethod;
    }

    @Override
    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    @Override
    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
