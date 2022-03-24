package jokoa;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Leihoa extends JFrame implements ActionListener{
	
	JButton botoia1;		//jokoa hasteko
	JButton nTableroa[][];	//neure tableroa
	JButton aTableroa[][];	//jokalariaren tableroa
	//String jok1,jok2;
	//int turno=-1;
	JLabel mezua1;			// zein jokalariren txanda den adieraziko du mezu honek
	JLabel mezua2;
	Color kolorea;			
		
	public Leihoa() {
		this.setLayout(null); //elem kokapena gure menpe
		mezua1=new JLabel ("Zure tableroa");
		mezua1.setBounds(290,40,200,30); //pantailan non egongo da eta bere ezaugarriak
		this.add(mezua1);
		mezua2= new JLabel ("Aurkariaren tableroa");
		mezua2.setBounds(850,40,200,30); //pantailan non egongo da eta bere ezaugarriak
		this.add(mezua2);
		botoia1= new JButton("Partida hasi");
		botoia1.setBounds(550,650,150,30); //posizioax, posizioay, luzeera (tamaina x), zabalera (tamaina y)
		this.add(botoia1);
		botoia1.addActionListener(this); //klik egiten bada botoia jakinarazi
		nTableroa =new JButton[10][10];
		aTableroa= new JButton[10][10];
		//gure taula
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				nTableroa[i][j]=new JButton();
				nTableroa[i][j].setBounds((i+1)*50+40, (j+1)*50+30, 50, 50);
				this.add(nTableroa[i][j]);
				nTableroa[i][j].addActionListener(this);
			}
		}
		//aurkariaren taula
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				aTableroa[i][j]=new JButton();
				aTableroa[i][j].setBounds((i+1)*50+600, (j+1)*50+30,50,50);
				this.add(aTableroa[i][j]);
				aTableroa[i][j].addActionListener(this);
			}
		}
		kolorea= nTableroa[0][0].getBackground();
	}
	
	public static void main(String[] args) {
		Leihoa obj= new Leihoa();
		obj.setDefaultCloseOperation(3); //Leihoa ixteko
		obj.setResizable(false); //leihoa handiagoa egiteko aukerarik ez
		obj.setSize(1200,750); //leihoaren tamaina zehaztu
		obj.setTitle("Flota urperatu");
		obj.setLocationRelativeTo(null); //pantailaren erdian jartzeko
		obj.setVisible(true); //leihoa ikusteko
	}

	@Override
	public void actionPerformed(ActionEvent e) {	//botoia klikatuz gero, gertatuko dena
		// TODO Auto-generated method stub
		if (e.getSource()==botoia1)	{	//non klikatu den adierazten du (hau itzuliz) 
		
		}
		//} if ()
	}
}
