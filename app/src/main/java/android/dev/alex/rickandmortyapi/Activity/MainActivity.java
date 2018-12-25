package android.dev.alex.rickandmortyapi.Activity;

import android.dev.alex.rickandmortyapi.Api.Api;
import android.dev.alex.rickandmortyapi.Api.ApiClient;
import android.dev.alex.rickandmortyapi.R;
import android.dev.alex.rickandmortyapi.adapter.AdapterForList;
import android.dev.alex.rickandmortyapi.model.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private  RecyclerView recyclerView;
    private  RecyclerView.LayoutManager layoutManager;
    private  AdapterForList adapterForList;
    private  List<Location> locationList;
    private  Api api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mLocationList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //mRecyclerView.setHasFixedSize(true);

        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Api api = retrofit.create(Api.class);
        api= ApiClient.getApiClient().create(Api.class);
        Call<List<Location>> call = api.getLocation();
        call.enqueue(new Callback<List<Location>>() {
            @Override
            public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                locationList=response.body();
                adapterForList= new AdapterForList(locationList,getApplicationContext());
                recyclerView.setAdapter(adapterForList);


                //textViewMain.setText(String.valueOf(locations1));

                //mAdapterForList= new AdapterForList(locations1,getApplicationContext());
                //mRecyclerView.setAdapter(mAdapterForList);
            }

            @Override
            public void onFailure(Call<List<Location>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });








        //mAdapterForList = new AdapterForList(this,mLocationList);
        //mRecyclerView.setAdapter(mAdapterForList);
    }
}
