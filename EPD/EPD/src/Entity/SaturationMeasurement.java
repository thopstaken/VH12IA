/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Calendar;

/**
 *
 * @author Jan
 */
public class SaturationMeasurement {
    
	private int value;
	private Calendar date;
	
	public SaturationMeasurement(int value, Calendar date) {
		this.setValue(value);
		this.setDate(date);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
}
