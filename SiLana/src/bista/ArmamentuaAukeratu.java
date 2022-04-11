package bista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import jokoa.Arma;
import jokoa.Jokalari1;
import jokoa.OntziFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArmamentuaAukeratu extends JFrame {

    private JPanel contentPane;
    private ButtonGroup group;
    private JTextField txtAukeratuArma;
    private JRadioButton bonba,misila;
    private JButton okBotoia;
    private static ArmamentuaAukeratu nArma=null;
    private Arma aukeratutakoa;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArmamentuaAukeratu frame = new ArmamentuaAukeratu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static ArmamentuaAukeratu getNireArmamentua() {
    	if (nArma==null) {
    		nArma=new ArmamentuaAukeratu();
    	}
    	return nArma;
    }
    
    private ArmamentuaAukeratu() {
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
        Arma[] armaPosibleak= Jokalari1.getNeureJok().armaPosibleakItzuli();
        for (int i = 0; i < armaPosibleak.length; i++) {
        	if (armaPosibleak[i].klaseBerekoa("Bonba")) {
				bonba = new JRadioButton("Bonba");
				bonba.setBounds(145, 63, 127, 25);
				group.add(bonba);
				contentPane.add(bonba);
			} else if (armaPosibleak[i].klaseBerekoa("Misila")) {
				misila = new JRadioButton("Misila");
				misila.setBounds(145, 93, 127, 25);
				group.add(misila);
				contentPane.add(misila);
			} 
        }
        JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Arma[] armaPosibleak= Jokalari1.getNeureJok().armaPosibleakItzuli();
				boolean armaBera;
				int i=0;
				String pArma;
				if (bonba.isSelected()) {
					pArma="Bonba";
				}else {
					pArma="Misila";
				}
				armaBera= armaPosibleak[i].klaseBerekoa(pArma);
				i++;
				while(!armaBera) {
					armaBera= armaPosibleak[i].klaseBerekoa(pArma);
					i++;
				} if (armaBera) {
					aukeratutakoa= armaPosibleak[i];
				}
				setVisible(false);
			}
		});
		btnNewButton.setBounds(145, 205, 97, 25);
		contentPane.add(btnNewButton);		
    
    }
    
    public Arma getAukeratutakoa() {
    	return aukeratutakoa;
    }
}
