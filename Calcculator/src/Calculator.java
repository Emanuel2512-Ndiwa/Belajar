import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
import javax.swing.border.LineBorder;

public class Calculator {

    int boardWidth = 360;
    int boardHeight = 540;

    // Warna kustom ala kalkulator modern
    Color customLigthGrey = new Color(212, 212, 210);
    Color customDarkGrey = new Color(80, 80, 80);
    Color customBlack = new Color(28, 28, 28);
    Color customOrange = new Color(255, 149, 0);

    String[] buttonValues = {
            "AC", "±", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };

    String[] rightSymbol = { "÷", "×", "-", "+", "=" };
    String[] topSymbol = { "AC", "±", "%" };
    
    String A = "0";
    String operator = null;
    String B = null;

    JFrame frame = new JFrame("Calculator");
    JLabel displayJLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    Calculator() {
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Pengaturan Tampilan Layar (Display)
        displayJLabel.setBackground(customBlack);
        displayJLabel.setForeground(Color.WHITE);
        displayJLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        displayJLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayJLabel.setText("0");
        displayJLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayJLabel);
        frame.add(displayPanel, BorderLayout.NORTH);

        // Pengaturan Panel Tombol
        buttonsPanel.setLayout(new GridLayout(5, 4));
        buttonsPanel.setBackground(customBlack);
        frame.add(buttonsPanel);

        for (int i = 0; i < buttonValues.length; i++) {
            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBorder(new LineBorder(customBlack));

            // Mewarnai tombol berdasarkan fungsinya
            if (Arrays.asList(topSymbol).contains(buttonValue)) {
                button.setBackground(customLigthGrey);
                button.setForeground(customBlack);
            } else if (Arrays.asList(rightSymbol).contains(buttonValue)) {
                button.setBackground(customOrange);
                button.setForeground(Color.WHITE);
            } else {
                button.setBackground(customDarkGrey);
                button.setForeground(Color.WHITE);
            }

            buttonsPanel.add(button);

            // Logika Klik Tombol
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    String val = source.getText();

                    // 1. Logika Tombol AC (Clear)
                    if (val.equals("AC")) {
                        clearAll();
                    } 
                    
                    // 2. Logika Tombol Angka dan Titik
                    else if ("0123456789".contains(val)) {
                        if (displayJLabel.getText().equals("0")) {
                            displayJLabel.setText(val);
                        } else {
                            displayJLabel.setText(displayJLabel.getText() + val);
                        }
                    } 
                    else if (val.equals(".")) {
                        if (!displayJLabel.getText().contains(".")) {
                            displayJLabel.setText(displayJLabel.getText() + ".");
                        }
                    }

                    // 3. Logika Operator (+, -, ×, ÷)
                    else if (Arrays.asList(rightSymbol).contains(val) && !val.equals("=")) {
                        A = displayJLabel.getText();
                        operator = val;
                        displayJLabel.setText("0"); // Menyiapkan layar untuk angka kedua
                    }

                    // 4. Logika Sama Dengan (=)
                    else if (val.equals("=")) {
                        if (operator != null) {
                            B = displayJLabel.getText();
                            double numA = Double.parseDouble(A);
                            double numB = Double.parseDouble(B);
                            double result = 0;

                            if (operator.equals("+")) result = numA + numB;
                            else if (operator.equals("-")) result = numA - numB;
                            else if (operator.equals("×")) result = numA * numB;
                            else if (operator.equals("÷")) {
                                if (numB != 0) result = numA / numB;
                                else {
                                    displayJLabel.setText("Error");
                                    return;
                                }
                            }

                            displayJLabel.setText(removeZeroDecimal(result));
                            operator = null; // Reset operator setelah hitung
                        }
                    }

                    // 5. Logika Simbol Tambahan (±, %, √)
                    else if (val.equals("±")) {
                        double num = Double.parseDouble(displayJLabel.getText()) * -1;
                        displayJLabel.setText(removeZeroDecimal(num));
                    } 
                    else if (val.equals("%")) {
                        double num = Double.parseDouble(displayJLabel.getText()) / 100;
                        displayJLabel.setText(removeZeroDecimal(num));
                    }
                    else if (val.equals("√")) {
                        double num = Double.parseDouble(displayJLabel.getText());
                        displayJLabel.setText(removeZeroDecimal(Math.sqrt(num)));
                    }
                }
            });
        }
        
        frame.setVisible(true);
    }

    void clearAll() {
        A = "0";
        operator = null;
        B = null;
        displayJLabel.setText("0");
    }

    String removeZeroDecimal(double numDisplay) {
        if (numDisplay % 1 == 0) {
            return Integer.toString((int) numDisplay);
        }
        return Double.toString(numDisplay);
    }

  
}