package com.example.proiect_ip.inshape.BackendAPIClient;

import com.example.proiect_ip.inshape.POJOs.Basket;
import com.example.proiect_ip.inshape.POJOs.BasketItem;
import com.example.proiect_ip.inshape.POJOs.Product;
import com.example.proiect_ip.inshape.POJOs.User;

import java.util.ArrayList;

/**
 * Created by liviu on 5/16/2016.
 */
public class BackendAPIClientMock implements IBackendAPIClient {
    private String userAuthToken;

    public Integer userAuth (String userName, String userPassword){
        //set auth token
        return 1;
    }

    public ArrayList<Basket> userBaskets(Integer userID){
        ArrayList<Basket> baskets = new ArrayList<Basket>();

        return baskets;
    }

    public User getUser (Integer userID){
        String userJSON = "";

        return new User();
    }

    public ArrayList<BasketItem> getBasketItems(Integer basketID){
        return new ArrayList<BasketItem>();
    }

    public Product getProductByID(Integer itemID){
        return new Product();
    }

    public void receiptPush(){

    }
}
