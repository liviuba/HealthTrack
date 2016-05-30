package com.example.proiect_ip.inshape.POJOs;

import com.example.proiect_ip.inshape.BackendAPIClient.BackendAPIClientFactory;
import com.example.proiect_ip.inshape.BackendAPIClient.IBackendAPIClient;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Created by liviu on 5/30/2016.
 */
public class Challenge {
    public static String CHALLENGE_ACCEPTED = "Accepted";
    public static String CHALLENGE_PENDING = "Pending";

    private Integer id;
    private String startDate;
    private String endDate;
    private Integer targetUserID;
    private User sourceUserID;
    private Integer challengeKiloCaloriesDaily;
    private Integer currencyPoints;
    private String status;

    public Integer getId(){
        return id;
    }
    public String getStartDate(){
        return this.startDate;
    }
    public String getEndDate(){
        return this.startDate;
    }
    public Integer getTargetUserID(){
        IBackendAPIClient client = BackendAPIClientFactory.getBackendAPIClient();

        //return client.getUserByID(this.targetUserID);
        return this.targetUserID;
    }
    public User getSourceUserID(){
        return this.sourceUserID;
    }
    public Integer getChallengeKiloCaloriesDaily(){
        return this.challengeKiloCaloriesDaily;
    }
    public Integer getCurrencyPoints(){
        return this.currencyPoints;
    }
    public String getStatus(){
        return this.status;
    }

    @JsonSetter("sourceUserID")
    public void setSourceUserID(Integer sourceUserID){
        IBackendAPIClient client = BackendAPIClientFactory.getBackendAPIClient();

        this.sourceUserID = client.getUserByID(sourceUserID);
    }
}
