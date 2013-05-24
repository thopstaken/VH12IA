package Boundary.Common;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Filter extends JFrame {
    
    private JButton acceptButton, cancelButton;
    private JPanel filterPanel, southPanel;
    private Container cp;
    
    public Filter() {
        init();
        addFilterItem(new JTextField(10), "Armando King");
        addFilterItem(new JTextField(10), "Armando is Cool");
        addFilterItem(new JTextField(10), "Scumbag Jowin");
        //addFilterItem();
        setVisible(true);
    }
    
    private void init(){
        cp = this.getContentPane();
        setSize(new Dimension(400,250));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //setup southpark
        filterPanel = new JPanel();
        filterPanel.setLayout(new FlowLayout());
        
        //setup southpark
        southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        
        acceptButton = new JButton("OK");
        acceptButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        cancelButton = new JButton("Annuleer");
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        
        southPanel.add(cancelButton);
        southPanel.add(acceptButton);
        
        cp.add(filterPanel, BorderLayout.CENTER);
        cp.add(southPanel, BorderLayout.SOUTH);
    }
    
    public void addFilterItem(Component c, String title){
        filterPanel.add(new FilterItem(c, title));
    }
    
    class FilterItem extends JPanel{
        
        private JCheckBox mSwitch;
        private JLabel mTitle;
        
        public FilterItem(Component c, String title) {
            mSwitch = new JCheckBox();
            mTitle = new JLabel(title);
            
            add(mSwitch);
            add(mTitle);
            add(c);
            setPreferredSize(new Dimension(400, 25));
           
        }
    }
}
