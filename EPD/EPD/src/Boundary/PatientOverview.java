package Boundary;

import Boundary.Common.Searchpanel;
import Boundary.Common.Userpanel;

import Control.GUIController;
import Control.PatientController;

import Entity.Patient;

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

public class PatientOverview extends JFrame implements MouseListener, KeyListener{
    
    private JPanel mUserPanel;
    private Searchpanel  mSearchPanel;
    private Container mContentPane;
    private JTable mUserTable;
    private static DefaultTableModel mTableModel;
    private String mUsername;
    private Date mLoginTime;
    
    private String[] tableHeaders = {"Patiëntnummer", "Achternaam", "Voornaam", "Afdeling", "Geboortedatum", "Geslacht", "Opnamedatum", "Arts"};
    
    //data
    private Object[][] mDataList;
    //controllers
    private GUIController mGuiControl;
    //actionlisteners
    private PatientOverviewListener mListener;
    
    public PatientOverview(String username, Date loginTime, GUIController guiControl) {
        super("Patiënten Overzicht");
       
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
       
        mTableModel = new DefaultTableModel(mDataList, tableHeaders)
            {
                @Override
                    public boolean isCellEditable(int row, int column) {
                       //all cells false
                       return false;
                    }
            };
        mUserTable.setModel(mTableModel);
        mUserTable.addMouseListener(this);
        mUserTable.addKeyListener(this);
        JScrollPane scrollPane = new JScrollPane(mUserTable);
        mContentPane.add(scrollPane, BorderLayout.CENTER);
        
        // Add search panel
        mSearchPanel = new Searchpanel();
        mSearchPanel.addSearchBar();
        mSearchPanel.addIntakeButton();
        mSearchPanel.addPatientRemoveButton();
        mSearchPanel.setPatientRemoveButtonListener(mListener);
        mSearchPanel.setIntakeButtonListener(mListener);
        mSearchPanel.setSearchButtonListener(mListener);
        mContentPane.add(mSearchPanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void updateTableData (Object[][] list) {
        mTableModel = new DefaultTableModel()   {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        mTableModel.setDataVector(list, tableHeaders);
        mUserTable.setModel(mTableModel);
    }

    public void mouseClicked(MouseEvent e) {
       
         if(e.getSource().equals(mUserTable)) {
           
             if(e.getClickCount() >= 2) {
                
                 int row = mUserTable.getSelectedRow();
                 new Timeline(mGuiControl, ((Userpanel) mUserPanel), mUserTable.getValueAt(row, 0).toString());
                 System.out.println("[DEBUG] Click event patient id " + Integer.parseInt(mUserTable.getValueAt(row, 0).toString()));
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
        if(e.getSource().equals(mUserTable)) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                int row = mUserTable.getSelectedRow();
                new Timeline(mGuiControl, ((Userpanel) mUserPanel), mUserTable.getValueAt(row, 0).toString());
                System.out.println("[DEBUG] Click event patient id " + Integer.parseInt(mUserTable.getValueAt(row, 0).toString()));
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void setMTableModel(DefaultTableModel tm) {
        mTableModel = tm;
    }

    public static DefaultTableModel getMTableModel() {
        return mTableModel;
    }

    public void setMUserTable(JTable mUserTable) {
        this.mUserTable = mUserTable;
    }

    public JTable getMUserTable() {
        return mUserTable;
    }


    class PatientOverviewListener implements ActionListener{

        public PatientOverviewListener(){
           
        }

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(command.equals("IntakeFormBtn")){
                new IntakeForm(mGuiControl);
            } else if (command.equals("Search")) {
                String search = mSearchPanel.getSearchTxtValue();
                Object[][] list = mGuiControl.getPatientList(search);
                updateTableData(list);
            }   else if(command.equals("removePatientBtn")) {
                String v = mTableModel.getValueAt(mUserTable.getSelectedRow(), 0).toString();
                Patient p = mGuiControl.getPatientByNumber(v);
                mGuiControl.removePatient(p);
            }
        }

        public void mouseClicked(MouseEvent e) {
           
            if(e.getSource() == mUserTable) {
                if(e.getClickCount() >= 2) {
                    int row = mUserTable.getSelectedRow();
                    int id = Integer.parseInt(mUserTable.getValueAt(row, 0).toString());
                    System.out.println(id);
                    
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
