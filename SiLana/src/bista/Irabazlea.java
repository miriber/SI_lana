package bista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jokoa.Jokoa;

import javax.swing.JTextPane;
import javax.swing.JButton;

public class Irabazlea extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Irabazlea frame = new Irabazlea();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Irabazlea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane mezua = new JTextPane();
		mezua.setEditable(false);
		mezua.setBounds(133, 61, 170, 40);
		Jokoa jok= Jokoa.getNireJoko();
		if (!jok.PCTxandaDa()) {		//Irabazlea PC den esaten du
			mezua.setText("Zorioonak! Irabazlea zara!");
		}else {
			mezua.setText("PC izan da garaile. Berriro jokatu nahi?");
		}
		contentPane.add(mezua);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(167, 147, 97, 25);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TableroaBista  tab = TableroaBista.getNireTableroa();
				//TODO Hasieratu dena
			}
			
		});
	}
}
