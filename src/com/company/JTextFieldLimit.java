package com.company;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class JTextFieldLimit extends PlainDocument {
    private int limit;

    public JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;

        if (getLength() + str.length() <= limit) { // Проверяем, не превышает ли кол-во символов ограничение
            try {
                Integer.parseInt(str); // Пытаемся преобразовать введенную строку в число
                super.insertString(offset, str, attr); // Если строка является числом и количество символов не превышено - вставляем в поле
            } catch (NumberFormatException ex) {
                // Если строка не является числом, ничего не делаем
            }
        }
    }
}