package com.epam.bouquet.decorator.impl;

import com.epam.bouquet.decorator.BouquetDecorator;
import com.epam.bouquet.decorator.PackagingMethod;

public class Packaging extends BouquetDecorator {

    public Packaging(PackagingMethod packagingMethod) {
        setAdditionalPrice(packagingMethod.getPrice());
        setToName(" + Packaging (" + packagingMethod.name() + ")");
    }
}
