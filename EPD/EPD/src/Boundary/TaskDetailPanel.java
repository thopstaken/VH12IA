package Boundary;

import Control.TaskController;

import Entity.Employee;
import Entity.LabTask;
import Entity.Patient;
import Entity.Task;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
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

public class TaskDetailPanel extends JPanel {
    
    private TaskController tc;

   // private HashMap<Integer, String> hmEmployees;
    ArrayList<Employee> empList;
    ArrayList<Employee> chosenEmp = new ArrayList<Employee>();
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
    private JTextField txtCategorie = new JTextField();
    private JTextField txtLocation = new JTextField();

    public TaskDetailPanel(TaskController tc) {
        
        this.tc = tc;
        
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //hmEmployees = tc.getAvailableEmployees();
        empList = tc.getAvailableEmployees();
        //hmLocations = tc.getLocations();
        for(Task.Category category : tc.getCategories()){
           // cbCategorie.addItem(category);
        }
        
        /*for (Map.Entry<Integer, String> entry : hmEmployees.entrySet())
        {
            lmAvailableEmployees.addElement(entry.getValue());
        }*/
        
        for(int i = 0; empList.size() >i; i++)
        {
            lmAvailableEmployees.add(i, empList.get(i).getName());
        }
    }

    private void jbInit() throws Exception {
        
        lblDescription.setText("Omschrijving");
        lblStartDateTime.setText("Start datum  (dd-MM-yyyy hh:mm)");
        lblEndDateTime.setText("Eind datum  (dd-MM-yyyy hh:mm)");
        lblCategorie.setText("Categorie");
        lblEmployee.setText("Medewerkers");
        lblLocation.setText("Locatie");

        txtCategorie.setEditable(false);
        txtLocation.setEditable(false);
        this.setLayout( xYLayout6 );
        this.setBounds(new Rectangle(0, 30, 800, 470));
        txtStartDateTime.setEditable(false);
        txtEndDateTime.setEditable(false);
        txtDescription.setEditable(false);
        this.add(txtLocation, new XYConstraints(200, 365, 205, 20));
        this.add(txtCategorie, new XYConstraints(205, 215, 200, 20));
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
        int empIndex = listAvailableEmployees.getSelectedIndex();
        chosenEmp.add(empList.get(empIndex));
        empList.remove(empIndex);
        lmAvailableEmployees.removeElement(listAvailableEmployees.getSelectedValue());
    }

    private void btnRemoveEmployee_actionPerformed(ActionEvent e) {
      //  lmAvailableEmployees.addElement(listSelectedEmployees.getSelectedValue());
      //  int empIndex = listSelectedEmployees.getSelectedIndex();
      //  empList.add(chosenEmp.get(empIndex));
        //chosenEmp.remove(empIndex);
      //  lmSelectedEmployees.removeElement(listSelectedEmployees.getSelectedValue());
    }
    
    public void newTask()
    {
        String notes = txtDescription.getText();
        String startDate = txtStartDateTime.getText();
        String endDate = txtEndDateTime.getText();
       // Task.Category category = Task.Category.valueOf(cbCategorie.getSelectedItem().toString());
        ArrayList<LabTask> labTasks = new ArrayList<LabTask>();
        Patient patient = new Patient();
        
        //tc.createTask(-1, notes , false, true, startDate , endDate , category  , chosenEmp, labTasks , patient);    
    }
    
}
