package com.backend.data.entities;

import com.backend.data.enums.Color;

import java.util.List;

public class User {

    private List<Color> chosenColorList;

    public User (List<Color> colorList) {
        this.chosenColorList = colorList;
    }

}
