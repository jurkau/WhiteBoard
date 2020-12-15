package com.codebind;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class Fenetre extends JFrame {

    // création du menu
    JMenuBar barMenu;
    JMenuItem itemImage;
    JMenuItem itemDiagramme;
    JMenuItem itemTableau;
    JMenu droits;
    JMenu insert;
    JMenu partage;
    JMenu save;
    JMenu connexion;
    JMenu inscription;

    // création des boutons de choix de tableaux et d'effacage générale
    JButton butTab1;
    JButton butTab2;
    JButton butTab3;
    JButton btClear;

    // boutons permettant le choix du crayon, de la gomme et de sa couleur
    JButton btnPen;
    JButton btnGomme;
    JButton btnColorRed;
    JButton btnColorBlack;
    JButton btnColorBlue;
    JButton btnColorGreen;

    // Image de gomme pour le bonton gomme
    ImageIcon gomme;

    // boutons permettant l'insertion de zone de texte
    JButton btnPostite;
    JButton btnText;

    //Création des controles
    public ControlTableau controlTab;
    public ControlMenu controlMenu;
    public ControleClear clear;
    public ControlTools controlTools;

    //création d'un tableau
    //WhiteBoard whiteBoard;
    WhiteBoard tableau1;
    WhiteBoard tableau2;
    WhiteBoard tableau3;
    WhiteBoard tableauCourant;

    JPanel pano;
    JPanel ptab1;
    JPanel ptab2;
    JPanel ptab3;
    JPanel ptableau;
    JPanel panToolBox;

    int sX = -1, sY = -1;
    boolean dragging = false;

    public Fenetre()
    {
        initAtribut();
        creerInterface();
        creerMenu();
        creerPostite();
        creerBoiteaOutil();
        pack();
        setSize(650,650);                   // Fixe la taille par défaut
        setVisible(true);                                // Affiche la fenetre
        setLocationRelativeTo(null);
        setTitle("Tableau Blanc Interractif");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Gestion de la fermeture
    }

    private void creerPostite() {
    }

    public void initAtribut()
    {
        // initialisation menu
        barMenu = new JMenuBar();
        itemDiagramme = new JMenuItem("Diagramme");
        itemImage = new JMenuItem("Image");
        itemTableau = new JMenuItem("Tableau");
        droits = new JMenu("Droits");
        insert = new JMenu("Insertion");
        partage = new JMenu("Partager");
        save = new JMenu("Enregistre");
        connexion = new JMenu("Connexion");
        inscription = new JMenu("Inscription");


        // Initiallisation Boite a outil
        btnPen = new JButton("Crayon");
        btnText = new JButton("Zone de texte");
        btnPostite = new JButton("Postite");
        btnGomme = new JButton();
        btnColorBlack = new JButton();
        btnColorRed = new JButton();
        btnColorBlue = new JButton();
        btnColorGreen = new JButton();
        panToolBox = new JPanel();

        // Initialisation image gomme
        gomme = new ImageIcon("gomme.jpg");
        btnGomme.setIcon(gomme);


        //initialisation des boutons sur la page principale
        butTab1 = new JButton("Tableau 1");
        butTab2 = new JButton("Tableau 2");
        butTab3 = new JButton("Tableau 3");
        btClear = new JButton("Clear");


        //initiation des contrôles pour les action du Menu et des tableaux
        controlTab = new ControlTableau(this);
        controlMenu = new ControlMenu(this);
        clear = new ControleClear(this);


        // création des tableaux
        tableau1 = new WhiteBoard(1);
        tableau2 = new WhiteBoard(2);
        tableau3 = new WhiteBoard(3);
        tableauCourant = tableau1;

        ptab1 = new JPanel();
        ptab2 = new JPanel();
        ptab3 = new JPanel();
        ptableau = new JPanel();

    }


    public void creerMenu() {
        //gestion des actions si on clic sur un des menu
        itemDiagramme.addActionListener(controlMenu);
        itemImage.addActionListener(controlMenu);
        itemTableau.addActionListener(controlMenu);


        // ajout des éléments dans le JMenu insert
        insert.add(itemDiagramme);
        insert.add(itemImage);
        insert.add(itemTableau);


        // ajout des éléments à la barre de Menu
        barMenu.add(droits);
        barMenu.add(insert);
        barMenu.add(partage);
        barMenu.add(save);
        barMenu.add(connexion);
        barMenu.add(inscription);
        setJMenuBar(barMenu);


        //ajout des tableaux
        getContentPane().add(tableau1, BorderLayout.CENTER);
        getContentPane().add(tableau2, BorderLayout.CENTER);
        getContentPane().add(tableau3, BorderLayout.CENTER);


        tableau2.setVisible(false);
        tableau3.setVisible(false);

    }

    public void creerBoiteaOutil()
    {
        controlTools = new ControlTools(this, tableauCourant);

        btnPen.addActionListener(controlTools);
        btnText.addActionListener(controlTools);
        btnPostite.addActionListener(controlTools);
        btnGomme.addActionListener(controlTools);

        btnColorBlack.addActionListener(controlTools);
        btnColorBlack.setBackground(Color.BLACK);

        btnColorRed.addActionListener(controlTools);
        btnColorRed.setBackground(Color.RED);

        btnColorBlue.addActionListener(controlTools);
        btnColorBlue.setBackground(Color.BLUE);

        btnColorGreen.addActionListener(controlTools);
        btnColorGreen.setBackground(Color.GREEN);
    }

    public void creerInterface()
    {
        /**pour superposer setLayout = null*/
        //création du panel général avec alignement verticale des éléments
        pano = new JPanel();
        pano.setLayout(new BoxLayout(pano, BoxLayout.Y_AXIS));

        //création du panel pour les boutons avec alignement horizontal des éléments
        JPanel panButTab = new JPanel();
        panButTab.setLayout(new BoxLayout(panButTab, BoxLayout.X_AXIS));

        // Insertion ajout des boutons dans le panel
        panButTab.add(butTab1);
        panButTab.add(butTab2);
        panButTab.add(butTab3);
        panButTab.add(btClear);

        // ajout du panel avec les boutons dans le panel
        pano.add(panButTab);

        ptableau.add(tableau1);
        ptableau.add(tableau2);
        ptableau.add(tableau3);
        ptableau.setLayout(null);

        setContentPane(ptableau);

        // ajout du paneau Boite a outils
        panToolBox = new JPanel();
        panToolBox.setLayout(new BoxLayout(panToolBox, BoxLayout.Y_AXIS));
        panToolBox.setBackground(Color.WHITE);

        panToolBox.add(btnPen);
        panToolBox.add(btnText);
        panToolBox.add(btnGomme);
        panToolBox.add(btnPostite);
        panToolBox.add(btnColorBlack);
        panToolBox.add(btnColorRed);
        panToolBox.add(btnColorBlue);
        panToolBox.add(btnColorGreen);
        setContentPane(panToolBox);

        pano.add(panToolBox);


        //ajout des actions sur les boutons
        butTab1.addActionListener(controlTab);
        butTab2.addActionListener(controlTab);
        butTab3.addActionListener(controlTab);
        btClear.addActionListener(clear);

        //permet l'affichag du panel général
        setContentPane(pano);

    }
}
