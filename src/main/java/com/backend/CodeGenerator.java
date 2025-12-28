package com.backend;

import com.backend.data.enums.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeGenerator {

    public List<List<Color>> generateAllCodes() {
        List<Color> allColors = new ArrayList<>(Arrays.asList(Color.values()));
        Color[] allColorsArr = allColors.toArray(new Color[0]);

        return  generateRecursive(allColorsArr);
    }

    private static List<List<Color>> generateRecursive(Color[] colors) {

        List<List<Color>> result = new ArrayList<>();

        // loop 4 times to get length 4
        for (Color colorOne : colors) {
            for (Color colorTwo : colors) {
                for (Color colorThree : colors) {
                    for (Color colorFour : colors) {
                        result.add(java.util.List.of(colorOne, colorTwo, colorThree, colorFour));
                    }

                }

            }


        }

        return result;

    }
}

