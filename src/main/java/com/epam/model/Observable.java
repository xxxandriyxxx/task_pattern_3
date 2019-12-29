package com.epam.model;

import com.epam.view.Observer;

public interface Observable {

    void registerObserver(Observer observer, int customerId);

    void notifyObservers(String message, int customerId);
}
