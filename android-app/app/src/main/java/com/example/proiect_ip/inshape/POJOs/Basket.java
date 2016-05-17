package com.example.proiect_ip.inshape.POJOs;

import com.example.proiect_ip.inshape.BackendAPIClient.BackendAPIClientFactory;
import com.example.proiect_ip.inshape.BackendAPIClient.BackendAPIClientMock;
import com.example.proiect_ip.inshape.BackendAPIClient.IBackendAPIClient;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by liviu on 5/2/2016.
 *
 * Intended as a container for a "shopping basket"
 *  i.e. one parsed receipt
 */
public class Basket {
    private Integer id;
    private String date;
    //private Location loc;
    private ArrayList<BasketItem> basketItems;

    public String getDate() {

        return date;
    }

    public ArrayList<BasketItem> getBasketItems() {
        return basketItems;
    }

    @JsonSetter("basketItems")
    public void setBasketItems(ArrayList<Integer> items) {
        basketItems = new ArrayList<BasketItem>();
        IBackendAPIClient client = BackendAPIClientFactory.getBackendAPIClient();

        for(Integer basketItem:items){
            basketItems.add(client.getBasketItem(basketItem));
        }
    }

    public Integer getId() {
        return id;
    }
}
