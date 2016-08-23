package com.digitalturbine.techtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.digitalturbine.techtest.adapters.AdAdapter;
import com.digitalturbine.techtest.data.Ad;
import com.digitalturbine.techtest.data.Ads;
import com.digitalturbine.techtest.data.AdsService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @BindView(R.id.recycler_view)
    RecyclerView adRecyclerView;
    private List<Ad> adList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        final AdAdapter adAdapter = new AdAdapter(MainActivity.this, adList);
        adRecyclerView.setAdapter(adAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ads.appia.com/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        AdsService adsService = retrofit.create(AdsService.class);
        Call<Ads> call = adsService.getAds();

        call.enqueue(new Callback<Ads>() {
            @Override
            public void onResponse(Call<Ads> call, Response<Ads> response) {
                Log.d(TAG, "onResponse: " +response.body().getAds().size());
                List<Ad> adList = response.body().getAds();
                adAdapter.replaceData(adList);

            }

            @Override
            public void onFailure(Call<Ads> call, Throwable t) {
                Log.d(TAG, "onResponse: " +t.toString());

            }
        });

    }


}
