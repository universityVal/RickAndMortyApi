package android.dev.alex.rickandmortyapi.Api;

import android.dev.alex.rickandmortyapi.model.Location;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/location")
    Call<List <Location>> getLocation();
}
