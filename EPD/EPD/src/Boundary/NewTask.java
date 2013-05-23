package Boundary;

import Control.TaskController;

import java.awt.Component;
import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

public class NewTask extends JFrame {
    private TaskController tc;
    
    private NewTaskPanel ntp;
    
    private JPanel pnlLoggedIn = new JPanel();
    private XYLayout xYLayout6 = new XYLayout();
    private JLabel lblLoggedIn = new JLabel();
    private JLabel lblUsername = new JLabel();
    private JLabel lblDateTime = new JLabel();
    private JButton btnLogout = new JButton();
    
    private JPanel pnlSecondary = new JPanel();
    private JButton btnAnnuleren = new JButton();
    private JButton btnSave = new JButton();

    public NewTask(TaskController tc) {
        
        this.tc = tc;
        ntp = new NewTaskPanel(tc);
        
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
        pnlSecondary.setLayout(xYLayout6);
        lblLoggedIn.setText("Ingelogd: ");
        lblUsername.setText("Username");
        lblDateTime.setText("01-01-2001  00:00");
        btnLogout.setText("Uitloggen");
        pnlSecondary.setBounds(new Rectangle(0, 500, 800, 80));
        btnAnnuleren.setText("Annuleren");
        btnSave.setText("Opslaan");

        pnlLoggedIn.add(lblDateTime, new XYConstraints(165, 10, 140, 15));
        pnlLoggedIn.add(lblLoggedIn, new XYConstraints(10, 10, 65, 15));
        pnlLoggedIn.add(lblUsername, new XYConstraints(65, 10, 80, 15));
        pnlLoggedIn.add(btnLogout, new XYConstraints(695, 5, 90, 20));
        
        this.getContentPane().add(ntp);
        this.getContentPane().add(pnlLoggedIn, null);
        pnlSecondary.add(btnSave, new XYConstraints(655, 0, 130, 70));
        pnlSecondary.add(btnAnnuleren, new XYConstraints(10, 0, 130, 70));
        this.getContentPane().add(pnlSecondary, null);
    }
}
