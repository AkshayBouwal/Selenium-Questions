package Questions;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class No_22_ExcelDataDriver {

    /*
    Write a java program to convert data from  Excel to Object[][] for @DataProvider annotation in TestNG
     */


    public static void main(String[] args) {

        XSSFWorkbook workbook = null;

        try {
            FileInputStream file = new FileInputStream("C:\\Users\\aksha\\IdeaProjects\\Automation\\src\\main\\java\\Questions\\SampleData.xlsx");
            workbook = new XSSFWorkbook(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not present on location");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        XSSFSheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();


        Object[][] data = new Object[rowCount - 1][colCount];

        /*
        rowCount - 1 because we want to eliminate header row
         */

        for (int i = 1; i < rowCount; i++) {

            Row ithRow = sheet.getRow(i);

            for (int j = 0; j < colCount; j++) {

                data[i - 1][j] = ithRow.getCell(j).getStringCellValue().trim();

                /*
                data[i-1] so that indexing start from (0,0) (0,1) (0,2)
                 */
            }

        }

        System.out.println(Arrays.deepToString(data));

    }
}
