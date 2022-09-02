package com.javarush.map;

public enum MAX_MOVE_ANIMAL {
    MAX_Wolf (3)
    ,MAX_Snake (1)
    ,MAX_Fox (2)
    ,MAX_Bear (2)
    ,MAX_Eagle(3)
    ,MAX_Horse(4)
    ,MAX_Deer(4)
    ,MAX_Rabbit(2)
    ,MAX_Mouse(1)
    ,MAX_Goat(3)
    ,MAX_Sheep(3)
    ,MAX_Boar(2)
    ,MAX_Buffalo(3)
    ,MAX_Duck(4);


    public int getMAX_MOVE() {
        return MAX_MOVE;
    }

    private final int MAX_MOVE;

    MAX_MOVE_ANIMAL(int MAX_MOVE) {
        this.MAX_MOVE = MAX_MOVE;
    }
}
