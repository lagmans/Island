package com.javarush.gui;


import com.javarush.entity.Herbivores.*;
import com.javarush.entity.Predators.*;
import com.javarush.map.Cell;
import com.javarush.map.MapOfCells;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller {




        ExecutorService executorService = Executors.newFixedThreadPool(5);

        public TextArea getShowStream() {
                return showStream;
        }

        public void setShowStream(TextArea showStream) {
                this.showStream = showStream;
        }

        @FXML
        private Button Buttom3;

        @FXML
        private Button Button2;

        @FXML
        private TextArea showStream;

        @FXML
        void Buttom3(ActionEvent event) {
                for (int i = 0; i < MapOfCells.cells.length; i++) {
                        for (int j = 0; j < MapOfCells.cells[0].length; j++) {
                                showAnimalInCell(MapOfCells.cells[i][j]);

                        }
                }
        }

        @FXML
        void Button2(ActionEvent event) {

                        for (int i = 0; i < MapOfCells.cells.length; i++) {
                                for (int j = 0; j < MapOfCells.cells[0].length; j++) {
                                        executorService.submit(MapOfCells.cells[i][j]);

                                      //  showAnimalInCell(MapOfCells.cells[i][j]);
                                       }
                        }
                executorService.shutdown();

        }


        public synchronized void showAnimalInCell (Cell cell) {
                StringBuilder builder= new StringBuilder();
                builder.append("Buffalo "+ cell.arrayList.stream().filter(s -> s instanceof Buffalo).count() +" ");
                builder.append("Caterpillar " + cell.arrayList.stream().filter(s -> s instanceof Caterpillar).count()+" ");
                builder.append("Deer " + cell.arrayList.stream().filter(s -> s instanceof Deer).count()+" ");
                builder.append("Duck " + cell.arrayList.stream().filter(s -> s instanceof Duck).count()+" ");
                builder.append("Goat " + cell.arrayList.stream().filter(s -> s instanceof Goat).count()+" ");
                builder.append("Horse " + cell.arrayList.stream().filter(s -> s instanceof Horse).count()+" ");
                builder.append("Mouse " + cell.arrayList.stream().filter(s -> s instanceof Mouse).count()+" ");
                builder.append("Rabbit " + cell.arrayList.stream().filter(s -> s instanceof Rabbit).count()+" ");
                builder.append("Sheep " + cell.arrayList.stream().filter(s -> s instanceof Sheep).count()+" ");
                builder.append("Bear " + cell.arrayList.stream().filter(s -> s instanceof Bear).count()+" ");
                builder.append("Boar " + cell.arrayList.stream().filter(s -> s instanceof Boar).count()+" ");
                builder.append("Eagle " + cell.arrayList.stream().filter(s -> s instanceof Eagle).count()+" ");
                builder.append("Fox " + cell.arrayList.stream().filter(s -> s instanceof Fox).count()+" ");
                builder.append("Snake " + cell.arrayList.stream().filter(s -> s instanceof Snake).count()+" ");
                builder.append("Wolf " + cell.arrayList.stream().filter(s -> s instanceof Wolf).count()+" ");
                builder.append("Plants " + cell.plants.size()+"\n");
                showStream.appendText(builder.toString());

        }




}