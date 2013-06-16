package com.guess.mondo;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.*;
import com.google.ads.AdRequest;
import com.google.ads.AdView;

import java.util.Random;

public class Game extends Activity {
    protected int count = 0;
    protected int all = 19;
    protected int truePlay = 0;
    protected int falsePlay = 0;
    protected RelativeLayout main, home;
    protected ImageView flag, home_flag, away_flag;
    protected TextView year, date, home_name, away_name, time, one, draw, two, mTrue, mFalse;
    //protected TextView test1, test2;
    protected Random randomGenerator;
    protected Resources res;
    protected Typeface name, info, tpTime;
    protected RadioGroup rg;
    protected RadioButton homeRB, drawRB, awayRB;
    protected Button next;
    protected int matchEnd;
    public String[] home_end, away_end, forecast;
    public boolean[] solution;
    //protected Airpush airpush;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set activity on full screen

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.main);

        randomGenerator = new Random();
        res = this.getResources();

        initViews();
        createTypeface();
        setTypeface();
        setTextViewsSize();
        setShadowsOfTextViews();
        setCheckListener();
        initFinalArrays();
        setUpAds();

        setRandomValues(all);
        all--;

        next.setEnabled(false);
        rg.clearCheck();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Disable next button after click
                next.setEnabled(false);
                forecast[count] = mForecast(mPlay(rg.getCheckedRadioButtonId()));

                // Information for player result
                if (mPlay(rg.getCheckedRadioButtonId()) == matchEnd) {
                    truePlay++;
                    mTrue.setText(String.valueOf(truePlay));
                    solution[count] = true;
                    count++;
                } else {
                    falsePlay++;
                    mFalse.setText(String.valueOf(falsePlay));
                    solution[count] = false;
                    count++;
                }

                // Set new values if button is clicked
                if (all > 0) {
                    setRandomValues(all);
                    all--;
                } else {
                    Intent intent = new Intent(getBaseContext(), EndScreen.class);
                    intent.putExtra("home_end", home_end);
                    intent.putExtra("away_end", away_end);
                    intent.putExtra("forecast", forecast);
                    intent.putExtra("solution", solution);
                    startActivity(intent);

                }

                // Clear check of radio buttons after button click
                rg.clearCheck();
            }
        });
    }

    // Initialization of all view in activity

    private void initViews() {
        // main RelativeLayout for background image
        main = (RelativeLayout) findViewById(R.id.frame);

        home = (RelativeLayout) findViewById(R.id.home);

        // info for the match
        flag = (ImageView) findViewById(R.id.flag);
        year = (TextView) findViewById(R.id.year);
        date = (TextView) findViewById(R.id.date);

        // flags and 3 key name of teams
        home_flag = (ImageView) findViewById(R.id.home_flag);
        away_flag = (ImageView) findViewById(R.id.away_flag);
        home_name = (TextView) findViewById(R.id.home_name);
        away_name = (TextView) findViewById(R.id.away_name);

        // play bar
        time = (TextView) findViewById(R.id.full_time);

        mTrue = (TextView) findViewById(R.id.my_true);
        mFalse = (TextView) findViewById(R.id.my_false);

        one = (TextView) findViewById(R.id.one);
        draw = (TextView) findViewById(R.id.ex);
        two = (TextView) findViewById(R.id.two);
        rg = (RadioGroup) findViewById(R.id.radioGroup1);

        homeRB = (RadioButton) findViewById(R.id.homeRB);
        drawRB = (RadioButton) findViewById(R.id.drawRB);
        awayRB = (RadioButton) findViewById(R.id.awayRB);

        next = (Button) findViewById(R.id.next);

        // test1 = (TextView) findViewById(R.id.test1);
        // test2 = (TextView) findViewById(R.id.test2);
    }

    // Initialization of typeface

    private void createTypeface() {
        name = Typeface.createFromAsset(getAssets(), "fonts/SAF.otf");
        info = Typeface.createFromAsset(getAssets(), "fonts/Practique.ttf");
        tpTime = Typeface.createFromAsset(getAssets(), "fonts/KiloGram_KG.otf");
    }

    // Set Typeface of TextViews

    private void setTypeface() {
        year.setTypeface(info);
        date.setTypeface(info);
        time.setTypeface(tpTime);

        one.setTypeface(tpTime);
        draw.setTypeface(tpTime);
        two.setTypeface(tpTime);

        mTrue.setTypeface(tpTime);
        mFalse.setTypeface(tpTime);
    }

    // Set size of TextViews

    private void setTextViewsSize() {
        year.setTextSize(28);
        date.setTextSize(28);
        time.setTextSize(18);

        mTrue.setTextSize(18);
        mFalse.setTextSize(18);
    }

    // Set shadow layer of TextViews

    private void setShadowsOfTextViews() {
        year.setShadowLayer(1, 1, 1, Color.DKGRAY);
        date.setShadowLayer(1, 1, 1, Color.DKGRAY);
        time.setShadowLayer(1, 1, 1, Color.DKGRAY);
        one.setShadowLayer(1, 1, 1, Color.DKGRAY);
        draw.setShadowLayer(1, 1, 1, Color.DKGRAY);
        two.setShadowLayer(1, 1, 1, Color.DKGRAY);
        mTrue.setShadowLayer(1, 1, 1, Color.DKGRAY);
        mFalse.setShadowLayer(1, 1, 1, Color.DKGRAY);
    }

    // Create listeners for RadioButtons

    private void setCheckListener() {
        homeRB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) next.setEnabled(b);
            }
        });

        drawRB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) next.setEnabled(b);
            }
        });

        awayRB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) next.setEnabled(b);
            }
        });
    }

    // Set up match

    private void setRandomValues(int all) {
        int randomInt = randomGenerator.nextInt(all);
        int[] homeGoal = res.getIntArray(homeGoalArray[randomInt]);
        int[] awayGoal = res.getIntArray(awayGoalArray[randomInt]);

        Mondial mondo = new Mondial(randomInt);

        //applyRotation(-30, 30);

        mondo.setBackground(main, pics);
        mondo.setFlags(flag, flags);
        mondo.setYear(year, years);

        mondo.getDataArray(dateArray);
        mondo.getTeamArray(teamsArray);
        mondo.getHomeArray(homeArray);
        mondo.getAwayArray(awayArray);

        home_name.setTypeface(name);
        away_name.setTypeface(name);
        home_name.setTextSize(28);
        away_name.setTextSize(28);
        home_name.setShadowLayer(1, 1, 1, Color.DKGRAY);
        away_name.setShadowLayer(1, 1, 1, Color.DKGRAY);

        mondo.setMatch(home_flag, away_flag, home_name, away_name, date, res);

        //home_flag.setAnimation(rotation);

        home_end[count] = mondo.getHome_end();
        away_end[count] = mondo.getAway_end();

        matchEnd = mondo.matchEnd(homeGoal, awayGoal);

        pics = removeElement(pics, randomInt);

        flags = removeElement(flags, randomInt);
        years = removeElement(years, randomInt);
        dateArray = removeElement(dateArray, randomInt);

        teamsArray = removeElement(teamsArray, randomInt);

        homeArray = removeElement(homeArray, randomInt);
        awayArray = removeElement(awayArray, randomInt);

        homeGoalArray = removeElement(homeGoalArray, randomInt);
        awayGoalArray = removeElement(awayGoalArray, randomInt);
    }

    // Getting information for what player is choose

    private int mPlay(int checkedId) {
        int mPlay;

        if (checkedId == R.id.homeRB) {
            mPlay = 1;
        } else if (checkedId == R.id.drawRB) {
            mPlay = 0;
        } else {
            mPlay = 2;
        }

        return mPlay;
    }

    // Initialization of array for next scree

    private void initFinalArrays() {
        home_end = new String[19];
        away_end = new String[19];
        forecast = new String[19];
        solution = new boolean[19];
    }

    private String mForecast(int mPlay) {
        String mForecast;

        if (mPlay == 1) {
            mForecast = "1";
        } else if (mPlay == 2) {
            mForecast = "2";
        }  else {
            mForecast = "X";
        }

        return mForecast;
    }

    // Removing elements from arrays

    public static int[] removeElement(int[] original, int element){
        int[] n = new int[original.length - 1];
        System.arraycopy(original, 0, n, 0, element );
        System.arraycopy(original, element+1, n, element, original.length - element-1);
        return n;
    }

    public static int[][] removeElement(int[][] original, int element){
        int[][] n = new int[original.length - 1][2];
        System.arraycopy(original, 0, n, 0, element );
        System.arraycopy(original, element+1, n, element, original.length - element-1);
        return n;
    }


    private void applyRotation(float start, float  end) {
        final float centerX = home_flag.getWidth() / 2;
        final float centerY = home_flag.getHeight();

        // The animation listener is used to trigger the next animation
        final Rotate3dAnimation rotation = new Rotate3dAnimation(start, end,
                centerX, centerY, 130.0f, true);
        rotation.setDuration(1200);
        rotation.setFillAfter(false);
        rotation.setDuration(Animation.RESTART);
        rotation.setInterpolator(new AccelerateInterpolator());

        home_flag.setAnimation(rotation);
    }

    // Setup ads

    private void setUpAds() {
        // airpush = new Airpush(getApplicationContext());
        // airpush.startPushNotification(true);
        // airpush.startSmartWallAd();
        // airpush.startDialogAd();
        // airpush.startLandingPageAd();
        // airpush.startAppWall();

        AdView adView = (AdView)this.findViewById(R.id.adView);
        adView.loadAd(new AdRequest());
    }



    private int[] dateArray = {
            R.array.uru_date, R.array.ita_date, R.array.fra_date, R.array.bra_date, R.array.sui_date,
            R.array.swe_date, R.array.chi_date, R.array.eng_date, R.array.mex_date, R.array.ger_date,
            R.array.arg_date, R.array.esp_date, R.array.mex_date1, R.array.ita_date1, R.array.usa_date,
            R.array.fra_date1, R.array.jpa_date, R.array.ger_date1, R.array.rsa_date,
    };

    private int[] teamsArray = {
            R.array.uru_teams, R.array.ita_teams, R.array.fra_teams, R.array.bra_teams, R.array.sui_teams,
            R.array.swe_teams, R.array.chi_teams, R.array.eng_teams, R.array.mex_teams, R.array.ger_teams,
            R.array.arg_teams, R.array.esp_teams, R.array.mex_teams1, R.array.ita_teams1, R.array.usa_teams,
            R.array.fra_teams1, R.array.jpa_teams, R.array.ger_teams1, R.array.rsa_teams,
    };

    private int[] homeArray = {
            R.array.home_30, R.array.home_34, R.array.home_38, R.array.home_50, R.array.home_54,
            R.array.home_58, R.array.home_62, R.array.home_66, R.array.home_70, R.array.home_74,
            R.array.home_78, R.array.home_82, R.array.home_86, R.array.home_90, R.array.home_94,
            R.array.home_98, R.array.home_02, R.array.home_06, R.array.home_10
    };

    private int[] awayArray = {
            R.array.away_30, R.array.away_34, R.array.away_38, R.array.away_50, R.array.away_54,
            R.array.away_58, R.array.away_62, R.array.away_66, R.array.away_70, R.array.away_74,
            R.array.away_78, R.array.away_82, R.array.away_86, R.array.away_90, R.array.away_94,
            R.array.away_98, R.array.away_02, R.array.away_06, R.array.away_10
    };

    private int[] homeGoalArray = {
            R.array.home_goal30, R.array.home_goal34, R.array.home_goal38, R.array.home_goal50, R.array.home_goal54,
            R.array.home_goal58, R.array.home_goal62, R.array.home_goal66, R.array.home_goal70, R.array.home_goal74,
            R.array.home_goal78, R.array.home_goal82, R.array.home_goal86, R.array.home_goal90, R.array.home_goal94,
            R.array.home_goal98, R.array.home_goal02, R.array.home_goal06, R.array.home_goal10
    };

    private int[] awayGoalArray = {
            R.array.away_goal30, R.array.away_goal34, R.array.away_goal38, R.array.away_goal50, R.array.away_goal54,
            R.array.away_goal58, R.array.away_goal62, R.array.away_goal66, R.array.away_goal70, R.array.away_goal74,
            R.array.away_goal78, R.array.away_goal82, R.array.away_goal86, R.array.away_goal90, R.array.away_goal94,
            R.array.away_goal98, R.array.away_goal02, R.array.away_goal06, R.array.away_goal10
    };

    private int[][] pics = {
            {R.drawable.uru301, R.drawable.uru302, R.drawable.uru303,
                    R.drawable.uru301, R.drawable.uru302, R.drawable.uru303,
                    R.drawable.uru301, R.drawable.uru302, R.drawable.uru303},

            {R.drawable.ita341, R.drawable.ita342, R.drawable.ita343,
                    R.drawable.ita341, R.drawable.ita342, R.drawable.ita343,
                    R.drawable.ita341, R.drawable.ita342, R.drawable.ita343},

            {R.drawable.fra381, R.drawable.fra382, R.drawable.fra383,
                    R.drawable.fra381, R.drawable.fra382, R.drawable.fra383,
                    R.drawable.fra381, R.drawable.fra382, R.drawable.fra383},

            {R.drawable.bra501, R.drawable.bra502, R.drawable.bra503,
                    R.drawable.bra501, R.drawable.bra502, R.drawable.bra503,
                    R.drawable.bra501, R.drawable.bra502, R.drawable.bra503},

            {R.drawable.sui541, R.drawable.sui542, R.drawable.sui543,
                    R.drawable.sui541, R.drawable.sui542, R.drawable.sui543,
                    R.drawable.sui541, R.drawable.sui542, R.drawable.sui543},

            {R.drawable.swe581, R.drawable.swe582, R.drawable.swe583,
                    R.drawable.swe581, R.drawable.swe582, R.drawable.swe583,
                    R.drawable.swe581, R.drawable.swe582, R.drawable.swe583},

            {R.drawable.chi621, R.drawable.chi622, R.drawable.chi623,
                    R.drawable.chi621, R.drawable.chi622, R.drawable.chi623,
                    R.drawable.chi621, R.drawable.chi622, R.drawable.chi623},

            {R.drawable.eng661, R.drawable.eng662, R.drawable.eng663,
                    R.drawable.eng661, R.drawable.eng662, R.drawable.eng663,
                    R.drawable.eng661, R.drawable.eng662, R.drawable.eng663},

            {R.drawable.mex701, R.drawable.mex702, R.drawable.mex703,
                    R.drawable.mex701, R.drawable.mex702, R.drawable.mex703,
                    R.drawable.mex701, R.drawable.mex702, R.drawable.mex703},

            {R.drawable.ger741, R.drawable.ger742, R.drawable.ger743,
                    R.drawable.ger741, R.drawable.ger742, R.drawable.ger743,
                    R.drawable.ger741, R.drawable.ger742, R.drawable.ger743},

            {R.drawable.arg781, R.drawable.arg782, R.drawable.arg783,
                    R.drawable.arg781, R.drawable.arg782, R.drawable.arg783,
                    R.drawable.arg781, R.drawable.arg782, R.drawable.arg783},

            {R.drawable.spa821, R.drawable.spa822, R.drawable.spa823,
                    R.drawable.spa821, R.drawable.spa822, R.drawable.spa823,
                    R.drawable.spa821, R.drawable.spa822, R.drawable.spa823},

            {R.drawable.mex861, R.drawable.mex862, R.drawable.mex863,
                    R.drawable.mex861, R.drawable.mex862, R.drawable.mex863,
                    R.drawable.mex861, R.drawable.mex862, R.drawable.mex863},

            {R.drawable.ita901, R.drawable.ita902, R.drawable.ita903,
                    R.drawable.ita901, R.drawable.ita902, R.drawable.ita903,
                    R.drawable.ita901, R.drawable.ita902, R.drawable.ita903},

            {R.drawable.usa941, R.drawable.usa942, R.drawable.usa943,
                    R.drawable.usa941, R.drawable.usa942, R.drawable.usa943,
                    R.drawable.usa941, R.drawable.usa942, R.drawable.usa943},

            {R.drawable.fra981, R.drawable.fra982, R.drawable.fra983,
                    R.drawable.fra981, R.drawable.fra982, R.drawable.fra983,
                    R.drawable.fra981, R.drawable.fra982, R.drawable.fra983},

            {R.drawable.jap021, R.drawable.jap022, R.drawable.jap023,
                    R.drawable.jap021, R.drawable.jap022, R.drawable.jap023,
                    R.drawable.jap021, R.drawable.jap022, R.drawable.jap023},

            {R.drawable.ger061, R.drawable.ger062, R.drawable.ger063,
                    R.drawable.ger061, R.drawable.ger062, R.drawable.ger063,
                    R.drawable.ger061, R.drawable.ger062, R.drawable.ger063},

            {R.drawable.rsa101, R.drawable.rsa102, R.drawable.rsa103,
                    R.drawable.rsa101, R.drawable.rsa102, R.drawable.rsa103,
                    R.drawable.rsa101, R.drawable.rsa102, R.drawable.rsa103}
    };

    private int[] years = {
            1930, 1934, 1938, 1950, 1954, 1958, 1962, 1966, 1970, 1974, 1978,
            1982, 1986, 1990, 1994, 1998, 2002, 2006, 2010
    };

    private int[] flags = {
            R.drawable.uruguay, R.drawable.italy, R.drawable.france, R.drawable.brazil, R.drawable.swiss,
            R.drawable.sweden, R.drawable.chile, R.drawable.england, R.drawable.mexico, R.drawable.german,
            R.drawable.argentina, R.drawable.spain, R.drawable.mexico, R.drawable.italy, R.drawable.usa,
            R.drawable.france, R.drawable.korea_japan, R.drawable.german, R.drawable.south_africa
    };
    /**
     public boolean onKeyDown(int keyCode, KeyEvent event) {
     if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
     airpush.startSmartWallAd();
     }
     return super.onKeyDown(keyCode, event);
     } **/
}
