package Boundary;

import Control.LoginController;

import Entity.UserLoginService;

import Entity.JAXWS.Users;

import Entity.LoginStatus;

import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

public class LoginFrame extends JDialog {
    
    LoginController lc;

    private JPanel jPanel1 = new JPanel();
    private XYLayout xYLayout1 = new XYLayout();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JButton jButton1 = new JButton();

    public LoginFrame(LoginController lc) {
        
        this.lc = lc;
        
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setModal(true);
        this.setSize(new Dimension(400, 174));
        jPanel1.setLayout(xYLayout1);
        jLabel1.setText("Gebruikersnam:");
        jLabel2.setText("Wachtwoord:");
        jButton1.setText("Inloggen");
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jPanel1.add(jButton1, new XYConstraints(240, 115, 90, 20));
        jPanel1.add(jTextField2, new XYConstraints(170, 65, 160, 20));
        jPanel1.add(jTextField1, new XYConstraints(170, 35, 160, 20));
        jPanel1.add(jLabel2, new XYConstraints(50, 65, 90, 15));
        jPanel1.add(jLabel1, new XYConstraints(50, 35, 115, 15));
        this.getContentPane().add(jPanel1, null);
    }

    private void jButton1_actionPerformed(ActionEvent e) {
        
        try
        {     
            Users result = lc.checkLogin(jTextField1.getText(), jTextField2.getText());
            
            if (result.getUserId() != null || result.getUserId().intValue() >= 0) 
            {
                
                LoginStatus login = LoginStatus.getInstance();
                login.updateUserInfo(result);
                System.out.println("Ingelogd met gebruikers ID:" + login.giveUserInfo().getUserId());
                this.dispose();
            }
            else 
            {
                System.err.println("Inloggen niet gelukt");
                dispose();
            }
        }
        catch (Exception ex) 
        {
            System.err.println("Fatale fout bij inloggen. De volgende fout werd gegeven");
            System.err.println(ex.getMessage());
            dispose();
        }

    }
}
