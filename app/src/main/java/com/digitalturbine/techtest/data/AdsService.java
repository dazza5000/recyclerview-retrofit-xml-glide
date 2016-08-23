package com.digitalturbine.techtest.data;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by daz on 8/23/16.
 */

public interface AdsService {

    //http://ads.appia.com/getAds?id=236&password=OVUJ1DJN&siteId=4288&deviceId=
    // 4230&sessionId=techtestsession&totalCampaignsRequested=10&lname=kelinske
    @GET("/getAds?id=236&password=OVUJ1DJN&siteId=4288&deviceId=4230&sessionId=techtestsession" +
            "&totalCampaignsRequested=10&lname=kelinske")
    Call<Ads> getAds();
}
