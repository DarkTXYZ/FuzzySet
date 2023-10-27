package com.ci.FuzzySet;

public class TempoMembership {

    static double OFFSET = 50;

    public static double calculate(String input, double bpm) {
        return switch (input) {
            case "MM" -> MarciaModerato(bpm);
            case "AM" -> AndanteModerato(bpm);
            case "M" -> Moderato(bpm);
            case "A" -> Allegro(bpm);
            case "V" -> Vivace(bpm);
            default -> 0.0;
        };
    }

    private static double gaussian(double x, double b, double c) {
        if (b <= x && x <= c)
            return 1.0;
        else if (x < b) {
            return Math.exp(-1.0 * Math.pow(x - b, 2) / OFFSET);
        } else {
            return Math.exp(-1.0 * Math.pow(x - c, 2) / OFFSET);
        }
    }

    public static double MarciaModerato(double bpm) {
        return gaussian(bpm, 66, 80);
    }

    public static double AndanteModerato(double bpm) {
        return gaussian(bpm, 80, 108);
    }

    public static double Moderato(double bpm) {
        return gaussian(bpm, 108, 120);
    }

    public static double Allegro(double bpm) {
        return gaussian(bpm, 120, 156);
    }

    public static double Vivace(double bpm) {
        return gaussian(bpm, 156, 176);
    }

}
