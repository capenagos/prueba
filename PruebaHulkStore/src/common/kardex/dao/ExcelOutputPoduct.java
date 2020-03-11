/**
 * 
 */
package common.kardex.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import common.kardex .utils.Excel;
import common.kardex .utils.GetProperties;
import common.kardex .exception.PruebaHolkStroreEception;
import common.kardex .model.OutputProduct;

/**
 * @author Carlos Penagos
 *
 */
public class ExcelOutputPoduct implements OutputProductDAO {
	private static Logger logger = Logger.getLogger(ExcelOutputPoduct.class);
	private static String path = null;

	public ExcelOutputPoduct() {
		path = GetProperties.getInstance().getdataProperties("path_excel");
	}

	@Override
	public void insert(OutputProduct data) {

	}

	@Override
	public void update(OutputProduct data) {

		Excel.updateCell(path, "Hoja1", (int) data.getId(), 1, String.valueOf(data.getQuantity()));
		Excel.updateCell(path, "Hoja1", (int) data.getId(), 3, String.valueOf(data.getSalePrice()));

	}

	@Override
	public OutputProduct consult(OutputProduct product) {
		;
		List<ArrayList<String>> data;
		try {
			data = Excel.readAll(path, "Hoja1");

			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).get(0).contains(product.getProductName())) {
					product.setId(i);
					product.setQuantity(Integer.parseInt((data.get(i).get(1))));
					product.setPrice(Double.parseDouble(data.get(i).get(3)));
					return product;
				}
			}
		} catch (PruebaHolkStroreEception e) {
			
			logger.error(e.getMessage());
		}
		return null;
	}

}
