package com.mlesikov.coder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mihail Lesikov.
 */
public class HuffmanDecoder {
    private Map<String, Character> characterMap = new HashMap<String, Character>();

    public static HuffmanDecoder build(Map<Character, String> codesMap) {
        HuffmanDecoder decoder = new HuffmanDecoder();
        for (Character character : codesMap.keySet()) {
            decoder.characterMap.put(codesMap.get(character), character);
        }
        return decoder;
    }

    public String decode(String codedText) {
        String decodedText = "";
        String buffer = "";

        for (int i = 0; i < codedText.length(); i++) {
            // add char to buffer
            buffer = buffer + codedText.charAt(i);// se vzimat posledovatelno btovete na kodiranoto soop6tenie i se pribavjaat v buffera

            // ako imame bukva s takav kod
            if (characterMap.containsKey(buffer)) {
                decodedText = decodedText + characterMap.get(buffer);
                buffer = "";
            }
        }

        return decodedText;
    }

}
