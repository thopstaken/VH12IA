package Boundary;

import Boundary.Common.Searchpanel;
import Boundary.Common.Userpanel;

import Control.PatientController;

import java.awt.BorderLayout;

import java.awt.Container;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PatientOverview extends JFrame{
    
    private JPanel mUserPanel;
    private Searchpanel  mSearchPanel;
    private Container mContentPane;
    private JTable mUserTable;
    private DefaultTableModel mTableModel;
    private String mUsername;
    private Date mLoginTime;
    
    //data
    private Object[][] mDataList;
    //controllers
    private PatientController mPatientControl;
    //actionlisteners
    private PatientOverviewListener mListener;
    
    public PatientOverview(String username, Date loginTime, PatientController patientControl) {
        super("Patiënten Overzicht");
        
        mUsername = username;
        mLoginTime = loginTime;
        mPatientControl = patientControl;
        mDataList = mPatientControl.getPatientList();
        mListener = new PatientOverviewListener();
        init();
                
    }
    
    private void init() {
        mContentPane = this.getContentPane();
        this.setSize(800, 600);
       
       // Add Top user panel
        mUserPanel = new Userpanel(mUsername, mLoginTime);
        mContentPane.add(mUserPanel, BorderLayout.NORTH);
        
        // Add center content
        mUserTable = new JTable();
        String[] tableHeaders = {"Patiëntnummer", "Achternaam", "Voornaam", "Afdeling", "Geboortedatum", "Geslacht", "Opnamedatum", "Arts"};
        //Object[][] data = new Object[][]{};
       
        mTableModel = new DefaultTableModel(mDataList, tableHeaders);
        mUserTable.setModel(mTableModel);
        
        JScrollPane scrollPane = new JScrollPane(mUserTable);
        mContentPane.add(scrollPane, BorderLayout.CENTER);
        
        // Add search panel
        mSearchPanel = new Searchpanel();
        mSearchPanel.addSearchBar();
        mSearchPanel.addFilter();
        mSearchPanel.addIntakeButton();
        mSearchPanel.setIntakeButtonListener(mListener);
        mContentPane.add(mSearchPanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    class PatientOverviewListener implements ActionListener{

        public PatientOverviewListener(){
            
        }

        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("IntakeFormBtn")){
                new IntakeForm();
            }
        }
        
    }
}
