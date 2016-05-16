package com.example.proiect_ip.inshape.POJOs;

/**
 * Created by liviu on 5/2/2016.
 *
 * Intended as a container for the bought items themselves.
 *
 * Might have extra info such as Price, Store, Expiration Date, etc
 */
public class BasketItem {
    private Integer ID;
    private Basket basket;
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Basket getBasket() {

        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Integer getID() {

        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
