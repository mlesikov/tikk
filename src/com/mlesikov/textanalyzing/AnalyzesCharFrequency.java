package com.mlesikov.textanalyzing;

import javax.swing.event.ListSelectionEvent;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by Mihail Lesikov.
 */
public class AnalyzesCharFrequency {

    public AnalyzesCharFrequency() {
        Locale.setDefault(Locale.UK);
    }

    public List<CharFrequency> analyze(String text) {

        Map<Character, Integer> charCounterMap = generateCharFrequencyMap(text);

        List<CharFrequency> charFrequencies = calculateCharFrequencyInPercents(charCounterMap, text.length());

        sort(charFrequencies);

        return charFrequencies;
    }

    private void sort(List<CharFrequency> charFrequencies) {
        Collections.sort(charFrequencies, new Comparator<CharFrequency>() {
            public int compare(CharFrequency o1, CharFrequency o2) {
                if (o1.getFrequencyPercent() > o2.getFrequencyPercent()) {
                    return -1;
                } else if (o1.getFrequencyPercent() < o2.getFrequencyPercent()) {
                    return 1;
                }
                return 0;
            }
        });
    }

    private List<CharFrequency> calculateCharFrequencyInPercents(Map<Character, Integer> charCounterMap, int textLength) {
        List<CharFrequency> charFrequencies = new ArrayList<CharFrequency>();
        for (Character ch : charCounterMap.keySet()) {
            //gets the count of the char matches in the text
            Double charCount = Double.valueOf((charCounterMap.get(ch)));
//            calculates the total frecuency of the char in percents in the text
            double percents = calculatePercents(textLength, charCount);

            CharFrequency charFrequency = new CharFrequency(ch, percents);

            charFrequencies.add(charFrequency);
        }
        return charFrequencies;
    }

    private double calculatePercents(int textLength, Double charCount) {
        double percents = (charCount / textLength) * 100;
        percents = Double.valueOf(new DecimalFormat("##.##").format(percents));
        return percents;
    }

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


