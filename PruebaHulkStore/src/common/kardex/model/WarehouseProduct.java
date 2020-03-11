/**
 * 
 */
package common.kardex.model;

/**
 * @author Carlos Penagos
 * producto restante
 */
public class WarehouseProduct extends Product {

	/**
	 * Costo del producto en bodega segun el 
	 * el ultimo valor de salida
	 */
	private double productCostInStock;
	/**
	 * Cantidad de productos den bodega
	 */
	private int quantityOfProductInStock;
	
	public double getProductCostInStock() {
		return productCostInStock;
	}
	public void setProductCostInStock(double productCostInStock) {
		this.productCostInStock = productCostInStock;
	}
	public int getQuantityOfProductInStock() {
		return quantityOfProductInStock;
	}
	public void setQuantityOfProductInStock(int quantityOfProductInStock) {
		this.quantityOfProductInStock = quantityOfProductInStock;
	}
	
	
}
