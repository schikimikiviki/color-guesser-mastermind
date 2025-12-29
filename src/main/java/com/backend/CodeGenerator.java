package com.backend;

import com.backend.data.entities.Colorcode;
import com.backend.data.enums.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeGenerator {

    public List<Colorcode> generateAllCodes() {
        List<Color> allColors = new ArrayList<>(Arrays.asList(Color.values()));
        Color[] allColorsArr = allColors.toArray(new Color[0]);

        return  generateRecursive(allColorsArr);
    }

    private static List<Colorcode> generateRecursive(Color[] colors) {

        List<Colorcode> result = new ArrayList<>();

        // loop 4 times to get length 4
        for (Color colorOne : colors) {
            for (Color colorTwo : colors) {
                for (Color colorThree : colors) {
                    for (Color colorFour : colors) {
                        Colorcode colorCode = new Colorcode(List.of(colorOne, colorTwo, colorThree, colorFour));
                        result.add(colorCode);
                    }

                }

            }


        }

        return result;

    }
}

