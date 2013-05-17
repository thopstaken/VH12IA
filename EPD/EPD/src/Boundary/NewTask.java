package Boundary;

import Control.TaskController;

import java.awt.Component;
import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;

import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

public class NewTask extends JFrame {
    private TaskController tc;
    private HashMap<String, String> hmEmployees;
    private HashMap<String, String> hmLocations;
    private JPanel pnlLoggedIn = new JPanel();
    private XYLayout xYLayout6 = new XYLayout();
    private JLabel lblLoggedIn = new JLabel();
    private JLabel lblUsername = new JLabel();
    private JLabel lblDateTime = new JLabel();
    private JButton btnLogout = new JButton();
    private JPanel pnlContent = new JPanel();
    private JTextField txtStartDateTime = new JTextField();
    private JTextField txtEndDateTime = new JTextField();
    private JTextArea txtDescription = new JTextArea();
    private JLabel lblDescription = new JLabel();
    private JLabel lblStartDateTime = new JLabel();
    private JLabel lblEndDateTime = new JLabel();
    private JLabel lblCategorie = new JLabel();
    private JLabel lblEmployee = new JLabel();
    private JLabel lblLocation = new JLabel();
    private DefaultListModel lmAvailableEmployees = new DefaultListModel();
    private DefaultListModel lmSelectedEmployees = new DefaultListModel();
    private JList listAvailableEmployees = new JList(lmAvailableEmployees);
    private JList listSelectedEmployees = new JList(lmSelectedEmployees);
    private JButton btnAddEmployee = new JButton();
    private JButton btnRemoveEmployee = new JButton();
    private JComboBox cbCategorie = new JComboBox();
    private JComboBox cbLocatie = new JComboBox();
    private JPanel pnlSecondary = new JPanel();
    private JButton btnAnnuleren = new JButton();
    private JButton btnSave = new JButton();

    public NewTask(TaskController tc) {
        
        this.tc = tc;
        
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        hmEmployees = tc.getAvailableEmployees();
        hmLocations = tc.getLocations();
        
        for (Map.Entry<String, String> entry : hmEmployees.entrySet())
        {
            lmAvailableEmployees.addElement(entry.getKey());
        }
        
        for (Map.Entry<String, String> entry : hmLocations.entrySet())
        {
            cbLocatie.addItem(entry.getKey());
        }
        
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(800, 600));
        pnlLoggedIn.setBounds(new Rectangle(0, 0, 800, 30));
        pnlLoggedIn.setLayout(xYLayout6);
        pnlContent.setLayout(xYLayout6);
        pnlSecondary.setLayout(xYLayout6);
        lblLoggedIn.setText("Ingelogd: ");
        lblUsername.setText("Username");
        lblDateTime.setText("01-01-2001  00:00");
        btnLogout.setText("Uitloggen");
        pnlContent.setBounds(new Rectangle(0, 30, 800, 470));
        lblDescription.setText("Omschrijving");
        lblStartDateTime.setText("Start datum  (dd-MM-yyyy hh:mm)");
        lblEndDateTime.setText("Eind datum  (dd-MM-yyyy hh:mm)");
        lblCategorie.setText("Categorie");
        lblEmployee.setText("Medewerkers");
        lblLocation.setText("Locatie");
        btnAddEmployee.setText(">");
        btnAddEmployee.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnAddEmployee_actionPerformed(e);
                }
            });
        btnRemoveEmployee.setText("<");
        btnRemoveEmployee.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnRemoveEmployee_actionPerformed(e);
                }
            });
        pnlSecondary.setBounds(new Rectangle(0, 500, 800, 80));
        btnAnnuleren.setText("Annuleren");
        btnSave.setText("Opslaan");
        
        pnlLoggedIn.add(lblDateTime, new XYConstraints(165, 10, 140, 15));
        pnlLoggedIn.add(lblLoggedIn, new XYConstraints(10, 10, 65, 15));
        pnlLoggedIn.add(lblUsername, new XYConstraints(65, 10, 80, 15));
        pnlLoggedIn.add(btnLogout, new XYConstraints(695, 5, 90, 20));
        pnlContent.add(cbLocatie, new XYConstraints(205, 365, 200, 20));
        pnlContent.add(cbCategorie, new XYConstraints(205, 220, 200, 20));
        pnlContent.add(btnRemoveEmployee, new XYConstraints(410, 310, 45, 20));
        pnlContent.add(btnAddEmployee, new XYConstraints(410, 270, 45, 20));
        pnlContent.add(listSelectedEmployees,
                       new XYConstraints(465, 250, 190, 105));
        pnlContent.add(listAvailableEmployees,
                       new XYConstraints(205, 250, 200, 105));
        pnlContent.add(lblLocation, new XYConstraints(15, 365, 45, 15));
        pnlContent.add(lblEmployee, new XYConstraints(10, 250, 130, 15));
        pnlContent.add(lblCategorie, new XYConstraints(10, 220, 100, 15));
        pnlContent.add(lblEndDateTime, new XYConstraints(10, 185, 200, 15));
        pnlContent.add(lblStartDateTime, new XYConstraints(10, 150, 180, 15));
        pnlContent.add(lblDescription, new XYConstraints(10, 45, 80, 35));
        pnlContent.add(txtDescription, new XYConstraints(205, 55, 200, 80));
        pnlContent.add(txtEndDateTime, new XYConstraints(205, 185, 200, 20));
        pnlContent.add(txtStartDateTime, new XYConstraints(205, 150, 200, 20));
        this.getContentPane().add(pnlContent, null);
        this.getContentPane().add(pnlLoggedIn, null);
        pnlSecondary.add(btnSave, new XYConstraints(655, 0, 130, 70));
        pnlSecondary.add(btnAnnuleren, new XYConstraints(10, 0, 130, 70));
        this.getContentPane().add(pnlSecondary, null);
    }

    private void btnAddEmployee_actionPerformed(ActionEvent e) {
        lmSelectedEmployees.addElement(listAvailableEmployees.getSelectedValue());
        lmAvailableEmployees.removeElement(listAvailableEmployees.getSelectedValue());
    }

    private void btnRemoveEmployee_actionPerformed(ActionEvent e) {
        lmAvailableEmployees.addElement(listSelectedEmployees.getSelectedValue());
        lmSelectedEmployees.removeElement(listSelectedEmployees.getSelectedValue());
    }
}
