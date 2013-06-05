package Boundary;

import java.awt.Dimension;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import oracle.jdeveloper.layout.XYLayout;

public class LoginFrame extends JFrame {
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JButton jButton1 = new JButton();
    private JPanel jPanel1 = new JPanel();
    private XYLayout xYLayout1 = new XYLayout();

    public LoginFrame() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(400, 161));
        jLabel1.setText("Gebruikersnaam:");
        jLabel1.setBounds(new Rectangle(40, 35, 115, 15));
        jLabel2.setText("Wachtwoord:");
        jLabel2.setBounds(new Rectangle(40, 75, 85, 15));
        jTextField1.setBounds(new Rectangle(140, 30, 165, 20));
        jTextField2.setBounds(new Rectangle(140, 70, 165, 20));
        jButton1.setText("Inloggen");
        jButton1.setBounds(new Rectangle(220, 110, 85, 20));
        jPanel1.setBounds(new Rectangle(0, 0, 400, 140));
        jPanel1.setLayout(xYLayout1);
        this.getContentPane().add(jPanel1, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jTextField2, null);
        this.getContentPane().add(jTextField1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
    }
}
