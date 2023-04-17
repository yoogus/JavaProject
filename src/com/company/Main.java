package com.company;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class Main extends JFrame {
    boolean isRussina = true;

    public Main() {

        setTitle("Расчет бюджета");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 450, 700);
        getContentPane().setBackground(Color.DARK_GRAY);
        setLayout(null);

        NumericText numericField = new NumericText();
        numericField.setBounds(150, 220, 160, 32);
        numericField.setDocument(new JTextFieldLimit(8));
        add(numericField);

        NumericText numericField2 = new NumericText();
        numericField2.setBounds(150, 300, 160, 32);
        numericField2.setDocument(new JTextFieldLimit(8));
        add(numericField2);

        NumericText numericField3 = new NumericText();
        numericField3.setBounds(150, 260, 160, 32);
        numericField3.setDocument(new JTextFieldLimit(8));
        add(numericField3);

        JTextField field3 = new JTextField();
        field3.setBounds(150, 260, 160, 32);
        add(field3);

        JLabel label3 = new JLabel();
        label3.setBounds(10, 260, 150, 32);
        label3.setText("Введите кол-во товара");
        label3.setForeground(Color.WHITE);
        add(label3);

        JTextField field2 = new JTextField();
        field2.setBounds(150, 300, 160, 32);
        add(field2);

        JLabel label2 = new JLabel();
        label2.setBounds(10, 300, 150, 32);
        label2.setText("Введите цену товара");
        label2.setForeground(Color.WHITE);
        add(label2);

        JTextField field1 = new JTextField();
        field1.setBounds(150, 220, 160, 32);
        add(field1);

        JLabel label = new JLabel();
        label.setBounds(10, 220, 130, 32);
        label.setText("Введите ваш бюджет");
        label.setForeground(Color.white);
        add(label);

        JButton button1 = new JButton("Применить");
        button1.setBounds(165, 340, 130, 32);
        add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (isRussina) {
                    button1.setText("Успешно!");
                } else {
                    button1.setText("Successfully!");
                }

                if (numericField.getText().isEmpty() || numericField2.getText().isEmpty() || numericField3.getText().isEmpty()) {
                    if (isRussina) {
                        JOptionPane.showMessageDialog(Main.this, "Вы не заполнили поля");
                    } else {
                        JOptionPane.showMessageDialog(Main.this, "You haven't filled in the fields");
                    }
                } else {
                    int a = Integer.parseInt(numericField.getText());
                    int b = Integer.parseInt(numericField2.getText());
                    int c = Integer.parseInt(numericField3.getText());

                    int sum = a - (b * c);
                    int zatr = b * c;

                    if (a >= zatr) {
                        if (isRussina)
                            JOptionPane.showMessageDialog(Main.this, "После покупки у вас останется: " + sum + "\nОбщая сумма покупки: " + zatr);
                        else
                            JOptionPane.showMessageDialog(Main.this, "After the purchase, you will have: " + sum + "\nTotal purchase amount: " + zatr);
                    } else {
                        if (isRussina)
                            JOptionPane.showMessageDialog(Main.this, "У вас нехватает денег!" + "\nДля покупки нужно: " + zatr);
                         else
                            JOptionPane.showMessageDialog(Main.this, "You don't have enough money!" + "\nTo buy you need: " + zatr);
                    }
                }
            }
        });

        JButton button2 = new JButton("ENG");
        button2.setBounds(10, 20, 70, 32);
        add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isRussina = false;
                label.setText("Enter your budget");
                label2.setText("Enter quantity");
                label3.setText("Enter the price of the item");
                button1.setText("Enter");
                numericField2.setBounds(170, 300, 160, 32);
                field2.setBounds(170, 300, 160, 32);
                numericField3.setBounds(170, 260, 160, 32);
                field3.setBounds(170, 260, 160, 32);
                numericField.setBounds(170, 220, 160, 32);
                field1.setBounds(170, 220, 160, 32);
                button1.setBounds(185, 340, 130, 32);
            }
        });

        JButton buttonRus = new JButton("RUS");
        buttonRus.setBounds(90, 20, 70, 32);
        add(buttonRus);
        buttonRus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isRussina = true;
                label.setText("Введите ваш бюджет");
                label2.setText("Введите цену товара");
                label3.setText("Введите кол-во товара");
                button1.setText("Применить");
                numericField2.setBounds(150, 300, 160, 32);
                field2.setBounds(150, 300, 160, 32);
                numericField3.setBounds(150, 260, 160, 32);
                field3.setBounds(150, 260, 160, 32);
                numericField.setBounds(150, 220, 160, 32);
                field1.setBounds(150, 220, 160, 32);
                button1.setBounds(165, 340, 130, 32);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

}
