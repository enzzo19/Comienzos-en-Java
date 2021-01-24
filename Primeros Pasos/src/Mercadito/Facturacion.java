package Mercadito;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.JComboBox;
import java.awt.List;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Cursor;

public class Facturacion extends JFrame {

	private JPanel contentPane;
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
	private JTable table;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facturacion frame = new Facturacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Facturacion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\enzzo\\OneDrive\\Escritorio\\Curso de Java\\Primeros Pasos\\src\\graficos\\iron carita.png"));
		setTitle("Facturacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Datos del Cliente");
		label.setBounds(53, 0, 105, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Nombres:");
		label_1.setBounds(0, 28, 62, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Apellidos:");
		label_2.setBounds(0, 56, 54, 22);
		contentPane.add(label_2);
		
		Label label_3 = new Label("DNI:");
		label_3.setBounds(29, 84, 26, 22);
		contentPane.add(label_3);
		
		Label label_4 = new Label("Direccion:");
		label_4.setBounds(0, 112, 54, 22);
		contentPane.add(label_4);
		
		Label label_5 = new Label("Telefono:");
		label_5.setBounds(0, 140, 54, 22);
		contentPane.add(label_5);
		
		textField = new JTextField();
		textField.setBounds(63, 28, 121, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(61, 56, 123, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(61, 86, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(61, 114, 123, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(61, 142, 86, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel = new JLabel("Forma de Pago:");
		lblNewLabel.setBounds(10, 168, 99, 22);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Efectivo");
		rdbtnNewRadioButton.setBounds(110, 169, 86, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnDebito = new JRadioButton("Debito");
		rdbtnDebito.setBounds(110, 195, 82, 23);
		contentPane.add(rdbtnDebito);
		
		JRadioButton rdbtnCredito = new JRadioButton("Credito");
		rdbtnCredito.setBounds(110, 221, 82, 23);
		contentPane.add(rdbtnCredito);
		
		Label label_6 = new Label("Datos de Productos");
		label_6.setBounds(277, 0, 105, 22);
		contentPane.add(label_6);
		
		Label label_7 = new Label("Codigo de Producto:");
		label_7.setBounds(238, 28, 105, 22);
		contentPane.add(label_7);
		
		Label label_8 = new Label("Descripcion:");
		label_8.setBounds(269, 56, 74, 22);
		contentPane.add(label_8);
		
		Label label_9 = new Label("Cantidad:");
		label_9.setBounds(281, 84, 62, 22);
		contentPane.add(label_9);
		
		Label label_10 = new Label("Precio Unitario:");
		label_10.setBounds(257, 112, 86, 22);
		contentPane.add(label_10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(349, 30, 146, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(349, 56, 146, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(349, 86, 121, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(349, 112, 121, 20);
		contentPane.add(textField_8);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(519, 111, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(618, 111, 89, 23);
		contentPane.add(btnNuevo);
		
		Label label_11 = new Label("Total del Producto");
		label_11.setBounds(577, 56, 109, 22);
		contentPane.add(label_11);
		
		textField_9 = new JTextField();
		textField_9.setBounds(583, 84, 99, 22);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		Label label_12 = new Label("Nombre del Producto");
		label_12.setBounds(556, 0, 136, 22);
		contentPane.add(label_12);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(549, 28, 158, 22);
		contentPane.add(textField_10);
		
		JLabel lblNewLabel_1 = new JLabel("Registro de Productos");
		lblNewLabel_1.setBounds(349, 154, 151, 18);
		contentPane.add(lblNewLabel_1);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		table.setAlignmentX(Component.RIGHT_ALIGNMENT);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Codigo de Producto", "Descripcion", "Cantidad", "Precio Unitario", "Total"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Codigo de Producto", "Descripcion", "Cantidad", "Precio Unitario", "Total"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setMinWidth(21);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setMinWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
		table.setBounds(233, 183, 428, 80);
		contentPane.add(table);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setBounds(577, 292, 105, 31);
		contentPane.add(btnGuardar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.setBounds(577, 339, 105, 31);
		contentPane.add(btnSalir);
		
		Label label_13 = new Label("SubTotal:");
		label_13.setBounds(238, 282, 62, 22);
		contentPane.add(label_13);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(309, 284, 146, 20);
		contentPane.add(textField_11);
		
		Label label_14 = new Label("IVA 21% :");
		label_14.setBounds(238, 311, 62, 22);
		contentPane.add(label_14);
		
		Label label_15 = new Label("Total:");
		label_15.setBounds(260, 339, 40, 22);
		contentPane.add(label_15);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(309, 315, 146, 20);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(309, 344, 146, 20);
		contentPane.add(textField_13);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\enzzo\\OneDrive\\Escritorio\\Curso de Java\\Primeros Pasos\\src\\Mercadito\\Sin t\u00EDtulo2.png"));
		btnNewButton_1.setBounds(505, 11, 40, 31);
		contentPane.add(btnNewButton_1);
	}
}
