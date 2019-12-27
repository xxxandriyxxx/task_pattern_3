package com.epam.decorator.impl;

import com.epam.decorator.BouquetDecorator;
import com.epam.decorator.enums.PackagingMethod;

public class Packaging extends BouquetDecorator {

    public Packaging(PackagingMethod packagingMethod) {
        setToName(" + Packaging (" + packagingMethod.name() + ")");
        setAdditionalPrice(packagingMethod.getPrice());
        setNewPackagingMethod(packagingMethod);
    }
}
