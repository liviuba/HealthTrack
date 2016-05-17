package com.example.proiect_ip.inshape.POJOs;

import com.example.proiect_ip.inshape.BackendAPIClient.BackendAPIClientMock;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;

/**
 * Created by liviu on 5/16/2016.
 */
public class User {
    private Integer id;
    private String lastName;
    private String email;
    private String firstName;
    private ArrayList<Basket> baskets;

    public String getEmail() {
        return email;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public ArrayList<Basket> getBaskets() {
        return baskets;
    }

    @JsonSetter("baskets")
    public void setBaskets(ArrayList<Integer> basketIDs){
        baskets = new ArrayList<Basket>();

        BackendAPIClientMock client = new BackendAPIClientMock();
        for(Integer basketID: basketIDs){
            baskets.add(client.getBasket(basketID));
        }
    }

    public Integer getId() {
        return id;
    }
}
