package io.alienlabs.gichukipaul.spacex;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.google.gson.Gson;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://api.spacex.land/graphql/";

    ApolloClient apolloClient;
    Gson gson;
    io.alienlabs.gichukipaul.spacex.Model.Response data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init apollo
        apolloClient = ApolloClient.builder()
                .serverUrl(BASE_URL)
                .build();

        gson = new Gson();

        getPastLaunches();

        //query ship details
        // shipDetails();

        //query to fetch launches data/info
        // launchInfo();


    }

    private void getPastLaunches() {
        apolloClient.query(new GetPastLaunchesQuery(30))
                .enqueue(new ApolloCall.Callback<GetPastLaunchesQuery.Data>() {
                    @Override
                    public void onResponse(@NonNull Response<GetPastLaunchesQuery.Data> response) {
                        List<GetPastLaunchesQuery.LaunchesPast> launchesPast = Objects.requireNonNull(response.getData()).launchesPast;
                        assert launchesPast != null;
                        Log.d("mainActivity", "onResponse:🚀 " + launchesPast.toString());
                        data = gson.fromJson(response.toString(), io.alienlabs.gichukipaul.spacex.Model.Response.class);
                    }

                    @Override
                    public void onFailure(@NonNull ApolloException e) {
                        Log.e("MainActivity", "onFailure:🚀 " + e.getLocalizedMessage());
                    }
                });
    }

    private void launchDetails(Integer ID) {
        apolloClient.query(new LaunchDetailsQuery(String.valueOf(ID))).enqueue(new ApolloCall.Callback<LaunchDetailsQuery.Data>() {
            @Override
            public void onResponse(@NonNull Response<LaunchDetailsQuery.Data> response) {
                Log.d("mainactivity", "onResponse: 🚀 " + response.getData().toString());
            }

            @Override
            public void onFailure(@NonNull ApolloException e) {
                Log.e("mainactivity", "🚀 onFailure: " + e.getLocalizedMessage());
            }
        });
    }

    private void launchInfo() {
        apolloClient.query(new LaunchesInfoQuery())
                .enqueue(new ApolloCall.Callback<LaunchesInfoQuery.Data>() {
                    @Override
                    public void onResponse(@NonNull Response<LaunchesInfoQuery.Data> response) {
                        if (Objects.requireNonNull(response.getData()).launches != null) {
                            List<LaunchesInfoQuery.Launch> launchList = Objects.requireNonNull(response.getData()).launches();
                            assert launchList != null;
                            Log.i("oyaa", "onResponse: " + launchList.toString());
                            // Toast.makeText(MainActivity.this, "Success getting launch info", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull ApolloException e) {
                        Log.i("oyaa 😊", e.getLocalizedMessage());
                        //Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void shipDetails() {
        apolloClient.query(new ShipDetailsQuery())
                .enqueue(new ApolloCall.Callback<ShipDetailsQuery.Data>() {
                    @Override
                    public void onResponse(@NonNull Response<ShipDetailsQuery.Data> response) {
                        Log.i("Oyaa", response.toString());
                        // Toast.makeText(MainActivity.this, "Success getting ship details info", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(@NonNull ApolloException e) {
                        Log.e("oyaa", "onFailure: " + e.getLocalizedMessage());
                        // Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}