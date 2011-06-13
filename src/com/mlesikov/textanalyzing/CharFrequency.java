package com.mlesikov.textanalyzing;

/**
 * Describes how what is the frequency of the char
 * Created by Mihail Lesikov.
 */
public class CharFrequency {
    private Character character;
    private Double frequencyPercent;

    public CharFrequency(Character character, double frequencyPercent) {

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
