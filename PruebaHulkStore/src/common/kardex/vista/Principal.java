package common.kardex.vista;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import common.kardex .controller.ControllerPruebaHulkStore;
import common.kardex .exception.PruebaHolkStroreEception;
import common.kardex .model.OutputProduct;
import common.kardex .model.ProductEntered;
import javax.swing.JEditorPane;
/**
 * 
 * @author Carlos Penagos
 *
 */
public class Principal extends JFrame {

	private static Logger logger = Logger.getLogger(Principal.class);
	/**
	 * contentPane
	 */
	private JPanel contentPane;
	/**
	 * outputPoduct
	 */
	private OutputProductPanel outputPoductPanel;
	/**
	 * Se guarda el objeto donde se encuentran los metodos para consultar datos
	 */
	private ControllerPruebaHulkStore controllerHulkStore;
	/**
	 * Buscar producto
	 */
	private SearchProduct searchProduct;
	/**
	 * Datos de producto
	 */
	private ProductEntered productEntered;
	/**
	 * Producto ingresado
	 */
	private EnterProduct enterProduct;
	/**
	 * Cantidad de producto en bodega
	 */
	private RemainingProduct remainingProduct;
	private JEditorPane editorPane;
	
	

	/**
	 * Create the frame.
	 */
	public Principal() {
		setAlwaysOnTop(true);
		
		controllerHulkStore = new ControllerPruebaHulkStore();
		productEntered = new ProductEntered();
		setTitle("Kardex Hulk Store");
		Image iconUser = new ImageIcon(this.getClass().getResource("/marvel.png")).getImage();
		setIconImage(iconUser);
		
		
        
		//setIcon(new ImageIcon(iconUser)); 
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(20, 20));
		setContentPane(contentPane);
		
