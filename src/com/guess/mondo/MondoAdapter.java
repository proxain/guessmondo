package com.guess.mondo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MondoAdapter extends BaseAdapter {

    private Activity activity;
    private String[] home_end, away_end, forecast;
    public boolean[] solution;
    private static LayoutInflater inflater = null;
    private Typeface tpName;

    public MondoAdapter(Activity a, String[] home_end, String[] away_end, String[] forecast, boolean[] solution) {
        activity = a;
        this.home_end = home_end;
        this.away_end = away_end;
        this.forecast = forecast;
        this.solution = solution;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void getTpName(Typeface tpName) {
        this.tpName = tpName;
    }

    private Typeface setTpName() {
        return tpName;
    }

    public int getCount() {
        return home_end.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.item_row, null);

        TextView home = (TextView)vi.findViewById(R.id.home_team); // title
        TextView away = (TextView)vi.findViewById(R.id.away_team); // artist name
        TextView mForecast = (TextView)vi.findViewById(R.id.forecast); // duration
        ImageView mSolutios =(ImageView)vi.findViewById(R.id.solution); // thumb image

        Country mHome = new Country(home_end[position]);
        Country mAway = new Country(away_end[position]);

        home.setTypeface(setTpName());
        away.setTypeface(setTpName());
        mForecast.setTypeface(setTpName());

        home.setTextColor(mHome.getTextColor());
        away.setTextColor(mAway.getTextColor());

        // Setting all values in listview
        home.setText(mHome.getName());
        away.setText(mAway.getName());
        mForecast.setText(forecast[position]);

        if (solution[position] == true) {
            mSolutios.setImageResource(R.drawable.tick);
        } else {
            mSolutios.setImageResource(R.drawable.tock);
        }

        return vi;
    }
}
