package root.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import root.GameMode.Visuals.NoScalingMode;
import root.GameMode.Visuals.VisualMode;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    JFrame window;
    JPanel window1;
    JFrame window2;
    Container con;
    JPanel titleNamePanel;
    JLabel titleNameLabel;

    JPanel startButtonLeftPanel;
    JButton startButtonLeft;


    JPanel startButtonRightPanel;
    JButton startButtonRight;

    Font font = new Font("Time New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Time New Roman", Font.PLAIN, 30);
    TitleHandScreen OpenNewWindow = new TitleHandScreen();

    public VisualMode visualMode = new NoScalingMode();

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        window = new JFrame();
//        window.setSize(visualMode.GameDim.width,visualMode.GameDim.height);
//        window.setPreferredSize(visualMode.GameDim);
//        window.setResizable(false);

        window.add(new MenuClass());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        con = window.getContentPane();


        startButtonLeftPanel = new JPanel();
        startButtonLeftPanel.setBounds(180, 500, 180, 200);

        startButtonLeft = new JButton("DAYMODE");
        startButtonLeft.setBackground(Color.BLACK);
        startButtonLeft.setForeground(Color.WHITE);
        startButtonLeft.setFont(normalFont);
        startButtonLeft.addActionListener(OpenNewWindow);


        startButtonRightPanel = new JPanel();
        startButtonRightPanel.setBounds(600, 500, 180, 200);


        startButtonRight = new JButton("NIGHTMODE");
        startButtonRight.setBackground(Color.BLACK);
        startButtonRight.setForeground(Color.WHITE);
        startButtonRight.setFont(normalFont);
        startButtonRight.addActionListener(OpenNewWindow);


        startButtonLeftPanel.add(startButtonLeft);
        startButtonRightPanel.add(startButtonRight);


        con.add(startButtonLeftPanel);
        con.add(startButtonRightPanel);
        window.setVisible(true);

    }

    public class TitleHandScreen implements ActionListener {
        int i;

        public void setI(int i) {
            this.i = i;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == startButtonLeft) {
                setI(0);
            } else {
                setI(1);
            }
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    root.PlantsVsZombies game = new root.PlantsVsZombies(i);
                    ((JFrame) SwingUtilities.getWindowAncestor(con)).dispose();
                    con = new Container();
                    con = game.getContentPane();
                    game.setVisible(true);

                }
            });
        }
    }

}
