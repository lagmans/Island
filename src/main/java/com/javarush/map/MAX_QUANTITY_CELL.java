package com.javarush.map;

public enum MAX_QUANTITY_CELL {
     MAX_Wolf (30)
    ,MAX_Snake (30)
    ,MAX_Fox (30)
    ,MAX_Bear (5)
    ,MAX_Eagle(20)
    ,MAX_Horse(20)
    ,MAX_Deer(20)
    ,MAX_Rabbit(150)
    ,MAX_Mouse(500)
    ,MAX_Goat(140)
    ,MAX_Sheep(140)
    ,MAX_Boar(50)
    ,MAX_Buffalo(10)
    ,MAX_Duck(200)
    ,MAX_Caterpillar(1000),
     MAX_Plants(2000);

    public int getQUANTITY() {
        return QUANTITY;
    }

    private final int QUANTITY;

    MAX_QUANTITY_CELL(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

}
