package com.epam.bouquet.impl;

import com.epam.bouquet.Bouquet;
import com.epam.bouquet.enums.Flower;
import com.epam.decorator.enums.DeliveryMethod;
import com.epam.decorator.enums.PackagingMethod;

import java.util.HashMap;
import java.util.Map;

public abstract class StandardBouquet implements Bouquet {

    private String name;
    private double price;
    protected HashMap<Flower, Integer> flowers;
    private PackagingMethod packagingMethod;
    private DeliveryMethod deliveryMethod;

    protected StandardBouquet(String name) {
        this.name = name;
        flowers = new HashMap<>();
        packagingMethod = PackagingMethod.WITHOUT_PACKAGING;
        deliveryMethod = DeliveryMethod.WITHOUT_DELIVERY;
    }

    protected void setPrice() {
        for (Map.Entry<Flower, Integer> entry : flowers.entrySet()) {
            price += entry.getKey().getPrice() * entry.getValue();
        }
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

    @Override
    public String toString() {
        return "Bouquet{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", flowers=" + flowers +
                ", packagingMethod=" + packagingMethod +
                ", deliveryMethod=" + deliveryMethod +
                '}';
    }
}
