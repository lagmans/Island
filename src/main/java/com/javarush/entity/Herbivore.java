package com.javarush.entity;

public abstract class Herbivore extends Animal {

    @Override
    public void eat(Object obj) {
        if (obj instanceof Animal){
            return;
        }
        super.eat(obj);
    }
}
