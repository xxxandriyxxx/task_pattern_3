package com.epam.decorator;

import com.epam.bouquet.Bouquet;
import com.epam.bouquet.enums.Flower;
import com.epam.decorator.enums.DeliveryMethod;
import com.epam.decorator.enums.PackagingMethod;

import java.util.HashMap;
import java.util.Optional;

public class BouquetDecorator implements Bouquet {

    protected Optional<Bouquet> bouquet;
    private String toName = "";
    private double additionalPrice;
    private Flower additionalFlower;
    private int additionalFlowerNumber;
    private PackagingMethod newPackagingMethod;
    private DeliveryMethod newDeliveryMethod;

    public void setBouquet(Bouquet outBouquet) {
        bouquet = Optional.ofNullable(outBouquet);
        if (additionalFlower != null) {
            bouquet.orElseThrow(IllegalArgumentException::new).getFlowers()
                    .put(additionalFlower, additionalFlowerNumber);
        }
        if (newPackagingMethod != null) {
            bouquet.orElseThrow(IllegalArgumentException::new).setPackagingMethod(newPackagingMethod);
        }
        if (newDeliveryMethod != null) {
            bouquet.orElseThrow(IllegalArgumentException::new).setDeliveryMethod(newDeliveryMethod);
        }
    }

    protected void setToName(String toName) {
        this.toName = toName;
    }

    protected void setAdditionalPrice(double additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    protected void setAdditionalFlower(Flower additionalFlower, int number) {
        this.additionalFlower = additionalFlower;
        this.additionalFlowerNumber = number;
    }

    protected void setNewPackagingMethod(PackagingMethod packagingMethod) {
        this.newPackagingMethod = packagingMethod;
    }

    protected void setNewDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.newDeliveryMethod = deliveryMethod;
    }

    @Override
    public String getName() {
        return bouquet.orElseThrow(IllegalArgumentException::new).getName() + toName;
    }

    @Override
    public double getCost() {
        return bouquet.orElseThrow(IllegalArgumentException::new).getCost() + additionalPrice;
    }

    @Override
    public HashMap<Flower, Integer> getFlowers() {
        return bouquet.orElseThrow(IllegalArgumentException::new).getFlowers();
    }

    @Override
    public PackagingMethod getPackagingMethod() {
        return bouquet.orElseThrow(IllegalArgumentException::new).getPackagingMethod();
    }

    @Override
    public void setPackagingMethod(PackagingMethod packagingMethod) {
        bouquet.orElseThrow(IllegalArgumentException::new).setPackagingMethod(packagingMethod);
    }

    @Override
    public DeliveryMethod getDeliveryMethod() {
        return bouquet.orElseThrow(IllegalArgumentException::new).getDeliveryMethod();
    }

    @Override
    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        bouquet.orElseThrow(IllegalArgumentException::new).setDeliveryMethod(deliveryMethod);
    }
}
