/**
 * 
 */
package common.kardex.exception;

/**
 * @author Carlos penagos
 *
 */

@SuppressWarnings("serial")
public class PruebaHolkStroreEception  extends Exception{

	public PruebaHolkStroreEception() {
		
	}
	/**
	 * Este metodo recibe como parametro el texto que se desea mostrar
	 * Cuando sucede un error
	 * @param message
	 */
	public PruebaHolkStroreEception (String message) {
		
		super(message);
	}
}
