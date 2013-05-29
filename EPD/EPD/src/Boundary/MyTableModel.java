package Boundary;

import Entity.Task;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
		private String[] columnNames = { "Patiëntnummer", "Opdrachtnummer", "Patientnaam", "Opdracht Type", "Notities" };
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
 
			Task object = list.get(row);
 
			switch (col) {
			case 0:
				return object.getPatient().getPatientNumber();
			case 1:
				return object.getTaskId();
			case 2:
				return object.getPatient().getFirstName() + " " + object.getPatient().getSurName();
			case 3:
				return object.getCategory();
			case 4:
				return object.getNotes();
			default:
				return "unknown";
			}
		}
 
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}
	}