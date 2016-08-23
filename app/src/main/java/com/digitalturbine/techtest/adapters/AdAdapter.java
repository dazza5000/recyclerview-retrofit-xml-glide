package com.digitalturbine.techtest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.digitalturbine.techtest.R;
import com.digitalturbine.techtest.data.Ad;

import java.util.List;


/**
 * Created by daz on 8/23/16.
 */

public class AdAdapter extends RecyclerView.Adapter<AdAdapter.ViewHolder> {

    private List<Ad> ads;
    private Context context;

    public AdAdapter(Context context, List<Ad> ads) {
        this.context = context;
        setList(ads);
    }

    @Override
    public AdAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View adView = inflater.inflate(R.layout.ad_item, parent, false);

        return new AdAdapter.ViewHolder(adView);
    }

    @Override
    public void onBindViewHolder(AdAdapter.ViewHolder viewHolder, int position) {

        Ad ad = ads.get(position);

        Glide
                .with(context)
                .load(ad.getProductThumbnail())
                .crossFade()
                .fitCenter()
                .into(viewHolder.productImage);
        viewHolder.productName.setText(ad.getProductName());
        viewHolder.productRating.setText(String.format("Rating: %s", ad.getRating()));
        viewHolder.productDescription.setText(ad.getProductDescription());

    }

    private void setList(List<Ad> ads) {
        this.ads = ads;
    }

    public void replaceData(List<Ad> ads){
        setList(ads);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return ads.size();
    }

    public Ad getItem(int position) {
        return ads.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productName;
        private TextView productRating;
        private TextView productDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            productImage = (ImageView) itemView.findViewById(R.id.product_image);
            productName = (TextView) itemView.findViewById(R.id.product_name);
            productRating = (TextView) itemView.findViewById(R.id.product_rating);
            productDescription = (TextView) itemView.findViewById(R.id.product_description);
        }

    }

}