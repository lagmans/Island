package com.javarush.entity.Herbivores;

import com.javarush.entity.Animal;
import com.javarush.entity.Herbivore;
import com.javarush.map.*;

import java.util.concurrent.ThreadLocalRandom;

public class Duck extends Herbivore {

    public Cell cell;

    public Duck(Cell cell) {
        this.cell = cell;
    }

    public Duck() {
    }

    @Override
    public synchronized void reproduction() {
        if ((cell.arrayList.stream().filter(s -> s instanceof Duck).count() > 2) &&
                (cell.arrayList.stream().filter(s -> s instanceof Duck).count() < MAX_QUANTITY_CELL.MAX_Duck.getQUANTITY())) {
            cell.arrayList.add(new Duck(cell));
        }
    }

    @Override
    public synchronized void move() {
        if ((cell.plants.size() < 50) && (cell.arrayList.stream().filter(s -> s instanceof Duck).count() > (MAX_QUANTITY_CELL.MAX_Duck.getQUANTITY() / 2))) {
            for (int i = 0; i < cell.arrayList.size(); i++) {
                if (cell.arrayList.get(i) instanceof Duck) {
                    cell.arrayList.remove(cell.arrayList.remove(i));
                    break;
                }
            }
            int a = ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Duck.getMAX_MOVE());
            int b = ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Duck.getMAX_MOVE());
            MapOfCells.cells[a][b].arrayList.add(new Duck(MapOfCells.cells[a][b]));
        }
    }

    @Override
    public synchronized void eat() {
        if (ThreadLocalRandom.current().nextInt(100) < 54) {
            cell.dayOffPlants = cell.dayOffPlants + SATURATION_ANIMAL.MAX_Duck.getSATURATION();
        } else {
            for (int i = 0; i < SATURATION_ANIMAL.MAX_Duck.getSATURATION() / WEIGHT_ANIMAL.MAX_Caterpillar.getWEIGHT(); i++) {
                if (cell.arrayList.get(i) instanceof Caterpillar) {
                    cell.arrayList.remove(cell.arrayList.remove(i));
                }
            }
        }
    }
}