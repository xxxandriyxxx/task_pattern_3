package com.epam.model.factory.impl;

import com.epam.model.bouquet_catalogue.Bouquet;
import com.epam.model.bouquet_catalogue.impl.EmptyBouquet;
import com.epam.model.bouquet_catalogue.impl.store2.StandardBirthdayBouquet2;
import com.epam.model.bouquet_catalogue.impl.store2.StandardValentinesBouquet2;
import com.epam.model.bouquet_catalogue.impl.store2.StandardWeddingBouquet2;
import com.epam.model.enums.BaseBouquetType;
import com.epam.model.factory.Store;

public class FlowerStore2 extends Store {

    @Override
    protected Bouquet createBouquet(BaseBouquetType baseBouquetType) {
        Bouquet bouquet = null;
        if(baseBouquetType == BaseBouquetType.EMPTY){
            bouquet = new EmptyBouquet();
        } else if(baseBouquetType == BaseBouquetType.BIRTHDAY){
            bouquet = new StandardBirthdayBouquet2();
        } else if(baseBouquetType == BaseBouquetType.VALENTINES){
            bouquet = new StandardValentinesBouquet2();
        } else if(baseBouquetType == BaseBouquetType.WEDDING){
            bouquet = new StandardWeddingBouquet2();
        }
        return bouquet;
    }
}
