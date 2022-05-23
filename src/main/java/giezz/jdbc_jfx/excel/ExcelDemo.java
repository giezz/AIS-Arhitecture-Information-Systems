package giezz.jdbc_jfx.excel;

import giezz.jdbc_jfx.dao.DAO;
import giezz.jdbc_jfx.dao.EmployeeDAO;
import giezz.jdbc_jfx.models.Employee;
import javafx.collections.ObservableList;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelDemo {

    private static final DAO<Employee, Integer> employeeDAO = new EmployeeDAO();

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static void export() {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Employees sheet");

            ObservableList<Employee> employees = employeeDAO.getAll();

            int rownum = 0;
            Cell cell;
            Row row;

            HSSFCellStyle style = createStyleForTitle(workbook);

            row = sheet.createRow(rownum);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Employee ID");
            cell.setCellStyle(style);

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Employee INN");
            cell.setCellStyle(style);

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Employee date of birth");
            cell.setCellStyle(style);

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Employee first name");
            cell.setCellStyle(style);

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Employee middle name");
            cell.setCellStyle(style);

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Employee last name");
            cell.setCellStyle(style);

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Employee phone");
            cell.setCellStyle(style);

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Employee email");
            cell.setCellStyle(style);

            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Employee driver license category");
            cell.setCellStyle(style);

            for (Employee emp : employees) {
                rownum++;
                row = sheet.createRow(rownum);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(emp.getId_employee());

                cell = row.createCell(1, CellType.NUMERIC);
                cell.setCellValue(emp.getInn());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(emp.getDate_of_birth());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(emp.getFirst_name());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(emp.getMiddle_name());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(emp.getLast_name());

                cell = row.createCell(6, CellType.NUMERIC);
                cell.setCellValue(emp.getPhone());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(emp.getEmail());

                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(emp.getDriver_license_category());
            }

            File file = new File("output/employee.xls");

            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            System.out.println("Created file: " + file.getAbsolutePath());
            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
