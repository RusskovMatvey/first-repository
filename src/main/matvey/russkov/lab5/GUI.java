package main.matvey.russkov.lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI extends JFrame {

    private JButton button1 = new JButton("Программа №1");
    private JButton button2 = new JButton("Программа №2");
    private JButton button3 = new JButton("Программа №3");
    private JButton button4 = new JButton("Программа №4");
    private JPanel main_panel = new JPanel();
    private JTextField input1 = new JTextField();
    private JLabel labelOutput = new JLabel("Вывод:");
    private JLabel labelArguments = new JLabel("Аргументы:");
    static public JTextArea textArea = new JTextArea(10, 6);
    private JScrollPane scroll = new JScrollPane(textArea);

    private void addListeners() {
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea.setText("");
                main.matvey.russkov.lab1.Main.main(input1.getText().split(" "));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        button2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea.setText("");
                main.matvey.russkov.lab2.Main.main(input1.getText().split(" "));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        button3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea.setText("");
                try {
                    main.matvey.russkov.lab3ex.Main.main(input1.getText().split(" "));
                } catch (Exception ex) {
                    textArea.setText("Input Error!");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        button4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea.setText("");
                try {
                    main.matvey.russkov.lab4.Main.main(input1.getText().split(" "));
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    GUI() {
        super.setSize(1024, 640);
        super.setTitle("Программа №5");
        main_panel.setVisible(true);
        super.setExtendedState(MAXIMIZED_BOTH);
        super.add(main_panel);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        super.setLocationRelativeTo(null);
        main_panel.setLayout(new GridBagLayout());
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textArea.setEditable(false);
        labelOutput.setFont(new Font("Arial", 20, 20));
        labelArguments.setFont(new Font("Arial", 20, 20));
        button1.setFont(new Font("Arial", 20, 20));
        button2.setFont(new Font("Arial", 20, 20));
        button3.setFont(new Font("Arial", 20, 20));
        button4.setFont(new Font("Arial", 20, 20));

        addListeners();
        final int xButton = 0;

        /*main_panel.add(BorderLayout.CENTER, labelArguments);
        main_panel.add(BorderLayout.NORTH, button1);
        main_panel.add(BorderLayout.CENTER, button2);
        main_panel.add(BorderLayout.CENTER, button3);
        main_panel.add(BorderLayout.CENTER, button4);
        main_panel.add(BorderLayout.CENTER, input1);
        main_panel.add(BorderLayout.CENTER, labelOutput);
        main_panel.add(BorderLayout.CENTER, scroll);*/
        main_panel.add(button1, new GridBagConstraints(xButton, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(0, 0, 15, 0), 40, 30));

        main_panel.add(button2, new GridBagConstraints(xButton, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(0, 0, 15, 0), 40, 30));

        main_panel.add(button3, new GridBagConstraints(xButton, 2, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(0, 0, 15, 0), 40, 30));

        main_panel.add(button4, new GridBagConstraints(xButton, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(0, 0, 15, 0), 40, 30));

        main_panel.add(labelArguments, new GridBagConstraints(1, 0, 4, 100, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(0, 20, 0, 0), 40, 20));

        main_panel.add(input1, new GridBagConstraints(1, 1, 4, 100, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(0, 20, 0, 0), 40, 20));

        main_panel.add(labelOutput, new GridBagConstraints(1, 2, 4, 100, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(0, 20, 0, 0), 40, 20));

        main_panel.add(scroll, new GridBagConstraints(1, 3, 4, 100, 0.0, 0.0, GridBagConstraints.NORTH,
                GridBagConstraints.VERTICAL, new Insets(0, 20, 0, 0), 300, 40));

        super.setVisible(true);
        super.setResizable(true);
    }
}
