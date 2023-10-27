package com.ci.FuzzySet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {



    public static void main(String[] args) throws Exception {
        MusicGenreController controller = new MusicGenreController();

        System.out.println(controller.predict(161, 280));
        System.out.println(controller.predict(120, 350));
        System.out.println(controller.predict(80, 293.66));

    }
}
