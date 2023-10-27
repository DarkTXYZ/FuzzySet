package com.ci.FuzzySet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MusicGenreController {

    List<String> tempoRule;
    List<String> keyRule;
    List<String> musicGenreClass;

    private static final List<String> ROCK_KEY = Arrays.asList("E_FFlat", "A", "D");
    private static final List<String> ROCK_TEMPO = List.of("V");

    private static final List<String> JAZZ_KEY = Arrays.asList("ASharp_BFlat", "DSharp_EFlat", "ESharp_F","GSharp_AFlat","CSharp_DFlat");
    private static final List<String> JAZZ_TEMPO = List.of("AM");

    private static final List<String> POPS_KEY = Arrays.asList("BSharp_C", "G");
    private static final List<String> POPS_TEMPO = List.of("M");

    private static final List<String> COUNTRY_KEY = Arrays.asList("BSharp_C", "E_FFlat", "A", "D");
    private static final List<String> COUNTRY_TEMPO = List.of("MM");
    public MusicGenreController() {
        this.tempoRule = new ArrayList<>();
        this.keyRule = new ArrayList<>();
        this.musicGenreClass = new ArrayList<>();

        addRules(ROCK_TEMPO,ROCK_KEY,"rock");
        addRules(JAZZ_TEMPO,JAZZ_KEY,"jazz");
        addRules(POPS_TEMPO,POPS_KEY,"pops");
        addRules(COUNTRY_TEMPO,COUNTRY_KEY,"country");
    }

    public void addRules(List<String> tempo, List<String> key, String musicGenre) {
        for (String t : tempo) {
            for (String k : key) {
                tempoRule.add(t);
                keyRule.add(k);
                musicGenreClass.add(musicGenre);
            }
        }
    }

    public String predict(double tempo, double frequency) {
        double rock = 0.0;
        double jazz = 0.0;
        double pops = 0.0;
        double country = 0.0;

        for (int i = 0; i < tempoRule.size(); ++i) {
            double tm = TempoMembership.calculate(tempoRule.get(i), tempo);
            double km = KeyMembership.calculate(keyRule.get(i), frequency);

            double alphaCut = Math.min(tm,km);

            switch (musicGenreClass.get(i)) {
                case "rock":
                    rock = Math.max(rock, alphaCut);
                case "jazz":
                    jazz = Math.max(jazz, alphaCut);
                case "pops":
                    pops = Math.max(pops, alphaCut);
                case "country":
                    country = Math.max(country, alphaCut);
            }
        }

        double maxValue = Math.max(rock, Math.max(jazz, Math.max(pops, country)));
        if (maxValue == rock)
            return "This song is rock song";
        else if (maxValue == jazz)
            return "This song is jazz song";
        else if (maxValue == pops)
            return "This song is pops song";
        return "This song is country song";
    }
}
