package com.javarush.entity.Herbivores;

import com.javarush.entity.Animal;
import com.javarush.entity.Herbivore;

public class Duck extends Herbivore {
    @Override
    public void eat(Object obj) {
        if ((obj instanceof Animal)&&(!(obj instanceof Caterpillar))) {
            return;
        }
        super.eat(obj);
    }
}
