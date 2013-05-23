package Boundary;

import Boundary.Common.Searchpanel;
import Boundary.Common.Userpanel;

import java.awt.BorderLayout;

import java.awt.Container;

import java.awt.Dimension;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class PatientOverview extends JFrame{
    
    private JPanel mUserPanel;
    private Searchpanel  mSearchPanel;
    private Container mContentPane;
    private JTable mUserTable;
    private String mUsername;
    private Date mLoginTime;
    
    public PatientOverview(String username, Date loginTime) {
        mUsername = username;
        mLoginTime = loginTime;
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
        
        mContentPane.add(mUserTable, BorderLayout.CENTER);
        
        // Add search panel
        mSearchPanel = new Searchpanel();
        mSearchPanel.addSearchBar();
        mSearchPanel.addFilter();
        mSearchPanel.addIntakeButton();
        mContentPane.add(mSearchPanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
