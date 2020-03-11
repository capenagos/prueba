package text.kardex.utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import common.kardex.utils.Excel;
import common.kardex.utils.GetProperties;

public class ExcelTest {
	
	private static Logger logger = Logger.getLogger(ExcelTest.class);
	private static String path = GetProperties.getInstance().getdataProperties("path_excel");

	@Before
	public void before() {
	
		String log4jConfPath = "resources\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);		
	}
	
	@Test
	public void testUpdateCell() {
		
		logger.info("Generado Prueba");
		Excel.updateCell(path,"Hoja1", 1, 3, "250");
		assertEquals("Se realizo la consulta correctaente",Excel.updateCell(path,"Hoja1", 1, 3, "2500"), true);
	}

	@Test
	public void testInserRowData() {
		
		ArrayList<Object> datas = new ArrayList<>();
		datas.add("Pad Mause");
		datas.add(2);
		datas.add(5000);
	
		Excel.inserRowData(path, "Hoja1", datas);
		assertEquals("Se realizo la consulta correctaente",Excel.inserRowData(path, "Hoja1", datas), true);
	}

	@Test
	public void testInsertRow() {
		
		Excel.insertRow(path, "Hoja1", 2);
		assertEquals("Se realizo la consulta correctaente",Excel.insertRow(path, "Hoja1", 1), true);
	}

}
