package com.epam;

import com.epam.model.bouquet_catalogue.Bouquet;
import com.epam.model.enums.BaseBouquetType;
import com.epam.model.enums.Flower;
import com.epam.model.bouquet_catalogue.impl.EmptyBouquet;
import com.epam.model.decorator.BouquetDecorator;
import com.epam.model.decorator.impl.DeliveryDeco;
import com.epam.model.decorator.impl.FlowerDeco;
import com.epam.model.enums.DeliveryMethod;
import com.epam.model.enums.DiscountCard;
import com.epam.model.enums.PackagingMethod;
import com.epam.model.decorator.impl.DiscountDeco;
import com.epam.model.decorator.impl.PackagingDeco;
import com.epam.model.factory.Store;
import com.epam.model.factory.impl.FlowerStore;

import java.util.HashMap;

public class Client {

    public static void main(String[] args) {
        Bouquet standardBouquet = new EmptyBouquet();
        BouquetDecorator flowerDecorator = new FlowerDeco(Flower.SUNFLOWER, 3);
        BouquetDecorator flowerDecorator2 = new FlowerDeco(Flower.IRIS, 5);
        BouquetDecorator packaging = new PackagingDeco(PackagingMethod.PAPER_WRAPPER);
        BouquetDecorator delivery = new DeliveryDeco(DeliveryMethod.ANOTHER_CITY);
        BouquetDecorator discount = new DiscountDeco(DiscountCard.GOLD);

        flowerDecorator.setBouquet(standardBouquet);
        flowerDecorator2.setBouquet(flowerDecorator);
        packaging.setBouquet(flowerDecorator2);
        delivery.setBouquet(packaging);
        discount.setBouquet(delivery);

        BouquetDecorator fullBouquet = discount;

        String name = fullBouquet.getName();
        double cost = fullBouquet.getCost();
        HashMap<Flower, Integer> flowers = fullBouquet.getFlowers();

        System.out.println("name = " + name);
        System.out.println("cost = " + cost);
        System.out.println("flowers = " + flowers);
        System.out.println("-----------------------------------");

        Store store = new FlowerStore();

        HashMap<Flower, Integer> additionalFlowers = new HashMap<>();

        additionalFlowers.put(Flower.IRIS, 200);
//        additionalFlowers.put(Flower.BLUEBELL, 7);
//        additionalFlowers.put(Flower.SUNFLOWER, 11);
        additionalFlowers.put(Flower.ROSE, 2);
        additionalFlowers.put(Flower.TULIP,10);

        Bouquet bouquet = store.order(BaseBouquetType.BIRTHDAY, additionalFlowers,
                PackagingMethod.WITHOUT_PACKAGING, DeliveryMethod.WITHIN_CITY, DiscountCard.SOCIAL);

        System.out.println("name= " + bouquet.getName());
        System.out.println("cost= " + bouquet.getCost());
        System.out.println("flowers= " + bouquet.getFlowers());
        System.out.println(bouquet);


    }

}
