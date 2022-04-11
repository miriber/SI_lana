package bista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArmamentuaAukeratu extends JFrame {

    private JPanel contentPane;
    private JTextField txtAukeratuArma;
    private JRadioButton bonba,misila;
    private JButton okBotoia;

    
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

    public ArmamentuaAukeratu() {

        initialize();
    }
    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        txtAukeratuArma = new JTextField();
        txtAukeratuArma.setEditable(false);
        txtAukeratuArma.setText("Aukeratu Arma:");
        txtAukeratuArma.setBounds(143, 28, 116, 32);
        contentPane.add(txtAukeratuArma);
        txtAukeratuArma.setColumns(10);


        for (int i = 0; i < 2; i++) {

        }
        contentPane.add(getBtnNewButton(), BorderLayout.SOUTH);
    }

    private JButton getBtnNewButton() {
        if (okBotoia == null) {
            okBotoia = new JButton("ok");
            okBotoia.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
        }
        return okBotoia;
    }
}
