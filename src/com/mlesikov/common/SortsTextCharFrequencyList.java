package com.mlesikov.common;

import com.mlesikov.textanalyzing.TextCharFrequency;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Mihail Lesikov.
 */
public class SortsTextCharFrequencyList {
    /**
     * sorts the given list by the char frequencies
     *
     * @param charFrequencies
     */
    public static void sortDescending(List<TextCharFrequency> charFrequencies) {

        // izvr6va brzo sortirane na bukvite v zavisimost koq bukva se sre6ta pove4e
        Collections.sort(charFrequencies, new Comparator<TextCharFrequency>() {
            public int compare(TextCharFrequency o1, TextCharFrequency o2) {
                if (o1.getFrequencyPercent() > o2.getFrequencyPercent()) {
                    return -1;
                } else if (o1.getFrequencyPercent() < o2.getFrequencyPercent()) {
                    return 1;
                }
                return 0;
            }
        });
    }
}
