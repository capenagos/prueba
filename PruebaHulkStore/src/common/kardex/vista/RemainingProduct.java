package common.kardex.vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class RemainingProduct extends JPanel {
	/**
	 * Se guarda el valor de la cantidad de producto en la bodega
	 */
	private JTextField txtTextproductcostinstock;

	/**
	 * Create the panel.
	 */
	public RemainingProduct() {
		setBorder(new TitledBorder(null, "Resultado", TitledBorder.ABOVE_TOP, TitledBorder.TOP, null, Color.BLACK));
		setLayout(new GridLayout(0, 2, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Producto restante");
		add(lblNewLabel);
		
		txtTextproductcostinstock = new JTextField();
		add(txtTextproductcostinstock);
		txtTextproductcostinstock.setColumns(10);

	}

	/**
	 * Metodo empleado para enviar el calor del producto
	 * @param txtTextproductcostinstock
	 */
	public void setTxtTextproductcostinstock(String txtTextproductcostinstock) {
		this.txtTextproductcostinstock.setText(txtTextproductcostinstock);
	}
	
	public void clearRemainingProduct() {
		txtTextproductcostinstock.setText("");
		
	}
	
}
