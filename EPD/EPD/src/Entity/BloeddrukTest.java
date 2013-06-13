package Entity;


import java.io.File;

import java.util.Calendar;

public class BloeddrukTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Starting...");
        System.out.println("Adding data...");
        Patient patient = new Patient();
        patient.setFirstName("Sietse");
        patient.setPrefix("");
        patient.setSurName("Trommelen");
        //patient.setDateOfBirth("9 juli 1993"); TODO Je vult string in terwijl hij Datetime verwacht kijk even wat je ermee wilt
        BloodpressureChart chart = new BloodpressureChart(patient);
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

        chart.addSaturationMeasurement(new SaturationMeasurement(87, cal1));
        chart.addSaturationMeasurement(new SaturationMeasurement(76, cal2));
        chart.addSaturationMeasurement(new SaturationMeasurement(70, cal3));
        chart.addSaturationMeasurement(new SaturationMeasurement(83, cal4));
        chart.addSaturationMeasurement(new SaturationMeasurement(90, cal5));

        chart.saveAndOpenXlsx("C:\\Users\\Administrator\\Desktop\\grafieken");
        
    }

}
