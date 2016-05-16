package com.example.proiect_ip.inshape.POJOs;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by liviu on 5/2/2016.
 *
 * Intended as a container for a "shopping basket"
 *  i.e. one parsed receipt
 */
public class Basket {
    private Integer ID;
    private User user;
    private Date date;
    //private Location loc;
    private ArrayList<BasketItem> basketItems;

    public ArrayList<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(ArrayList<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getID() {

        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
