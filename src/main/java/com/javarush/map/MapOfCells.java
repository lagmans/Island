package com.javarush.map;

import com.javarush.entity.Herbivores.*;
import com.javarush.entity.Plants;
import com.javarush.entity.Predators.*;

public class MapOfCells {

   public  static Cell[][] cells = new Cell[5][5];

   public MapOfCells() {

         for (int i = 0; i < MapOfCells.cells.length; i++) {
            for (int j = 0; j < MapOfCells.cells[0].length; j++) {


               cells[i][j] = new Cell(i,j);
               for (int k = 0; k <MAX_QUANTITY_CELL.MAX_Plants.getQUANTITY(); k++) {

                  MapOfCells.cells[i][j].plants.add(new Plants(MapOfCells.cells[i][j]));

               }

               for (int k = 0; k < MAX_QUANTITY_CELL.MAX_Buffalo.getQUANTITY()/2; k++) {
                  MapOfCells.cells[i][j].arrayList.add(new Buffalo(MapOfCells.cells[i][j]));
               }
               for (int k = 0; k < MAX_QUANTITY_CELL.MAX_Caterpillar.getQUANTITY()/2; k++) {
                  MapOfCells.cells[i][j].arrayList.add(new Caterpillar(MapOfCells.cells[i][j]));
               }
               for (int k = 0; k < MAX_QUANTITY_CELL.MAX_Deer.getQUANTITY()/2; k++) {
                  MapOfCells.cells[i][j].arrayList.add(new Deer(MapOfCells.cells[i][j]));
               }
               for (int k = 0; k < MAX_QUANTITY_CELL.MAX_Duck.getQUANTITY()/2; k++) {
                  MapOfCells.cells[i][j].arrayList.add(new Duck(MapOfCells.cells[i][j]));
               }
               for (int k = 0; k < MAX_QUANTITY_CELL.MAX_Goat.getQUANTITY()/2; k++) {
                  MapOfCells.cells[i][j].arrayList.add(new Goat(MapOfCells.cells[i][j]));
               }
               for (int k = 0; k < MAX_QUANTITY_CELL.MAX_Horse.getQUANTITY()/2; k++) {
                  MapOfCells.cells[i][j].arrayList.add(new Horse(MapOfCells.cells[i][j]));
               }
               for (int k = 0; k < MAX_QUANTITY_CELL.MAX_Mouse.getQUANTITY()/2; k++) {
                  MapOfCells.cells[i][j].arrayList.add(new Mouse(MapOfCells.cells[i][j]));
               }
               for (int k = 0; k < MAX_QUANTITY_CELL.MAX_Rabbit.getQUANTITY()/2; k++) {
                  MapOfCells.cells[i][j].arrayList.add(new Rabbit(MapOfCells.cells[i][j]));
               }
               for (int k = 0; k < MAX_QUANTITY_CELL.MAX_Sheep.getQUANTITY()/2; k++) {
                  MapOfCells.cells[i][j].arrayList.add(new Sheep(MapOfCells.cells[i][j]));
               }
               for (int k = 0; k < MAX_QUANTITY_CELL.MAX_Bear.getQUANTITY()/2; k++) {
                  MapOfCells.cells[i][j].arrayList.add(new Bear(MapOfCells.cells[i][j]));
               }
               for (int k = 0; k < MAX_QUANTITY_CELL.MAX_Boar.getQUANTITY()/2; k++) {
                  MapOfCells.cells[i][j].arrayList.add(new Boar(MapOfCells.cells[i][j]));
               }
               for (int k = 0; k < MAX_QUANTITY_CELL.MAX_Eagle.getQUANTITY()/2; k++) {
                  MapOfCells.cells[i][j].arrayList.add(new Eagle(MapOfCells.cells[i][j]));
               }
               for (int k = 0; k < MAX_QUANTITY_CELL.MAX_Fox.getQUANTITY()/2; k++) {
                  MapOfCells.cells[i][j].arrayList.add(new Fox(MapOfCells.cells[i][j]));
               }
               for (int k = 0; k < MAX_QUANTITY_CELL.MAX_Snake.getQUANTITY()/2; k++) {
                  MapOfCells.cells[i][j].arrayList.add(new Snake(MapOfCells.cells[i][j]));
               }
               for (int k = 0; k < MAX_QUANTITY_CELL.MAX_Wolf.getQUANTITY()/2; k++) {
                  MapOfCells.cells[i][j].arrayList.add(new Wolf(MapOfCells.cells[i][j]));
               }
            }
         }

   }
}
