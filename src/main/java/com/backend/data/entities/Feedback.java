package com.backend.data.entities;

public class Feedback {
    private final int correctPosition; // exact matches
    private final int correctColor;    // correct color, wrong position

    public Feedback(int correctPosition, int correctColor) {
        this.correctPosition = correctPosition;
        this.correctColor = correctColor;
    }

    public int getCorrectPosition() {
        return correctPosition;
    }

    public int getCorrectColor() {
        return correctColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feedback)) return false;
        Feedback other = (Feedback) o;
        return correctPosition == other.correctPosition && correctColor == other.correctColor;
    }

}

