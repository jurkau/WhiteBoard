package com.codebind;
import javax.swing.*;
import java.awt.event.*;
import java.util.AbstractList;
import java.util.Enumeration;

public class ControlMenu implements ActionListener{

    Fenetre fen;

    public ControlMenu() {}

    public ControlMenu(Fenetre fen) {this.fen = fen; }

    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == fen.itemDiagramme)
        {

        }

    }
}
