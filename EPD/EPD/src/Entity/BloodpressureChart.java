package Entity;


import java.awt.Color;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class BloodpressureChart {


    private ArrayList<BloodPressureMeasurement> systolicList;
    private ArrayList<BloodPressureMeasurement> diastolicList;
    private Date time;
    private ArrayList<SaturationMeasurement> saturationList;
    private SimpleDateFormat timeformat;
    private Patient patient;

    public BloodpressureChart(Patient pt) {
        systolicList = new ArrayList<BloodPressureMeasurement>();
        diastolicList = new ArrayList<BloodPressureMeasurement>();
        saturationList = new ArrayList<SaturationMeasurement>();
        time = Calendar.getInstance().getTime();
        timeformat = new SimpleDateFormat("HH-mm-ss");
        patient = pt;
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

    public void setDiastolicList(ArrayList<BloodPressureMeasurement> diastolicList) {
        this.diastolicList = diastolicList;
    }

    public void addSystolicMeasurement(BloodPressureMeasurement msrmnt) {
        systolicList.add(msrmnt);
    }

    public void addDiastolicMeasurement(BloodPressureMeasurement msrmnt) {
        diastolicList.add(msrmnt);
    }

    private void saveToPNG(String path) {

        String date = null;

        try {
            /* Loop through lists and add measurements to dataset */
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            SimpleDateFormat format = new SimpleDateFormat("dd/M/yyyy HH:mm");
            for (BloodPressureMeasurement meting : systolicList) {
                date = format.format(meting.getDate().getTime());
                dataset.addValue(meting.getValue(), "bovendruk", date);
            }

            for (BloodPressureMeasurement meting : diastolicList) {
                date = format.format(meting.getDate().getTime());
                dataset.addValue(meting.getValue(), "onderdruk", date);
            }

            /* Create line chart object */
            JFreeChart lineChartObject =
                ChartFactory.createLineChart("Bloeddruk verloop", "Datum",
                                             "Bloeddruk", dataset,
                                             PlotOrientation.VERTICAL, true,
                                             true, false);
            CategoryPlot plot = lineChartObject.getCategoryPlot();
            /*
			 * plot.setDomainGridlineStroke(new BasicStroke(1));
			 * plot.setRangeGridlineStroke(new BasicStroke(1));
			 */
            plot.setBackgroundAlpha(0);
            plot.setDomainGridlinesVisible(true);
            plot.setRangeGridlinesVisible(true);
            plot.setRangeGridlinePaint(Color.black);
            plot.setDomainGridlinePaint(Color.black);

            /* Save chart to file */
            int width = 645;
            int height = 360;

            File lineChart = new File(path + "\\bloeddruk.png");
            ChartUtilities.saveChartAsPNG(lineChart, lineChartObject, width,
                                          height);
        } catch (Exception i) {
            i.printStackTrace();
        }
    }

    private void saveToXsls(String path) {

        try {

            InputStream inp = new FileInputStream("resources\\bloeddruk.xlsx");
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);


            //Fill form with patient values
            if (patient.getFirstName() != null) {
                Row nameRow = sheet.getRow(0);
                Cell nameCell = nameRow.getCell(2);
                nameCell.setCellValue(patient.getFirstName() + " " +
                                      patient.getPrefix() + " " +
                                      patient.getSurName());

                Row birthRow = sheet.getRow(1);
                Cell birthCell = birthRow.getCell(2);
                birthCell.setCellValue(patient.getDateOfBirth());
            }

            /* TO DO: other data, not supplied yet */

            SimpleDateFormat format = new SimpleDateFormat("d MMM yyyy HH:mm");
            // add picture
            InputStream is = new FileInputStream(path + "\\bloeddruk.png");
            byte[] bytes = IOUtils.toByteArray(is);
            int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            is.close();
            File inputPicture = new File(path + "\\bloeddruk.png");
            inputPicture.delete();

            CreationHelper helper = wb.getCreationHelper();
            // Sheet sheet = wb.createSheet();

            // Create the drawing patriarch. This is the top level container for
            // all shapes.
            Drawing drawing = sheet.createDrawingPatriarch();

            // add a picture shape
            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(11);
            Picture pict = drawing.createPicture(anchor, pictureIdx);
            pict.resize();

            Row row = sheet.createRow(30);
            for (int i = 0; i < saturationList.size(); i++) {
                Cell cell = row.createCell(3 + i);

                if (i != 0) {
                    cell.setCellValue(saturationList.get(i).getValue() + "%");
                } else {
                    cell.setCellValue("Sat " +
                                      saturationList.get(i).getValue() + "%");
                }
            }

            Row row2 = sheet.getRow(31);
            for (int i = 0; i < diastolicList.size(); i++) {
                Cell cell = row2.getCell(3 + i);
                cell.setCellValue(systolicList.get(i).getValue() + "/" +
                                  diastolicList.get(i).getValue());
            }
            // save workbook
            String file = path + "\\" + timeformat.format(time) + ".xls";
            if (wb instanceof XSSFWorkbook)
                file += "x";
            FileOutputStream fileOut = new FileOutputStream(file);
            wb.write(fileOut);
            fileOut.close();
        } catch (Exception i) {
            i.printStackTrace();
        }
    }

    private void saveToPdf(String path) {
        try {
            File inputFile =
                new File(path + "\\" + timeformat.format(time) + ".xlsx");
            String filepath = path + "\\" + time.getTime() + ".pdf";
            File outputFile = new File(filepath);

            // connect to an OpenOffice.org instance running on port 8100
            OpenOfficeConnection connection =
                new SocketOpenOfficeConnection(8100);
            connection.connect();

            // convert
            DocumentConverter converter =
                new OpenOfficeDocumentConverter(connection);
            converter.convert(inputFile, outputFile);

            // close the connection
            connection.disconnect();


        } catch (Exception i) {
            i.printStackTrace();
        }
        File inputFile =
            new File(path + "\\" + timeformat.format(time) + ".xlsx");
        inputFile.delete();
    }

    public void saveAndOpenPdf(String path) {
        System.out.println("Saving as PNG");
        saveToPNG(path);
        System.out.println("Saving as XLSX");
        saveToXsls(path);
        System.out.println("Exporting to PDF...");
        saveToPdf(path);
        System.out.println("Done!");

        try {
            // open pdf
            String filepath = path + "\\" + time.getTime() + ".pdf";
            if ((new File(filepath)).exists()) {

                Process p =
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +
                                              filepath);
                p.waitFor();

            } else {

                System.out.println("File is not exists");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveAndOpenXlsx(String path) {
        System.out.println("Saving as PNG");
        saveToPNG(path);
        System.out.println("Saving as XLSX");
        saveToXsls(path);
        System.out.println("Done!");

        String filepath = path + "\\" + timeformat.format(time) + ".xlsx";
        try {
            if ((new File(filepath)).exists()) {


                Process p =
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +
                                              filepath);
                p.waitFor();

            } else {

                System.out.println("File is not exists");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSaturationList(ArrayList<SaturationMeasurement> saturationList) {
        this.saturationList = saturationList;
    }

    public ArrayList<SaturationMeasurement> getSaturationList() {
        return saturationList;
    }

    public void addSaturationMeasurement(SaturationMeasurement msrmnt) {
        saturationList.add(msrmnt);
    }
}
