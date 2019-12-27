package com.epam.decorator.enums;

public enum DeliveryMethod {

    ANOTHER_CITY(60), WITHIN_CITY(20), FREE_DELIVERY(0), WITHOUT_DELIVERY(0);

    private final double PRICE;

    DeliveryMethod(double price) {
        this.PRICE = price;
    }

    public double getPrice() {
        return PRICE;
    }
}
