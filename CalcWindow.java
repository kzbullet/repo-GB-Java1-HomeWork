package ru.geekbrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcWindow extends JFrame {

    JPanel buttonPanel = new JPanel();
    JTextField fieldScreen = new JTextField();
    int operator;
    double num1;
    double num2;

    JButton resetButton = new JButton("Reset");

    public CalcWindow() {
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200,200,300,300);
        setResizable(false);

        fieldScreen.setHorizontalAlignment(SwingConstants.RIGHT);
        fieldScreen.setFont(new Font("Arial", Font.PLAIN, 20));
        fieldScreen.setEnabled(false);
        fieldScreen.setDisabledTextColor(Color.black);
        add(fieldScreen, BorderLayout.NORTH);

        addButtonsToPanel();
        add(buttonPanel, BorderLayout.CENTER);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = 0;
                num1 = 0;
                num2 = 0;
                fieldScreen.setText("");
            }
        });
        add(resetButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addButtonsToPanel () {
        buttonPanel.setLayout(new GridLayout(4, 4));
        JButton[] buttons = new JButton[16];
        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
        }
        buttons[0].setText("7");
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addText = fieldScreen.getText() + "7";
                fieldScreen.setText(addText);
            }
        });
        buttons[1].setText("8");
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addText = fieldScreen.getText() + "8";
                fieldScreen.setText(addText);
            }
        });
        buttons[2].setText("9");
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addText = fieldScreen.getText() + "9";
                fieldScreen.setText(addText);
            }
        });
        buttons[3].setText("%");
        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = 1;
                num1 = getNumber();
                fieldScreen.setText("");
            }
        });
        buttons[4].setText("4");
        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addText = fieldScreen.getText() + "4";
                fieldScreen.setText(addText);
            }
        });
        buttons[5].setText("5");
        buttons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addText = fieldScreen.getText() + "5";
                fieldScreen.setText(addText);
            }
        });
        buttons[6].setText("6");
        buttons[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addText = fieldScreen.getText() + "6";
                fieldScreen.setText(addText);
            }
        });
        buttons[7].setText("x");
        buttons[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = 2;
                num1 = getNumber();
                fieldScreen.setText("");
            }
        });
        buttons[8].setText("1");
        buttons[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addText = fieldScreen.getText() + "1";
                fieldScreen.setText(addText);
            }
        });
        buttons[9].setText("2");
        buttons[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addText = fieldScreen.getText() + "2";
                fieldScreen.setText(addText);
            }
        });
        buttons[10].setText("3");
        buttons[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addText = fieldScreen.getText() + "3";
                fieldScreen.setText(addText);
            }
        });
        buttons[11].setText("-");
        buttons[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = 3;
                num1 = getNumber();
                fieldScreen.setText("");
            }
        });
        buttons[12].setText("0");
        buttons[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addText = fieldScreen.getText() + "0";
                fieldScreen.setText(addText);
            }
        });
        buttons[13].setText(".");
        buttons[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addText = fieldScreen.getText() + ".";
                fieldScreen.setText(addText);
            }
        });
        buttons[14].setText("=");
        buttons[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num2 = getNumber();
                calculate();
                fieldScreen.setText(String.valueOf(calculate()));
            }
        });
        buttons[15].setText("+");
        buttons[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = 4;
                num1 = getNumber();
                fieldScreen.setText("");
            }
        });
    }

    public double getNumber () {
        if (!fieldScreen.getText().isEmpty()) {
            return Double.parseDouble(fieldScreen.getText());
        } else {
            return 0;
        }
    }

    public double calculate() {
        double result = 0;
        switch (operator) {
            case 1:
                result = num1 / num2;
                break;
            case 2:
                result = num1 * num2;
                break;
            case 3:
                result = num1 - num2;
                break;
            case 4:
                result = num1 + num2;
                break;
            default:
                break;
        }
        return result;
    }

}
