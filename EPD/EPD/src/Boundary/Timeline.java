package Boundary;

import Boundary.Common.Userpanel;

import Control.GUIController;

import Entity.Patient;

import java.awt.BorderLayout;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        
        //infopanel
        infoPanel = new JPanel();
        JPanel pPanel = new JPanel();
        JLabel lblPatientNaam = new JLabel(mPatient.getFirstName());
        pPanel.add(lblPatientNaam);
        JLabel lblPatientGbDatum = new JLabel(mPatient.getDateOfBirth());
        pPanel.add(lblPatientGbDatum);
        JLabel lblPatientNr = new JLabel(mPatient.getPatientNumber());
        pPanel.add(lblPatientNr);
        infoPanel.add(pPanel, BorderLayout.WEST);
        
        cp = getContentPane();        
        cp.add(mUserPanel, BorderLayout.NORTH);
        cp.add(infoPanel, BorderLayout.CENTER);
        
    }
    
    
}
