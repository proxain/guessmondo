package com.guess.mondo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.algeria_kit, R.drawable.angola_kit, R.drawable.argentina_kit, R.drawable.australia_kit,
            R.drawable.austria_kit, R.drawable.belgium_kit, R.drawable.bolivia_kit, R.drawable.brazil_kit,
            R.drawable.bulgaria_kit, R.drawable.cameroon_kit, R.drawable.canada_kit,
            R.drawable.chile_kit, R.drawable.china_kit, R.drawable.colombia_kit, R.drawable.congo_kit,
            R.drawable.costa_rica_kit, R.drawable.croatia_kit, R.drawable.cuba_kit, R.drawable.czech_republic_kit,
            R.drawable.czechoslovakia_kit, R.drawable.denmark_kit, R.drawable.east_germany_kit, R.drawable.ecuador_kit,
            R.drawable.egypt_kit, R.drawable.el_salvador_kit, R.drawable.england_kit, R.drawable.france_kit
    };

    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
    }

}
