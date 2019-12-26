package com.epam.bouquet.decorator;

public enum PackagingMethod {

    PAPER_WRAPPER(10), CLEAR_WRAPPER(10), RIBBON_WRAP(5), FREE_PACKAGING(0);

    private final double PRICE;

    PackagingMethod(double price) {
        this.PRICE = price;
    }

    public double getPrice() {
        return PRICE;
    }
}
