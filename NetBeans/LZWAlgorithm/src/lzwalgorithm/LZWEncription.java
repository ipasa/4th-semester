/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzwalgorithm;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nasir
 */
public class LZWEncription {

    DisplayingInput di;
    List string;
    List code;
    String input;
    String encriptedString = "";
    String decomposedString = "";

    public LZWEncription(List s, List c, DisplayingInput d) {
        string = s;
        code = c;
        di = d;
    }

    public String encriptedCode(String inp) {
        input = inp;
        String s, c;

        DefaultTableModel dtm = (DefaultTableModel) di.encodeTable.getModel();

        for (int i = 0; i < dtm.getRowCount(); i++) {
            dtm.removeRow(i);
        }

        s = "" + input.toCharArray()[0];
        int row = 0, column = 0;

        for (int i = 0; i < input.length(); i++) {
            column = 0;

            dtm.addRow(new Object[]{""});

            dtm.setValueAt(s, row, column);
            column = 1;
            if (i + 1 < input.length()) {
                c = "" + input.toCharArray()[i + 1];
                dtm.setValueAt(c, row, column);
            } else {
                c = "";

                dtm.setValueAt("EOF", row, column);
                column = 2;
                encriptedString += string.indexOf(s) + 1;
                dtm.setValueAt(string.indexOf(s) + 1, row, column);
                return encriptedString;
            }

            if (string.contains(s + c)) {
                s += c;
            } else {
                column = 2;
                encriptedString += string.indexOf(s) + 1;
                dtm.setValueAt(string.indexOf(s) + 1, row, column);
                string.add("" + s + c);
                column = 3;
                dtm.setValueAt(string.indexOf("" + s + c) + 1, row, column);
                column = 4;
                dtm.setValueAt("" + s + c, row, column);
                s = c;
            }

            row++;

        }

        return encriptedString;
    }

    public String decomposition(String inp) {
        input = inp;

        DefaultTableModel dtm = (DefaultTableModel) di.decodeTable.getModel();

        for (int i = 0; i < dtm.getRowCount(); i++) {
            dtm.removeRow(i);
        }

        int row = 0, column = 0;

        int k;
        String entry, s = null;

        for (int i = 0; i < input.length(); i++) {
            column = 0;

            dtm.addRow(new Object[]{""});

            dtm.setValueAt(s == null ? "NIL" : s, row, column);

            k = Integer.parseInt("" + input.toCharArray()[i]) - 1;
            column = 1;
            dtm.setValueAt(k + 1, row, column);

            entry = (String) string.get(k);
            column = 2;

            dtm.setValueAt(entry, row, column);

            decomposedString += entry;
            if (s != null) {
                string.add(s + entry);

                column = 3;

                dtm.setValueAt(string.indexOf(s + entry) + 1, row, column);

                column = 4;

                dtm.setValueAt(s + entry.toCharArray()[0], row, column);
            }
            s = entry;
            row++;
            if (i == inp.length() - 1) {
                dtm.addRow(new Object[]{""});
                column = 0;
                dtm.setValueAt(s, row, column);
                column = 1;
                dtm.setValueAt("EOF", row, column);
            }
        }

        return decomposedString;
    }

}
