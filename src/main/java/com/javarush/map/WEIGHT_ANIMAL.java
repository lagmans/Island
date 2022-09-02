package com.javarush.map;

public enum WEIGHT_ANIMAL {
    MAX_Wolf (50)
    ,MAX_Snake (15)
    ,MAX_Fox (8)
    ,MAX_Bear (500)
    ,MAX_Eagle(6)
    ,MAX_Horse(400)
    ,MAX_Deer(300)
    ,MAX_Rabbit(2)
    ,MAX_Mouse(0.05)
    ,MAX_Goat(60)
    ,MAX_Sheep(70)
    ,MAX_Boar(400)
    ,MAX_Buffalo(700)
    ,MAX_Duck(1)
    ,MAX_Caterpillar(0.01);


    public double getWEIGHT() {
        return WEIGHT;
    }

    private final double WEIGHT;

    WEIGHT_ANIMAL(double WEIGHT) {
        this.WEIGHT = WEIGHT;
    }
}
