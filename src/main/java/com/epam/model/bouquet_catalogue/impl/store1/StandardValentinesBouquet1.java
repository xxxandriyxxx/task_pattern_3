package com.epam.model.bouquet_catalogue.impl.store1;

import com.epam.model.bouquet_catalogue.impl.EmptyBouquet;
import com.epam.model.enums.Flower;

public class StandardValentinesBouquet1 extends EmptyBouquet {

    public StandardValentinesBouquet1() {
        name = "StandardValentinesBouquet_store1";
        flowers.put(Flower.SNOWDROP, 15);
        flowers.put(Flower.BLUEBELL, 10);
        setPrice();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
