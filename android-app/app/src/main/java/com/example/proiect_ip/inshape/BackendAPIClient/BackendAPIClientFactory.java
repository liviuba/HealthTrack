package com.example.proiect_ip.inshape.BackendAPIClient;

import android.content.Context;
import android.content.res.AssetManager;

/**
 * Created by liviu on 5/17/2016.
 */
public class BackendAPIClientFactory {
    private static final String ISOLATED = "NO_VM";
    private static final String WITH_BACKEND = "WITH_VM";

    private static final String env = ISOLATED;

    private static AssetManager assets;
    private static String APIEndpointIP;

    /**
     * Pass everything needed for either type of BackendAPIClient, because of the stupid AssetManager
     */
    public BackendAPIClientFactory(AssetManager assets, String APIEndpointIP){
        BackendAPIClientFactory.assets = assets;
        BackendAPIClientFactory.APIEndpointIP = APIEndpointIP;
    }
    public BackendAPIClientFactory(){}

    public static IBackendAPIClient getBackendAPIClient(){
        IBackendAPIClient client;

        if(env == ISOLATED){
            client = new BackendAPIClientMock(assets);
        }
        else{
            client = new BackendAPIClient(APIEndpointIP);
        }

        return client;
    }
}
