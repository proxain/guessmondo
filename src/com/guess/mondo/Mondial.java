package com.guess.mondo;

import android.content.res.Resources;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class Mondial {
    protected int number, random;
    private int[] mDataArray, mTeamArray, mHomeArray, mAwayArray;
    public String home_end, away_end;

    // Initialization constructor

    public Mondial(int number) {
        this.number = number;
    }

    // Set background on main

    public void setBackground(RelativeLayout layout, int[][] pics) {
        Random randomGenerator = new Random();

        int random = randomGenerator.nextInt(8);

        layout.setBackgroundResource(pics[number][random]);
    }

    // Set a flag of host country

    public void setFlags(ImageView flag, int[] flags) {
        flag.setImageResource(flags[number]);
    }

    // Set the year of world cup

    public void setYear(TextView year, int[] years) {
        year.setText(String.valueOf(years[number]));
    }

    // Get date array

    public void getDataArray(int[] mDataArray) {
        this.mDataArray = mDataArray;
    }

    // Set date array

    private int setDataArray() {
        return mDataArray[number];
    }

    // Get team array

    public void getTeamArray(int[] mTeamArray) {
        this.mTeamArray = mTeamArray;
    }

    // Set team array

    private int setTeamArray() {
        return mTeamArray[number];
    }

    // Get home team array

    public void getHomeArray(int[] mHomeArray) {
        this.mHomeArray = mHomeArray;
    }

    // Set home team array

    private int setHomeArray() {
        return mHomeArray[number];
    }

    // Get away team array

    public void getAwayArray(int[] mAwayArray) {
        this.mAwayArray = mAwayArray;
    }

    // Set away team array

    private int setAwayArray() {
        return mAwayArray[number];
    }

    // Initialization of match

    public void setMatch(ImageView home_img, ImageView away_img, TextView home_name,
                         TextView away_name, TextView date, Resources res) {
        String[] name = res.getStringArray(setTeamArray());
        String[] dates = res.getStringArray(setDataArray());

        int[] home_pos = res.getIntArray(setHomeArray());
        int[] away_pos = res.getIntArray(setAwayArray());

        Random randomGenerator = new Random();

        random = randomGenerator.nextInt(dates.length);

        Country home = new Country(name[home_pos[random]]);
        Country away = new Country(name[away_pos[random]]);

        date.setText(dates[random]);

        home_img.setImageResource(home.getImage());
        home_name.setText(home.getName());
        home_name.setTextColor(home.getTextColor());
        away_img.setImageResource(away.getImage());
        away_name.setText(away.getName());
        away_name.setTextColor(away.getTextColor());

        home_end = home.getName();
        away_end = away.getName();

        // test1.setText(String.valueOf(homeData[random]));
        // test2.setText(String.valueOf(awayData[random]));
    }

    public String getHome_end() {
        return home_end;
    }

    public String getAway_end() {
        return away_end;
    }

    // Getting information for match end

    public int matchEnd(int[] home_data, int[] away_data) {
        int matchEnd;

        if (home_data[random] > away_data[random]) {
            matchEnd = 1;
        } else if (home_data[random] == away_data[random]) {
            matchEnd = 0;
        } else {
            matchEnd = 2;
        }

        return matchEnd;
    }
}
