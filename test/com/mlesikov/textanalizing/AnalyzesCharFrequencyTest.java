package com.mlesikov.textanalizing;

import com.mlesikov.textanalyzing.AnalyzesCharFrequency;
import com.mlesikov.textanalyzing.CharFrequency;
import org.junit.Test;

import java.util.List;
import java.util.SortedSet;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mihail Lesikov.
 */
public class AnalyzesCharFrequencyTest {
    private AnalyzesCharFrequency analyzesCharFrequency = new AnalyzesCharFrequency();

    private String text = "";

    @Test
    public void shouldAnalyzeCharFrequencyWhenGivenSimpleText() throws Exception {
        text = "a";

        List<CharFrequency> charFrequencies = analyzesCharFrequency.analyze(text);

        assertCharFrequency(charFrequencies.iterator().next(), "a", 100d);
    }

    @Test
    public void shouldAnalyzeCharFrequencyWhenGivenText() throws Exception {
        text = "aba";

        List<CharFrequency> charFrequencies = analyzesCharFrequency.analyze(text);

        assertCharFrequency(charFrequencies.get(0), "a", 66.67d);
        assertCharFrequency(charFrequencies.get(1), "b", 33.33d);
    }

    private void assertCharFrequency(CharFrequency charFrequency, String expectedCharacter, Double expectedFrequencyPercent) {
        assertEquals("hm, wrong character", (Character)expectedCharacter.toCharArray()[0], charFrequency.getCharacter());
        assertEquals("hm, wrong frequency percents", expectedFrequencyPercent, charFrequency.getFrequencyPercent());
    }
}
