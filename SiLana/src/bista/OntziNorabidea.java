package bista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jokoa.Jokalari;
import jokoa.Pertsona;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.CardLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class OntziNorabidea extends JFrame {

	private JPanel contentPane;
	private ButtonGroup group;
	private JButton botoia;
	private JRadioButton btn1,btn2;
	private char orientazioa;
	private static OntziNorabidea nOntziNorabidea=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OntziNorabidea frame = new OntziNorabidea();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public static OntziNorabidea getNireOntziNorabidea() {
		if (nOntziNorabidea==null) {
			nOntziNorabidea=new OntziNorabidea();
		}
		return nOntziNorabidea;
	}
	/**
	 * Create the frame.
	 */
	private OntziNorabidea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		group= new ButtonGroup();
		btn1 = new JRadioButton("Horizontala");
		btn1.setBounds(45, 85, 127, 25);
		group.add(btn1);
		contentPane.add(btn1);
		
		btn2 = new JRadioButton("Bertikala");
		btn2.setBounds(45, 117, 127, 25);
		group.add(btn2);
		contentPane.add(btn2);
		
		JTextPane txt = new JTextPane();
		txt.setEditable(false);
		txt.setText("Kokatu nahi duzun ontziaren norabidea aukeratu:");
		txt.setBounds(47, 40, 311, 25);
		contentPane.add(txt);
		
		botoia = new JButton("OK");
		botoia.setBounds(155, 187, 97, 25);
		contentPane.add(botoia);
		botoia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean aukeratuta = true;
				if (btn1.isSelected()) {
					orientazioa='H';	//Horizontala
				}else if (btn2.isSelected()) {
					orientazioa= 'B';	// Bertikala aukeratzen bada
				} else {
					aukeratuta = false;
					JOptionPane.showMessageDialog(botoia, "Norabide bat aukeratu behar duzu.");
				}
				/*//KENDUTAKOA
				Tableroa tab=Tableroa.getNireTableroa();	
				int x= tab.getTablerotikOntziX();
				int y= tab.getTablerotikOntziY();
				//Aukeratutako ontzia lortu
				OntziaErabaki erabikitakoOntzi= OntziaErabaki.getNireOntziaErabaki();
				Ontzi pOntzi= erabikitakoOntzi.getAukeraketa();*/
				if (aukeratuta) {
					Jokalari jok1= Pertsona.getNeureJok();
					jok1.ontziakKokatu();
					TableroaBista tab= TableroaBista.getNireTableroa();
					tab.partidaJokatu();
					setVisible(false);
				}
				
			}
		});

	}
	
	public char getOrientazioa() {
		return orientazioa;
	}

	public void setOrientazioa(char o) {
		orientazioa = o;
	}
			
	
	
}
