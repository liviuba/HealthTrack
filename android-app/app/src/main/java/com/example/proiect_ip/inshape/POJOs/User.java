package com.example.proiect_ip.inshape.POJOs;

import android.util.Log;

import com.example.proiect_ip.inshape.BackendAPIClient.BackendAPIClientFactory;
import com.example.proiect_ip.inshape.BackendAPIClient.BackendAPIClientMock;
import com.example.proiect_ip.inshape.BackendAPIClient.IBackendAPIClient;
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
    private String username;
    private String password;
    private ArrayList<Basket> baskets;
    private ArrayList<Challenge> acceptedChallenges;
    private ArrayList<Challenge> pendingChallenges;
    private ArrayList<Integer> sentChallenges;

    public String getEmail() {
        return email;
    }

    public ArrayList<Challenge> getAcceptedChallenges(){
        return this.acceptedChallenges;
    }
    public ArrayList<Challenge> getPendingChallenges(){
        return this.pendingChallenges;
    }
    public ArrayList<Integer> getSentChallenges(){
        return this.sentChallenges;
    }

    public String getFirstName() {

        return firstName;
    }
    public String getUsername() {

        return username;
    }

    //Returns the hashed password or something
    //used just so the POJOs work
    public String getPassword(){
        return password;
    }


    public String getLastName() {
        return lastName;
    }

    public ArrayList<Basket> getBaskets() {
        return this.baskets;
    }

    @JsonSetter("baskets")
    public void setBaskets(ArrayList<Integer> basketIDs){
        this.baskets = new ArrayList<Basket>();

        IBackendAPIClient client = BackendAPIClientFactory.getBackendAPIClient();
        for(Integer basketID: basketIDs){
            this.baskets.add(client.getBasket(basketID));
        }
    }

    @JsonSetter("acceptedChallenges")
    public void setAcceptedChallenges(ArrayList<Integer> challengeIDs){
        this.acceptedChallenges = new ArrayList<Challenge>();

        IBackendAPIClient client = BackendAPIClientFactory.getBackendAPIClient();
        for(Integer challengeID: challengeIDs){
            this.acceptedChallenges.add(client.getChallengeByID(challengeID));
        }
    }

    @JsonSetter("pendingChallenges")
    public void setPendingChallenges(ArrayList<Integer> challengeIDs){
        this.pendingChallenges = new ArrayList<Challenge>();

        IBackendAPIClient client = BackendAPIClientFactory.getBackendAPIClient();
        for(Integer challengeID: challengeIDs){
            this.pendingChallenges.add(client.getChallengeByID(challengeID));
        }
    }

    /*
    @JsonSetter("sentChallenges")
    public void setSentChallenges(ArrayList<Integer> challengeIDs){
        this.sentChallenges = new ArrayList<Challenge>();

        IBackendAPIClient client = BackendAPIClientFactory.getBackendAPIClient();
        for(Integer challengeID: challengeIDs){
            this.sentChallenges.add(client.getChallengeByID(challengeID));
        }
    }
    */

    public Integer getId() {
        return id;
    }
}
