package Boundary;

import Control.TaskController;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

public class NewTaskPanel extends JPanel {
    
    private TaskController tc;

    private HashMap<String, String> hmEmployees;
    private HashMap<String, String> hmLocations;
    
    private XYLayout xYLayout6 = new XYLayout();
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
    
    public NewTaskPanel(TaskController tc) {
        
        this.tc = tc;
        
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        hmEmployees = tc.getAvailableEmployees();
        hmLocations = tc.getLocations();
        for(String category : tc.getCategories()){
            cbCategorie.addItem(category);
        }
        
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
        this.setLayout( xYLayout6 );
        this.setBounds(new Rectangle(0, 30, 800, 470));
        this.add(cbLocatie, new XYConstraints(205, 365, 200, 20));
        this.add(cbCategorie, new XYConstraints(205, 220, 200, 20));
        this.add(btnRemoveEmployee, new XYConstraints(410, 310, 45, 20));
        this.add(btnAddEmployee, new XYConstraints(410, 270, 45, 20));
        this.add(listSelectedEmployees,
                       new XYConstraints(465, 250, 190, 105));
        this.add(listAvailableEmployees,
                       new XYConstraints(205, 250, 200, 105));
        this.add(lblLocation, new XYConstraints(15, 365, 45, 15));
        this.add(lblEmployee, new XYConstraints(10, 250, 130, 15));
        this.add(lblCategorie, new XYConstraints(10, 220, 100, 15));
        this.add(lblEndDateTime, new XYConstraints(10, 185, 200, 15));
        this.add(lblStartDateTime, new XYConstraints(10, 150, 195, 15));
        this.add(lblDescription, new XYConstraints(10, 45, 80, 35));
        this.add(txtDescription, new XYConstraints(205, 55, 450, 80));
        this.add(txtEndDateTime, new XYConstraints(205, 185, 200, 20));
        this.add(txtStartDateTime, new XYConstraints(205, 150, 200, 20));
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
