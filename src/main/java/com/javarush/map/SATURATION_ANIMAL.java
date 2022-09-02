package com.javarush.map;

public enum SATURATION_ANIMAL {
    MAX_Wolf (8)
    ,MAX_Snake (3)
    ,MAX_Fox (2)
    ,MAX_Bear (80)
    ,MAX_Eagle(1)
    ,MAX_Horse(60)
    ,MAX_Deer(50)
    ,MAX_Rabbit(0.45)
    ,MAX_Mouse(0.01)
    ,MAX_Goat(10)
    ,MAX_Sheep(15)
    ,MAX_Boar(50)
    ,MAX_Buffalo(100)
    ,MAX_Duck(0.15);


    public double getSATURATION() {
        return SATURATION;
    }

    private final double SATURATION;

    SATURATION_ANIMAL(double SATURATION) {
        this.SATURATION = SATURATION;
    }
}
