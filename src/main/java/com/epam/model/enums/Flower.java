package com.epam.model.enums;

public enum Flower {
    ROSE(25), TULIP(10), LILY(25), DAISY(15), SNOWDROP(10), POPPY(12),
    BLUEBELL(8), SUNFLOWER(30), IRIS(15);

    final private double PRICE;

    private Flower(double price) {
        this.PRICE = price;
    }

    public double getPrice() {
        return PRICE;
    }
}
