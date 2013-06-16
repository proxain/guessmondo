package com.guess.mondo;

import android.os.Parcel;
import android.os.Parcelable;

public class Country implements Parcelable {
    protected int flag, color;
    protected String country_name;

    public Country(String name) {
        String[] key3country = {
                "ALG", "ANG", "ARG", "AUS", "AUT", "BEL", "BOL", "BRA", "BUL", "CAN",
                "CHI", "CHN", "CIV", "CMR", "COD", "COL", "CRC", "CRO", "CUB", "CZE",
                "DEN", "ECU", "EGY", "ENG", "ESP", "FRA", "GDR", "GER", "GHA", "GRE",
                "HAI", "HON", "HUN", "IDN", "IRN", "IRL", "IRQ", "ISR", "ITA", "JAM",
                "JPN", "KOR", "KSA", "KUW", "MAR", "MEX", "NED", "NGA", "NIR", "NOR",
                "NZL", "PAR", "PER", "POL", "POR", "PRK", "ROM", "RSA", "RUS", "SCO",
                "SEN", "SRB", "SLV", "SRM", "SUI", "SVK", "SVN", "SWE", "TCH", "TOG",
                "TRI", "TUN", "TUR", "UAE", "UKR", "URU", "USA", "WAL", "YUG"
        };
        for (int i = 0; i < key3country.length; i++) {
            if (name.equals(key3country[i])) {
                country_name = key3country[i];
                int[] flags = {
                        R.drawable.alg_flag, R.drawable.ang_flag, R.drawable.arg_flag, R.drawable.aus_flag, R.drawable.aut_flag,
                        R.drawable.bel_flag, R.drawable.bol_flag, R.drawable.bra_flag, R.drawable.bul_flag, R.drawable.can_flag,
                        R.drawable.chi_flag, R.drawable.chn_flag, R.drawable.civ_flag, R.drawable.cmr_flag, R.drawable.cod_flag,
                        R.drawable.col_flag, R.drawable.crc_flag, R.drawable.cro_flag, R.drawable.cub_flag, R.drawable.tch_flag,
                        R.drawable.den_flag, R.drawable.ecu_flag, R.drawable.egy_flag, R.drawable.eng_flag, R.drawable.esp_flag,
                        R.drawable.fra_flag, R.drawable.gdr_flag, R.drawable.ger_flag, R.drawable.gha_flag, R.drawable.gre_flag,
                        R.drawable.hai_flag, R.drawable.hon_flag, R.drawable.hun_flag, R.drawable.idn_flag, R.drawable.ira_flag,
                        R.drawable.irl_flag, R.drawable.irq_flag, R.drawable.isr_flag, R.drawable.ita_flag, R.drawable.jam_flag,
                        R.drawable.jpn_flag, R.drawable.kor_flag, R.drawable.ksa_flag, R.drawable.kuw_flag, R.drawable.mar_flag,
                        R.drawable.mex_flag, R.drawable.ned_flag, R.drawable.nga_flag, R.drawable.nir_flag, R.drawable.nor_flag,
                        R.drawable.nzl_flag, R.drawable.par_flag, R.drawable.per_flag, R.drawable.pol_flag, R.drawable.por_flag,
                        R.drawable.prk_flag, R.drawable.rom_flag, R.drawable.rsa_flag, R.drawable.rus_flag, R.drawable.sco_flag,
                        R.drawable.sen_flag, R.drawable.ser_flag, R.drawable.slv_flag, R.drawable.srb_flag, R.drawable.sui_flag,
                        R.drawable.svk_flag, R.drawable.svn_flag, R.drawable.swe_flag, R.drawable.tch_flag, R.drawable.tog_flag,
                        R.drawable.tri_flag, R.drawable.tun_flag, R.drawable.tur_flag, R.drawable.uae_flag, R.drawable.ukr_flag,
                        R.drawable.uru_flag, R.drawable.usa_flag, R.drawable.wal_flag, R.drawable.yug_flag
                };
                flag = flags[i];
                int[] teamColor = {
                        0xFFF9F9F9, 0xFFFF0000, 0xFF6AB5FF, 0xFFFFBF00, 0xFFFF0000, 0xFFFF0000, 0xFF008000, 0xFFFFDF00,
                        0xFFFFFFFF, 0xFFFF0000, 0xFFFF0000, 0xFFFF0000, 0xFFFF8000, 0xFF004E2F, 0xFF007FFF, 0xFFFFFF00,
                        0xFFFF0000, 0xFFFF0000, 0xFFFF0000, 0xFFFF0000, 0xFFFF0000, 0xFFFFDD00, 0xFFDD0000, 0xFFFFFFFF,
                        0xFFFF0000, 0xFF0E428F, 0xFF0C1C8C, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFF0000DF, 0xFFFFFFFF,
                        0xFFFF0000, 0xFFCA0000, 0xFFFFFFFF, 0xFF008000, 0xFFFFFFFF, 0xFF0000FF, 0xFF0000FF, 0xFFF7EB29,
                        0xFF000040, 0xFFEE1111, 0xFFFFFFFF, 0xFF0000FF, 0xFFFF0000, 0xFF008032, 0xFFFF8000, 0xFF008000,
                        0xFF32AD42, 0xFFEF2B2D, 0xFFF9F9F9, 0xFFE00000, 0xFFFFFFFF, 0xFFFF0000, 0xFFFF0000, 0xFFEE1720,
                        0xFFFFE000, 0xFFFFD131, 0xFFFF0000, 0xFF000080, 0xFFE9E9E9, 0xFFDF0000, 0xFF0B0BFF, 0xFF0000FF,
                        0xFFFF0000, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFF00, 0xFFFF0000, 0xFFFFFF55, 0xFFFF0000, 0xFFFFFFFF,
                        0xFFFF0000, 0xFFFFFFFF, 0xFFFFDF00, 0xFF80BBFF, 0xFFA30036, 0xFFFF0000, 0xFF0000FD
                };
                color = teamColor[i];
            }
        }
    }

    public int getImage() {
        return flag;
    }

    public String getName() {
        return country_name;
    }

    public int getTextColor() {
        return color;
    }

    private String[] country = {
            "Algeria", "Angola", "Argentina", "Australia", "Austria",
            "Belgium", "Bolivia", "Brazil", "Bulgaria", "Canada",
            "Chile", "China PR", "Cote d'Ivoire", "Cameroon", "DR Congo",
			"Colombia", "Costa Rica", "Croatia", "Cuba", "Czech Republic",
            "Denmark", "Ecuador", "Egypt", "England", "Spain",
            "France", "East Germany", "Germany", "Ghana", "Greece",
            "Haiti", "Honduras", "Hungary", "Indonesia", "Iran",
            "Ireland", "Iraq", "Israel", "Italy", "Jamaica",
            "Japan", "South Korea", "Saudi Arabia", "Kuwait", "Morocco",
            "Mexico", "Netherlands", "Nigeria", "Northern Ireland", "Norway",
            "New Zealand", "Paraguay", "Peru", "Poland", "Portugal",
            "North Korea", "Romania", "South Africa", "Russia", "Scotland",
            "Senegal", "Serbia", "El Salvador", "Serbia and Montenegro", "Switzerland",
            "Slovakia", "Slovenia", "Sweden", "Czechoslovakia", "Togo",
            "Trinidad and Tobago", "Tunisia", "Turkey", "UAE", "Ukraine",
            "Uruguay", "USA", "Wales", "Yugoslavia"
    };

    @Override
    public int describeContents() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
