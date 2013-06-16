package com.guess.mondo;

/**
 * Created with IntelliJ IDEA.
 * User: todot
 * Date: 2/18/13
 * Time: 12:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class Achievement {
    protected int shirt;
    protected String country_name;

    public Achievement(int number) {
        int[] kits = {
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
        shirt = kits[number];
        String[] country = {
                "Algeria", "Angola", "Argentina", "Australia", "Austria",
                "Belgium", "Bolivia", "Brazil", "Bulgaria", "Cameroon",
                "Canada", "Chile", "China PR", "Colombia", "DR Congo",
                "Costa Rica", "Croatia", "Cuba", "Czech Republic", "Czechoslovakia",
                "Denmark", "East Germany", "Ecuador", "Egypt", "El Salvador",
                "England", "France", "Germany", "Ghana", "Greece",
                "Haiti", "Honduras", "Hungary", "Indonesia", "Iran",
                "Iraq", "Ireland", "Israel", "Italy", "Cote d'Ivoire",
                "Jamaica", "Japan", "Kuwait", "Mexico", "Morocco",
                "Netherlands", "New Zealand", "Nigeria", "North Korea", "Northern Ireland",
                "Norway", "Paraguay", "Peru", "Poland", "Portugal",
                "Romania", "Russia", "Saudi Arabia", "Scotland", "Senegal",
                "Serbia and Montenegro", "Serbia", "Slovakia", "Slovenia", "South Africa",
                "South Korea", "Spain", "Sweden", "Switzerland", "Togo",
                "Trinidad and Tobago", "Tunisia", "Turkey", "UAE", "Ukraine",
                "Uruguay", "USA", "Wales", "Yugoslavia"
        };
        country_name = country[number];
    }


    public int getImage() {
        return shirt;
    }

    public String getName() {
        return country_name;
    }

}
