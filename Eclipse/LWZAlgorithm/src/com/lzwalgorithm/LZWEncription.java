/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lzwalgorithm;

import java.util.List;

/**
 *
 * @author nasir
 */
public class LZWEncription {

    List string;
    List code;
    String input;
    String encriptedString = "";
    String decomposedString = "";

    public LZWEncription(List s, List c) {
        string = s;
        code = c;
    }

    public String encriptedCode(String inp) {
        input = inp;
        String s, c;

        s = "" + input.toCharArray()[0];

        for (int i = 0; i < input.length(); i++) {

            if (i + 1 < input.length()) {
                c = "" + input.toCharArray()[i + 1];
            } else {
                c = "";
                encriptedString += string.indexOf(s) + 1;
                return encriptedString;
            }
            if (string.contains(s + c)) {
                s += c;
            } else {
                encriptedString += string.indexOf(s) + 1;
                string.add("" + s + c);
                s = c;
            }

        }

        return encriptedString;
    }

    public String decomposition(String inp) {
        input = inp;

        int k;
        String entry, s = null;

        for (int i = 0; i < input.length(); i++) {
            k = Integer.parseInt("" + input.toCharArray()[i]) - 1;
            entry = (String) string.get(k);
            decomposedString += entry;
            if (s != null) {
                string.add(s + entry);
            }
            s = entry;
        }

        return decomposedString;
    }

}
