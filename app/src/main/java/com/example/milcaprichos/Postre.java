package com.example.milcaprichos;

import java.util.ArrayList;

public class Postre {
    //Atributos
    private int ID;
    private String NAME_DESSERT;
    private String NAME_CATEGORY;
    private String IMAGE_URL;
    private String DESCRIPTION;
    private String DATE_ADDED;
    private String NAME_PERSON;
    private ArrayList<Ingrediente> ingredientes;



    //Constructor vacío
    public Postre() {
    }

    //Constructor con todos los atributos
    public Postre(int ID, String NAME_DESSERT, String NAME_CATEGORY, String IMAGE_URL, String DESCRIPTION, String DATE_ADDED, String NAME_PERSON, ArrayList<Ingrediente> ingredientes) {
        this.ID = ID;
        this.NAME_DESSERT = NAME_DESSERT;
        this.NAME_CATEGORY = NAME_CATEGORY;
        this.IMAGE_URL = IMAGE_URL;
        this.DESCRIPTION = DESCRIPTION;
        this.DATE_ADDED = DATE_ADDED;
        this.NAME_PERSON = NAME_PERSON;
        this.ingredientes = ingredientes;
    }

    //Métodos get y set
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME_DESSERT() {
        return NAME_DESSERT;
    }

    public void setNAME_DESSERT(String NAME_DESSERT) {
        this.NAME_DESSERT = NAME_DESSERT;
    }

    public String getNAME_CATEGORY() {
        return NAME_CATEGORY;
    }

    public void setNAME_CATEGORY(String NAME_CATEGORY) {
        this.NAME_CATEGORY = NAME_CATEGORY;
    }

    public String getIMAGE_URL() {
        return IMAGE_URL;
    }

    public void setIMAGE_URL(String IMAGE_URL) {
        this.IMAGE_URL = IMAGE_URL;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getDATE_ADDED() {
        return DATE_ADDED;
    }

    public void setDATE_ADDED(String DATE_ADDED) {
        this.DATE_ADDED = DATE_ADDED;
    }

    public String getNAME_PERSON() {
        return NAME_PERSON;
    }

    public void setNAME_PERSON(String NAME_PERSON) {
        this.NAME_PERSON = NAME_PERSON;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
