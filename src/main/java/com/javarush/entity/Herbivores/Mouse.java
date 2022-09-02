package com.javarush.entity.Herbivores;

import com.javarush.entity.Herbivore;
import com.javarush.map.*;

import java.util.concurrent.ThreadLocalRandom;

public class Mouse extends Herbivore {
    public Mouse() {
    }

    public Cell cell;

    public Mouse(Cell cell) {
        this.cell = cell;
    }

    @Override
    public synchronized void reproduction() {
        if ((cell.arrayList.stream().filter(s ->s instanceof Mouse).count()>2)&&
                (cell.arrayList.stream().filter(s->s instanceof Mouse).count() < MAX_QUANTITY_CELL.MAX_Mouse.getQUANTITY())) {
            cell.arrayList.add(new Mouse(cell));
        }
    }

    @Override
    public synchronized void move() {
        if ((cell.plants.size() < 50)&&(cell.arrayList.stream().filter(s->s instanceof Mouse).count()>(MAX_QUANTITY_CELL.MAX_Mouse.getQUANTITY()/2))){
            for (int i = 0; i < cell.arrayList.size(); i++) {
                if (cell.arrayList.get(i) instanceof Mouse){
                    cell.arrayList.remove(cell.arrayList.remove(i));
                    break;
                }
            }
            int a = ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Mouse.getMAX_MOVE());
            int b =  ThreadLocalRandom.current().nextInt(MAX_MOVE_ANIMAL.MAX_Mouse.getMAX_MOVE()) ;
            MapOfCells.cells[a][b].arrayList.add(new Mouse(MapOfCells.cells[a][b]));
        }
    }

    @Override
    public synchronized void eat() {
        if (ThreadLocalRandom.current().nextInt(100)<54) {
            cell.dayOffPlants = cell.dayOffPlants + SATURATION_ANIMAL.MAX_Mouse.getSATURATION();
        } else {
            for (int i = 0; i < SATURATION_ANIMAL.MAX_Mouse.getSATURATION()/WEIGHT_ANIMAL.MAX_Caterpillar.getWEIGHT(); i++) {
                for (int j = 0; j < cell.arrayList.size(); j++) {
                    if (cell.arrayList.get(i) instanceof Caterpillar){
                        cell.arrayList.remove(cell.arrayList.remove(j));
                        break;
                    }
                }
            }
        }
    }
}
