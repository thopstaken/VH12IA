package Boundary;

import Boundary.Common.ModifiedFlowLayout;
import Boundary.Common.Userpanel;

import Control.GUIController;

import Entity.Patient;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;

import java.awt.Dimension;
import java.awt.ScrollPane;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class Timeline extends JFrame {
    
    private Patient mPatient;
    private GUIController mGuiControl;
    
    private Userpanel mUserPanel;
    
    private Container cp;
    private JPanel contentPanel, infoPanel;
    
    public Timeline(GUIController guiControl, Userpanel userPanel, String patientNr) {        
        mGuiControl = guiControl;

        mPatient = mGuiControl.getPatientByNumber(patientNr);
        mUserPanel = userPanel;

        
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
        JLabel lblPatientNaam = new JLabel("PatiŽntnaam: " + mPatient.getFirstName());
        pPanel.add(lblPatientNaam);
        JLabel lblPatientGbDatum = new JLabel("Geboortedatum: " + mPatient.getDateOfBirth());
        pPanel.add(lblPatientGbDatum);
        JLabel lblPatientNr = new JLabel("PatiŽntnummer: " + mPatient.getPatientNumber());
        pPanel.add(lblPatientNr);
        //btnPanel
        JPanel btnPanel = new JPanel();
        JButton btnAnamnese = new JButton("Anamnese Indienen");
        btnPanel.add(btnAnamnese);
        JButton btnVitaleFnc = new JButton("Vitale Functies Overzicht");
        btnPanel.add(btnVitaleFnc);
        JButton btnRapport = new JButton("Rapport ophalen");
        btnPanel.add(btnRapport);
        JButton btnOpdracht = new JButton("Opdracht indienen");
        btnPanel.add(btnOpdracht);
        infoPanel.add(pPanel, BorderLayout.WEST);
        infoPanel.add(btnPanel, BorderLayout.CENTER);
        
        //contentPanel
        contentPanel = new JPanel();
        contentPanel.setLayout(new ModifiedFlowLayout());
        contentPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        contentPanel.setPreferredSize(new Dimension(750, 465));
        JScrollPane sPane = new JScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sPane.getVerticalScrollBar().setUnitIncrement(16);
        
        cp = getContentPane();        
        cp.add(mUserPanel, BorderLayout.NORTH);
        cp.add(infoPanel, BorderLayout.CENTER);
        cp.add(sPane, BorderLayout.SOUTH);
        
    }
    
    
}
