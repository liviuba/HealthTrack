package com.example.proiect_ip.inshape.BackendAPIClient;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.example.proiect_ip.inshape.POJOs.Basket;
import com.example.proiect_ip.inshape.POJOs.BasketItem;
import com.example.proiect_ip.inshape.POJOs.Product;
import com.example.proiect_ip.inshape.POJOs.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by liviu on 5/16/2016.
 *
 * Enables mocking of API replies when a VM is unavailable
 * Heavily coupled with assets/Mocks directory, thread with care!
 */
public class BackendAPIClientMock implements IBackendAPIClient {
    private String userAuthToken;
    private ObjectMapper mapper;
    private AssetManager assetManager;

    /*
        Needed in order to avoid shuffling arround the AssetManager
     */
    public BackendAPIClientMock(AssetManager assetManager){
        mapper = new ObjectMapper();
        this.assetManager = assetManager;
    }

    public User userAuth (String userName, String userPassword){
        User user = new User();

        try {
            user = mapper.readValue(this.assetManager.open("Mocks/User.json"), User.class);
        }
        catch (java.io.IOException ioExc){
            Log.e("InShape", ioExc.getMessage());
        }
        //set auth token
        return user;
    }

    public Basket getBasket(Integer basketID){
        Basket basket = new Basket();

        try {
            basket = mapper.readValue(this.assetManager.open("Mocks/Basket" + basketID + ".json"), Basket.class);
        }
        catch (java.io.IOException ioExc){
            Log.e("InShape", ioExc.getMessage());
        }

        return basket;
    }

    public BasketItem getBasketItem(Integer basketID) {
        BasketItem basketItem = new BasketItem();

        try {
            basketItem = mapper.readValue(this.assetManager.open("Mocks/BasketItem" + basketID + ".json"), BasketItem.class);
        } catch (java.io.IOException ioExc) {
            Log.e("InShape", ioExc.getMessage());
        }

        return basketItem;
    }

    public Product getProduct(Integer itemID){
        Product product = new Product();

        try {
            product = mapper.readValue(this.assetManager.open("Mocks/Product" + itemID + ".json"), Product.class);
        } catch (java.io.IOException ioExc) {
            Log.e("InShape", ioExc.getMessage());
        }

        return product;
    }

    public void receiptPush(){
        //TODO
    }
}
