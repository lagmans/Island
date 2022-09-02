package com.javarush.entity.Herbivores;

import com.javarush.entity.Herbivore;
import com.javarush.map.*;

import java.util.concurrent.ThreadLocalRandom;

public class Rabbit extends Herbivore {


    public Cell cell;

    public Rabbit(Cell cell) {
        this.cell = cell;
    }


    public Rabbit() {
    }

    @Override
    public synchronized void reproduction() {
        if ((cell.arrayList.stream().filter(s ->s instanceof Rabbit).count()>2)&&
                (cell.arrayList.stream().filter(s->s instanceof Rabbit).count() < MAX_QUANTITY_CELL.MAX_Rabbit.getQUANTITY())) {
            cell.arrayList.add(new Rabbit(cell));
        }
    }

    @Override
    public synchronized void move() {
        if ((cell.plants.size() < 50)&&(cell.arrayList.stream().filter(s->s instanceof Rabbit).count()>(MAX_QUANTITY_CELL.MAX_Rabbit.getQUANTITY())/2)){
            for (int i = 0; i < cell.arrayList.size(); i++) {
                if (cell.arrayList.get(i) instanceof Rabbit){
                    cell.arrayList.remove(cell.arrayList.remove(i));
                    break;
                }
            }
            int a = ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Rabbit.getMAX_MOVE());
            int b =  ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Rabbit.getMAX_MOVE()) ;
            MapOfCells.cells[a][b].arrayList.add(new Rabbit(MapOfCells.cells[a][b]));
        }
    }

    @Override
    public synchronized void eat() {
        cell.dayOffPlants = cell.dayOffPlants + SATURATION_ANIMAL.MAX_Rabbit.getSATURATION();
    }
}
