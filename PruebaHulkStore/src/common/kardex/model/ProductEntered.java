/**
 * 
 */
package common.kardex.model;

import java.sql.Date;

/**
 * @author Carlos Penagos
 *
 */
public class ProductEntered extends Product{

	/**
	 * Fecha de ultimo ingreso del producto
	 */
	private Date lastEntryDate;
	/**
	 * Costo del total del producto
	 */
	private double enteredProductCost;
	
	public Date getLastEntryDate() {
		return lastEntryDate;
	}
	public void setLastEntryDate(Date lastEntryDate) {
		this.lastEntryDate = lastEntryDate;
	}
	public double getEnteredProductCost() {
		return enteredProductCost;
	}
	public void setEnteredProductCost(double enteredProductCost) {
		this.enteredProductCost = enteredProductCost;
	}
	
	
	
}
