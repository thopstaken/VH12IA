package Boundary;

import Boundary.Common.ModifiedFlowLayout;

import Control.GUIController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AddRapport extends JFrame {
    
    private JPanel mContentPanel, mSouthPanel;
    private JButton acceptButton, cancelButton;
    private Container cp;
    
    private JTextField tfBovenDruk, tfOnderDruk, tfSaturatie;
    private JTextArea taOpmerkingen;
       
    private GUIController guiControl;
    
    public AddRapport(GUIController guiControl) {
        super("Rapport");
        this.guiControl = guiControl;
        init();
        
        Dimension tfD = new Dimension(470, 25);
        Dimension taD = new Dimension(470, 100);
        tfBovenDruk = new JTextField(18);
        tfOnderDruk = new JTextField(18);
        tfSaturatie = new JTextField(18);
        taOpmerkingen = new JTextArea(5,18);
        
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        taOpmerkingen.setBorder(border);
        
        addFormItem("Bovendruk:", tfBovenDruk, tfD);
        addFormItem("Onderdruk:", tfOnderDruk, tfD);
        addFormItem("Saturatie:", tfSaturatie, tfD);
        addFormItem("Opmerkingen:", taOpmerkingen, taD);
        
        setVisible(true);
    }
    
    private void init(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(500, 300);
        
        cp = this.getContentPane();

        //setup content
        mContentPanel = new JPanel();
        mContentPanel.setLayout(new ModifiedFlowLayout());
        JScrollPane scrollPane =
            new JScrollPane(mContentPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        //setup southpark
        mSouthPanel = new JPanel();
        mSouthPanel.setLayout(new FlowLayout());

        acceptButton = new JButton("OK");
        acceptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int bdruk = -1;
                int odruk = -1;
                int sat = -1;
                try {
                   bdruk = Integer.parseInt(tfBovenDruk.getText());
                   odruk =  Integer.parseInt(tfOnderDruk.getText());
                   sat = Integer.parseInt(tfSaturatie.getText());
                }catch(NumberFormatException  nex) {
                    
                }
                    
                if(bdruk == -1 || odruk == -1 || sat == -1) {
                        JOptionPane.showMessageDialog(null, "Bovendruk, Onderdruk en Saturatie moeten numeriek zijn.");
                }  else {
                    guiControl.addBloedDrukRapport(bdruk, odruk, sat, taOpmerkingen.getText());
                    dispose();
                }
                
                
            }});
        cancelButton = new JButton("Annuleer");
        cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });

        mSouthPanel.add(cancelButton);
        mSouthPanel.add(acceptButton);

        cp.add(scrollPane, BorderLayout.CENTER);
        cp.add(mSouthPanel, BorderLayout.SOUTH); 
    }
    
    /**
     * @param item
     * Form item that has to be filled in.
     * @param c
     * Component for filling in the form item.
     */
    public void addFormItem(String item, Component c, Dimension d) {
        mContentPanel.add(new FormItem(item, c, d));
    }

    class FormItem extends JPanel {

        private JLabel mItem;

        public FormItem(String item, Component c, Dimension size) {
            setPreferredSize(size);
            setLayout(new GridLayout(1, 2));

            mItem = new JLabel(item);
            mItem.setToolTipText(mItem.getText());

            add(mItem);

            JPanel compPnl = new JPanel();
            compPnl.setLayout(new FlowLayout(FlowLayout.LEFT));
            compPnl.add(c);
            add(compPnl);


        }
    }
    
}
