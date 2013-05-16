package Entity.charts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class BloodpressureChart {

	private ArrayList<BloodPressureMeasurement> systolicList;
	private ArrayList<BloodPressureMeasurement> diastolicList;

	public BloodpressureChart() {
		systolicList = new ArrayList<BloodPressureMeasurement>();
		diastolicList = new ArrayList<BloodPressureMeasurement>();
	}

	public ArrayList<BloodPressureMeasurement> getSystolicList() {
		return systolicList;
	}

	public void setSystolicList(ArrayList<BloodPressureMeasurement> systolicList) {
		this.systolicList = systolicList;
	}

	public ArrayList<BloodPressureMeasurement> getDiastolicList() {
		return diastolicList;
	}

	public void setDiastolicList(
			ArrayList<BloodPressureMeasurement> diastolicList) {
		this.diastolicList = diastolicList;
	}

	public void addSystolicMeasurement(BloodPressureMeasurement msrmnt) {
		systolicList.add(msrmnt);
	}

	public void addDiastolicMeasurement(BloodPressureMeasurement msrmnt) {
		diastolicList.add(msrmnt);
	}

	public void saveToPNG(String path) {

		String date = null;

		try {
			/* Loop through lists and add measurements to dataset */
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			SimpleDateFormat format = new SimpleDateFormat("d MMM yyyy HH:mm");
			for (BloodPressureMeasurement meting : systolicList) {
				date = format.format(meting.getDate().getTime());
				dataset.addValue(meting.getValue(), "bovendruk", date);
			}

			for (BloodPressureMeasurement meting : diastolicList) {
				date = format.format(meting.getDate().getTime());
				dataset.addValue(meting.getValue(), "onderdruk", date);
			}

			/* Create line chart object */
			JFreeChart lineChartObject = ChartFactory.createLineChart(
					"Bloeddruk verloop", "Datum", "Bloeddruk", dataset,
					PlotOrientation.VERTICAL, true, true, false);
			/* Save chart to file */
			int width = 860;
			int height = 480;

			File lineChart = new File(path + "\\bloeddruk.png");
			ChartUtilities.saveChartAsPNG(lineChart, lineChartObject, width,
					height);
		} catch (Exception i) {
			i.printStackTrace();
		}
	}

	public void saveToXsls(String path) {

		try {
			// create a new workbook
			Workbook wb = new XSSFWorkbook(); // or new HSSFWorkbook();
			SimpleDateFormat format = new SimpleDateFormat(
					"d MMM yyyy HH:mm:ss");
			// add picture data to this workbook.
			InputStream is = new FileInputStream(path + "\\bloeddruk.png");
			byte[] bytes = IOUtils.toByteArray(is);
			int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
			is.close();

			CreationHelper helper = wb.getCreationHelper();
			Sheet sheet = wb.createSheet();

			// Create the drawing patriarch. This is the top level container for
			// all shapes.
			Drawing drawing = sheet.createDrawingPatriarch();

			// add a picture shape
			ClientAnchor anchor = helper.createClientAnchor();
			anchor.setCol1(3);
			anchor.setRow1(1);
			Picture pict = drawing.createPicture(anchor, pictureIdx);
			pict.resize();

			// add values column next to chart
			for (int i = 1; i <= systolicList.size(); i++) {
				Row row = sheet.createRow((short) i);
				Cell cell = row.createCell(1);
				cell.setCellValue(systolicList.get(i - 1).getValue() + "/"
						+ diastolicList.get(i - 1).getValue());
			}

			// save workbook
			String file = path + "\\bloeddruk.xls";
			if (wb instanceof XSSFWorkbook)
				file += "x";
			FileOutputStream fileOut = new FileOutputStream(file);
			wb.write(fileOut);
			fileOut.close();
		} catch (Exception i) {
			i.printStackTrace();
		}
	}
}
