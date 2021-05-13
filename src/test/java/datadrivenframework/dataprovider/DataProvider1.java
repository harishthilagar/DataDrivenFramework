package datadrivenframework.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProvider1 {

	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet ws;
	String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\TestData.xlsx";
	LinkedList<LinkedList<String>> addressList;
	
    @DataProvider(name ="addressDataProvider")
	public Iterator<Object> getExcelSheetData() {
		LinkedList<Object> objList = new LinkedList<Object>();
		try {
			fis = new FileInputStream(filePath);
			wb = new XSSFWorkbook(fis);
			int noOfSheets = wb.getNumberOfSheets();
			System.out.println(noOfSheets);
			for (int i = 0; i < noOfSheets; i++) {
				ws = wb.getSheetAt(i);
				if (ws.getSheetName().equalsIgnoreCase("Addresses")) {
					Iterator<Row> ri = ws.rowIterator();
					Row header = ri.next();
					while (ri.hasNext()) {
						LinkedList<String> temp = new LinkedList<String>();
						Row contentRow = ri.next();
						Iterator<Cell> ci = contentRow.cellIterator();
						if (ci.next().getStringCellValue().equalsIgnoreCase("Yes")) {
							while (ci.hasNext()) {
								Cell currentCell = ci.next();
								String cellValue = currentCell.getStringCellValue();
								temp.add(cellValue);
							}
						}
						Object a = new Object();
						a = (Object) temp;
						objList.add(a);
					}

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objList.iterator();
	}

}