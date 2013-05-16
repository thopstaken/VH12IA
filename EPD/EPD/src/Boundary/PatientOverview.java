package Boundary;

import Boundary.Common.Userpanel;

import java.awt.BorderLayout;

import java.awt.Container;

import java.awt.Dimension;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PatientOverview extends JFrame{
    
    private JPanel mUserPanel;
    private Container mContentPane;
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
        mUserPanel = new Userpanel(mUsername, mLoginTime);
        mUserPanel.setPreferredSize(new Dimension(780,35));
        mContentPane.add(mUserPanel, BorderLayout.NORTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
