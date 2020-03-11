package common.kardex.vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.apache.log4j.Logger;

import common.kardex .exception.PruebaHolkStroreEception;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OutputProductPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * logger
	 */
	private static Logger logger = Logger.getLogger(OutputProductPanel.class);
	/**
	 * Se gurda el objeto de la clase principal
	 */
	private Principal principal;
	/**
	 * Cantidad de producto
	 */
	private JTextField textQuantity;
	/**
	 * precio del producto
	 */
	private JTextField textPrice;
	/**
	 * Label
	 */
	private JLabel lblProduct;
	/**
	 * Nombre del producto
	 */
	private JTextField textProduct;
	
	private JButton btnNewButton;

	public OutputProductPanel(Principal principal) {
		this();
		this.principal= principal;
	}
	/**
	 * Create the panel.
	 */
	public OutputProductPanel() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ingreso del producto de salida", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		setLayout(new GridLayout(0, 2, 4, 5));
		
		
		lblProduct = new JLabel("Producto");
		Image iconUser = new ImageIcon(this.getClass().getResource("/product.png")).getImage();
		lblProduct.setIcon(new ImageIcon(iconUser)); 
		add(lblProduct);
		
		textProduct = new JTextField();
		add(textProduct);
		textProduct.setBorder(BorderFactory.createCompoundBorder(textProduct.getBorder(), BorderFactory.createEmptyBorder(6, 6, 6, 6)));
		textProduct.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Valor Unidad");
		Image valorimg = new ImageIcon(this.getClass().getResource("/valor.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(valorimg));
		add(lblNewLabel_1);
		
		textPrice = new JTextField();
		add(textPrice);
		textPrice.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cantidad");
		Image cantidad = new ImageIcon(this.getClass().getResource("/cantidad.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(cantidad));
		add(lblNewLabel);
		
		textQuantity = new JTextField();
		add(textQuantity);
		textQuantity.setColumns(10);
		
		btnNewButton = new JButton("Guardar");
		Image saveimg = new ImageIcon(this.getClass().getResource("/guardar.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(saveimg));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					principal.saveOutputPoduct();
				} catch (PruebaHolkStroreEception e) {
					logger.error(e.getMessage());
				}
			}
		});
		add(btnNewButton);

	}

	public String getTextQuantity() {
		return textQuantity.getText();
	}

	public void setTextQuantity(String Quantity) {
		this.textQuantity.setText(Quantity);
	}

	public String getTextPrice() {
		return textPrice.getText();
	}

	public void setTextPrice(String textPrice) {
		this.textPrice.setText(textPrice);
	}

	
	public String getTextProduct() {
		return textProduct.getText();
	}

	public void setTextProduct(String textProduct) {
		this.textProduct.setText(textProduct);
	}
	
	/**
	 * Limpia los campos
	 */
	public void clearOutputPoduct() {
		
		textQuantity.setText("");
		textPrice.setText("");
		textProduct.setText("");
	}

}
