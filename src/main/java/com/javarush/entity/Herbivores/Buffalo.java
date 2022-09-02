package com.javarush.entity.Herbivores;

import com.javarush.entity.Herbivore;
import com.javarush.map.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Buffalo extends Herbivore {


    public Cell cell;

    public Buffalo(Cell cell) {
        this.cell = cell;
    }

    public Buffalo() {
    }

    @Override
    public synchronized void reproduction() {
        if ((cell.arrayList.stream().filter(s ->s instanceof Buffalo).count()>2)&&
                (cell.arrayList.stream().filter(s->s instanceof Buffalo).count() < MAX_QUANTITY_CELL.MAX_Buffalo.getQUANTITY())) {
            cell.arrayList.add(new Buffalo(cell));
        }
    }

    @Override
    public synchronized void move() {
        if ((cell.plants.size() < 50)&&(cell.arrayList.stream().filter(s->s instanceof Buffalo).count()>(MAX_QUANTITY_CELL.MAX_Buffalo.getQUANTITY()/2))){
            for (int i = 0; i < cell.arrayList.size(); i++) {
                if (cell.arrayList.get(i) instanceof Buffalo){
                    cell.arrayList.remove(cell.arrayList.remove(i));
                    break;
                }
            }
            int a = ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Buffalo.getMAX_MOVE());
            int b =  ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Buffalo.getMAX_MOVE()) ;
            MapOfCells.cells[a][b].arrayList.add(new Buffalo(MapOfCells.cells[a][b]));
        }
    }

    @Override
    public synchronized void eat() {
        cell.dayOffPlants = cell.dayOffPlants + SATURATION_ANIMAL.MAX_Buffalo.getSATURATION();
    }

}
