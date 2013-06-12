package Boundary;

import Entity.Task;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
		private String[] columnNames = {"Opdrachtnummer","Patiëntnummer", "Patientnaam", "Opdracht Type", "Notities" };
		ArrayList<Task> list = null;
 
		MyTableModel(ArrayList<Task> list) {
			this.list = list;
		}
 
		public int getColumnCount() {
			return columnNames.length;
		}
 
		public int getRowCount() {
			return list.size();
		}
 
		public String getColumnName(int col) {
			return columnNames[col];
		}
 
		public Object getValueAt(int row, int col) {
 
			Task task = list.get(row);
 
			switch (col) {
                        case 0:
                                return task.getTaskId();
                        
			case 1:
				return task.getPatient().getPatientNumber();
			
			case 2:
				return task.getPatient().getFirstName() + " " + task.getPatient().getSurName();
			case 3:
				return task.getCategory();
			case 4:
				return task.getNotes();
                       
			default:
				return "unknown";
			}
		}
 
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}
	}