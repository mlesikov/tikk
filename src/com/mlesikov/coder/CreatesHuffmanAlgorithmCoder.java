package com.mlesikov.coder;

import com.mlesikov.coder.huffman.HuffmanNode;
import com.mlesikov.coder.huffman.HuffmanTree;
import com.mlesikov.textanalyzing.TextCharFrequency;
import com.mlesikov.textanalyzing.AnalyzesTextCharsFrequency;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mihail Lesikov.
 */
public class CreatesHuffmanAlgorithmCoder {
    private AnalyzesTextCharsFrequency analyzesTextCharsFrequency;
    private HuffmanTree huffmanTree;

    public CreatesHuffmanAlgorithmCoder(AnalyzesTextCharsFrequency analyzesTextCharsFrequency,
                                        HuffmanTree huffmanTree) {
        this.analyzesTextCharsFrequency = analyzesTextCharsFrequency;
        this.huffmanTree = huffmanTree;
    }


    public HuffmanCoder create(String text) {

        List<TextCharFrequency> textCharFrequencies = analyzesTextCharsFrequency.analyze(text);

        huffmanTree.buildTree(textCharFrequencies);

        return buildCoder(huffmanTree.getNodeList(), text);
    }


    private HuffmanCoder buildCoder(List<HuffmanNode> nodes, String text) {
        Map<Character, String> codesMap = new HashMap<Character, String>();

        for (HuffmanNode node : nodes) {
            codesMap.put(node.getElement(), node.getCode());
        }

        return new HuffmanCoder(text, codesMap);
    }
}
