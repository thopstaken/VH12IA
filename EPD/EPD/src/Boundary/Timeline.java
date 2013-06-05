package Boundary;

import Boundary.Common.Userpanel;

import Control.GUIController;

import Entity.Patient;

import java.awt.BorderLayout;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Timeline extends JFrame {
    
    private Patient mPatient;
    private GUIController mGuiControl;
    
    private Userpanel mUserPanel;
    
    private Container cp;
    private JPanel contentPanel, infoPanel;
    
    public Timeline(GUIController guiControl, Userpanel userPanel, int patientId) {        
        mGuiControl = guiControl;

        mPatient = mGuiControl.getPatientById(patientId);
        mUserPanel = userPanel;

        
        init();
        
        setVisible(true);
    }
    
    private void init(){
        setSize(800, 600);
        
        cp = getContentPane();
        
        cp.add(mUserPanel, BorderLayout.NORTH);
        
    }
    
    
}
