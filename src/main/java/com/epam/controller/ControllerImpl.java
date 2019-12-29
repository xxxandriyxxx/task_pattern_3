package com.epam.controller;

import com.epam.model.BusinessLogic;
import com.epam.model.Model;
import com.epam.model.bouquet_catalogue.Bouquet;
import com.epam.model.enums.*;
import com.epam.view.Observer;

import java.util.HashMap;
import java.util.List;

public class ControllerImpl implements Controller {

    private Model model;

    public ControllerImpl() {
        model = new BusinessLogic();
    }

    @Override
    public List<String> getStores() {
        return model.getStores();
    }

    @Override
    public Bouquet orderBouquet(int storeNumber, BaseBouquetType baseBouquetType, HashMap<Flower,
            Integer> additionalFlowers, PackagingMethod packagingMethod, DeliveryMethod deliveryMethod,
                                DiscountCard discountCard) {
        return model.orderBouquet(storeNumber, baseBouquetType, additionalFlowers, packagingMethod,
                deliveryMethod, discountCard);
    }

    @Override
    public Bouquet getBouquet(int storeNumber, BaseBouquetType baseBouquetType) {
        return model.getBouquet(storeNumber,baseBouquetType);
    }

    @Override
    public List<Flower> getFlowers() {
        return model.getFlowers();
    }

    @Override
    public BaseBouquetType getDefaultBaseBouquetType() {
        return model.getDefaultBaseBouquetType();
    }

    @Override
    public List<BaseBouquetType> getBaseBouquetTypes() {
        return model.getBaseBouquetTypes();
    }

    @Override
    public PackagingMethod getDefaultPackagingMethod() {
        return model.getDefaultPackagingMethod();
    }

    @Override
    public List<PackagingMethod> getPackagingMethods() {
        return model.getPackagingMethods();
    }

    @Override
    public DeliveryMethod getDefaultDeliveryMethod() {
        return model.getDefaultDeliveryMethod();
    }

    @Override
    public List<DeliveryMethod> getDeliveryMethods() {
        return model.getDeliveryMethods();
    }

    @Override
    public DiscountCard getDefaultDiscountCard() {
        return model.getDefaultDiscountCard();
    }

    @Override
    public List<DiscountCard> getDiscountCards() {
        return model.getDiscountCards();
    }

    @Override
    public void registerObserver(Observer observer) {
        model.registerObserver(observer);
    }
}
