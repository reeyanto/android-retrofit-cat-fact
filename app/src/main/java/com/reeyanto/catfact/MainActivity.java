package com.reeyanto.catfact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.reeyanto.catfact.responses.CatResponse;
import com.reeyanto.catfact.services.CatService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://catfact.ninja")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CatService catService = retrofit.create(CatService.class);

        TextView tvResult = findViewById(R.id.tv_result);
        Button btnFetch   = findViewById(R.id.btn_fetch);

        btnFetch.setOnClickListener(view -> {
            Call<CatResponse> responseCall = catService.getRandomFact();
            responseCall.enqueue(new Callback<CatResponse>() {
                @Override
                public void onResponse(Call<CatResponse> call, Response<CatResponse> response) {
                    CatResponse catResponse = response.body();
                    tvResult.setText(catResponse.getFact());
                }

                @Override
                public void onFailure(Call<CatResponse> call, Throwable t) {
                    tvResult.setText(t.getMessage());
                }
            });
        });
    }
}