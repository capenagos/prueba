package common.kardex.vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.apache.log4j.Logger;

import common.kardex .exception.PruebaHolkStroreEception;

public class SearchProduct extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(SearchProduct.class);
	/**
	 * Se gurda el objeto de la clase principal
	 */
	private Principal principal;
	/**
	/**
	 * Se guarda el nombre del producto
	 */
	private JTextField textProduct;

	public SearchProduct(Principal principal) {
		this();
		this.principal= principal;
	}
	/**
	 * Create the panel.
	 */
	public SearchProduct() {
		setBorder(new TitledBorder(null, "Buscar producto", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
		setLayout(new GridLayout(0, 2, 5, 5));
		
		JLabel searchProduct = new JLabel("Nombre del producto");
		Image productoimg = new ImageIcon(this.getClass().getResource("/producto.png")).getImage();
		searchProduct.setIcon(new ImageIcon(productoimg));
		add(searchProduct);
		
		
		textProduct = new JTextField();
		add(textProduct);
		textProduct.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Buscar");
		Image iconUser = new ImageIcon(this.getClass().getResource("/buscar.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(iconUser)); 
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					principal.searchProducto();
				} catch (PruebaHolkStroreEception e1) {
					logger.error(e1.getMessage());
				}
			}
		});
		add(btnNewButton);

	}

	/**
	 * Se obtiene el texto ingresado en el campo
	 * @return
	 */
	public String getTextProduct() {
		return textProduct.getText();
	}

	/**
	 *  Se envia texto al campo
	 * @param textProduct
	 */
	
	public void setTextProduct(String textProduct) {
		this.textProduct.setText(textProduct);
	}
	
	/**
	 * Este metodo se utiliza para limpiar el 
	 * campo donde se ingresa el producto a buscar
	 */
	public void clearSearchProduct() {
		textProduct.setText("");
	}
	

}
