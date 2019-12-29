package com.epam.model.bouquet_catalogue.impl.store2;

import com.epam.model.bouquet_catalogue.impl.EmptyBouquet;
import com.epam.model.enums.Flower;

public class StandardWeddingBouquet2 extends EmptyBouquet {

    public StandardWeddingBouquet2() {
        name = "StandardWeddingBouquet_store2";
        flowers.put(Flower.TULIP, 11);
        flowers.put(Flower.DAISY, 8);
        setPrice();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
