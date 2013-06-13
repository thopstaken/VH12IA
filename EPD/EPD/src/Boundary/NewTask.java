package Boundary;

import Boundary.Common.MessageDialogInterface;
import Boundary.Common.Searchpanel;
import Boundary.Common.Userpanel;

import Control.TaskController;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

public class NewTask extends JFrame implements MessageDialogInterface {
    private TaskController tc;
    
    private Userpanel userP;
    private NewTaskPanel ntp;
    private TaskOverviewPanel top;  
    private TaskDetailPanel tdp;
    private XYLayout xYLayout6 = new XYLayout();
    
    private JPanel pnlSecondary = new JPanel();
    private JButton btnAnnuleren = new JButton();
    private JButton btnSave = new JButton();
    private JButton btnNew = new JButton();
    private JButton btnApprove = new JButton();
    private Searchpanel searchPanel = new Searchpanel();
    private TaskOverviewListener listener;


    public NewTask(TaskController tc) {
        
        this.tc = tc;
        ntp = new NewTaskPanel(tc);
        tdp = new TaskDetailPanel();
        top = new TaskOverviewPanel(tc, this);
        listener = new TaskOverviewListener();
        
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
        btnNew.setText("Nieuwe Opdracht");
        btnApprove.setText("Approve Task");
        
        btnNew.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnNew_actionPerformed(e);
                }
            });
        btnSave.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnSave_actionPerformed(e);
                }
            });
        btnAnnuleren.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnAnnuleren_actionPerformed(e);
                }
            });
        
        btnApprove.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                btnApprove_actionPerformed(e);
            }
        });
        this.getContentPane().add(userP, BorderLayout.NORTH);
        this.getContentPane().add(top, BorderLayout.CENTER);
        
       
        
        searchPanel.addSearchBar();

        pnlSecondary.add(searchPanel, new XYConstraints(285, 10, 800, 35));
        searchPanel.setSearchButtonListener(listener);

        pnlSecondary.add(btnNew, new XYConstraints(10, 0, 130, 70));
        
        //pnlSecondary.add(btnSave, new XYConstraints(655, 0, 130, 70));
        //pnlSecondary.add(btnAnnuleren, new XYConstraints(10, 0, 130, 70));
        this.getContentPane().add(pnlSecondary, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void btnNew_actionPerformed(ActionEvent e) {
        pnlSecondary.removeAll();
        this.getContentPane().remove(top);
        this.getContentPane().add(ntp, BorderLayout.CENTER);
        pnlSecondary.add(btnSave, new XYConstraints(655, 0, 130, 70));
        pnlSecondary.add(btnAnnuleren, new XYConstraints(10, 0, 130, 70));
        this.validate();
        this.repaint();
    }
    
    private void btnAnnuleren_actionPerformed(ActionEvent e) {
        pnlSecondary.removeAll();
        this.getContentPane().remove(ntp);
        this.getContentPane().remove(tdp);
        this.getContentPane().add(top, BorderLayout.CENTER);
        pnlSecondary.add(searchPanel, new XYConstraints(285, 10, 800, 35));
        pnlSecondary.add(btnNew, new XYConstraints(10, 0, 130, 70));
        this.validate();
        this.repaint();
    }

    public void openDetailScherm(int taskID) {
        pnlSecondary.removeAll();
        this.getContentPane().remove(top);
        this.getContentPane().add(tdp = new TaskDetailPanel(tc, taskID), BorderLayout.CENTER);
        pnlSecondary.add(btnAnnuleren, new XYConstraints(10, 0, 130, 70));
        
        btnApprove.setEnabled(true);
        //check if approved to enable/disable button
        if(tc.isTaskApproved(taskID))
        {
            btnApprove.setEnabled(false);
            
        }
        
        pnlSecondary.add(btnApprove, new XYConstraints(600,0,130,70));
        
        this.validate();
        this.repaint();
    }
    
    public void btnApprove_actionPerformed(ActionEvent e)
    {
           tdp.setApproved();
           btnApprove.setEnabled(false);
           
    }
    
    private void btnSave_actionPerformed(ActionEvent e) {
        boolean successful = ntp.newTask();
        
        if(successful){
            pnlSecondary.removeAll();
            this.getContentPane().remove(ntp);
            this.getContentPane().add(top, BorderLayout.CENTER);
            pnlSecondary.add(btnNew, new XYConstraints(10, 0, 130, 70));
            
            //reset velden als het aanmaken gelukt is
            ntp = new NewTaskPanel(tc);
            
            this.validate();
            this.repaint();
        }
    }

    public void showError(String title, String message) {
        JOptionPane.showMessageDialog(this,
            message,
            title,
            JOptionPane.ERROR_MESSAGE);
    }

    public void showWarning(String title, String message) {
        JOptionPane.showMessageDialog(this,
            message,
            title,
            JOptionPane.WARNING_MESSAGE);
    }

    public void showNotice(String title, String message) {
        JOptionPane.showMessageDialog(this,
            message,
            title,
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    class TaskOverviewListener implements ActionListener{

        public TaskOverviewListener(){
           
        }

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();           
              if (command.equals("Search")) {
                String search = searchPanel.getSearchTxtValue();
               top.updateTable( top.searchList(search));                
            }
        }

       


    }
    
    
    
}
