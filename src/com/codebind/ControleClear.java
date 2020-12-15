package com.codebind;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ControleClear extends JFrame implements ActionListener {

    Fenetre fen;

    public ControleClear(Fenetre fen){
        this.fen = fen;
    }

    /**
     * suivant l'id du tableau permet de clear le tableau correspondant
     */
    public void actionPerformed(ActionEvent actionEvent)
    {

        if (fen.tableauCourant.getId()== 1){
            fen.tableau1.clear();
        }

        if (fen.tableauCourant.getId()== 2){
            fen.tableau2.clear();
        }

        if (fen.tableauCourant.getId()== 3){
            fen.tableau3.clear();
        }
    }
}
