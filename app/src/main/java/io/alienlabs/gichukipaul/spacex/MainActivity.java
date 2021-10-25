package io.alienlabs.gichukipaul.spacex;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://api.spacex.land/graphql/";

    ApolloClient apolloClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apolloClient = ApolloClient.builder()
                .serverUrl(BASE_URL)
                .build();

        apolloClient.query(new ShipDetailsQuery())
                .enqueue(new ApolloCall.Callback<ShipDetailsQuery.Data>() {
                    @Override
                    public void onResponse(@NonNull Response<ShipDetailsQuery.Data> response) {
                        Log.i("Oyaa", response.toString());
                    }

                    @Override
                    public void onFailure(@NonNull ApolloException e) {
                        Log.e("oyaa", "onFailure: " + e.getLocalizedMessage());
                    }
                });

    }
}