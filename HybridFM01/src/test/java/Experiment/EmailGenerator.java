package Experiment;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class EmailGenerator {

    public static String genEmailWithTimestamp() {
        Date date = new Date();
        String timestamp = date.toString().replace(" ", "_").replace(":", "_").replace("_", "").replace("IST", "");
        return "m" + timestamp + "@ym.com";
    }

    public static void main(String[] args) {
        // number of emails
        int numberOfEmails = 10;

        // create workbook & sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Email Addresses");

        // for header row
        Row headerRow = sheet.createRow(0);
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Unique Email Addresses");

        // generate emails in the sheet
        for (int i = 1; i <= numberOfEmails; i++) {
            String email = genEmailWithTimestamp();
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(email);

            
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // workbook
        try (FileOutputStream fileOut = new FileOutputStream("UniqueEmails.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel file has been generated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