		((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/fondo.png"));
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        

		searchProduct = new SearchProduct(this);
		contentPane.add(searchProduct, BorderLayout.NORTH);

		outputPoductPanel = new OutputProductPanel(this);
		contentPane.add(outputPoductPanel, BorderLayout.CENTER);

		remainingProduct = new RemainingProduct();
		contentPane.add(remainingProduct, BorderLayout.SOUTH);

		enterProduct = new EnterProduct(this);
		contentPane.add(enterProduct, BorderLayout.EAST);
		
		editorPane = new JEditorPane();
		enterProduct.add(editorPane);

	}

	public OutputProductPanel getOutputPoduct() {
		return outputPoductPanel;
	}

	/**
	 * metodo se usa paraencargado de guardar el producto retirado
	 * @throws PruebaHolkStroreEception
	 */
	public void saveOutputPoduct() throws PruebaHolkStroreEception {
		OutputProduct product = new OutputProduct();
		validateField("Producto", outputPoductPanel.getTextProduct());
		validateField("Valor Unidad", outputPoductPanel.getTextPrice());
		validateField("Cantidad", outputPoductPanel.getTextQuantity());
		validateInt("Cantidad", outputPoductPanel.getTextQuantity());
		validateDouble("Valor Unidad", outputPoductPanel.getTextPrice());
		product.setSalePrice((Double.parseDouble((outputPoductPanel.getTextPrice()))));
		product.setId(productEntered.getId());
		product.setQuantity(Integer.parseInt(outputPoductPanel.getTextQuantity()));
		product.setProductName(outputPoductPanel.getTextProduct());

		if (productEntered.getQuantity() < Integer.parseInt(outputPoductPanel.getTextQuantity())) {
			JOptionPane.showMessageDialog(this,
					" La cantidad de producto que desea retirar es mayor a la del inventario");
		} else {
			product.setQuantity(productEntered.getQuantity() + Integer.parseInt(outputPoductPanel.getTextQuantity()));
			controllerHulkStore.updateProduct(product);
			remainingProduct.setTxtTextproductcostinstock(String.valueOf(productEntered.getQuantity()));
			outputPoductPanel.clearOutputPoduct();
			remainingProduct.clearRemainingProduct();
			searchProduct.clearSearchProduct();
			enterProduct.clearEnterProduct();

		}

	}

	/**
	 * Este metodo se usa para buscar el producto
	 * 
	 * @throws PruebaHolkStroreEception
	 */
	public void searchProducto() throws PruebaHolkStroreEception {

		outputPoductPanel.clearOutputPoduct();
		remainingProduct.clearRemainingProduct();
		enterProduct.clearEnterProduct();

		productEntered.setProductName(searchProduct.getTextProduct());

		logger.info("Producto a buscar " + searchProduct.getTextProduct());
		validateField("Nombre del producto", searchProduct.getTextProduct());

		productEntered = controllerHulkStore.consult(productEntered);
		if (productEntered == null) {
			JOptionPane.showMessageDialog(this, "No se encontro el producto");
		} else {
			logger.info("Producto encontrado " + productEntered.getProductName());
			outputPoductPanel.setTextProduct(productEntered.getProductName());
			remainingProduct.setTxtTextproductcostinstock(String.valueOf(productEntered.getQuantity()));
			outputPoductPanel.setTextPrice(String.valueOf(productEntered.getSalePrice()));
		}

	}

	/**
	 * Este emtodo se utiliza para insertar un nuevo producto
	 * @throws PruebaHolkStroreEception
	 */
	public void inserProduct() throws PruebaHolkStroreEception {

		String nameProducto = enterProduct.getTextNameProduct();

		validateField("Producto", nameProducto);
		validateField("Valor", enterProduct.getTextPrice());
		validateField("Cantidad", enterProduct.getTextQuantity());
		validateInt("Cantidad", enterProduct.getTextQuantity());
		validateDouble("Valor", enterProduct.getTextPrice());
		 double price = Double.parseDouble(enterProduct.getTextPrice());
		int quantity = Integer.parseInt(enterProduct.getTextQuantity());

		productEntered.setProductName(nameProducto);
		logger.info("Producto a ingresar   nombre " + nameProducto + ", Cantidad " + quantity + ", precio " + price);
		if (controllerHulkStore.consult(productEntered) != null) {
			JOptionPane.showMessageDialog(this, "Este producto ya esta el la base de datos");
			logger.info("Este producto ya esta el la base de datos");
			throw new PruebaHolkStroreEception("Este producto ya esta el la base de datos");
		} else {

			productEntered.setProductName(nameProducto);
			productEntered.setPrice(price);
			productEntered.setQuantity(quantity);
			controllerHulkStore.insert(productEntered);
			outputPoductPanel.clearOutputPoduct();
			remainingProduct.clearRemainingProduct();
			searchProduct.clearSearchProduct();
			enterProduct.clearEnterProduct();


		}
		
	}

	/**
	 * Este metodo se usa para validar que los campos no esten vacios
	 * 
	 * @param nameField
	 * @param text
	 * @throws PruebaHolkStroreEception
	 */
	public void validateField(String nameField, String text) throws PruebaHolkStroreEception {
		if (text.length() < 1) {
			JOptionPane.showMessageDialog(this, "El campo " + nameField + " no puede esta vacio ");
			throw new PruebaHolkStroreEception("Campo " + nameField + " esta  vacio");

		}

	}

	/**
	 * Este metodo se usa para validar si el valor es un entero
	 * 
	 * @param nameField
	 * @param text
	 * @throws PruebaHolkStroreEception
	 */
	public void validateInt(String nameField, String text) throws PruebaHolkStroreEception {
		try {
			Integer.parseInt(text);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "El campo " + nameField + " no es un numero ");
			throw new PruebaHolkStroreEception("Campo " + nameField + " no es un numero");

		}

	}
	/**
	 * Este metodo se usa para validar si el valor es un double
	 * 
	 * @param nameField
	 * @param text
	 * @throws PruebaHolkStroreEception
	 */
	public void validateDouble(String nameField, String text) throws PruebaHolkStroreEception {
		try {
			Double.parseDouble(text);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "El campo " + nameField + " no es un numero ");
			throw new PruebaHolkStroreEception("Campo " + nameField + " no es un numero");

		}

	}	
	
}
