package fileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	FileInputStream fis=null;
	
	public String getDataFromExcel(String sheetname,int row,int cel) throws Exception, FileNotFoundException {
		fis= new FileInputStream("./testData/ShopperStackData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetname);
		String value=sheet.getRow(row).getCell(cel).toString();
		wb.close();
		
		return value;	
	}
	
	public int getRowCount(String sheetname) throws Exception {
		fis= new FileInputStream("./testData/ShopperStackData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetname);
		int row=sheet.getPhysicalNumberOfRows();
		wb.close();
		return row;
	}
	
	public int getCellCount(String sheetname) throws Exception {
		fis= new FileInputStream("./testData/ShopperStackData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetname);
		int cel=sheet.getRow(0).getPhysicalNumberOfCells();
		wb.close();
		return cel;
	}
	
	public void setDataInExcelFile(String sheetname,int row,int cell,String data) throws Exception {
		fis= new FileInputStream("./testData/ShopperStackData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetname);
		Cell cel=sheet.getRow(row).createCell(cell);
		cel.setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream("./testData/ShopperStackData.xlsx");
		wb.write(fos);
		fos.flush();
		wb.close();
	}
}
