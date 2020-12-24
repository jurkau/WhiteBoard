package com.codebind;

import javax.swing.*;
import java.awt.*;

public class Postite extends JFrame{


    // Bouton de choix de couleur d'arrière plan de la zone de texte
    JButton btnRed;
    JButton btnGreen;
    JButton btnBlue;
    JButton btnOrange;
    JButton btnWhite;
    JButton btnCyan;
    JButton btnYellow;

    // bouton de  validation permettant d'insérer la zone de texte dans le tableau courant
    JButton btnValidate;

    // zone de texte ou l'on ecrit le commentaire.
    JTextArea body;

    // Panel contenant les différents éléments
    JPanel panneauBoutonCouleur;
    JPanel panneauBoutonValide;
    JPanel pano;

    ControlPostite controlPostite;


    WhiteBoard tableauCourant;

    public Postite()
    {
        initAttribut();
        creerElement();
        creerPostite();
        setTitle("Postite");
        setSize(250,250);
        setVisible(true);  // Affiche la fenetre
    }

    public void initAttribut()
    {
        //Ceci est la zone de texte du postit,
        //vous pouvez écrire vos commentaires dedans
        body = new JTextArea(5,50);

        // Ces boutons permettent de changer la couleur
        // de l'arrière plan de la zone de texte, ainsi
        // nous pourrons différencier les messages de chaque
        // membre du groupe
        btnWhite = new JButton();
        btnBlue = new JButton();
        btnGreen = new JButton();
        btnOrange = new JButton();
        btnRed = new JButton();
        btnCyan = new JButton();
        btnYellow = new JButton();

        // Ce bouton permet d'ajouter le postit au tableau
        btnValidate = new JButton("Valider");

        // controlPostite permet de définir les action des boutons
        controlPostite = new ControlPostite(this);


    }

    public void creerElement()
    {
        btnWhite.addActionListener(controlPostite);
        btnWhite.setBackground(Color.WHITE);

        btnRed.addActionListener(controlPostite);
        btnRed.setBackground(Color.RED);

        btnOrange.addActionListener(controlPostite);
        btnOrange.setBackground(Color.ORANGE);

        btnGreen.addActionListener(controlPostite);
        btnGreen.setBackground(Color.GREEN);

        btnBlue.addActionListener(controlPostite);
        btnBlue.setBackground(Color.BLUE);

        btnYellow.addActionListener(controlPostite);
        btnYellow.setBackground(Color.YELLOW);

        btnCyan.addActionListener(controlPostite);
        btnCyan.setBackground(Color.CYAN);

        btnValidate.addActionListener(controlPostite);

        body.setEditable(true);
    }

    public void creerPostite()
    {
        pano = new JPanel();
        pano.setLayout(new BorderLayout());

        // Creation du panneau des boutons d'arrière plan
        panneauBoutonCouleur = new JPanel();
        panneauBoutonCouleur.setLayout(new BoxLayout(panneauBoutonCouleur, BoxLayout.X_AXIS));
        panneauBoutonCouleur.add(btnWhite);
        panneauBoutonCouleur.add(btnRed);
        panneauBoutonCouleur.add(btnOrange);
        panneauBoutonCouleur.add(btnYellow);
        panneauBoutonCouleur.add(btnGreen);
        panneauBoutonCouleur.add(btnBlue);
        panneauBoutonCouleur.add(btnCyan);

        // Creation d'espace entre les éléments du tableau
        panneauBoutonCouleur.add(Box.createVerticalStrut(20));
        panneauBoutonCouleur.setBorder(BorderFactory.createLineBorder(Color.black));

        panneauBoutonValide = new JPanel();
        panneauBoutonValide.setLayout(new BoxLayout(panneauBoutonValide, BoxLayout.X_AXIS));
        panneauBoutonValide.add(btnValidate);

        pano.add(panneauBoutonCouleur, BorderLayout.NORTH);
        pano.add(body, BorderLayout.CENTER);
        pano.add(panneauBoutonValide, BorderLayout.SOUTH);
        setContentPane(pano);
    }

}
