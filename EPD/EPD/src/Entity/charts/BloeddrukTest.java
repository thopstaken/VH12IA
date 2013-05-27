package Entity.charts;

import Entity.charts.BloodPressureMeasurement;
import Entity.charts.BloodpressureChart;
import java.util.Calendar;

public class BloeddrukTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BloodpressureChart chart = new BloodpressureChart();
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.DAY_OF_MONTH, 2);
		
		Calendar cal3 = Calendar.getInstance();
		cal3.set(Calendar.DAY_OF_MONTH, 3);

		Calendar cal4 = Calendar.getInstance();
		cal4.set(Calendar.DAY_OF_MONTH, 4);
		
		Calendar cal5 = Calendar.getInstance();
		cal5.set(Calendar.DAY_OF_MONTH, 5);
		
		chart.addSystolicMeasurement(new BloodPressureMeasurement(103, cal1));
		chart.addSystolicMeasurement(new BloodPressureMeasurement(110, cal2));
		chart.addSystolicMeasurement(new BloodPressureMeasurement(107, cal3));
		chart.addSystolicMeasurement(new BloodPressureMeasurement(119, cal4));
		chart.addSystolicMeasurement(new BloodPressureMeasurement(127, cal5));
		
		chart.addDiastolicMeasurement(new BloodPressureMeasurement(66, cal1));
		chart.addDiastolicMeasurement(new BloodPressureMeasurement(78, cal2));
		chart.addDiastolicMeasurement(new BloodPressureMeasurement(70, cal3));
		chart.addDiastolicMeasurement(new BloodPressureMeasurement(82, cal4));
		chart.addDiastolicMeasurement(new BloodPressureMeasurement(60, cal5));
		
		
		chart.saveToPNG("C:\\Users\\Sietse\\Desktop\\Grafieken");
		chart.saveToXsls("C:\\Users\\Sietse\\Desktop\\Grafieken");
		
	}

}
