/**
 * 
 */
package common.kardex.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import common.kardex .exception.PruebaHolkStroreEception;
import common.kardex .model.ProductEntered;
import common.kardex .utils.Excel;
import common.kardex .utils.GetProperties;

/**
 * @author Carlos Penagos
 *
 */
public class ExelProductEntered implements ProductEnteredDAO {

	private static Logger logger = Logger.getLogger(ExelProductEntered.class);
	private static String path = null;

	public ExelProductEntered() {
		path = GetProperties.getInstance().getdataProperties("path_excel");
		System.out.println("este es el path"+path);
	}

	@Override
	public void insert(ProductEntered productEntered) {

		List<Object> datas = new ArrayList<Object>();
		datas.add(productEntered.getProductName());
		datas.add(String.valueOf(productEntered.getQuantity()));
		datas.add(String.valueOf(productEntered.getPrice()));
		Excel.inserRowData(path, "Hoja1", datas);

	}

	@Override
	public void update(ProductEntered data) {

		Excel.updateCell(path, "Hoja1", (int) data.getId(), 0, String.valueOf(data.getProductName()));
		Excel.updateCell(path, "Hoja1", (int) data.getId(), 1, String.valueOf(data.getQuantity()));
		Excel.updateCell(path, "Hoja1", (int) data.getId(), 2, String.valueOf(data.getPrice()));

	}

	@Override
	public ProductEntered consult(ProductEntered product) {

		List<ArrayList<String>> data;
		try {
			data = Excel.readAll(path, "Hoja1");

			for (int i = 1; i < data.size(); i++) {
				logger.info(data.get(i));
				System.out.println(data.get(i));
				System.out.println(data.get(i).get(3));
				
				if (data.get(i).get(0).equalsIgnoreCase(product.getProductName())) {
					product.setProductName(data.get(i).get(0));
					product.setId(i);
					product.setQuantity(Integer.parseInt((data.get(i).get(1))));
					product.setSalePrice(Double.parseDouble(data.get(i).get(3)));
					return product;
				}
			}
		} catch (PruebaHolkStroreEception e) {
			logger.error(e.getMessage());
		}
		return null;

	}

}
