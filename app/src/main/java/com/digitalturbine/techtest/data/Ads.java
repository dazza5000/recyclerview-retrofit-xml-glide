package com.digitalturbine.techtest.data;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by daz on 8/23/16.
 */
@Root(name="ads", strict=false)
public class Ads {

    @ElementList(entry = "ad", inline = true)
    private List<Ad> ads;

    public List<Ad> getAds() {
        return ads;
    }
}
