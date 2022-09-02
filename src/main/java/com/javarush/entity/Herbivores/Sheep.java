package com.javarush.entity.Herbivores;

import com.javarush.entity.Herbivore;
import com.javarush.map.*;

import java.util.concurrent.ThreadLocalRandom;

public class Sheep extends Herbivore {
    public Sheep() {
    }

    public Cell cell;

    public Sheep(Cell cell) {
        this.cell = cell;
    }

    @Override
    public synchronized void reproduction() {
        if ((cell.arrayList.stream().filter(s ->s instanceof Sheep).count()>2)&&
                (cell.arrayList.stream().filter(s->s instanceof Sheep).count() < MAX_QUANTITY_CELL.MAX_Sheep.getQUANTITY())) {
            cell.arrayList.add(new Sheep(cell));
        }
    }

    @Override
    public synchronized void move() {
        if ((cell.plants.size() < 50)&&(cell.arrayList.stream().filter(s->s instanceof Sheep).count()>(MAX_QUANTITY_CELL.MAX_Sheep.getQUANTITY()/2))){
            for (int i = 0; i < cell.arrayList.size(); i++) {
                if (cell.arrayList.get(i) instanceof Sheep){
                    cell.arrayList.remove(cell.arrayList.remove(i));
                    break;
                }
            }
            int a = ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Sheep.getMAX_MOVE());
            int b =  ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Sheep.getMAX_MOVE()) ;
            MapOfCells.cells[a][b].arrayList.add(new Sheep(MapOfCells.cells[a][b]));
        }
    }

    @Override
    public synchronized void eat() {
        cell.dayOffPlants = cell.dayOffPlants + SATURATION_ANIMAL.MAX_Sheep.getSATURATION();
    }
}
