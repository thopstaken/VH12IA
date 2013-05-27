package Boundary;

import Control.TaskController;

import Entity.Task;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import java.util.ArrayList;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableModel;

import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

public class TaskOverviewPanel extends JPanel {
    private TaskController tc;
    
    private JTable jTable1 = new JTable();
    private MyTableModel mTableModel;

    public TaskOverviewPanel(TaskController tc) {
        
        this.tc = tc;
        
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
        
        String[] tableHeaders = {};
        ArrayList<Task> tl = tc.getTaskList();
        
        mTableModel = new MyTableModel(tl);
        jTable1.setModel(mTableModel);
        
        JScrollPane scrollPane = new JScrollPane(jTable1);
        this.add(scrollPane, BorderLayout.CENTER);
        
    }
}


