package com.mlesikov.coder;

import com.mlesikov.textanalyzing.AnalyzesTextCharsFrequency;
import org.junit.Test;
import sun.plugin.dom.core.Text;

import java.util.Map;

/**
 * Created by Mihail Lesikov.
 */
public class GeneratesHuffmanAlgorithmCodesTest {
    private GeneratesHuffmanAlgorithmCodes generatesHuffmanCodes = new GeneratesHuffmanAlgorithmCodes(new MockAnalyzesTextCharsFrequency());
    private String  text="";

    @Test
    public void shouldGenerateCodesUsingHuffmanAlgorithm() throws Exception {


        Map<Character, String> codesMap = generatesHuffmanCodes.generate(text);

    }

    private class MockAnalyzesTextCharsFrequency extends AnalyzesTextCharsFrequency {
    }
}
