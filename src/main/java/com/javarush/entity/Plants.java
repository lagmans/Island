package com.javarush.entity;

import com.javarush.map.Cell;
import com.javarush.map.MAX_QUANTITY_CELL;

public class Plants {
    Cell cell;

    public Plants(Cell cell) {
        this.cell = cell;
    }

    public synchronized void grow(){
        for (int i = 0; i < 7; i++) {
            cell.plants.add(new Plants(cell));
            if ((cell.plants.size()+1) > MAX_QUANTITY_CELL.MAX_Plants.getQUANTITY()){
                break;
            }
        }

    }
}
