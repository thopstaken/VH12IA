package Boundary;

import java.awt.Dimension;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

public class NewTask extends JFrame {
    private JPanel pnlLoggedIn = new JPanel();
    private XYLayout xYLayout6 = new XYLayout();
    private JLabel lblLoggedIn = new JLabel();
    private JLabel lblUsername = new JLabel();
    private JLabel lblDateTime = new JLabel();
    private JButton btnLogout = new JButton();

    public NewTask() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(800, 600));
        pnlLoggedIn.setBounds(new Rectangle(0, 0, 800, 30));
        pnlLoggedIn.setLayout(xYLayout6);
        lblLoggedIn.setText("Ingelogd: ");
        lblUsername.setText("Username");
        lblDateTime.setText("01-01-2001  00:00");
        btnLogout.setText("Uitloggen");
        pnlLoggedIn.add(lblDateTime, new XYConstraints(165, 10, 140, 15));
        pnlLoggedIn.add(lblLoggedIn, new XYConstraints(10, 10, 65, 15));
        pnlLoggedIn.add(lblUsername, new XYConstraints(65, 10, 80, 15));
        pnlLoggedIn.add(btnLogout, new XYConstraints(695, 5, 90, 20));
        this.getContentPane().add(pnlLoggedIn, null);
    }
}
