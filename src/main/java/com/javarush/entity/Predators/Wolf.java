package com.javarush.entity.Predators;

import com.javarush.entity.Herbivores.*;
import com.javarush.entity.Predator;
import com.javarush.map.*;

import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Predator {
    public Cell cell;

    public Wolf(Cell cell) {
        this.cell = cell;
    }




    @Override
    public void reproduction() {
        if ((cell.arrayList.stream().filter(s ->s instanceof Wolf).count()>2)&&
                (cell.arrayList.stream().filter(s->s instanceof Wolf).count() < MAX_QUANTITY_CELL.MAX_Wolf.getQUANTITY())) {
            cell.arrayList.add(new Wolf(cell));
        }
    }

    @Override
    public synchronized void move() {
        for (int i = 0; i < cell.arrayList.size(); i++) {
            if (cell.arrayList.get(i) instanceof Wolf){
                cell.arrayList.remove(cell.arrayList.remove(i));
                break;
            }
        }
        while (true) {
            int a = ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Wolf.getMAX_MOVE());
            int b =  ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Wolf.getMAX_MOVE());
            if (MapOfCells.cells[a][b].arrayList.stream().filter(s -> s instanceof Wolf).count() < MAX_QUANTITY_CELL.MAX_Wolf.getQUANTITY()){
                MapOfCells.cells[a][b].arrayList.add(new Wolf(MapOfCells.cells[a][b]));
                break;
            }
        }


    }

    @Override
    public synchronized void eat() {
        int saturationOfDay = 0;
        saturationOfDay = hunt() + saturationOfDay;
        if (saturationOfDay <= SATURATION_ANIMAL.MAX_Wolf.getSATURATION()) {
            move();
        }
    }

    @Override
    public synchronized int hunt() {
        int whoseHunt = ThreadLocalRandom.current().nextInt(9);
        int successHunt = ThreadLocalRandom.current().nextInt(100);
        switch (whoseHunt) {
            case 0:{
                if (successHunt < 60 ) {
                    for (int i = 0; i < cell.arrayList.size(); i++) {
                        if (cell.arrayList.get(i) instanceof Goat){
                            cell.arrayList.remove(cell.arrayList.remove(i));
                            break;
                        }
                    }
                    return (int) WEIGHT_ANIMAL.MAX_Goat.getWEIGHT();
                }
            }
            case 1:{
                if (successHunt < 40 ) {
                    for (int i = 0; i < cell.arrayList.size(); i++) {
                        if (cell.arrayList.get(i) instanceof Duck){
                            cell.arrayList.remove(cell.arrayList.remove(i));
                            break;
                        }
                    }
                    return (int) WEIGHT_ANIMAL.MAX_Duck.getWEIGHT();
                }
            }
            case 2: {
                if (successHunt <10 ) {
                    for (int i = 0; i < cell.arrayList.size(); i++) {
                        if (cell.arrayList.get(i) instanceof Horse){
                            cell.arrayList.remove(cell.arrayList.remove(i));
                            break;
                        }
                    }
                    return (int) WEIGHT_ANIMAL.MAX_Horse.getWEIGHT();
                }
            }
            case 3:
            {
                if (successHunt < 15 ) {
                    for (int i = 0; i < cell.arrayList.size(); i++) {
                        if (cell.arrayList.get(i) instanceof Deer){
                            cell.arrayList.remove(cell.arrayList.remove(i));
                            break;
                        }
                    }
                    return (int) WEIGHT_ANIMAL.MAX_Deer.getWEIGHT();
                }
            }
            case 4:
            {
                if (successHunt < 60 ) {
                    for (int i = 0; i < cell.arrayList.size(); i++) {
                        if (cell.arrayList.get(i) instanceof Rabbit){
                            cell.arrayList.remove(cell.arrayList.remove(i));
                            break;
                        }
                    }
                    return (int) WEIGHT_ANIMAL.MAX_Rabbit.getWEIGHT();
                }
            }
            case 5:
            {
                if (successHunt < 80 ) {
                    for (int j = 0; j < 100; j++) {
                        for (int i = 0; i < cell.arrayList.size(); i++) {
                            if (cell.arrayList.get(i) instanceof Mouse){
                                cell.arrayList.remove(cell.arrayList.remove(i));
                                break;
                            }
                        }
                    }

                    return (int) WEIGHT_ANIMAL.MAX_Mouse.getWEIGHT()*100;
                }
            }
            case 6:
            {
                if (successHunt < 70 ) {
                    for (int i = 0; i < cell.arrayList.size(); i++) {
                        if (cell.arrayList.get(i) instanceof Sheep){
                            cell.arrayList.remove(cell.arrayList.remove(i));
                            break;
                        }
                    }
                    return (int) WEIGHT_ANIMAL.MAX_Sheep.getWEIGHT();
                }
            }
            case 7:
            {
                if (successHunt < 15 ) {
                    for (int i = 0; i < cell.arrayList.size(); i++) {
                        if (cell.arrayList.get(i) instanceof Boar){
                            cell.arrayList.remove(cell.arrayList.remove(i));
                            break;
                        }
                    }
                    return (int) WEIGHT_ANIMAL.MAX_Boar.getWEIGHT();
                }
            }
            case 8:
            {
                if (successHunt < 10 ) {
                    for (int i = 0; i < cell.arrayList.size(); i++) {
                        if (cell.arrayList.get(i) instanceof Buffalo){
                            cell.arrayList.remove(cell.arrayList.remove(i));
                            break;
                        }
                    }
                    return (int) WEIGHT_ANIMAL.MAX_Buffalo.getWEIGHT();
                }
            }
        }
        return 0;
    }

}
