package com.digitalturbine.techtest.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by daz on 8/23/16.
 */
@Root(name="ad", strict=false)
public class Ad {
    @Element(name = "appId", required = false)
    public String appId;

    @Element(name = "averageRatingImageURL", required = false)
    public String averageRatingImageURL;

    @Element(name = "bidRate", required = false)
    public String bidRate;

    @Element(name = "callToAction", required = false)
    public String callToAction;

    @Element(name = "campaignDisplayOrder", required = false)
    public String campaignDisplayOrder;

    @Element(name = "campaignTypeId", required = false)
    public String campaignTypeId;

    @Element(name = "productDescription", required = false)
    public String productDescription;

    @Element(name = "productName", required = false)
    public String productName;

    @Element(name = "productThumbnail", required = false)
    public String productThumbnail;

    @Element(name = "rating", required = false)
    public String rating;

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductThumbnail() {
        return productThumbnail;
    }

    public String getRating() {
        return rating;
    }

}
