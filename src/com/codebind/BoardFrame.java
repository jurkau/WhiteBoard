package com.codebind;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardFrame extends JFrame{

	public BoardFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		JPanel panel = new JPanel();
		TextField tfTableau = new TextField();
		TextField tfTableau1 = new TextField();
		tfTableau1.setBackground(Color.WHITE);
		tfTableau.setBackground(Color.WHITE);
		tfTableau.setBounds(200,200,800,500);
		tfTableau1.setBounds(1050,400,200, 300);
		panel.setLayout(null);
		panel.add(tfTableau, "align center");
		panel.add(tfTableau1, "");
		
		setContentPane(panel);
	}

	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				BoardFrame frame = new BoardFrame();
				frame.setVisible(true);
			}
		});
	}*/
}
