package com.backend.data.entities;

import com.backend.data.enums.Color;

import java.util.List;

public class User {

    private List<Color> chosenColorList;

    public User (List<Color> colorList) {
        this.chosenColorList = colorList;
    }

    public Colorcode getChosenColorList() {
        return new Colorcode(chosenColorList); // cast into Colorcode type
    }

    public void setChosenColorList(List<Color> chosenColorList) {
        this.chosenColorList = chosenColorList;
    }





}
