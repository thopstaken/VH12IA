package Boundary;

import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JList jList1 = new JList();
    private JList jList2 = new JList();
    private JList listAvailableEmployees = new JList();
    private JList listSelectedEmployees = new JList();
    private JButton btnAddEmployee = new JButton();
    private JButton btnRemoveEmployee = new JButton();
    private JComboBox cbCategorie = new JComboBox();
    private JComboBox cbLocatie = new JComboBox();

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
        pnlContent.setLayout(xYLayout6);
        lblLoggedIn.setText("Ingelogd: ");
        lblUsername.setText("Username");
        lblDateTime.setText("01-01-2001  00:00");
        btnLogout.setText("Uitloggen");
        pnlContent.setBounds(new Rectangle(0, 30, 800, 470));
        lblDescription.setText("Omschrijving");
        lblStartDateTime.setText("Start datum");
        lblEndDateTime.setText("Eind datum");
        lblCategorie.setText("Categorie");
        lblEmployee.setText("Medewerkers");
        lblLocation.setText("Locatie");
        btnAddEmployee.setText("jButton1");
        btnRemoveEmployee.setText("jButton2");
        pnlLoggedIn.add(lblDateTime, new XYConstraints(165, 10, 140, 15));
        pnlLoggedIn.add(lblLoggedIn, new XYConstraints(10, 10, 65, 15));
        pnlLoggedIn.add(lblUsername, new XYConstraints(65, 10, 80, 15));
        pnlLoggedIn.add(btnLogout, new XYConstraints(695, 5, 90, 20));
        pnlContent.add(cbLocatie, new XYConstraints(165, 365, 155, 20));
        pnlContent.add(cbCategorie, new XYConstraints(165, 220, 155, 20));
        pnlContent.add(btnRemoveEmployee, new XYConstraints(370, 310, 20, 20));
        pnlContent.add(btnAddEmployee, new XYConstraints(370, 270, 20, 20));
        pnlContent.add(listSelectedEmployees, new XYConstraints(400, 250, 190, 105));
        pnlContent.add(listAvailableEmployees, new XYConstraints(165, 250, 200, 105));
        pnlContent.add(jList2, new XYConstraints(165, 250, 195, 105));
        pnlContent.add(jList1, new XYConstraints(165, 250, 195, 105));
        pnlContent.add(lblLocation, new XYConstraints(15, 365, 45, 15));
        pnlContent.add(lblEmployee, new XYConstraints(10, 250, 130, 15));
        pnlContent.add(lblCategorie, new XYConstraints(10, 220, 100, 15));
        pnlContent.add(lblEndDateTime, new XYConstraints(10, 185, 115, 15));
        pnlContent.add(lblStartDateTime, new XYConstraints(10, 150, 75, 15));
        pnlContent.add(lblDescription, new XYConstraints(10, 45, 80, 35));
        pnlContent.add(txtDescription, new XYConstraints(165, 55, 200, 80));
        pnlContent.add(txtEndDateTime, new XYConstraints(165, 185, 95, 20));
        pnlContent.add(txtStartDateTime, new XYConstraints(165, 150, 95, 20));
        this.getContentPane().add(pnlContent, null);
        this.getContentPane().add(pnlLoggedIn, null);
    }
}
