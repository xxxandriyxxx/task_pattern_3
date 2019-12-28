package com.epam.decorator.enums;

public enum DiscountCard {

    GOLD(15, 0, true, true),
    BONUS(0, 50, true, false),
    SOCIAL(2, 0, false, false);

    private final int DISCOUNT_PERCENT;
    private final double DISCOUNT_PRICE;
    private final boolean HAS_FREE_PACKAGING;
    private final boolean HAS_FREE_DELIVERY;

    DiscountCard(int percent, double price, boolean hasFreePackaging, boolean hasFreeDelivery) {
        this.DISCOUNT_PERCENT = percent;
        this.DISCOUNT_PRICE = price;
        this.HAS_FREE_PACKAGING = hasFreePackaging;
        this.HAS_FREE_DELIVERY = hasFreeDelivery;
    }

    public int getDiscountPercent() {
        return DISCOUNT_PERCENT;
    }

    public double getDiscountPrice() {
        return DISCOUNT_PRICE;
    }

    public boolean hasFreePackaging() {
        return HAS_FREE_PACKAGING;
    }

    public boolean hasFreeDelivery() {
        return HAS_FREE_DELIVERY;
    }
}
