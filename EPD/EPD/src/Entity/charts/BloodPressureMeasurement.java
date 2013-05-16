package Entity.charts;

import java.util.Calendar;
import java.util.Date;

public class BloodPressureMeasurement {

	private int value;
	private Calendar date;
	
	public BloodPressureMeasurement(int value, Calendar date) {
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
