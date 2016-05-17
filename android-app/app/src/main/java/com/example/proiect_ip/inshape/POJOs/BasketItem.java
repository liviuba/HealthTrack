package com.example.proiect_ip.inshape.POJOs;
import com.example.proiect_ip.inshape.BackendAPIClient.BackendAPIClientFactory;
import com.example.proiect_ip.inshape.BackendAPIClient.IBackendAPIClient;
import com.fasterxml.jackson.annotation.JsonSetter;

import android.content.ClipData;

import com.example.proiect_ip.inshape.BackendAPIClient.BackendAPIClientMock;

import java.util.ArrayList;

/**
 * Created by liviu on 5/2/2016.
 *
 * Intended as a container for the bought items themselves.
 *
 * Might have extra info such as Price, Store, Expiration Date, etc
 */
public class BasketItem {
    private Integer id;
    private Integer basket;
    private Product product;

    public Integer getBasket() {
        return basket;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getId() {
        return id;
    }

    @JsonSetter("product")
    public void setProduct(Integer prod) {
        IBackendAPIClient client = BackendAPIClientFactory.getBackendAPIClient();

        product = client.getProduct(prod);
    }
}
