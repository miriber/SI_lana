package jokoa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class OntziNorabidea extends JFrame {

	private JPanel contentPane;
	private ButtonGroup group;
	private JButton botoia;
	private JRadioButton btn1,btn2;
	private char orientazioa;
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

	
	/**
	 * Create the frame.
	 */
	public OntziNorabidea() {
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
				if (btn1.isSelected()) {
					orientazioa='H';
				}else if (btn2.isSelected()) {
					orientazioa= 'B';
				}
				System.out.println(orientazioa);
				Jokalari jok1= Jokalari1.getNeureJok();
				OntziaErabaki erabikitakoOntzi= new OntziaErabaki();
				Ontzi pOntzi= erabikitakoOntzi.getAukeraketa();
				Tableroa tab=new Tableroa();
				int x= tab.getTablerotikOntziX();
				int y= tab.getTablerotikOntziY();
				//TODO EXCEPTION 
				jok1.neureOntziakKokatu(x, y, orientazioa, pOntzi);
				System.out.println(orientazioa);	
				tab.partidaJokatu();
				setVisible(false);
			}
		});

	}
			
	
	
}
