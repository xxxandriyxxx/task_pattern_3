package com.epam.bouquet;

import java.util.HashMap;

public interface Bouquet {

    String getName();

    double getCost();

//    void addFlowers(Flower flower, int amount);

    HashMap<Flower,Integer> getFlowers();
}
