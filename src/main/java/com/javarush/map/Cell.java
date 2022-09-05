package com.javarush.map;

import com.javarush.entity.Animal;
import com.javarush.entity.Herbivore;
import com.javarush.entity.Herbivores.Caterpillar;
import com.javarush.entity.Plants;
import com.javarush.gui.Controller;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Cell extends Thread {
    Controller controller;

    public volatile ArrayList<Animal> arrayList = new ArrayList<>();
    public volatile ArrayList<Plants> plants = new ArrayList<>();
    public volatile int  dayPassed = 0;

    public volatile double dayOffPlants;
    public final int height;
    public final int width;

    public Cell(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public  int getWidth() {
        return width;
    }


    @Override
    public void run() {

        if ((plants.size()< 25)&&(arrayList.stream().filter(s->s instanceof Caterpillar).count()<250)){
            migration();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).eat();
        }
        for (int i = 0; i < plants.size(); i++) {
            plants.get(i).grow();
            arrayList.add(new Caterpillar(this));
            arrayList.add(new Caterpillar(this));
            arrayList.add(new Caterpillar(this));
            arrayList.add(new Caterpillar(this));
            arrayList.add(new Caterpillar(this));
        }
        for (int i = 0; i <= dayOffPlants; i++) {
            if (plants.size() < 5){
                break;
            }
            plants.remove(i);
        }

        dayPassed++;

        if (dayPassed%10==0){
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i).reproduction();
            }
        }



//        controller.getShowStream().setText("Cell is : " + height + " " + width);
//        countAnimalInCell(this).forEach((key,value) -> {
//            controller.getShowStream().setText("Quantity " + key +" : " + value);
//        });


    }


    public synchronized void migration(){
        for (int i = 0; i < arrayList.size(); i++) {
            if ((arrayList.get(i) instanceof Herbivore) &&( ThreadLocalRandom.current().nextInt(3)==0)) {
                arrayList.get(i).move();
            }
        }
    }


}
