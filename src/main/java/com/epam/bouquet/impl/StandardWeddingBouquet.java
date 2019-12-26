package com.epam.bouquet.impl;

import com.epam.bouquet.Bouquet;
import com.epam.bouquet.Flower;

import java.util.HashMap;
import java.util.Map;

public class StandardWeddingBouquet implements Bouquet {

    private String name;
    private HashMap<Flower, Integer> flowers;

    public StandardWeddingBouquet() {
        name = "StandardWeddingBouquet";
        flowers = new HashMap<>();
        flowers.put(Flower.ROSE, 11);
        flowers.put(Flower.DAISY, 10);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCost() {
        double cost = 0;
        for (Map.Entry<Flower, Integer> entry : flowers.entrySet()) {
            cost += entry.getValue();
        }
        return cost;
    }

//    @Override
//    public void addFlowers(Flower flower, int amount) {
//        flowers.put(flower, amount);
//    }

    @Override
    public HashMap<Flower, Integer> getFlowers() {
        return flowers;
    }
}
