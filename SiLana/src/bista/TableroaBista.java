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

import jokoa.Egoera;
import jokoa.Flota;
import jokoa.Jokalari;
import jokoa.Pertsona;
import jokoa.Jokoa;
import jokoa.PC;
import jokoa.Tablero;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


public class TableroaBista extends JFrame implements Observer {

	private JPanel contentPane;
	private JButton botoia1;		//jokoa hasteko
	private JButton nTableroa[][];	//jokalariaren tableroa
	private JButton aTableroa[][];	//aurkariaren tableroa
	private Jokalari jokPertsona, jokPC;
	private JLabel mezua1;			// zein jokalariren txanda den adieraziko du mezu honek
	private JLabel mezua2;
	private boolean tiroMomentua=false;
	private JButton aleatoriokiButton, biltegiButton, flotaKokatuButton, tiroButton;
	private int klikatutakoX, klikatutakoY;
	private static TableroaBista neTableroa= null;
	
	
	
	public static void main(String[] args) {
		System.out.println("tableroa --> main");
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
	
	public static TableroaBista getNireTableroa() {
		System.out.println("tableroa --> getNireTableroa");
		if (neTableroa==null) {
			neTableroa=new TableroaBista();
		}
		return neTableroa;
	}
	    
	private TableroaBista() {
		//Jokalari1.getNeureJok().getNeureTablero().addObserver(this);
		//PC.getNeureJok().getNeureTablero().addObserver(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		aleatoriokiButton = new JButton("Aleatorio jarri");
		contentPane.add(aleatoriokiButton);
		aleatoriokiButton.setBounds(500, 600, 150, 50);
		aleatoriokiButton.setVisible(false);
				
		biltegiButton = new JButton("Biltegia");
        contentPane.add(biltegiButton);              //Biltegiaren botoia
        biltegiButton.setBounds(50, 600, 150, 50);
        biltegiButton.setVisible(false);
        
        flotaKokatuButton = new JButton("FlotaKokatu");
        contentPane.add(flotaKokatuButton);
        flotaKokatuButton.setBounds(250, 600, 150, 50);
        flotaKokatuButton.setVisible(false);
        
        tiroButton = new JButton("TiroEgin");
        contentPane.add(tiroButton);
        tiroButton.setBounds(250, 600, 150, 50);
        tiroButton.setVisible(false);
        
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
		
		jokPertsona=Pertsona.getNeureJok();
		jokPC=PC.getNeureJok();
		
		jokPertsona.getNeureTablero().addObserver(this);
		jokPC.getNeureTablero().addObserver(this);
		
		
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
	}
	
	public static void tableroaIkusi() {
		System.out.println("tableroa --> tableroaIkusi");
		TableroaBista frame = TableroaBista.getNireTableroa();
		frame.setVisible(true); //leihoa ikusteko
		frame.setDefaultCloseOperation(3); //Leihoa ixteko
		frame.setResizable(false); //leihoa handiagoa egiteko aukerarik ez
		frame.setSize(1200, 750); //leihoaren tamaina zehaztu
		frame.setTitle("Flota Urperatu");
		frame.setLocationRelativeTo(null); //pantailaren erdian jartzeko
	}

	private JButton getBtnNewButton() {
		System.out.println("tableroa --> getBtnNewButton");
		if (botoia1 == null) {
			botoia1 = new JButton("Partida hasi");
			botoia1.addActionListener(new ActionListener() {  //klik egiten bada botoia jakinarazi
				public void actionPerformed(ActionEvent e) { //botoia klikatuz gero, gertatuko dena 
					botoia1.setVisible(false);
					biltegiButton.setVisible(true);
					aleatoriokiButton.setVisible(true);
					flotaKokatuButton.setVisible(true);
					JOptionPane.showMessageDialog(botoia1, "Jokoa hasiko da");	//Mezua inprimatu
					jokoaHasi(); //TODO HAU BEHARREZKOA?
				}
			});
			biltegiButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					ArmamentuaAukeratu arm = ArmamentuaAukeratu.getNireArmamentua(true);
					arm.eguneratuLista(true);
                    arm.setVisible(true);
                    setVisible (false);
				}
			});
			aleatoriokiButton.addActionListener(new ActionListener (){
				public void actionPerformed (ActionEvent e) {
					jokPertsona.aleatorioOntziakKokatu();
					aleatoriokiButton.setVisible(false);
					flotaKokatuButton.setVisible(false);
					partidaJokatu();
				}
			});
			flotaKokatuButton.addActionListener(new ActionListener() {  //klik egiten bada botoia jakinarazi
				@Override
				public void actionPerformed(ActionEvent e) {
					nMatrizekoXY(e, true);
					aMatrizekoXY(e, false);
					JOptionPane.showMessageDialog(flotaKokatuButton, "Ontzia kokatzeko momentua, zeure taulako gelaxka bat aukeratu. Bertan, ontzia kokatuko da.");
					neureTaulanOntziakKokatu();
					flotaKokatuButton.setVisible(false);
					aleatoriokiButton.setVisible(false);
					partidaJokatu();
				}
			});
			tiroButton.addActionListener(new ActionListener() {  //klik egiten bada botoia jakinarazi
				@Override
				public void actionPerformed(ActionEvent e) {
					tiroMomentua=true;
					aMatrizekoXY(e, true);
					//TODO--> ALDATU RADAR DENEAN??
					nMatrizekoXY(e, false);
					Jokoa jok= Jokoa.getNireJoko();
					//JOptionPane.showMessageDialog(tiroButton, "Tiro egiteko gelaxka bat aukeratu.");
					System.out.println("/////jokPertsona//////"+jokPertsona.badagoKokatuGabekoOntzirik());
					System.out.println("/////jokPC//////"+jokPC.badagoKokatuGabekoOntzirik());
					if (jok.PCTxandaDa()) {
						PC.getNeureJok().tiroEgin();
					}else {
						aurkariTaulanOntziakAurkitu();
					}
					tiroButton.setVisible(false);
					//} else {
					//	ArmamentuaAukeratu arm= ArmamentuaAukeratu.getNireArmamentua();
					//arm.setVisible(true);
				//	setVisible(false);
				//	}
					
					/*boolean jokPCBuk=jokPertsona.jokalariBatenOntziGuztiakAurkitu();
					boolean jokPertsonaBuk= jokPC.jokalariBatenOntziGuztiakAurkitu();
					//TODO hau jokoan egiten da
					while (!jokPCBuk && !jokPertsonaBuk) {
						jokPertsona.
					}
					tiroButton.setVisible(false);*/
				}
			});
		}
		return botoia1;
	}
	
	public void partidaJokatu() {
		System.out.println("tableroa --> partidaJokatu");
		if (!jokPertsona.badagoKokatuGabekoOntzirik()) {
			tiroButton.setVisible(true);
			klikatutakoX = -1;
			klikatutakoY = -1;
		}
		tableroaIkusi();
	//	while () --> koloreak begiratu
		botoia1 = null;
		JButton has = getBtnNewButton();
	}
		
	private void neureTaulanOntziakKokatu() {
		System.out.println("tableroa --> neureTaulanOntziaKokatu");
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				nTableroa[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					//	while (jokPertsona.badagoKokatuGabekoOntzirik()) {
							nMatrizekoXY(e, true);
							aMatrizekoXY(e, false);
		                    OntziaErabaki erabikitakoOntzi= OntziaErabaki.getNireOntziaErabaki();
		                    erabikitakoOntzi.eguneratuLista();
		                    erabikitakoOntzi.setVisible(true);
						//}
	                    setVisible (false);
					}
				});
			}
		}
	}
	
	private void aurkariTaulanOntziakAurkitu() {
		System.out.println("tableroa --> aurkariTaulanOntziakAurkitu");
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				aTableroa[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//aMatrizekoXY(e);
						if(tiroMomentua==true) {
							ArmamentuaAukeratu arm= ArmamentuaAukeratu.getNireArmamentua(false);
		                    arm.eguneratuLista(false);
		                    arm.setVisible(true);
		                    setVisible (false);
		                    tiroMomentua=false;
						}
	                    
					} 
				});
			}
		}
	}
	
	private void jokoaHasi() {
		System.out.println("tableroa --> jokoaHasi");
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				nTableroa[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nMatrizekoXY (e, true);
						aMatrizekoXY(e, false);
					}
				});
				aTableroa[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						aMatrizekoXY (e, true);
						nMatrizekoXY(e, false);
					}
				});
			}
		}
	}
	private void aMatrizekoXY(ActionEvent e, boolean ukitu) {
		System.out.println("tableroa --> aMatrizekoXY");
		if (!jokPertsona.badagoKokatuGabekoOntzirik() && !Jokoa.getNireJoko().PCTxandaDa()) {
			boolean aurkitu= false;
			int x=-1, y=-1;
			int i=0,j=0;
			while(i<10 && j<10 && !aurkitu && ukitu) {
				if(aTableroa[i][j]==e.getSource()) {
					aurkitu=true;
					x = i;
					y = j;
				} else {
					if(i==9) {
						i = 0;
						j++;
					}else {
						i++;
					}
				}
			}
			if(!ukitu) {
				//TODO INTERFACE
				System.out.println("Tablero hau ukitzeko garaia ez da orain");
			}
			matrizekoXY(aurkitu, x,y);
		}
		
	}
	
	private void matrizekoXY (boolean aurkitu, int x, int y) {
		/*if (!aurkitu) {
			XTextField.setText("");
			YTextField.setText("");
		} else {
			XTextField.setText(Integer.toString(x));
			YTextField.setText(Integer.toString(y));*/
		if (aurkitu) {
	        klikatutakoX=x;
	        klikatutakoY=y; 
		}
	}
	
	private void nMatrizekoXY(ActionEvent e, boolean ukitu) {
		System.out.println("tableroa --> nMatrizekoXY");
		boolean aurkitu= false;
		int x=-1, y=-1;
		int i=0, j=0;
		if (jokPertsona.badagoKokatuGabekoOntzirik() && ukitu) {
			while(i<10 && j<10 && !aurkitu) {
				System.out.println(i+"nMATR"+j);
				if(nTableroa[i][j]==e.getSource()) {
					aurkitu=true;
					x = i;
					y = j;
				} else {
					if(i==9) {
						i = 0;
						j++;
					}else{
						i++;
					}
				}
			}
			matrizekoXY(aurkitu, x,y);
		}
		if (!ukitu) {
			System.out.println("Tablero hau ez da ukitu beharrekoa");
			//TODO INTERFACE EGIN
		}
			//JokalariPC.
		//}
			//TODO mezua: jada ontzi guztiak jarri dira
	}

	
	public int getTablerotikOntziX(){
		System.out.println("tableroa --> getTablerotikOntziX");
		System.out.println(klikatutakoX);
		// sakatutako x itzuli, beti ere geure tablerokoa bada eta honako hau ez bdago ontziz okupatuta
		return klikatutakoX;
	}
	
	
	public int getTablerotikOntziY(){
		System.out.println("tableroa --> getTablerotikOntziY");
		System.out.println(klikatutakoY);
		return klikatutakoY;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("tableroa --> update");
		Tablero tab;
		boolean[][] ura;
		boolean txandaPC = Jokoa.getNireJoko().PCTxandaDa();
		System.out.println("tableroa --> update --> TXANDA: " + txandaPC);
		System.out.println("tableroa --> update --> Jokoa.getNireJoko().getOntziakKokatzen(): " + jokPertsona.badagoKokatuGabekoOntzirik());
		if (jokPertsona.badagoKokatuGabekoOntzirik()) {
			tab = jokPertsona.getNeureTablero();
			ura= tab.getUraDa();
			for (int i = 0; i <10; i++) {
	            for (int j = 0; j < 10; j++) {
	            	if (!ura[i][j]) {
	            		nTableroa[i][j].setBackground(Color.BLACK);
	            	}
	            }
	        }
		} else {
			if (txandaPC) {
				tab = jokPertsona.getNeureTablero();
			} else {
				tab = jokPC.getNeureTablero();
			}
			ura = tab.getUraDa();
			JButton[][] unekoTab = getUnekoTiroTableroa(txandaPC);
			for (int i = 0; i <10; i++) {
	            for (int j = 0; j < 10; j++) {
	            	if(tab.begistatuDA(i, j)) {
	            		if(tab.getOntzia(i, j)!=null) {
	            			unekoTab[i][j].setBackground(Color.green);
	            		}
	            	}
	            	if (tab.tiroJasoDu(i, j)) {
	            		if (ura[i][j]){
	            			unekoTab[i][j].setBackground(Color.BLUE);
	            		} else {
	            			if (tab.getOntzia(i, j).getEgoera(Egoera.HONDORATUTA)) {
	            				unekoTab[i][j].setBackground(Color.RED);
	            			} else {
	            				unekoTab[i][j].setBackground(Color.ORANGE);
	            			}
	            			
	            		}
	            	}
	            }
	        }	
			Jokoa.getNireJoko().txandaAldatu();
		}
	}

	private JButton[][] getUnekoTiroTableroa(boolean txanda) {
		JButton[][] tab;
		if (txanda) {
			tab = nTableroa;
		} else {
			tab = aTableroa;
		}
		return tab;
	}
	
} 
