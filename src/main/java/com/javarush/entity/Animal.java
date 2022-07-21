package com.javarush.entity;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Animal {

    AtomicInteger weight;

    boolean isAlive;

    public void eat(Object obj) {

    }

    public Animal reproduction() {
        return null;
    }

    public void move(Object obj) {

    }

}
