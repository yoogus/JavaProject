package com.company;

import javax.swing.*;
import javax.swing.text.*;

public class NumericText extends JTextField {

    public NumericText() {
        super();
        setColumns(10);
        setDocument(new NumericDocument());
    }

    private static class NumericDocument extends PlainDocument {
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null) {
                return;
            }
            char[] c = str.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (Character.isDigit(c[i])) {
                    super.insertString(offs, new String(new char[]{c[i]}), a);
                    offs++;
                }
            }
        }
    }
}