package com.mlesikov.common;

/**
 * Describes how what is the frequency of the char
 * Created by Mihail Lesikov.
 */
public class TextCharFrequency {
    private Character character;
    private Double frequencyPercent;

    public TextCharFrequency(Character character, double frequencyPercent) {

        this.character = character;
        this.frequencyPercent = frequencyPercent;
    }

    public Character getCharacter() {
        return character;
    }

    public Double getFrequencyPercent() {
        return frequencyPercent;
    }
}
