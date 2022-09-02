package com.javarush.entity.Predators;

import com.javarush.entity.Herbivores.Caterpillar;
import com.javarush.entity.Herbivores.Duck;
import com.javarush.entity.Herbivores.Mouse;
import com.javarush.entity.Herbivores.Rabbit;
import com.javarush.entity.Predator;
import com.javarush.map.*;

import java.util.concurrent.ThreadLocalRandom;

public class Fox extends Predator {
    public Cell cell;

    public Fox(Cell cell) {
        this.cell = cell;
    }




    @Override
    public synchronized void reproduction() {
        if ((cell.arrayList.stream().filter(s ->s instanceof Fox).count()>2)&&
                (cell.arrayList.stream().filter(s->s instanceof Fox).count() < MAX_QUANTITY_CELL.MAX_Fox.getQUANTITY())) {
            cell.arrayList.add(new Fox(cell));
        }
    }

    @Override
    public synchronized void move() {
        for (int i = 0; i < cell.arrayList.size(); i++) {
            if (cell.arrayList.get(i) instanceof Fox){
                cell.arrayList.remove(cell.arrayList.remove(i));
                break;
            }
        }
        while (true) {
            int a = ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Fox.getMAX_MOVE());
            int b =  ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Fox.getMAX_MOVE());
            if (MapOfCells.cells[a][b].arrayList.stream().filter(s -> s instanceof Fox).count() < MAX_QUANTITY_CELL.MAX_Fox.getQUANTITY()){
                MapOfCells.cells[a][b].arrayList.add(new Fox(MapOfCells.cells[a][b]));
                break;
            }
        }


    }

    @Override
    public synchronized void eat() {

        int saturationOfDay = 0;
        saturationOfDay = hunt() + saturationOfDay;

        if (saturationOfDay <= SATURATION_ANIMAL.MAX_Fox.getSATURATION()) {
            move();
        }
    }

    @Override
    public synchronized int hunt() {
        int whoseHunt = ThreadLocalRandom.current().nextInt(4);
        int successHunt = ThreadLocalRandom.current().nextInt(100);
        switch (whoseHunt) {
            case 0: {
                if (successHunt < 15) {
                    for (int i = 0; i < cell.arrayList.size(); i++) {
                        if (cell.arrayList.get(i) instanceof Fox) {
                            cell.arrayList.remove(cell.arrayList.remove(i));
                            break;
                        }
                    }
                    return (int) (WEIGHT_ANIMAL.MAX_Fox.getWEIGHT());
                }
            }
            case 1:{
                if (successHunt < 20 ) {
                    for (int i = 0; i < cell.arrayList.size(); i++) {
                        if (cell.arrayList.get(i) instanceof Rabbit){
                            cell.arrayList.remove(cell.arrayList.remove(i));
                            break;
                        }
                    }
                    return (int) (WEIGHT_ANIMAL.MAX_Rabbit.getWEIGHT());
                }
            }
            case 2: {
                if (successHunt < 40 ) {
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
                if (successHunt < 10 ) {

                        for (int i = 0; i < cell.arrayList.size(); i++) {
                            if (cell.arrayList.get(i) instanceof Duck){
                                cell.arrayList.remove(cell.arrayList.remove(i));
                                break;
                            }
                        }

                    return (int) (WEIGHT_ANIMAL.MAX_Duck.getWEIGHT());
                }
            }

        }
        return 0;
    }
}
