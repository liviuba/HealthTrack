package com.example.proiect_ip.inshape.POJOs;

/**
 * Created by liviu on 5/2/2016.
 *
 * Intended as a container for the Product itself, unrelated to the user.
 *
 * i.e. An instance would refer to "Milka ciocolata cu pietre 200g"
 *      w/ nutritional info attached
 */
public class Product {
    private Integer ID;
    private String name;
    private String calories;
    private Integer serving;

    public Integer getServing() {
        return serving;
    }

    public void setServing(Integer serving) {
        this.serving = serving;
    }

    public String getCalories() {

        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getID() {

        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
