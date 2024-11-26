package com.example.milcaprichos;

public class Ingrediente {

    //Atributos
    private int ID;
    private String NAME_INGREDIENT;
    private String MEASURE;
    private int QUANTITY;

    //Constructor vacío

    public Ingrediente() {
    }


    //Constructor con todos los atributos

    public Ingrediente(int ID, String NAME_INGREDIENT, String MEASURE, int QUANTITY) {
        this.ID = ID;
        this.NAME_INGREDIENT = NAME_INGREDIENT;
        this.MEASURE = MEASURE;
        this.QUANTITY = QUANTITY;
    }

    //Métodos de acceso get y set

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME_INGREDIENT() {
        return NAME_INGREDIENT;
    }

    public void setNAME_INGREDIENT(String NAME_INGREDIENT) {
        this.NAME_INGREDIENT = NAME_INGREDIENT;
    }

    public String getMEASURE() {
        return MEASURE;
    }

    public void setMEASURE(String MEASURE) {
        this.MEASURE = MEASURE;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }
}
