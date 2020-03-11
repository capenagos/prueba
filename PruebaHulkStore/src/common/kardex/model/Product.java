package common.kardex.model;

/**
 * 
 * @author Carlos Penagos
 *
 */
public class Product {

	/**
	 * Nombre del producto
	 */
	private String productName;
	/**
	 * Valor del producto de salida
	 */
	private double price;
	/**
	 * Precio de venta
	 */
	private double salePrice;
	/**
	 * ID del producto
	 * @return
	 */
	private long id;
	/**
	 * Cantidad del producto
	 * @return
	 */
	private int quantity;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

		

}
