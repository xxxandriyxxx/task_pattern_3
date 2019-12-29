package com.epam.model.factory.impl;

import com.epam.model.bouquet_catalogue.Bouquet;
import com.epam.model.bouquet_catalogue.impl.store1.StandardBirthdayBouquet1;
import com.epam.model.enums.BaseBouquetType;
import com.epam.model.bouquet_catalogue.impl.EmptyBouquet;
import com.epam.model.bouquet_catalogue.impl.store1.StandardValentinesBouquet1;
import com.epam.model.bouquet_catalogue.impl.store1.StandardWeddingBouquet1;
import com.epam.model.factory.Store;

public class FlowerStore1 extends Store {

    @Override
    protected Bouquet createBouquet(BaseBouquetType baseBouquetType) {
        Bouquet bouquet = null;
        if(baseBouquetType == BaseBouquetType.EMPTY){
            bouquet = new EmptyBouquet();
        } else if(baseBouquetType == BaseBouquetType.BIRTHDAY){
            bouquet = new StandardBirthdayBouquet1();
        } else if(baseBouquetType == BaseBouquetType.VALENTINES){
            bouquet = new StandardValentinesBouquet1();
        } else if(baseBouquetType == BaseBouquetType.WEDDING){
            bouquet = new StandardWeddingBouquet1();
        }
        return bouquet;
    }
}
