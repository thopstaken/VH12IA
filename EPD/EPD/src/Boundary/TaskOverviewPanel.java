package Boundary;

import Control.TaskController;

import Entity.Task;

import java.awt.BorderLayout;
import java.awt.Rectangle;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

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
    private NewTask nt;
    private XYLayout xYLayout = new XYLayout();
    private JTable jTable1 = new JTable();
    private MyTableModel mTableModel;

    public TaskOverviewPanel(TaskController tc,NewTask nt ) {
        
        this.tc = tc;
        this.nt = nt;
        
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                   JTable target = (JTable)e.getSource();
                   int row = target.getSelectedRow();
                   int column = 0;
                   int i;
                   i=Integer.parseInt(jTable1.getValueAt(row,column).toString());
                   
                    System.out.print(i);
                }
            
            }
        });
        
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( xYLayout );
        this.setBounds(new Rectangle(0, 30, 800, 470));
        this.add(jTable1, new XYConstraints(10, 25, 740, 360));
        
        ArrayList<Task> tl = tc.getTaskList();
        
        mTableModel = new MyTableModel(tl);
        jTable1.setModel(mTableModel);
        
        JScrollPane scrollPane = new JScrollPane(jTable1);
        this.add(scrollPane, BorderLayout.CENTER);
        
    }
}


