package Website.writer;

import Website.entity.Student;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExcelWriter {

    private static String[] columns = {"Lớp TC", "Mã Sinh Viên", "Họ Tên", "Lớp CN", "Đã điểm danh?", "Màu sắc"};
    private static List<Student> Students = new ArrayList<>();

    // Initializing Students data to insert into the excel file
    static {
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1999, 2, 1); // 0 means January
        Students.add(new Student("D12CNPM1", "1781310183","user1", "Đinh Doãn Việt ", "D12CNPM2", true, xuLyMauSac(true),""));
    }

    public static String xuLyMauSac(Boolean isDiemDanh) {
        String color = null;
        if (isDiemDanh) {
            color = "blue";
        } else {
            color = "red";
        }
        return color;
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        // Create a Workbook
        Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat,
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Student");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Other rows and cells with Students data
        int rowNum = 1;
        for (Student Student : Students) {
            Row row = sheet.createRow(rowNum++);

            // Student's name (Column A)
            row.createCell(0)
                    .setCellValue(Student.getTenLop());

            // Student's email (Column B)
            row.createCell(1)
                    .setCellValue(Student.getMaSV());
            row.createCell(2)
                    .setCellValue(Student.getTenSV());
            row.createCell(3)
                    .setCellValue(Student.getLopCN());
            row.createCell(4)
                    .setCellValue(Student.isIsDiemDanh());


        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("D:\\ThongKeSinhVien.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }
}
