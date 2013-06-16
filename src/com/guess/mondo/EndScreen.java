package com.guess.mondo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import com.google.ads.AdRequest;
import com.google.ads.AdView;

import java.util.Random;

public class EndScreen extends Activity {
    protected Typeface name;
    private static LayoutInflater inflater = null;
    protected Random randomGenerator;
    public String[] home_info, away_info, forecast_info;
    public boolean[] solution_info;
    public RelativeLayout achievement, achievement_none;
    public TextView my_true, my_false;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.endscreen);

        randomGenerator = new Random();

        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //AdView adView = new AdView(this, AdSize.BANNER, "a1511823b1c1281");


        //adView.loadAd(new AdRequest());

        //adView.getMeasuredWidth();
        //adView.getMeasuredHeight();

        getInfos();

        initLayouts();


        final Button playAgain = (Button) findViewById(R.id.play_again);
        Button mainMenu = (Button) findViewById(R.id.main_menu);

        TextView myTruePoints = (TextView) findViewById(R.id.my_true);
        TextView myFalsePoints = (TextView) findViewById(R.id.my_false);

        setAchievement();

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Game.class);
                startActivity(intent);
                // setAchievement();
            }
        });

        Typeface buttonTp = Typeface.createFromAsset(getAssets(), "fonts/SpicyRice-Regular.otf");

        playAgain.setTypeface(buttonTp);
        playAgain.setTextSize(30);
        playAgain.setShadowLayer(1, -2, 2, 0xFF7B5B8A);
        mainMenu.setTypeface(buttonTp);
        mainMenu.setTextSize(30);
        mainMenu.setShadowLayer(1, 2, 2, 0xFF7B5B8A);

        name = Typeface.createFromAsset(getAssets(), "fonts/SAF.otf");

        myTruePoints.setTypeface(name);
        myFalsePoints.setTypeface(name);

        scrollContent();

        /**list = (ListView) findViewById(R.id.list);

        // Getting adapter by passing xml data ArrayList
        adapter = new MondoAdapter(this, homeTest(), awayTest(), forecastTest(), solutionTest());
        adapter.getTpName(name);
        list.setAdapter(adapter);**/

        AdView adView = (AdView)this.findViewById(R.id.adView);
        adView.loadAd(new AdRequest());
    }

    private void getInfos() {
        Intent i = getIntent();

        home_info = i.getStringArrayExtra("home_end");
        away_info = i.getStringArrayExtra("away_end");
        forecast_info = i.getStringArrayExtra("forecast");
        solution_info = i.getBooleanArrayExtra("solution");
    }

    private void initLayouts() {
        achievement = (RelativeLayout) findViewById(R.id.achievement);
        achievement_none = (RelativeLayout) findViewById(R.id.achievement_none);

        my_true = (TextView) findViewById(R.id.my_true);
        my_false = (TextView) findViewById(R.id.my_false);

        if (points(solution_info) > 10) {
            achievement.setVisibility(View.VISIBLE);
            achievement_none.setVisibility(View.INVISIBLE);
        } else {
            achievement.setVisibility(View.INVISIBLE);
            achievement_none.setVisibility(View.VISIBLE);
        }

        my_true.setText(String.valueOf(points(solution_info)));
        my_false.setText(String.valueOf(19 - points(solution_info)));
    }

    private int points(boolean[] solution) {
        int count = 0;

        for (int i = 0; i<solution.length; i++) {
            if (solution[i] == true) count++;
        }

        return count;
    }

    private String[] homeTest() {
        return new String[]{"ALG", "ANG", "ARG", "AUS", "AUT", "BEL", "BOL", "BRA", "BUL", "CAN",
                "CHI", "CHN", "CIV", "CMR", "COD", "COL", "CRC", "CRO", "CUB",};
    }

    private String[] awayTest() {
        return new String[]{"DEN", "ECU", "EGY", "ENG", "ESP", "FRA", "GDR", "GER", "GHA", "GRE",
                "HAI", "HON", "HUN", "IDN", "IRN", "IRL", "IRQ", "ISR", "ITA"};
    }

    private String[] forecastTest() {
        return new String[]{"1", "X", "2", "1", "X", "2", "1", "X", "2", "1", "X", "2",
                "1", "X", "2", "1", "X", "2", "1"};
    }

    private boolean[] solutionTest() {
        boolean[] mySolution;
        mySolution = new boolean[19];

        for (int i = 0; i < 19; i++) {
            mySolution[i] = i % 2 == 0;
        }

        return mySolution;
    }

    private int[] kits() {
        return new int[] {
                R.drawable.algeria_kit, R.drawable.angola_kit, R.drawable.argentina_kit, R.drawable.australia_kit,
                R.drawable.austria_kit, R.drawable.belgium_kit, R.drawable.bolivia_kit, R.drawable.brazil_kit,
                R.drawable.bulgaria_kit, R.drawable.cameroon_kit, R.drawable.canada_kit,
                R.drawable.chile_kit, R.drawable.china_kit, R.drawable.colombia_kit, R.drawable.congo_kit,
                R.drawable.costa_rica_kit, R.drawable.croatia_kit, R.drawable.cuba_kit, R.drawable.czech_republic_kit,
                R.drawable.czechoslovakia_kit, R.drawable.denmark_kit, R.drawable.east_germany_kit, R.drawable.ecuador_kit,
                R.drawable.egypt_kit, R.drawable.el_salvador_kit, R.drawable.england_kit, R.drawable.france_kit,
                R.drawable.germany_kit, R.drawable.ghana_kit, R.drawable.greece_kit, R.drawable.haiti_kit,
                R.drawable.honduras_kit, R.drawable.hungary_kit, R.drawable.indonesia_kit, R.drawable.iran_kit,
                R.drawable.iraq_kit, R.drawable.ireland_kit, R.drawable.israel_kit, R.drawable.italy_kit,
                R.drawable.ivory_coast_kit, R.drawable.jamaica_kit, R.drawable.japan_kit, R.drawable.kuwait_kit,
                R.drawable.mexico_kit, R.drawable.morocco_kit, R.drawable.netherlands_kit, R.drawable.new_zealand_kit,
                R.drawable.nigeria_kit, R.drawable.north_korea_kit, R.drawable.northern_ireland_kit, R.drawable.norway_kit,
                R.drawable.paraguay_kit, R.drawable.peru_kit, R.drawable.poland_kit, R.drawable.portugal_kit,
                R.drawable.romania_kit, R.drawable.russia_kit, R.drawable.saudi_arabia_kit, R.drawable.scotland_kit,
                R.drawable.senegal_kit, R.drawable.serbia_and_montenegro_kit, R.drawable.serbia_kit, R.drawable.slovakia_kit,
                R.drawable.slovenia_kit, R.drawable.south_africa_kit, R.drawable.south_korea_kit, R.drawable.spain_kit,
                R.drawable.sweden_kit, R.drawable.switzerland_kit, R.drawable.togo_kit, R.drawable.trinidad_and_tobago_kit,
                R.drawable.tunisia_kit, R.drawable.turkey_kit, R.drawable.uae_kit, R.drawable.ukraine_kit,
                R.drawable.uruguay_kit, R.drawable.usa_kit, R.drawable.wales_kit, R.drawable.yugoslavia_kit
        };
    }



    private View getView(int position) {
        View vi;
            vi = inflater.inflate(R.layout.item_row, null);

        TextView home = (TextView)vi.findViewById(R.id.home_team); // title
        TextView away = (TextView)vi.findViewById(R.id.away_team); // artist name
        TextView mForecast = (TextView)vi.findViewById(R.id.forecast); // duration
        ImageView mSolutios =(ImageView)vi.findViewById(R.id.solution); // thumb image

        Country mHome = new Country(home_info[position]);
        Country mAway = new Country(away_info[position]);

        home.setTypeface(name);
        away.setTypeface(name);
        mForecast.setTypeface(name);

        home.setTextColor(mHome.getTextColor());
        away.setTextColor(mAway.getTextColor());

        home.setShadowLayer(1, -2, 2, Color.DKGRAY);
        away.setShadowLayer(1, 2, 2, Color.DKGRAY);

        mForecast.setShadowLayer(1, 1, 1, Color.DKGRAY);

        // Setting all values in listview
        home.setText(mHome.getName());
        away.setText(mAway.getName());
        mForecast.setText(forecast_info[position]);

        boolean[] solutionTest4e = solution_info;

        if (solutionTest4e[position]) {
            mSolutios.setImageResource(R.drawable.tick);
        } else {
            mSolutios.setImageResource(R.drawable.tock);
        }

        vi.setId(position+1);

        return vi;
    }

    private void scrollContent() {
        RelativeLayout scroll_content = (RelativeLayout) findViewById(R.id.scroll_content);

        for (int i = 0; i < home_info.length; i++) {
            RelativeLayout.LayoutParams params =
                    new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            if (i != 0) {
                params.addRule(RelativeLayout.BELOW, i);
                scroll_content.addView(getView(i), i, params);
            } else {
                scroll_content.addView(getView(i), i);
            }

        }
    }

    protected void setAchievement() {
        ImageView kit = (ImageView) findViewById(R.id.shirt);
        TextView nation = (TextView) findViewById(R.id.national);
        TextView tshirt = (TextView) findViewById(R.id.tshirt);

        Typeface tpAchievement = Typeface.createFromAsset(getAssets(), "fonts/DroidSans-Bold.ttf");

        nation.setTypeface(tpAchievement);
        tshirt.setTypeface(tpAchievement);

        nation.setShadowLayer(1, 2, 2, Color.BLACK);
        tshirt.setShadowLayer(1, 2, 2, Color.BLACK);

        int randomInt = randomGenerator.nextInt(79);

        Achievement achiev = new Achievement(randomInt);

        kit.setImageResource(achiev.getImage());
        nation.setText(achiev.getName());
    }
}
