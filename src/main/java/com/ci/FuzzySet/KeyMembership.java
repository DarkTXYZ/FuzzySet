package com.ci.FuzzySet;

public class KeyMembership {

    static double OFFSET = 100;

    public static double calculate(String input, double frequency) {
        return switch (input) {
            case "E_FFlat" -> E_FFlat(frequency);
            case "A" -> A(frequency);
            case "D" -> D(frequency);
            case "ASharp_BFlat" -> ASharp_BFlat(frequency);
            case "DSharp_EFlat" -> DSharp_EFlat(frequency);
            case "ESharp_F" -> ESharp_F(frequency);
            case "GSharp_AFlat" -> GSharp_AFlat(frequency);
            case "CSharp_DFlat" -> CSharp_DFlat(frequency);
            case "BSharp_C" -> BSharp_C(frequency);
            case "G" -> G(frequency);
            default -> 0.0;
        };
    }

    private static double gaussian(double x, double a) {
        return Math.exp(-1.0 * Math.pow(x - a, 2) / OFFSET);
    }

    public static double E_FFlat(double frequency) {
        return gaussian(frequency, 329.63);
    }

    public static double A(double frequency) {
        return gaussian(frequency, 440.00);
    }

    public static double D(double frequency) {
        return gaussian(frequency, 293.66);
    }

    public static double ASharp_BFlat(double frequency) {
        return gaussian(frequency, 466.16);
    }

    public static double DSharp_EFlat(double frequency) {
        return gaussian(frequency, 311.13);
    }

    public static double ESharp_F(double frequency) {
        return gaussian(frequency, 349.23);
    }

    public static double GSharp_AFlat(double frequency) {
        return gaussian(frequency, 415.30);
    }

    public static double CSharp_DFlat(double frequency) {
        return gaussian(frequency, 277.18);
    }

    public static double BSharp_C(double frequency) {
        return gaussian(frequency, 261.63);
    }

    public static double G(double frequency) {
        return gaussian(frequency, 392.00);
    }

}
