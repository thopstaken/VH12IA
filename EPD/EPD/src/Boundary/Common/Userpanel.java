package Boundary.Common;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Label;

import java.awt.Panel;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.SimpleTimeZone;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Userpanel extends JPanel   {
    private static final long  serialVersionUID = -1;
    private JLabel mUsernamelbl;
    private JButton mLogoutbtn;
    private String mUsername;
    private Date mLoggedDate;
    
    public Userpanel(String user, Date loggedin)  {
        mUsername = user;
        mLoggedDate = loggedin;
        init();
    }
    
    private void init() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy hh:mm");
        setLayout(new BorderLayout(0, 2));
        setPreferredSize(new Dimension(780,35));
        
        mUsernamelbl = new JLabel("Ingelogd: " + mUsername + " " + sdf.format(mLoggedDate));
        mUsernamelbl.setBorder(new EmptyBorder(0, 5, 0, 0));
        mLogoutbtn = new JButton("Uitloggen");
        
        this.add(mUsernamelbl, BorderLayout.WEST);
        Panel east = new Panel();
        this.add(east, BorderLayout.EAST);
        east.add(mLogoutbtn);
        
  
    }
}
