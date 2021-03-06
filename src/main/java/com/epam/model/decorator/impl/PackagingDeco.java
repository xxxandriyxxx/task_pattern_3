package com.epam.model.decorator.impl;

import com.epam.model.decorator.BouquetDecorator;
import com.epam.model.enums.PackagingMethod;

public class PackagingDeco extends BouquetDecorator {

    public PackagingDeco(PackagingMethod packagingMethod) {
        setToName(" + PackagingDecorator (" + packagingMethod.name() + ")");
        setAdditionalPrice(packagingMethod.getPrice());
        setNewPackagingMethod(packagingMethod);
    }
}
