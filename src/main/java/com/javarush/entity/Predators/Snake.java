package com.javarush.entity.Predators;

import com.javarush.entity.Herbivores.Caterpillar;
import com.javarush.entity.Herbivores.Duck;
import com.javarush.entity.Herbivores.Mouse;
import com.javarush.entity.Herbivores.Rabbit;
import com.javarush.entity.Predator;
import com.javarush.map.*;

import java.util.concurrent.ThreadLocalRandom;

public class Snake extends Predator {
    public Cell cell;

    public Snake(Cell cell) {
        this.cell = cell;
    }




    @Override
    public synchronized void reproduction() {
        if ((cell.arrayList.stream().filter(s ->s instanceof Snake).count()>2)&&
                (cell.arrayList.stream().filter(s->s instanceof Snake).count() < MAX_QUANTITY_CELL.MAX_Snake.getQUANTITY())) {
            cell.arrayList.add(new Snake(cell));
        }
    }

    @Override
    public synchronized void move() {
        for (int i = 0; i < cell.arrayList.size(); i++) {
            if (cell.arrayList.get(i) instanceof Snake){
                cell.arrayList.remove(cell.arrayList.remove(i));
                break;
            }
        }
        while (true) {
            int a = ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Snake.getMAX_MOVE());
            int b =  ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Snake.getMAX_MOVE());
            if (MapOfCells.cells[a][b].arrayList.stream().filter(s -> s instanceof Snake).count() < MAX_QUANTITY_CELL.MAX_Snake.getQUANTITY()){
                MapOfCells.cells[a][b].arrayList.add(new Snake(MapOfCells.cells[a][b]));
                break;
            }
        }


    }

    @Override
    public synchronized void eat() {
        int saturationOfDay = 0;
        saturationOfDay = hunt() + saturationOfDay;
        if (saturationOfDay <= SATURATION_ANIMAL.MAX_Snake.getSATURATION()) {
            move();
        }
    }

    @Override
    public synchronized int hunt() {
        int whoseHunt = ThreadLocalRandom.current().nextInt(4);
        int successHunt = ThreadLocalRandom.current().nextInt(100);
        switch (whoseHunt) {
            case 0: {
                if (successHunt < 70) {
                    for (int i = 0; i < cell.arrayList.size(); i++) {
                        if (cell.arrayList.get(i) instanceof Rabbit) {
                            cell.arrayList.remove(cell.arrayList.remove(i));
                            break;
                        }
                    }
                    return (int) (WEIGHT_ANIMAL.MAX_Rabbit.getWEIGHT());
                }
            }
            case 1:{
                if (successHunt < 60 ) {
                    for (int i = 0; i < cell.arrayList.size(); i++) {
                        if (cell.arrayList.get(i) instanceof Duck){
                            cell.arrayList.remove(cell.arrayList.remove(i));
                            break;
                        }
                    }
                    return (int) (WEIGHT_ANIMAL.MAX_Duck.getWEIGHT());
                }
            }
            case 2: {
                if (successHunt < 90 ) {
                    for (int j = 0; j< 100; j++) {
                        for (int i = 0; i < cell.arrayList.size(); i++) {
                            if (cell.arrayList.get(i) instanceof Mouse){
                                cell.arrayList.remove(cell.arrayList.remove(i));
                                break;
                            }
                        }
                    }
                    return (int) (WEIGHT_ANIMAL.MAX_Mouse.getWEIGHT()*100);
                }
            }
            case 3: {
                if (successHunt < 40 ) {
                    for (int j = 0; j < 100; j++) {
                        for (int i = 0; i < cell.arrayList.size(); i++) {
                            if (cell.arrayList.get(i) instanceof Caterpillar){
                                cell.arrayList.remove(cell.arrayList.remove(i));
                                break;
                            }
                        }
                    }
                    return (int) (WEIGHT_ANIMAL.MAX_Caterpillar.getWEIGHT()*100);
                }
            }

        }
        return 0;
    }
}
