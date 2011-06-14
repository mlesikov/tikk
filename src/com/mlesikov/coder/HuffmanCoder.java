package com.mlesikov.coder;

import java.util.Map;

/**
 * Created by Mihail Lesikov.
 */
public class HuffmanCoder {
    private String text;
    private Map<Character, String> codesMap;

    public HuffmanCoder(String text, Map<Character, String> codesMap) {
        this.text = text;
        this.codesMap = codesMap;
    }


    public String code() {
        String codedText = "";

        for (Character character : text.toCharArray()) {
            codedText = codedText + codesMap.get(character);
        }

        return codedText;
    }

    public Map<Character, String> getCodesMap() {
        return codesMap;
    }
}
