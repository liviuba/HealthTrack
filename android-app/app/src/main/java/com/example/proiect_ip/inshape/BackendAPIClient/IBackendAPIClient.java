package com.example.proiect_ip.inshape.BackendAPIClient;

import java.util.ArrayList;

import com.example.proiect_ip.inshape.POJOs.BasketItem;
import com.example.proiect_ip.inshape.POJOs.Basket;
import com.example.proiect_ip.inshape.POJOs.Challenge;
import com.example.proiect_ip.inshape.POJOs.Product;
import com.example.proiect_ip.inshape.POJOs.User;

/**
 * Created by liviu on 4/30/2016.
 */
public interface IBackendAPIClient {

    String userAuthKey = null;

    /**
     * Does the auth itself; Intended to be called (most likely) in a constructor.
     *  Also sets userAuthKey for authentication when issuing furter API calls
     *
     * @param userName
     * @param userPassword
     *
     * @return the user ID
     */
    User userAuth (String userName, String userPassword);

    /**
     * Gets all basket IDs for a user
     *
     * @param basketID
     *
     * @return  Populated Basket POJO
     */
    public Basket getBasket(Integer basketID);

    /** @TODO : Do these at some point
     *
     * userBasketsSince()
     * userBasketsInInterval()
     * lastUserBasket()
     * userBasketIDs()  - returns all basket IDs / in a short form, to later query only the relevant ones
     */

    public BasketItem getBasketItem(Integer basketID);
    Product getProduct(Integer itemID);


    /**
     *  @TODO: Figure out a proper way to do this. NOT async ATM
     *          Have a callback for when processing is done (/return Item array w/ parsed info)
     *          Take an easily manageable param for the image handler
     *          Do magic
     */
    void receiptPush();


    public User getUserByID(Integer nUserID);
    public Challenge getChallengeByID(Integer challengeID);
}
