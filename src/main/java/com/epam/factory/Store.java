package com.epam.factory;

import com.epam.bouquet_catalogue.Bouquet;
import com.epam.bouquet_catalogue.enums.BaseBouquetType;
import com.epam.bouquet_catalogue.enums.Flower;
import com.epam.decorator.BouquetDecorator;
import com.epam.decorator.enums.DeliveryMethod;
import com.epam.decorator.enums.DiscountCard;
import com.epam.decorator.enums.PackagingMethod;
import com.epam.decorator.impl.DeliveryDeco;
import com.epam.decorator.impl.DiscountDeco;
import com.epam.decorator.impl.FlowerDeco;
import com.epam.decorator.impl.PackagingDeco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Store {

    protected abstract Bouquet createBouquet(BaseBouquetType baseBouquetType);

    public Bouquet order(BaseBouquetType baseBouquetType, HashMap<Flower, Integer> additionalFlowers,
                         PackagingMethod packagingMethod, DeliveryMethod deliveryMethod, DiscountCard discountCard) {
        Bouquet bouquet = createBouquet(baseBouquetType);
        List<FlowerDeco> flowerDecoList = new ArrayList<>();
        BouquetDecorator packageDecorator = new PackagingDeco(packagingMethod);
        BouquetDecorator deliveryDecorator = new DeliveryDeco(deliveryMethod);
        BouquetDecorator discountDecorator = new DiscountDeco(discountCard);

        for (Map.Entry<Flower, Integer> entry : additionalFlowers.entrySet()) {
            flowerDecoList.add(new FlowerDeco(entry.getKey(), entry.getValue()));
        }
        if (!flowerDecoList.isEmpty()) {
            for (int i = 0; i < flowerDecoList.size(); i++) {
                if (i == 0) {
                    flowerDecoList.get(i).setBouquet(bouquet);
                } else {
                    flowerDecoList.get(i).setBouquet(flowerDecoList.get(i - 1));
                }
            }
            packageDecorator.setBouquet(flowerDecoList.get(flowerDecoList.size() - 1));
        } else {
            packageDecorator.setBouquet(bouquet);
        }
        deliveryDecorator.setBouquet(packageDecorator);
        discountDecorator.setBouquet(deliveryDecorator);
        return discountDecorator;
    }
}
