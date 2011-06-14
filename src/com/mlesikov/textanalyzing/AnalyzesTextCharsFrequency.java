package com.mlesikov.textanalyzing;

import com.mlesikov.common.TextCharFrequency;
import com.mlesikov.common.SortsTextCharFrequencyList;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Mihail Lesikov.
 */
public class AnalyzesTextCharsFrequency {

    public AnalyzesTextCharsFrequency() {
        Locale.setDefault(Locale.UK);
    }

    public List<TextCharFrequency> analyze(String text) {

        Map<Character, Integer> charCounterMap = generateCharFrequencyMap(text);

        List<TextCharFrequency> charFrequencies = calculateCharFrequencyInPercents(charCounterMap, text.length());

        SortsTextCharFrequencyList.sortDescending(charFrequencies);

        return charFrequencies;
    }



    /**
     * calculate char frequencies in the text as a percents
     *
     * @param charCounterMap
     * @param textLength
     * @return
     */
    private List<TextCharFrequency> calculateCharFrequencyInPercents(Map<Character, Integer> charCounterMap, int textLength) {
        List<TextCharFrequency> charFrequencies = new ArrayList<TextCharFrequency>();
        for (Character ch : charCounterMap.keySet()) {
            //gets the count of the char matches in the text
            Double charCount = Double.valueOf((charCounterMap.get(ch)));
//            calculates the total frecuency of the char in percents in the text
            double percents = calculatePercents(textLength, charCount);

            TextCharFrequency charFrequency = new TextCharFrequency(ch, percents);

            charFrequencies.add(charFrequency);
        }
        return charFrequencies;
    }

    /**
     * calculates the percents of matching chars in the text
     *
     * @param textLength
     * @param charCount
     * @return
     */
    private double calculatePercents(int textLength, Double charCount) {
        double percents = (charCount / textLength) * 100;
        percents = Double.valueOf(new DecimalFormat("##.##").format(percents));
        return percents;
    }

    /**
     * generates the map of all chars in the given text and their counts in the text
     *
     * @param text
     * @return
     */
    private Map<Character, Integer> generateCharFrequencyMap(String text) {
        Map<Character, Integer> charCounterMap = new HashMap<Character, Integer>();

        for (Character ch : text.toCharArray()) {
            if (charCounterMap.containsKey(ch)) {
                Integer count = charCounterMap.get(ch);
                charCounterMap.put(ch, count + 1);
            } else {
                charCounterMap.put(ch, 1);
            }
        }
        return charCounterMap;
    }
}


