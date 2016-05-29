package com.example.proiect_ip.inshape;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.example.proiect_ip.inshape.BackendAPIClient.BackendAPIClientFactory;
import com.example.proiect_ip.inshape.BackendAPIClient.BackendAPIClientMock;
import com.example.proiect_ip.inshape.BackendAPIClient.IBackendAPIClient;
import com.example.proiect_ip.inshape.POJOs.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**API mock deserialization test **/
        new BackendAPIClientFactory(getAssets(), "127.0.0.1");//TODO: Get rid of this at some point

        IBackendAPIClient client = BackendAPIClientFactory.getBackendAPIClient();
        User test = client.userAuth("testUsername", "testPasswd");

        ArrayList<Basket> baskets = test.getBaskets();
        for(Basket i: baskets){
            for(BasketItem j: i.getBasketItems()){
                Log.d("test", "" + j.getProduct().getName());
            }
        }

        /**
         * Making API calls to host test
         */
        final Button button = (Button) findViewById(R.id.button);

        Log.d("test2","test");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * http://stackoverflow.com/questions/2169294/how-to-add-manifest-permission-to-android-application
                 * http://stackoverflow.com/questions/23171291/httpurlconnection-not-working-on-android
                 */
                new Thread (new Runnable() {
                    @Override
                    public void run() {
                        TextView myAwesomeTextView = (TextView) findViewById(R.id.textView3);

                        try {
                            URL url = new URL("http://10.0.2.2:8080/");
                            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                            String a = String.valueOf(urlConnection.getResponseCode());
                            //InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                            //String a = in.toString();

                            //myAwesomeTextView.setText(a);
                        } catch (IOException e) {
                        }
                    }
                }).start();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
