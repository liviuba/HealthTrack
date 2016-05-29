package com.example.proiect_ip.inshape.BackendAPIClient;

import com.example.proiect_ip.inshape.POJOs.Basket;
import com.example.proiect_ip.inshape.POJOs.BasketItem;
import com.example.proiect_ip.inshape.POJOs.Product;
import com.example.proiect_ip.inshape.POJOs.User;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by liviu on 5/17/2016.
 */
public class BackendAPIClient implements IBackendAPIClient{
    /** API paths **/
    private String userAuth = "userAuth";
    private String getBasket = "getBasket";
    private String getBasketItem = "getBasketItem";
    private String getProduct = "getProduct";

    /** GET params **/
    private String userAuthUsername = "username";
    private String userAuthPassword = "password";

    private String getBasketBasketID = "basket";
    private String getBasketItemItemID = "basketItem";
    private String getProductProductID = "product";


    /** Actual members & stuff **/



    public BackendAPIClient(String APIEndpoint){


    }
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
