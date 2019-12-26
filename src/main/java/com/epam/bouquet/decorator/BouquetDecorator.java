package com.epam.bouquet.decorator;

import com.epam.bouquet.Bouquet;
import com.epam.bouquet.Flower;

import java.util.HashMap;
import java.util.Optional;

public class BouquetDecorator implements Bouquet{

    private Optional<Bouquet> bouquet;
    private double additionalPrice;
    private String toName = "";
    private Flower additionalFlower;

    public void setBouquet(Bouquet outBouquet) {
        bouquet = Optional.ofNullable(outBouquet);
        if (additionalFlower != null) {
            bouquet.orElseThrow(IllegalArgumentException::new).getFlowers().put(additionalFlower, 1);
        }
    }

    protected void setAdditionalPrice(double additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    public void setAdditionalFlower(Flower additionalFlower) {
        this.additionalFlower = additionalFlower;
    }

    public void setToName(String toName){
        this.toName = toName;
    }


    @Override
    public String getName() {
        return bouquet.orElseThrow(IllegalArgumentException::new).getName()+toName;
    }

    @Override
    public double getCost() {
        return bouquet.orElseThrow(IllegalArgumentException::new).getCost() + additionalPrice;
    }

    @Override
    public HashMap<Flower, Integer> getFlowers() {
        return bouquet.orElseThrow(IllegalArgumentException::new).getFlowers();
    }
}
