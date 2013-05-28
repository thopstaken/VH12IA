package Boundary.Common;

import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.Dimension;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Searchpanel extends JPanel {
    private final int WIDTH = 800;
    private final int HEIGHT = 35;
    
    private JPanel leftPane;
    private JPanel rightPane;
   
    private JTextField searchTxt;
   
    private JButton searchBtn;
    private JButton filterBtn;
    private JButton newPatientBtn;
    
    public Searchpanel() {
        init();
    }
    
    public void init()  {
        setLayout(new BorderLayout(0,2));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        //init components
        searchTxt = new JTextField(30);
        searchBtn = new JButton("Zoek");
        filterBtn = new JButton("Filter");
        
        filterBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Filter f = new Filter();
                
            }
        });
        newPatientBtn = new JButton("Intake Formulier");        
        
        // Left Pane
        leftPane = new JPanel();
        leftPane.setLayout(new FlowLayout());
        
        // Right Pane
        rightPane = new JPanel();
        rightPane.setLayout(new FlowLayout());
        
        add(leftPane, BorderLayout.WEST);
        add(rightPane, BorderLayout.EAST);
    }
    
    public void addSearchBar()  {
        addToPane(leftPane, searchTxt);
        addToPane(leftPane, searchBtn);
    }
    
    public void addFilter() {
        addToPane(leftPane, filterBtn);
    }
    
    public void addIntakeButton()   {
        addToPane(rightPane, newPatientBtn);
    }
    
    public void setIntakeButtonListener(ActionListener al){
        newPatientBtn.setActionCommand("IntakeFormBtn");
        newPatientBtn.addActionListener(al);
    }
    
    public void addToPane(JPanel pane, Component c)  {
        pane.add(c);
    }
    
}
