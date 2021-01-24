package Mercadito;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Panel;

public class Stock {

	private JFrame frmControlDeStock;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock window = new Stock();
					window.frmControlDeStock.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Stock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmControlDeStock = new JFrame();
		frmControlDeStock.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\enzzo\\OneDrive\\Escritorio\\Curso de Java\\Primeros Pasos\\src\\graficos\\iron carita.png"));
		frmControlDeStock.setTitle("Control de Stock");
		frmControlDeStock.setBounds(100, 100, 737, 424);
		frmControlDeStock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmControlDeStock.getContentPane().setLayout(null);
		
		Label label = new Label("Carga de Productos");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(477, 10, 172, 22);
		frmControlDeStock.getContentPane().add(label);
		
		Label label_1 = new Label("Codigo de Producto:");
		label_1.setBounds(10, 38, 105, 22);
		frmControlDeStock.getContentPane().add(label_1);
		
		Label label_2 = new Label("Descripcion:");
		label_2.setBounds(41, 92, 74, 22);
		frmControlDeStock.getContentPane().add(label_2);
		
		Label label_3 = new Label("Cantidad:");
		label_3.setBounds(53, 122, 62, 22);
		frmControlDeStock.getContentPane().add(label_3);
		
		Label label_4 = new Label("Precio Unitario:");
		label_4.setBounds(29, 150, 86, 22);
		frmControlDeStock.getContentPane().add(label_4);
		
		Label label_5 = new Label("Fecha de Vencimiento:");
		label_5.setBounds(-2, 178, 117, 22);
		frmControlDeStock.getContentPane().add(label_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(121, 38, 126, 20);
		frmControlDeStock.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 211, 126, 20);
		frmControlDeStock.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(121, 94, 126, 20);
		frmControlDeStock.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(121, 122, 126, 20);
		frmControlDeStock.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(121, 152, 126, 20);
		frmControlDeStock.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(121, 180, 126, 20);
		frmControlDeStock.getContentPane().add(textField_5);
		
		Label label_6 = new Label("Fecha de Ingreso:");
		label_6.setBounds(10, 206, 105, 22);
		frmControlDeStock.getContentPane().add(label_6);
		
		Label label_7 = new Label("Busqueda de Productos");
		label_7.setFont(new Font("Arial", Font.BOLD, 14));
		label_7.setBounds(53, 10, 187, 22);
		frmControlDeStock.getContentPane().add(label_7);
		
		Label label_8 = new Label("Codigo de Producto:");
		label_8.setBounds(404, 38, 105, 22);
		frmControlDeStock.getContentPane().add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(515, 38, 126, 20);
		frmControlDeStock.getContentPane().add(textField_6);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\enzzo\\OneDrive\\Escritorio\\Curso de Java\\Primeros Pasos\\src\\Mercadito\\Sin t\u00EDtulo2.png"));
		button.setBounds(257, 27, 40, 31);
		frmControlDeStock.getContentPane().add(button);
		
		JButton btnCargar = new JButton("CARGAR");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCargar.setBounds(536, 226, 105, 31);
		frmControlDeStock.getContentPane().add(btnCargar);
		
		Label label_9 = new Label("Descripcion:");
		label_9.setBounds(435, 66, 74, 22);
		frmControlDeStock.getContentPane().add(label_9);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(515, 94, 126, 20);
		frmControlDeStock.getContentPane().add(textField_7);
		
		Label label_10 = new Label("Cantidad:");
		label_10.setBounds(445, 92, 62, 22);
		frmControlDeStock.getContentPane().add(label_10);
		
		Label label_11 = new Label("Precio Unitario:");
		label_11.setBounds(423, 122, 86, 22);
		frmControlDeStock.getContentPane().add(label_11);
		
		Label label_12 = new Label("Fecha de Vencimiento:");
		label_12.setBounds(392, 150, 117, 22);
		frmControlDeStock.getContentPane().add(label_12);
		
		Label label_13 = new Label("Fecha de Ingreso:");
		label_13.setBounds(404, 178, 101, 22);
		frmControlDeStock.getContentPane().add(label_13);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(515, 122, 126, 20);
		frmControlDeStock.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(515, 152, 126, 20);
		frmControlDeStock.getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(515, 183, 126, 20);
		frmControlDeStock.getContentPane().add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(515, 66, 126, 20);
		frmControlDeStock.getContentPane().add(textField_11);
		
		Label label_14 = new Label("Datos de Productos");
		label_14.setFont(new Font("Dialog", Font.BOLD, 12));
		label_14.setBounds(72, 66, 123, 22);
		frmControlDeStock.getContentPane().add(label_14);
		
		JButton btnGenerarPdf = new JButton("GENERAR PDF");
		btnGenerarPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerarPdf.setBounds(10, 343, 105, 31);
		frmControlDeStock.getContentPane().add(btnGenerarPdf);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(236, 343, 105, 31);
		frmControlDeStock.getContentPane().add(btnNuevo);
		
		JButton btnVerEnExcel = new JButton("VER EN Excel");
		btnVerEnExcel.setBounds(121, 343, 105, 31);
		frmControlDeStock.getContentPane().add(btnVerEnExcel);
		
		Label label_15 = new Label("Imagen:");
		label_15.setBounds(64, 271, 51, 22);
		frmControlDeStock.getContentPane().add(label_15);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(637, 343, 74, 31);
		frmControlDeStock.getContentPane().add(btnSalir);
		
		Panel panel = new Panel();
		panel.setBounds(121, 237, 101, 102);
		frmControlDeStock.getContentPane().add(panel);
	}

}
