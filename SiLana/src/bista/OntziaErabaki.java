package bista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import jokoa.Jokalari;
import jokoa.Pertsona;
import jokoa.Ontzi;
import jokoa.OntziFactory;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class OntziaErabaki extends JFrame {

	private static OntziaErabaki nOntziaErabaki=null;
	private JPanel contentPane;
	private ButtonGroup group;	//horrela JRadioButton bakarra aukeratu ahal da
	private JRadioButton ontzi1,ontzi2,ontzi3,ontzi4;
	private Ontzi aukeratutakoOntzi;
	private JTextField txtAukeratuOntziBat;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("ontziaErabaki --> main");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OntziaErabaki frame = getNireOntziaErabaki();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static OntziaErabaki getNireOntziaErabaki() {
		System.out.println("ontziaErabaki --> getNireOntziaErabaki");
		if (nOntziaErabaki==null) {
			nOntziaErabaki=new OntziaErabaki();
		}
		return nOntziaErabaki;
	}
	
	private OntziaErabaki() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAukeratuOntziBat = new JTextField();
		txtAukeratuOntziBat.setEditable(false);
		txtAukeratuOntziBat.setText("Aukeratu ontzi bat:");
		txtAukeratuOntziBat.setBounds(143, 28, 116, 32);
		contentPane.add(txtAukeratuOntziBat);
		txtAukeratuOntziBat.setColumns(10);
		
		group=new ButtonGroup();
		ArrayList<Ontzi> ontziPosibleak=Pertsona.getNeureJok().ontziPosibleakItzuli();
		int zenbatGelditu;
		Ontzi pOntzi;
		for (int i =0;i<ontziPosibleak.size();i++) {
			//gelditzen diren ontzi motak agertu
			pOntzi=ontziPosibleak.get(i);
			System.out.println(pOntzi);
			zenbatGelditu=Pertsona.getNeureJok().ontziKop(pOntzi);
			if (pOntzi.getMotaBera("Fragata")) {
				ontzi1 = new JRadioButton("Fragata ("+zenbatGelditu+")");
				ontzi1.setBounds(145, 63, 127, 25);
				group.add(ontzi1);
				contentPane.add(ontzi1);
			} else if (pOntzi.getMotaBera("Suntsitzailea")) {
				ontzi2 = new JRadioButton("Suntsitzailea ("+zenbatGelditu+")");
				ontzi2.setBounds(145, 93, 127, 25);
				group.add(ontzi2);
				contentPane.add(ontzi2);
			} else if (pOntzi.getMotaBera("Itsaspekoa")) {
				ontzi3 = new JRadioButton("Itsaspekoa("+zenbatGelditu+")");
				ontzi3.setBounds(145, 123, 127, 25);
				group.add(ontzi3);
				contentPane.add(ontzi3);
			} else if (pOntzi.getMotaBera("Hegazkina")) {
				ontzi4 = new JRadioButton("Hegazkina ("+zenbatGelditu+")");
				ontzi4.setBounds(145, 159, 127, 25);
				group.add(ontzi4);
				contentPane.add(ontzi4);
			}
		}
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OntziFactory nFact = OntziFactory.getNireOntziFact();
				//ArrayList<Ontzi> ontziPosibleak=Pertsona.getNeureJok().ontziPosibleakItzuli();
				boolean ontziaJarri = true;
				String ontzia = "";
				//gelditzen diren ontzietatik bat aukeratu
				if (ontzi1.isSelected()) {
					System.out.println("SE METEE EN ONTZI1");
					ontzia = "Fragata";
					aukeratutakoOntzi= nFact.createOntzi(1); // OntziFact erabiliz sortu aukeratutako ontzia
				} else if (ontzi2.isSelected()) {
					System.out.println("SE METEE EN ONTZI2");
					ontzia = "Suntsitzailea";
					aukeratutakoOntzi=nFact.createOntzi(2);
				} else if (ontzi3.isSelected()) {
					System.out.println("SE METEE EN ONTZI3");
					ontzia = "Itsaspekoa";
					aukeratutakoOntzi=nFact.createOntzi(3);
				} else if (ontzi4.isSelected()) {
					System.out.println("SE METEE EN ONTZI4");
					ontzia = "Hegazkina";
					aukeratutakoOntzi=nFact.createOntzi(4);
				} else {
					System.out.println("TODO OK");
					//elmensajito tope wapo bien refacherito
					ontziaJarri = false;
					JOptionPane.showMessageDialog(btnOK, "Ontzi bat aukeratu behar duzu.");
				}
				group.clearSelection();
				if (ontziaJarri) {
					OntziNorabidea norabidea = OntziNorabidea.getNireOntziNorabidea();
					if (!ontzia.equals("Fragata")) {
						norabidea.setVisible(true);
						
					} else {
						norabidea.setOrientazioa('H');
						Jokalari jok1= Pertsona.getNeureJok();
						jok1.ontziakKokatu();
						TableroaBista tab= TableroaBista.getNireTableroa();
						tab.partidaJokatu();
					}
					setVisible(false);					
				}
				
			}
		});
		btnOK.setBounds(145, 205, 97, 25);
		contentPane.add(btnOK);				
	}
	
	public void eguneratuLista() {	
		if (aukeratutakoOntzi!=null) {
			int zenbatGelditu=Pertsona.getNeureJok().ontziKop(aukeratutakoOntzi);
			if (aukeratutakoOntzi.getMotaBera("Fragata")) {
				contentPane.remove(ontzi1);
			}else if (aukeratutakoOntzi.getMotaBera("Suntsitzailea")) {
				contentPane.remove(ontzi2);
			}else if (aukeratutakoOntzi.getMotaBera("Itsaspekoa")) {
				contentPane.remove(ontzi3);
			}else if (aukeratutakoOntzi.getMotaBera("Hegazkina")) {
				contentPane.remove(ontzi4);
			}
			if (zenbatGelditu!=0) {
				if (aukeratutakoOntzi.getMotaBera("Fragata")) {
					ontzi1 = new JRadioButton("Fragata ("+zenbatGelditu+")");
					ontzi1.setBounds(145, 63, 127, 25);
					group.add(ontzi1);
					contentPane.add(ontzi1);
				} else if (aukeratutakoOntzi.getMotaBera("Suntsitzailea")) {
					ontzi2 = new JRadioButton("Suntsitzailea ("+zenbatGelditu+")");
					ontzi2.setBounds(145, 93, 127, 25);
					group.add(ontzi2);
					contentPane.add(ontzi2);
				} else if (aukeratutakoOntzi.getMotaBera("Itsaspekoa")) {
					ontzi3 = new JRadioButton("Itsaspekoa("+zenbatGelditu+")");
					ontzi3.setBounds(145, 123, 127, 25);
					group.add(ontzi3);
					contentPane.add(ontzi3);
				} else if (aukeratutakoOntzi.getMotaBera("Hegazkina")) {
					ontzi4 = new JRadioButton("Hegazkina ("+zenbatGelditu+")");
					ontzi4.setBounds(145, 159, 127, 25);
					group.add(ontzi4);
					contentPane.add(ontzi4);
				}
			}
			
			
		}
	}
	
	public Ontzi getAukeraketa() {
		System.out.println("ontziaErabaki --> getAukeraketa");
		return aukeratutakoOntzi;
	}
	
	
}
