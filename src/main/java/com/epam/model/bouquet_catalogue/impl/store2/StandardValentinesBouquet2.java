package com.epam.model.bouquet_catalogue.impl.store2;

import com.epam.model.bouquet_catalogue.impl.EmptyBouquet;
import com.epam.model.enums.Flower;

public class StandardValentinesBouquet2 extends EmptyBouquet {

    public StandardValentinesBouquet2() {
        name = "StandardValentinesBouquet_store2";
        flowers.put(Flower.ROSE, 11);
        setPrice();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
