package bista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import jokoa.Arma;
import jokoa.Biltegia;
import jokoa.Jokalari;
import jokoa.Pertsona;
import jokoa.Jokoa;
import jokoa.OntziFactory;
import jokoa.Tablero;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ArmamentuaAukeratu extends JFrame {

    private JPanel contentPane;
    private ButtonGroup group;
    private JTextField txtAukeratuArma;
    private JRadioButton bonba,misila,ezkutua, radarra;
    private JButton okBotoia;
    private static ArmamentuaAukeratu nArma=null;
    private Arma aukeratutakoa;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArmamentuaAukeratu frame = new ArmamentuaAukeratu(false);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static ArmamentuaAukeratu getNireArmamentua(boolean biltegia) {
    	if (nArma==null) {
    		nArma=new ArmamentuaAukeratu(biltegia);
    	}
    	return nArma;
    }
    
    private ArmamentuaAukeratu(boolean biltegia) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
		contentPane.setLayout(null);

        txtAukeratuArma = new JTextField();
        txtAukeratuArma.setEditable(false);
        txtAukeratuArma.setText("Aukeratu arma:");
        txtAukeratuArma.setBounds(143, 28, 116, 32);
        contentPane.add(txtAukeratuArma);
        txtAukeratuArma.setColumns(10);

        group=new ButtonGroup();
        Jokalari jokPerts= Pertsona.getNeureJok();
        ArrayList<String> armaPosibleak= Pertsona.getNeureJok().armaPosibleMotakItzuli();
       // if (!biltegia) {
      /*  }else {
        	int momentukoDiru=jokPerts.getDiru();
        	armaPosibleak= Biltegia.getNireBiltegia().diruHorrekinArmaPosibleak(momentukoDiru);
        }*/
        if (armaPosibleak.contains("Bonba")) {
        	bonba = new JRadioButton("Bonba");
        	bonba.setBounds(145, 63, 127, 25);
			group.add(bonba);
			contentPane.add(bonba);
        }
        if (armaPosibleak.contains("Misila")) {
			misila = new JRadioButton("Misila");
			misila.setBounds(145, 93, 127, 25);
			group.add(misila);
			contentPane.add(misila); 
        }
        if (armaPosibleak.contains("Radarra")) {
			radarra = new JRadioButton("Radarra");
			radarra.setBounds(145, 123, 127, 25);
			group.add(radarra);
			contentPane.add(radarra);
        }
        if (armaPosibleak.contains("Ezkutua")) {
			ezkutua = new JRadioButton("Ezkutua");
			ezkutua.setBounds(145, 153, 127, 25);
			group.add(ezkutua);
			contentPane.add(ezkutua);
        }
        JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Arma> armaPosibleak= Pertsona.getNeureJok().armaPosibleakItzuli();
				//System.out.print(armaPosibleak);
				Jokoa jok=Jokoa.getNireJoko();
				boolean armaBera = false, armaAukeratu=true;
				int i=0;
				String pArma="";
				if (bonba.isSelected()) {
					pArma="Bonba";
				}else if (misila.isSelected()){
					pArma="Misila";
				}else if (ezkutua.isSelected()){
					pArma="Ezkutua";
				}else if (radarra.isSelected()){
					pArma="Radarra";
				}
				else {
					armaAukeratu=false;
					JOptionPane.showMessageDialog(btnOK, "Arma bat aukeratu behar duzu.");
				}
				System.out.println("ArmamentuAukeratu-->pARMA: " + pArma);
				if (armaAukeratu) {
					while(!armaBera && i< armaPosibleak.size()) {
						System.out.println("ARMA BERA: " + armaBera);
						System.out.println(armaPosibleak.get(i));
						armaBera= armaPosibleak.get(i).klaseBerekoa(pArma);
						System.out.println("ARMA BERA: " + armaBera);
						System.out.println(i+"I-REN BALIOA");
						if (!armaBera) {
							i++;
							System.out.println("KONT"+i);
						}
					} 
					group.clearSelection();
					System.out.println("PARMA: "+pArma);
					if (armaBera) {
						System.out.println(i+"I-REN BALIOA");
						aukeratutakoa= armaPosibleak.get(i);
					}
					System.out.println("AUKERATUTAKOA"+aukeratutakoa);
					group.clearSelection();
					
					if (!jok.PCTxandaDa()&& !biltegia) {
						jokPerts.tiroEgin();
						if(pArma.equals("Ezkutua")) {
							JOptionPane.showMessageDialog(btnOK, "Ezkutua jarri egin da");
						}
					}
					if (!jok.PCTxandaDa()&& biltegia) {
						jokPerts.erosiArma();
					}
					if (!jok.PCTxandaDa()) {
						TableroaBista tab= TableroaBista.getNireTableroa();
						tab.partidaJokatu();
						setVisible(false);
					}
				}
				
					
			}
		});
		btnOK.setBounds(145, 205, 97, 25);
		contentPane.add(btnOK);		
    }
    
	public void eguneratuLista(boolean biltegia) {
		ArrayList<String> armaPosibleak;
		if (!biltegia) {
        	armaPosibleak= Pertsona.getNeureJok().armaPosibleMotakItzuli();
        }else {
        	int momentukoDiru=Pertsona.getNeureJok().getDiru();
        	armaPosibleak= Biltegia.getNireBiltegia().diruHorrekinArmaPosibleak(momentukoDiru);
        }
		if (!armaPosibleak.contains("Bonba")) {
			contentPane.remove(bonba);
		}
		if (!armaPosibleak.contains("Misila")) {
			contentPane.remove(misila);
		}
		if (!armaPosibleak.contains("Ezkutua")) {
			contentPane.remove(ezkutua);
		}
		if (!armaPosibleak.contains("Radarra")) {
			contentPane.remove(radarra);
		}
	}
    
    public Arma getAukeratutakoa() {
    	return aukeratutakoa;
    }
}
