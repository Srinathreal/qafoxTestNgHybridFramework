package qafox.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {

	public static final int IMPLICIT_WAIT = 10;
	public static final int PAGE_LOAD = 5;

	public static Object[][] getDataFromExcel(String SheetName) throws IOException {

		File file = new File(System.getProperty("user.dir") + "/src/main/java/qafox/testdata/TestDataDemo.xlsx");
		XSSFWorkbook workbook = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(SheetName);
		int rows = sheet.getLastRowNum();
		short cols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {
			XSSFRow rowdata = sheet.getRow(i + 1);

			for (int j = 0; j < cols; j++) {
				XSSFCell cell = rowdata.getCell(j);

				CellType cellType = cell.getCellType();

				switch (cellType) {

				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;
	}
}
