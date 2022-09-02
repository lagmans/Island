package com.javarush.gui;


import com.javarush.map.MapOfCells;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Controller {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);

        @FXML
        private Button Buttom3;

        @FXML
        private Button Button2;

        @FXML
        void Buttom3(ActionEvent event) {

        }

        @FXML
        void Button2(ActionEvent event) {
                for (int i = 0; i < MapOfCells.cells.length; i++) {
                        for (int j = 0; j < MapOfCells.cells[0].length; j++) {
                                executorService.execute(MapOfCells.cells[i][j]);
                        }
                }
        }

}