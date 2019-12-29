package com.epam.model;

import com.epam.view.Observer;

public interface Observable {

    void registerObserver(Observer observer);

    void notifyObservers(String message);
}
