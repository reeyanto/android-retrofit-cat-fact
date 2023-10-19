package com.reeyanto.catfact.services;

import com.reeyanto.catfact.responses.CatResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatService {

    @GET("/fact")
    Call<CatResponse> getRandomFact();
}
