package com.javarush.map;

import com.javarush.entity.Animal;
import com.javarush.entity.Plants;

import java.util.ArrayList;

public class Cell implements Runnable {

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

    public int getWidth() {
        return width;
    }


    @Override
    public synchronized void run() {
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).eat();
        }
        dayPassed++;

        if (dayPassed%10==0){
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i).reproduction();
            }
        }
    }
}
