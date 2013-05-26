package Boundary;

import java.awt.Rectangle;

import javax.swing.JPanel;

import javax.swing.JTable;

import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

public class TaskOverviewPanel extends JPanel {
    private JTable jTable1 = new JTable();

    public TaskOverviewPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( new XYLayout() );
        this.setBounds(new Rectangle(0, 30, 800, 470));
        this.add(jTable1, new XYConstraints(30, 25, 740, 360));
        
    }
}
