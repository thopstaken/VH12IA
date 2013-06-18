package Boundary;

import Boundary.Common.ModifiedFlowLayout;
import Boundary.Common.TimelinePanel;
import Boundary.Common.Userpanel;

import Control.GUIController;

import Control.TaskController;

import Entity.BloeddrukTest;
import Entity.EnumCollection;
import Entity.Patient;

import Entity.TimeLineItem;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ViewportLayout;
import javax.swing.border.LineBorder;

public class Timeline extends JFrame {
    
    private Patient mPatient;
    private GUIController mGuiControl;
    
    private Userpanel mUserPanel;
    private SimpleDateFormat mSDF = new SimpleDateFormat("dd-MM-yyyy");
    private TimelineListeners mListeners;
    private Container cp;
    private JPanel contentPanel, infoPanel;
    
    public Timeline(GUIController guiControl, Userpanel userPanel, String patientNr) {        
        mGuiControl = guiControl;

        mPatient = mGuiControl.getPatientByNumber(patientNr);
        mUserPanel = userPanel;
        mListeners = new TimelineListeners();
        
        init();
        
        setVisible(true);
    }
    
    private void init(){
        setSize(800, 600);
        setResizable(false);
        
        //infopanel
        infoPanel = new JPanel();
        infoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        //pPanel
        JPanel pPanel = new JPanel();
        pPanel.setLayout(new BoxLayout(pPanel, BoxLayout.Y_AXIS));
        JLabel lblPatientNaam = new JLabel("Patiëntnaam: " + mPatient.getFirstName());
        pPanel.add(lblPatientNaam);
        JLabel lblPatientGbDatum = new JLabel("Geboortedatum: " + mSDF.format(mPatient.getDateOfBirth().getTime()));
        pPanel.add(lblPatientGbDatum);
        JLabel lblPatientNr = new JLabel("Patiëntnummer: " + mPatient.getPatientNumber());
        pPanel.add(lblPatientNr);
        //btnPanel
        JPanel btnPanel = new JPanel();
        JButton btnAnamnese = new JButton("Anamnese Indienen");
        btnPanel.add(btnAnamnese);
        btnAnamnese.addActionListener(mListeners);
        JButton btnVitaleFnc = new JButton("Vitale Functies Overzicht");
        btnPanel.add(btnVitaleFnc);
        btnVitaleFnc.addActionListener(mListeners);
        JButton btnRapport = new JButton("Rapport ophalen");
        btnPanel.add(btnRapport);
        btnRapport.addActionListener(mListeners);
        JButton btnOpdracht = new JButton("Afsprakenoverzicht");
        btnOpdracht.addActionListener(mListeners);
        btnPanel.add(btnOpdracht);
        infoPanel.add(pPanel, BorderLayout.WEST);
        infoPanel.add(btnPanel, BorderLayout.CENTER);
        
        //contentPanel
        contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        contentPanel.setPreferredSize(new Dimension(750, 465));
        JScrollPane sPane = new JScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sPane.getVerticalScrollBar().setUnitIncrement(16);
        
        cp = getContentPane();        
        cp.add(mUserPanel, BorderLayout.NORTH);
        cp.add(infoPanel, BorderLayout.CENTER);
        cp.add(sPane, BorderLayout.SOUTH);


        try {
            for(TimeLineItem it  : mGuiControl.getAllItemsByID(mPatient.getPatientId())) {
            TimelinePanel tp = new TimelinePanel(it);
            contentPanel.add(tp);
        }
        } catch (SQLException e) {
        }
    }
    
    class TimelineListeners implements ActionListener   {
        
        public TimelineListeners() {
    
        }

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            System.out.println(command);
            if(command.equals("Afsprakenoverzicht")) {
                new NewTask(new TaskController(mPatient));
            }
            if(command.equals("Rapport ophalen")){
                new AddRapport(mGuiControl);
            }
            if(command.equals("Vitale Functies Overzicht")) {
                BloeddrukTest.testBloadDrukRapport();
            }
            
        }
    }
    
}
