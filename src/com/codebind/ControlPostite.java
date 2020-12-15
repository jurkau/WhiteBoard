package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.AbstractList;
import java.util.Enumeration;

public class ControlPostite implements ActionListener{

    Fenetre fen;
    Postite pos;

    public ControlPostite(){}

    public ControlPostite(Postite postite)
    {
        this.pos = postite;
    }

    public ControlPostite(Fenetre fenetre, Postite postite)
    {
        this.fen = fenetre;
        this.pos = postite;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == pos.btnValidate) {
            pos.panneauBoutonCouleur.setVisible(false);
            pos.panneauBoutonValide.setVisible(false);
            fen.pano.add(pos.body);
            fen.revalidate();
        }

        if(actionEvent.getSource() == pos.btnOrange)
        {
            pos.body.setBackground(Color.ORANGE);
        }


        if(actionEvent.getSource() == pos.btnBlue)
        {
            pos.body.setBackground(Color.BLUE);
        }

        if(actionEvent.getSource() == pos.btnGreen)
        {
            pos.body.setBackground(Color.GREEN);
        }

        if(actionEvent.getSource() == pos.btnWhite)
        {
            pos.body.setBackground(Color.WHITE);
        }

        if(actionEvent.getSource() == pos.btnRed)
        {
            pos.body.setBackground(Color.RED);
        }

        if(actionEvent.getSource() == pos.btnYellow)
        {
            pos.body.setBackground(Color.YELLOW);
        }

        if(actionEvent.getSource() == pos.btnCyan)
        {
            pos.body.setBackground(Color.CYAN);
        }
    }
}
