package com.epam.decorator.impl;

import com.epam.decorator.BouquetDecorator;
import com.epam.decorator.enums.DiscountCard;

public class Discount extends BouquetDecorator {

    private DiscountCard discountCard;

    public Discount(DiscountCard discountCard) {
        setToName(" + DiscountCard (" + discountCard + ")");
        this.discountCard = discountCard;
    }

    @Override
    public double getCost() {
        double cost = bouquet.orElseThrow(IllegalArgumentException::new).getCost();
        cost *= (double) (100 - discountCard.getDiscountPercent()) / 100;
        cost -= discountCard.getDiscountPrice();
        if (discountCard.hasFreePackaging()) {
            cost -= bouquet.orElseThrow(IllegalArgumentException::new).getPackagingMethod().getPrice();
        }
        if (discountCard.hasFreeDelivery()) {
            cost -= bouquet.orElseThrow(IllegalArgumentException::new).getDeliveryMethod().getPrice();
        }
        return cost;
    }
}
