package Boundary;

import Boundary.Common.Searchpanel;
import Boundary.Common.Userpanel;

import Control.GUIController;
import Control.PatientController;

import java.awt.BorderLayout;

import java.awt.Container;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
    private GUIController mGuiControl;
    //actionlisteners
    private PatientOverviewListener mListener;
    
    public PatientOverview(String username, Date loginTime, GUIController guiControl) {
        super("PatiŽnten Overzicht");
        
        mUsername = username;
        mLoginTime = loginTime;
        mGuiControl = guiControl;

        mDataList = mGuiControl.getPatientList(); // DEZE  WEER TERUGZETTEN VOOR DATABASE CONNECTIE!

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
        String[] tableHeaders = {"PatiŽntnummer", "Achternaam", "Voornaam", "Afdeling", "Geboortedatum", "Geslacht", "Opnamedatum", "Arts"};      
       
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
    
  
    class PatientOverviewListener implements ActionListener, MouseListener, KeyListener{

        public PatientOverviewListener(){
            
        }

        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("IntakeFormBtn")){
                new IntakeForm(mGuiControl);
            }
        }

        public void mouseClicked(MouseEvent e) {
           
            if(e.getSource() == mUserTable) {
                if(e.getClickCount() > 2) {
                    int row = mUserTable.getSelectedRow();
                    int id = Integer.parseInt(mUserTable.getValueAt(row, 0).toString());
                    
                }
            }
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
        }
    }
}
