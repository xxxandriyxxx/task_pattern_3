package com.epam.model.bouquet_catalogue.impl;

import com.epam.model.bouquet_catalogue.Bouquet;
import com.epam.model.enums.Flower;
import com.epam.model.enums.DeliveryMethod;
import com.epam.model.enums.PackagingMethod;

import java.util.HashMap;
import java.util.Map;

public class EmptyBouquet implements Bouquet {

    protected String name;
    private double price;
    protected HashMap<Flower, Integer> flowers;
    private PackagingMethod packagingMethod;
    private DeliveryMethod deliveryMethod;

    public EmptyBouquet() {
        this.name = "EmptyBouquet";
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
