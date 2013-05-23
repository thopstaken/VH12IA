package Boundary;

import java.awt.Rectangle;

import javax.swing.JPanel;

import oracle.jdeveloper.layout.XYLayout;

public class TaskOverviewPanel extends JPanel {
    
    private XYLayout xYLayout6 = new XYLayout();
    
    public TaskOverviewPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( xYLayout6 );
        this.setBounds(new Rectangle(0, 30, 800, 470));
    }
}
