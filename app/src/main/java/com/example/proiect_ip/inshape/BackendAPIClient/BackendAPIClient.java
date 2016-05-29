package com.example.proiect_ip.inshape.BackendAPIClient;

import com.example.proiect_ip.inshape.POJOs.Basket;
import com.example.proiect_ip.inshape.POJOs.BasketItem;
import com.example.proiect_ip.inshape.POJOs.Product;
import com.example.proiect_ip.inshape.POJOs.User;

/**
 * Created by liviu on 5/17/2016.
 */
public class BackendAPIClient implements IBackendAPIClient{
    public BackendAPIClient(String APIEndpoint){}
    public BasketItem getBasketItem(Integer basketID){
        //TODO
        return new BasketItem();
    }
    public Product getProduct(Integer itemID){
        //TODO
        return new Product();
    }
    public void receiptPush(){
        //TODO
    }
    public Basket getBasket(Integer basketID){
        //TODO
        return new Basket();
    }
    public User userAuth (String userName, String userPassword){
        //TODO
        return new User();
    }
}
