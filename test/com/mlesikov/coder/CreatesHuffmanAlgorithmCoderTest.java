package com.mlesikov.coder;

import com.mlesikov.coder.huffman.HuffmanTree;
import com.mlesikov.textanalyzing.AnalyzesTextCharsFrequency;
import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Mihail Lesikov.
 */
public class CreatesHuffmanAlgorithmCoderTest {
    private CreatesHuffmanAlgorithmCoder createsHuffmanCoder = new CreatesHuffmanAlgorithmCoder(new MockAnalyzesTextCharsFrequency(), new HuffmanTree());
    private String text = "aaabbc";

    @Test
    public void testName() throws Exception {
        text = "abracadabra";     //ABRACADABRA

        HuffmanCoder huffmanCoder = createsHuffmanCoder.create(text);

        Map<Character, String> codesMap = huffmanCoder.getCodesMap();
        assertEquals("0", codesMap.get('a'));
        assertEquals("10", codesMap.get('b'));
        assertEquals("1100", codesMap.get('c'));
        assertEquals("1101", codesMap.get('d'));
        assertEquals("111", codesMap.get('r'));
    }

    private class MockAnalyzesTextCharsFrequency extends AnalyzesTextCharsFrequency {
    }
}
