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
    private Integer id;
    private String name;
    private String calories;
    private Integer serving;

    public Integer getServing() {
        return serving;
    }

    public String getCalories() {

        return calories;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
