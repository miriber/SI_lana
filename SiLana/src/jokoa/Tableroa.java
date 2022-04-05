package jokoa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tableroa extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tableroa frame = new Tableroa();
					frame.setVisible(true); //leihoa ikusteko
					frame.setDefaultCloseOperation(3); //Leihoa ixteko
					frame.setResizable(false); //leihoa handiagoa egiteko aukerarik ez
					frame.setSize(1200, 750); //leihoaren tamaina zehaztu
					frame.setTitle("Flota Urperatu");
					frame.setLocationRelativeTo(null); //pantailaren erdian jartzeko
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JButton botoia1;		//jokoa hasteko
	JButton nTableroa[][];	//neure tableroa
	JButton aTableroa[][];	//jokalariaren tableroa
	//Jokalari1 jok1;
	//PC jok2;
	JLabel mezua1;			// zein jokalariren txanda den adieraziko du mezu honek
	JLabel mezua2;
	JLabel xKoor;
    JLabel yKoor;
	Color kolorea;	
	
	private JButton biltegiB;
	private JTextField XTextField;
	private JTextField YTextField;
	    
	public Tableroa() {
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		contentPane.add(getBtnNewButton());
		getContentPane().setLayout(null); //elem kokapena gure menpe
		mezua1=new JLabel ("Zure tableroa");
		mezua1.setBounds(290,40,200,30); //pantailan non egongo da eta bere ezaugarriak
		getContentPane().add(mezua1);
		mezua2= new JLabel ("Aurkariaren tableroa");
		mezua2.setBounds(850,40,200,30); //pantailan non egongo da eta bere ezaugarriak
		getContentPane().add(mezua2);
		botoia1.setBounds(550,650,150,30); //posizioax, posizioay, luzeera (tamaina x), zabalera (tamaina y)
		/*botoia1.addActionListener(this);*/ //klik egiten bada botoia jakinarazi
		nTableroa =new JButton[10][10];
		aTableroa= new JButton[10][10];
		
		xKoor = new JLabel("X:");
        yKoor = new JLabel("Y:");

        xKoor.setBounds(800, 640, 100, 50);
        getContentPane().add(xKoor);
        yKoor.setBounds(900, 640, 100, 50);
        getContentPane().add(yKoor);

        XTextField = new JTextField();
        contentPane.add(XTextField);
        XTextField.setColumns(10);
        XTextField.setBounds(820, 650, 40, 30);

        YTextField = new JTextField();
        contentPane.add(YTextField);
        YTextField.setColumns(10);
        YTextField.setBounds(920, 650, 40, 30);
		
		//gure taula
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				nTableroa[i][j]=new JButton();
				nTableroa[i][j].setBounds((i+1)*50+40, (j+1)*50+30, 50, 50);
				getContentPane().add(nTableroa[i][j]);
				nTableroa[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource()==nTableroa) {
                            XTextField.setText(Integer.toString(getX));
                            YTextField.setText(Integer.toString(y));


                        }
                    }
                });
            }
        }
		//aurkariaren taula
		for (int i=0;i<10;i++) {
            for (int j=0;j<10;j++) {
                aTableroa[i][j]=new JButton();
                aTableroa[i][j].setBounds((i+1)50+600, (j+1)50+30,50,50);
                getContentPane().add(aTableroa[i][j]);
                aTableroa[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource()==nTableroa) {
                            XTextField.setText(Integer.toString(x));
                            YTextField.setText(Integer.toString(y));


                        }
                    }
                });
            }
        }
		kolorea= nTableroa[0][0].getBackground();
	
	}

	private JButton getBtnNewButton() {
		if (botoia1 == null) {
			botoia1 = new JButton("Partida hasi");
			botoia1.addActionListener(new ActionListener() {  //klik egiten bada botoia jakinarazi
				public void actionPerformed(ActionEvent e) { //botoia klikatuz gero, gertatuko dena
					if (e.getSource()==botoia1)	{	//non klikatu den adierazten du (hau itzuliz) 
						JOptionPane.showMessageDialog(botoia1, "Jokoa hasiko da");	//Mezua inprimatu
				}
				}});
		}
		return botoia1;
	}
	
	//TODO public Ontzi  ontziaAukeratu(){
		// aukerakHauekInprima() erabili
		//gelditzen diren ontzi motak agertu--> 
		//eta hauetako bat aukeratu
		// OntziFact erabiliz sortu
		// aukeratutako botoiaren arabera ontzi hori sortu 
		//gehituOntz (Ontzi pOntzi): Flotako ontziZer gehitu
	//}
	
	//TODO public String ontziarenNorabidea()
		//Horizontal eta bertikal aukerak dituen test
		//test honen emaitza return
	//}
	@Override
	public void actionPerformed(ActionEvent e) { 
		// TODO Auto-generated method stub
		
		
	}
	
}
