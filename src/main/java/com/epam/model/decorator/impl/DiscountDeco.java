package com.epam.model.decorator.impl;

import com.epam.model.decorator.BouquetDecorator;
import com.epam.model.enums.DiscountCard;

public class DiscountDeco extends BouquetDecorator {

    private DiscountCard discountCard;

    public DiscountDeco(DiscountCard discountCard) {
        setToName(" + DiscountCard (" + discountCard + ")");
        this.discountCard = discountCard;
    }

    @Override
    public double getCost() {
        double cost = bouquet.orElseThrow(IllegalArgumentException::new).getCost();
        if (discountCard.hasFreePackaging()) {
            cost -= bouquet.orElseThrow(IllegalArgumentException::new).getPackagingMethod().getPrice();
        }
        if (discountCard.hasFreeDelivery()) {
            cost -= bouquet.orElseThrow(IllegalArgumentException::new).getDeliveryMethod().getPrice();
        }
        if (cost > discountCard.getDiscountPrice()) {
            cost -= discountCard.getDiscountPrice();
        }
        cost *= (double) (100 - discountCard.getDiscountPercent()) / 100;
        return cost;
    }
}
