/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lzwalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nasir
 */
public class LZWAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        List string = new ArrayList();
        List code = new ArrayList();
        string.add("A");
        string.add("B");
        string.add("C");
        code.add("1");
        code.add("2");
        code.add("3");
        String input = "ABABBABCABABBA";
        LZWEncription lz=new LZWEncription(string, code);
        String encrypted=lz.encriptedCode(input);
        System.out.println("E: "+encrypted);
        lz=new LZWEncription(string, code);
        String decomposed=lz.decomposition(encrypted);
        System.out.println("D: "+decomposed);
    }

}
