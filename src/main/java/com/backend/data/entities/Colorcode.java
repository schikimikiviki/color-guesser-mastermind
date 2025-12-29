package com.backend.data.entities;

import com.backend.data.enums.Color;

import java.util.Arrays;
import java.util.List;

public class Colorcode {
    List<Color> colorList;

    public Colorcode(List<Color> colorList){
        this.colorList = colorList;
    }

    public List<Color> getColorList() {
        return colorList;
    }

    public void setColorList(List<Color> colorList) {
        this.colorList = colorList;
    }

    @Override
    public String toString() {
        return (Arrays.toString(colorList.toArray()));

    }




}
