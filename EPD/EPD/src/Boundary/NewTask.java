package Boundary;

import Boundary.Common.Userpanel;

import Control.TaskController;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Date;
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
    
    private Userpanel userP;
    private NewTaskPanel ntp;
    
    private XYLayout xYLayout6 = new XYLayout();
    
    private JPanel pnlSecondary = new JPanel();
    private JButton btnAnnuleren = new JButton();
    private JButton btnSave = new JButton();

    public NewTask(TaskController tc) {
        
        this.tc = tc;
        ntp = new NewTaskPanel(tc);
        userP = new Userpanel("TestUser", new Date());
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(800, 600));
        pnlSecondary.setLayout(xYLayout6);
        
        pnlSecondary.setBounds(new Rectangle(0, 500, 800, 80));
        btnAnnuleren.setText("Annuleren");
        btnSave.setText("Opslaan");
        
        this.getContentPane().add(userP, BorderLayout.NORTH);
        this.getContentPane().add(ntp, BorderLayout.CENTER);
        
        pnlSecondary.add(btnSave, new XYConstraints(655, 0, 130, 70));
        pnlSecondary.add(btnAnnuleren, new XYConstraints(10, 0, 130, 70));
        this.getContentPane().add(pnlSecondary, BorderLayout.SOUTH);
    }
}
