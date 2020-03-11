package text.kardex.dao;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import common.kardex.dao.ExelProductEntered;
import common.kardex.model.ProductEntered;
import text.kardex.utils.ExcelTest;

public class ExelProductEnteredTest {
	
	private static Logger logger = Logger.getLogger(ExcelTest.class);
	private ExelProductEntered excelOutputPoduct;

	@Before
	public void before() {

		logger.info("Ejecutado prueba");
		String log4jConfPath = "resources\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);	
	}

	@Test
	public void testConsult() {
		
		ProductEntered product =new ProductEntered();
		product.setProductName("Vasos");
		product.setId(1);
		product.setQuantity(1);
		product.setSalePrice(3);
		
		excelOutputPoduct.consult(product);
		
		assertEquals("Se realizo la consulta correctaente",excelOutputPoduct.consult(product), true);
		
	}

}
