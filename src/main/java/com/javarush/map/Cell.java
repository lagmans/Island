package com.javarush.map;

import com.javarush.entity.Animal;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Cell {

    ArrayList<Animal> arrayList = new ArrayList<>();
    AtomicInteger height;
    AtomicInteger width;

}
