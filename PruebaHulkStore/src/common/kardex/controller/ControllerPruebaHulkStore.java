/**
 * 
 */
package common.kardex.controller;

import common.kardex .model.OutputProduct;
import common.kardex .model.ProductEntered;
import common.kardex .dao.ExcelOutputPoduct;
import common.kardex .dao.ExelProductEntered;

/**
 * @author Carlos Penagos
 *
 */
public class ControllerPruebaHulkStore {
	/**
	 * ExcelOutputPoduct
	 */
	private ExcelOutputPoduct excelOutputPoduct;
	/**
	 * ExelProductEntered
	 */
	private ExelProductEntered exelProductEntered;
	
	/**
	 * Constructor
	 */
	public ControllerPruebaHulkStore( ) {
		excelOutputPoduct=new ExcelOutputPoduct();
		exelProductEntered= new ExelProductEntered();
	}
	
	/**
	 * Actualiza los datos enviados
	 * @param outputPoduct
	 */
	public void updateProduct(OutputProduct outputPoduct) {
		
		excelOutputPoduct.update(outputPoduct);
		
	}
	/**
	 * Consuta el producto
	 * @param outputPoduct
	 * @return
	 */
	public OutputProduct consult(OutputProduct outputPoduct) {
		
		excelOutputPoduct.consult(outputPoduct);
		return outputPoduct;
		
	}
	
	/**
	 * Actualiza los datos enviados
	 * @param outputPoduct
	 */
	public void updateProduct(ProductEntered productEntered) {
		
		exelProductEntered.update(productEntered);
		
	}
	/**
	 * Consuta el producto
	 * @param outputPoduct
	 * @return
	 */
	public ProductEntered consult(ProductEntered productEntered) {
		
		
		return exelProductEntered.consult(productEntered);
		
	}
	/**
	 * Este metodo se utiliza 
	 * para insertar un nuevo producto
	 * @param productEntered
	 */
	public void insert(ProductEntered productEntered) {
		exelProductEntered.insert(productEntered);
	}
}
