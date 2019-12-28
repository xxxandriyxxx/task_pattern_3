package com.epam.factory.impl;

import com.epam.bouquet_catalogue.Bouquet;
import com.epam.bouquet_catalogue.enums.BaseBouquetType;
import com.epam.bouquet_catalogue.impl.EmptyBouquet;
import com.epam.bouquet_catalogue.impl.StandardBirthdayBouquet;
import com.epam.bouquet_catalogue.impl.StandardValentinesBouquet;
import com.epam.bouquet_catalogue.impl.StandardWeddingBouquet;
import com.epam.factory.Store;

public class FlowerStore extends Store {

    @Override
    protected Bouquet createBouquet(BaseBouquetType baseBouquetType) {
        Bouquet bouquet = null;
        if(baseBouquetType == BaseBouquetType.EMPTY){
            bouquet = new EmptyBouquet();
        } else if(baseBouquetType == BaseBouquetType.BIRTHDAY){
            bouquet = new StandardBirthdayBouquet();
        } else if(baseBouquetType == BaseBouquetType.VALENTINES){
            bouquet = new StandardValentinesBouquet();
        } else if(baseBouquetType == BaseBouquetType.WEDDING){
            bouquet = new StandardWeddingBouquet();
        }
        return bouquet;
    }
}
