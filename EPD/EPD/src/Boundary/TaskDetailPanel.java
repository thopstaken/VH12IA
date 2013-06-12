package Boundary;

import Control.TaskController;

import Entity.Employee;
import Entity.LabTask;
import Entity.Patient;
import Entity.Task;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.ListModel;

import javax.swing.table.DefaultTableModel;

import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

public class TaskDetailPanel extends JPanel {

    private TaskController tc;
    private ArrayList<Employee> empList;
    private XYLayout xYLayout6 = new XYLayout();
    private JTextField txtStartDateTime = new JTextField();
    private JTextField txtEndDateTime = new JTextField();
    private JTextArea txtDescription = new JTextArea();
    private JCheckBox chkbApproved = new JCheckBox();
    private JLabel lblDescription = new JLabel();
    private JLabel lblStartDateTime = new JLabel();
    private JLabel lblEndDateTime = new JLabel();
    private JLabel lblCategorie = new JLabel();
    private JLabel lblEmployee = new JLabel();
    private JLabel lblApproved = new JLabel();
    private DefaultListModel lmAvailableEmployees = new DefaultListModel();
    private JList listAvailableEmployees = new JList(lmAvailableEmployees);
    private JTextField txtCategorie = new JTextField();
    private Task task;

    public TaskDetailPanel(TaskController tc, int taskID) {

        this.tc = tc;
        task = tc.getTask(taskID);
        //task.setApproved(true);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    
    private void jbInit() throws Exception {

        lblDescription.setText("Omschrijving");
        lblStartDateTime.setText("Start datum  (dd-MM-yyyy hh:mm)");
        lblEndDateTime.setText("Eind datum  (dd-MM-yyyy hh:mm)");
        lblCategorie.setText("Categorie");
        lblEmployee.setText("Medewerkers");
        lblApproved.setText("Approved");


        txtCategorie.setEditable(false);
        chkbApproved.setEnabled(false);
        
        if(task.isApproved())
        {
            chkbApproved.setSelected(true);
        }
        
        chkbApproved.setSize(20, 20);


        this.setLayout(xYLayout6);
        this.setBounds(new Rectangle(0, 30, 800, 470));
        txtStartDateTime.setEditable(false);
        txtEndDateTime.setEditable(false);
        txtDescription.setEditable(false);

        this.add(txtCategorie, new XYConstraints(205, 215, 200, 20));
        this.add(listAvailableEmployees,
                 new XYConstraints(205, 250, 200, 105));

        this.add(lblEmployee, new XYConstraints(10, 250, 130, 15));
        this.add(lblCategorie, new XYConstraints(10, 220, 100, 15));
        this.add(lblEndDateTime, new XYConstraints(10, 185, 200, 15));
        this.add(lblStartDateTime, new XYConstraints(10, 150, 195, 15));
        this.add(lblDescription, new XYConstraints(10, 45, 80, 35));
        this.add(txtDescription, new XYConstraints(205, 55, 450, 80));
        this.add(txtEndDateTime, new XYConstraints(205, 185, 200, 20));
        this.add(txtStartDateTime, new XYConstraints(205, 150, 200, 20));
        this.add(lblApproved, new XYConstraints(10, 365, 500, 10));
        this.add(chkbApproved, new XYConstraints(205, 365, 500, 10));
        fillFields();

    }

    private void fillFields() {


        txtCategorie.setText(task.getCategory().toString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        txtStartDateTime.setText(sdf.format(task.getStartDateTime().getTime()));
        txtEndDateTime.setText(sdf.format(task.getEndDateTime().getTime()));
        txtDescription.setText(task.getNotes().toString());
        ArrayList<Employee> empList = task.getWorkingEmployeeList();

        DefaultListModel model =
            (DefaultListModel)listAvailableEmployees.getModel();

        for (Employee emp : empList) {
            model.addElement(emp.getName().toString());


        }

    }


    public void newTask() {
        String notes = txtDescription.getText();
        String startDate = txtStartDateTime.getText();
        String endDate = txtEndDateTime.getText();
        // Task.Category category = Task.Category.valueOf(cbCategorie.getSelectedItem().toString());
        ArrayList<LabTask> labTasks = new ArrayList<LabTask>();
        Patient patient = new Patient();

        //tc.createTask(-1, notes , false, true, startDate , endDate , category  , chosenEmp, labTasks , patient);
    }
    
    public void setApproved()
    {
        chkbApproved.setSelected(true);
        tc.setTaskApproved(task.getTaskId());    
    }

}
