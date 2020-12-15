package com.codebind;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

class Appli extends JFrame {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater( new Runnable() {

            public void run() {
                Fenetre f = new Fenetre();
            }

        });
    }
}
