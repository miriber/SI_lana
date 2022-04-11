package bista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument.Iterator;

import jokoa.Jokalari1;
import jokoa.Ontzi;
import jokoa.OntziFactory;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OntziaErabaki extends JFrame {

	private static OntziaErabaki nOntziaErabaki=null;
	private JPanel contentPane;
	private ButtonGroup group;	//horrela JRadioButton bakarra aukeratu ahal da
	//private JButton botoia;
	private JRadioButton ontzi1,ontzi2,ontzi3,ontzi4;
	private Ontzi aukeratutakoOntzi;
	private JTextField txtAukeratuOntziBat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		Ontzi[] ontziPosibleak=Jokalari1.getNeureJok().ontziPosibleakItzuli();
		for (int i =0;i<ontziPosibleak.length;i++) {
			//gelditzen diren ontzi motak agertu
			if (ontziPosibleak[i].getMotaBera("Fragata")) {
				ontzi1 = new JRadioButton("Fragata (1)");
				ontzi1.setBounds(145, 63, 127, 25);
				group.add(ontzi1);
				contentPane.add(ontzi1);
			} else if (ontziPosibleak[i].getMotaBera("Suntsitzailea")) {
				ontzi2 = new JRadioButton("Suntsitzailea (2)");
				ontzi2.setBounds(145, 93, 127, 25);
				group.add(ontzi2);
				contentPane.add(ontzi2);
			} else if (ontziPosibleak[i].getMotaBera("Itsaspekoa")) {
				ontzi3 = new JRadioButton("Itsaspekoa (3)");
				ontzi3.setBounds(145, 123, 127, 25);
				group.add(ontzi3);
				contentPane.add(ontzi3);
			} else if (ontziPosibleak[i].getMotaBera("Hegazkina")) {
				ontzi4 = new JRadioButton("Hegazkina (4)");;
				ontzi4.setBounds(145, 159, 127, 25);
				group.add(ontzi4);
				contentPane.add(ontzi4);
			}
		}
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OntziFactory nFact = OntziFactory.getNireOntziFact();
				//gelditzen diren ontzietatik bat aukeratu
				if (ontzi1.isSelected()) {
					aukeratutakoOntzi= nFact.createOntzi(1); // OntziFact erabiliz sortu aukeratutako ontzia
				} else if (ontzi2.isSelected()) {
					aukeratutakoOntzi=nFact.createOntzi(2);
				} else if (ontzi3.isSelected()) {
					aukeratutakoOntzi=nFact.createOntzi(3);
				} else {
					aukeratutakoOntzi=nFact.createOntzi(4);					
				}/* if (aukeratutakoOntzi.getMotaBera("Fragata")) {
					Tableroa tab= new Tableroa();
					tab.setVisible(true);
				}else{*/
				OntziNorabidea norabidea = OntziNorabidea.getNireOntziNorabidea();
				norabidea.setVisible(true);
				//}	
				setVisible(false);
			}
		});
		btnNewButton.setBounds(145, 205, 97, 25);
		contentPane.add(btnNewButton);				
	}
	
	public Ontzi getAukeraketa() {
		return aukeratutakoOntzi;
	}
	
	
}
