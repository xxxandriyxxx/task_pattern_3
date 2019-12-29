package com.epam.model.bouquet_catalogue.impl.store2;

import com.epam.model.bouquet_catalogue.impl.EmptyBouquet;
import com.epam.model.enums.Flower;

public class StandardBirthdayBouquet2 extends EmptyBouquet {

    public StandardBirthdayBouquet2() {
        name = "StandardBirthdayBouquet_store2";
        flowers.put(Flower.LILY, 9);
        flowers.put(Flower.IRIS, 6);
        setPrice();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
