package lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class ReadExcel {
	XSSFWorkbook workbook;
	XSSFSheet sheet1;

	public  ReadExcel(String excelPath) throws IOException {

		try {
			FileInputStream fis = new FileInputStream(excelPath);

			workbook = new XSSFWorkbook(fis);
			sheet1 = workbook.getSheetAt(0);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public String getdata(int SheetNumber, int row, int coloumn) {
		sheet1 = workbook.getSheetAt(SheetNumber);
		String data = sheet1.getRow(row).getCell(coloumn).getStringCellValue();
		return data;

	}

	public int getRowCount(int sheetIndex) {

		int row = workbook.getSheetAt(sheetIndex).getLastRowNum();

		row = row + 1;
		return row;
	}

}
