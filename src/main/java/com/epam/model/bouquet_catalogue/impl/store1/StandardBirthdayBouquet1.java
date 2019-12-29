package com.epam.model.bouquet_catalogue.impl.store1;

import com.epam.model.bouquet_catalogue.impl.EmptyBouquet;
import com.epam.model.enums.Flower;

public class StandardBirthdayBouquet1 extends EmptyBouquet {

    public StandardBirthdayBouquet1() {
        name = "StandardBirthdayBouquet_store1";
        flowers.put(Flower.TULIP, 9);
        flowers.put(Flower.IRIS, 5);
        flowers.put(Flower.POPPY, 3);
        setPrice();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
