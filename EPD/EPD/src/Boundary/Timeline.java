package Boundary;

import Control.GUIController;

import Entity.Patient;

import javax.swing.JFrame;

public class Timeline extends JFrame {
    
    private Patient mPatient;
    private GUIController mGuiControl;
    
    public Timeline(GUIController guiControl, int patientId) {
        setSize(800, 600);
        
        mGuiControl = guiControl;
        mPatient = mGuiControl.getPatientById(patientId);
        
        
        setVisible(true);
    }
}
