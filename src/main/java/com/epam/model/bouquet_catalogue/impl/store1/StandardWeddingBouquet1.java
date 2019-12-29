package com.epam.model.bouquet_catalogue.impl.store1;

import com.epam.model.bouquet_catalogue.impl.EmptyBouquet;
import com.epam.model.enums.Flower;

public class StandardWeddingBouquet1 extends EmptyBouquet {

    public StandardWeddingBouquet1() {
        name = "StandardWeddingBouquet_store1";
        flowers.put(Flower.ROSE, 11);
        flowers.put(Flower.DAISY, 10);
        setPrice();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
