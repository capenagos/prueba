
package common.kardex.model;

import java.sql.Date;

/**
 * @author Carlos Penagos
 * Producto de salida
 */
public class OutputProduct extends Product{

	/**
	 * Fecha de la salida del producto
	 */
	private Date lastDepartureDate;
	/**
	 * Costo del total del producto
	 */
	private double outputProductCost;

	public Date getLastDepartureDate() {
		return lastDepartureDate;
	}
	public void setLastDepartureDate(Date lastDepartureDate) {
		this.lastDepartureDate = lastDepartureDate;
	}
	public double getOutputProductCost() {
		return outputProductCost;
	}
	public void setOutputProductCost(double outputProductCost) {
		this.outputProductCost = outputProductCost;
	}
	
	

}
