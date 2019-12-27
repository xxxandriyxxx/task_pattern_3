package com.epam.decorator.impl;

import com.epam.decorator.BouquetDecorator;
import com.epam.decorator.enums.PackagingMethod;

public class PackagingDeco extends BouquetDecorator {

    public PackagingDeco(PackagingMethod packagingMethod) {
        setToName(" + PackagingDeco (" + packagingMethod.name() + ")");
        setAdditionalPrice(packagingMethod.getPrice());
        setNewPackagingMethod(packagingMethod);
    }
}
