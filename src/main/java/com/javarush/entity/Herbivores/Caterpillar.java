package com.javarush.entity.Herbivores;

import com.javarush.entity.Herbivore;
import com.javarush.map.Cell;

public class Caterpillar extends Herbivore {
    Cell cell;

    public Caterpillar(Cell cell) {
        this.cell = cell;
    }
}
