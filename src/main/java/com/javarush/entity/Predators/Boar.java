package com.javarush.entity.Predators;


import com.javarush.entity.Herbivores.*;
import com.javarush.entity.Predator;
import com.javarush.map.*;

import java.util.concurrent.ThreadLocalRandom;

public class Boar extends Predator {
    public Cell cell;

    public Boar(Cell cell) {
        this.cell = cell;
    }




    @Override
    public void reproduction() {
        if ((cell.arrayList.stream().filter(s ->s instanceof Boar).count()>2)&&
                (cell.arrayList.stream().filter(s->s instanceof Boar).count() < MAX_QUANTITY_CELL.MAX_Boar.getQUANTITY())) {
            cell.arrayList.add(new Boar(cell));
        }
    }

    @Override
    public synchronized void move() {
        for (int i = 0; i < cell.arrayList.size(); i++) {
            if (cell.arrayList.get(i) instanceof Boar){
                cell.arrayList.remove(cell.arrayList.remove(i));
                break;
            }
        }
        while (true) {
            int a = ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Boar.getMAX_MOVE());
            int b =  ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Boar.getMAX_MOVE());
            if (MapOfCells.cells[a][b].arrayList.stream().filter(s -> s instanceof Boar).count() < MAX_QUANTITY_CELL.MAX_Boar.getQUANTITY()){
                MapOfCells.cells[a][b].arrayList.add(new Boar(MapOfCells.cells[a][b]));
                break;
            }
        }


    }

    @Override
    public synchronized void eat() {
        int countHunt = 60;
        int saturationOfDay = 0;
        while (countHunt > 0) {
        saturationOfDay = hunt() + saturationOfDay;
        countHunt--;
        }
        if (saturationOfDay <= SATURATION_ANIMAL.MAX_Boar.getSATURATION()){
            move();
        }

    }
    @Override
    public synchronized int hunt() {
        int whoseHunt = ThreadLocalRandom.current().nextInt(3);
        int successHunt = ThreadLocalRandom.current().nextInt(100);
        switch (whoseHunt) {
            case 0:{
                cell.dayOffPlants = cell.dayOffPlants + 1;
                return 1;
                }
            case 1:{
                if (successHunt < 90 ) {
                    for (int j = 0; j < 150; j++) {
                        for (int i = 0; i < cell.arrayList.size(); i++) {
                            if (cell.arrayList.get(i) instanceof Caterpillar){
                                cell.arrayList.remove(cell.arrayList.remove(i));
                                break;
                            }
                        }
                    }
                    return (int) (WEIGHT_ANIMAL.MAX_Caterpillar.getWEIGHT()*150);
                }
            }
            case 2: {
                if (successHunt < 50 ) {
                    for (int j = 0; j < 50; j++) {
                        for (int i = 0; i < cell.arrayList.size(); i++) {
                            if (cell.arrayList.get(i) instanceof Mouse){
                                cell.arrayList.remove(cell.arrayList.remove(i));
                                break;
                            }
                        }
                    }

                    return (int) (WEIGHT_ANIMAL.MAX_Horse.getWEIGHT()*50);
                }
            }
        }
        return 0;
    }
}
