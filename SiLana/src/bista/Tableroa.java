package bista;

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

import jokoa.Jokalari;
import jokoa.Jokalari1;
import jokoa.Tablero;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


public class Tableroa extends JFrame implements Observer {

	private JPanel contentPane;
	private JButton botoia1;		//jokoa hasteko
	private JButton nTableroa[][];	//neure tableroa
	private JButton aTableroa[][];	//jokalariaren tableroa
	private Jokalari jok1, jokPC;
	private JLabel mezua1;			// zein jokalariren txanda den adieraziko du mezu honek
	private JLabel mezua2,xKoor, yKoor;
	private Color kolorea;	
	private JButton biltegiButton, flotaKokatuButton;
	private JTextField XTextField, YTextField;
	private int klikatutakoX, klikatutakoY;
	private static Tableroa neTableroa= null;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tableroaIkusi();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	    
	private Tableroa() {
		Tablero.getTablero().addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		biltegiButton = new JButton("Biltegia");
        contentPane.add(biltegiButton);              //Biltegiaren botoia
        biltegiButton.setBounds(50, 600, 150, 50);
        biltegiButton.setVisible(false);
        
        flotaKokatuButton = new JButton("FlotaKokatu");
        contentPane.add(flotaKokatuButton);
        flotaKokatuButton.setBounds(250, 600, 150, 50);
        flotaKokatuButton.setVisible(false);
        
		contentPane.add(getBtnNewButton());
		getContentPane().setLayout(null); //elem kokapena gure menpe
		mezua1=new JLabel ("Zure tableroa");
		mezua1.setBounds(290,40,200,30); //pantailan non egongo da eta bere ezaugarriak
		getContentPane().add(mezua1);
		mezua2= new JLabel ("Aurkariaren tableroa");
		mezua2.setBounds(850,40,200,30); //pantailan non egongo da eta bere ezaugarriak
		getContentPane().add(mezua2);
		botoia1.setBounds(550,650,150,30); //posizioax, posizioay, luzeera (tamaina x), zabalera (tamaina y)
		
		nTableroa =new JButton[10][10];
		aTableroa= new JButton[10][10];
		
		jok1=Jokalari1.getNeureJok();
		//jokPC=PC.getNeureJok();
		
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
            }
        }
		//aurkariaren taula
		for (int i=0;i<10;i++) {
            for (int j=0;j<10;j++) {
                aTableroa[i][j]=new JButton();
                aTableroa[i][j].setBounds((i+1)*50+600, (j+1)*50+30,50,50);
                getContentPane().add(aTableroa[i][j]);
            }   
        }
		
		//jokPC.ontziakKokatu();
		kolorea= nTableroa[0][0].getBackground();
	}
	
	public static Tableroa getNireTableroa() {
		if (neTableroa==null) {
			neTableroa=new Tableroa();
		}
		return neTableroa;
	}
	
	public static void tableroaIkusi() {
		Tableroa frame = Tableroa.getNireTableroa();
		frame.setVisible(true); //leihoa ikusteko
		frame.setDefaultCloseOperation(3); //Leihoa ixteko
		frame.setResizable(false); //leihoa handiagoa egiteko aukerarik ez
		frame.setSize(1200, 750); //leihoaren tamaina zehaztu
		frame.setTitle("Flota Urperatu");
		frame.setLocationRelativeTo(null); //pantailaren erdian jartzeko
	}

	private JButton getBtnNewButton() {
		if (botoia1 == null) {
			botoia1 = new JButton("Partida hasi");
			botoia1.addActionListener(new ActionListener() {  //klik egiten bada botoia jakinarazi
				public void actionPerformed(ActionEvent e) { //botoia klikatuz gero, gertatuko dena 
					botoia1.setVisible(false);
					biltegiButton.setVisible(true);
					flotaKokatuButton.setVisible(true);
					JOptionPane.showMessageDialog(botoia1, "Jokoa hasiko da");	//Mezua inprimatu
					jokoaHasi();
				}
			});
			flotaKokatuButton.addActionListener(new ActionListener() {  //klik egiten bada botoia jakinarazi
				@Override
				public void actionPerformed(ActionEvent e) {
					if (jok1.badagoKokatuGabekoOntzirik()) { //ontzi guztiak kokatuta ez dauden bitartean
						JOptionPane.showMessageDialog(flotaKokatuButton, "Ontzia kokatzeko momentua, zeure taulako gelaxka bat aukeratu. Bertan, ontzia kokatuko da.");
						neureTaulanOntziakKokatu();
		           } else {
		        	   JOptionPane.showMessageDialog(flotaKokatuButton, "Jada zure ontzi guztiak kokatuta daude");
		           }
				}
			});
		}
		return botoia1;
	}
	
	public void partidaJokatu() {
		tableroaIkusi();
	//	while () --> koloreak begiratu
		botoia1=null;
		JButton has=getBtnNewButton();
	}
		
	private void neureTaulanOntziakKokatu() {
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				nTableroa[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nMatrizekoXY(e);
	                    OntziaErabaki erabikitakoOntzi= OntziaErabaki.getNireOntziaErabaki();
	                    erabikitakoOntzi.setVisible(true);
	                    setVisible (false);
					}
	               });
			}
		}
	}
	
	private void jokoaHasi() {
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				nTableroa[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nMatrizekoXY (e);
					}
				});
				aTableroa[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						aMatrizekoXY (e);
					}
				});
			}
		}
	}
	private void aMatrizekoXY(ActionEvent e) {
		boolean aurkitu= false;
		int x=0;
		int y=0;
		while(x<=8 && y<=8 && aurkitu==false) {
			if(aTableroa[x][y]==e.getSource()) {
				aurkitu=true;
			}else{
				x++;
				if(x==9) {
					x=0;
					y++;
				}
			}
		}
		XTextField.setText(Integer.toString(x));
		YTextField.setText(Integer.toString(y));
        klikatutakoX=x;
        klikatutakoY=y; 
	}
	
	private void nMatrizekoXY(ActionEvent e) {
		boolean aurkitu= false;
		int x=0;
		int y=0;
		while(x<=8 && y<=8 && aurkitu==false) {
			if(nTableroa[x][y]==e.getSource()) {
				aurkitu=true;
			}else{
				x++;
				if(x==9) {
					x=0;
					y++;
				}
			}
		}
		XTextField.setText(Integer.toString(x));
		YTextField.setText(Integer.toString(y));
        klikatutakoX=x;
        klikatutakoY=y; 
	}

	
	public int getTablerotikOntziX(){
	// sakatutako x itzuli, beti ere geure tablerokoa bada eta honako hau ez bdago ontziz okupatuta
		return klikatutakoX;
	}
	
	
	public int getTablerotikOntziY(){
		return klikatutakoY;
	}

	@Override
	public void update(Observable o, Object arg) {
		Tablero tab =Tablero.getTablero();
        boolean[][] ura= tab.getUraDa();
        for (int i = 0; i <10; i++) {
            for (int j = 0; j < 10; j++) {
                nTableroa[i][j].setBackground(new Color(255,50,50));
                if (!ura[i][j]){
                        nTableroa[i][j].setBackground(new Color(255,50,50));
                }
            }
        }
	}
	
} 
