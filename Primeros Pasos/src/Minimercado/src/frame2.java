import java.awt.EventQueue;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class frame2 {

	private JFrame frame2;
	private JTextField textVenta;
	private JTextField textFactura;
	private JTextField ingresoNombreCliente;
	private JTextField ingresoDniCliente;
	private JTextField txtIva;
	private JTextField txtSubtotal;
	private JTextField txtTotal;
	private JTextField ingresoCodigo1;
	private JTable table;
	private JTextField ingresoCodigo2;
	private JTable table_1;
	private JTextField ingresoCodigo3;
	private JTable tablaControlStock;
	private JTable tablaControlStock_1;
	private JTextField ingresoNombre1;
	private JTextField ingresoStock1;
	private JTextField ingresoPrecio1;
	private JTextField ingresoFecha;
	private JTextField ingresoCodigo5;
	private JTextField ingresoStock2;
	private JTextField ingresoPrecio2;
	private JTextField ingresoNombre;
	private JTable tablaEmpleados;
	private JTextField ingresoNombre2;
	private JTextField ingresoCorreo;
	private JTextField ingresoDni;
	private JTextField ingresoApellido2;
	private JTextField ingresoDni2;
	private JTextField ingresoDni3;
	private JTextField ingresoTelefono;
	java.sql.Statement stmt;
	java.sql.Connection conexion;
	String dato[];
	DefaultTableModel model=new DefaultTableModel();
	private JTable table_2;
	private JTable table_2_1;
	private JTable table_4;
	private JPasswordField ingresoContraseña2;
	private JTable table_3;
	private JTextField textField_3;
	private JTextField txtDescuento;
	private JComboBox comboDescuento;
	DecimalFormat df = new DecimalFormat("#.00");

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		String className = getLookAndFeelClassName("Windows");
		try {
			UIManager.setLookAndFeel(className);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 window = new frame2();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public static String getLookAndFeelClassName(String nameSnippet) {
	    LookAndFeelInfo[] plafs = UIManager.getInstalledLookAndFeels();
	    for (LookAndFeelInfo info : plafs) {
	        if (info.getName().contains(nameSnippet)) {
	            return info.getClassName();
	        }
	    }
	    return null;
	}
	public frame2() {
		initialize();
	}
	private void calcularTotal() {
		float sum=0;
		for(int i=0; i<table_1.getRowCount(); i++) {
			sum=sum+Float.valueOf((String) table_1.getValueAt(i, 3));
		}
		double desc=0;
		switch((String)comboDescuento.getSelectedItem()) {
			case "0 %": desc=0.0;
			break;
			case "5 %": desc=0.05;
			break;
			case "10 %": desc=0.1;
			break;
			case "15 %": desc=0.15;
			break;
			case "20 %": desc=0.2;
			break;
			case "25 %": desc=0.25;
			break;
			case "30 %": desc=0.3;
			break;
			case "40 %": desc=0.4;
			break;
			case "50 %": desc=0.5;
			break;
		}
		txtSubtotal.setText(String.valueOf(df.format(sum)));
		txtDescuento.setText(String.valueOf(df.format(sum-sum*desc)));
		txtIva.setText(String.valueOf(df.format((sum-sum*desc)+(sum-sum*desc)*0.21)));
		txtTotal.setText(String.valueOf(df.format((sum-sum*desc)+(sum-sum*desc)*0.21)));
	}
	private void cargarTabla2(JTable tabla) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
			
			model=new DefaultTableModel();
			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Stock");
			model.addColumn("Precio");
			model.addColumn("Fehca de ingreso");
			tabla.setModel(model);
			
			dato=new String[5];
			stmt=conexion.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * from productos");
			
			while(result.next()) {
				dato[0]=result.getString(1);
				dato[1]=result.getString(2);
				dato[2]=result.getString(3);
				dato[3]=result.getString(4);
				dato[4]=result.getString(5);
				model.addRow(dato);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void cargarTabla3(JTable tabla) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
			
			model=new DefaultTableModel();
			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Stock");
			model.addColumn("Precio");
			model.addColumn("Fehca de ingreso");
			tabla.setModel(model);
			
			dato=new String[5];
			stmt=conexion.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * from carrito");
			
			while(result.next()) {
				dato[0]=result.getString(1);
				dato[1]=result.getString(2);
				dato[2]=result.getString(3);
				dato[3]=result.getString(4);
				dato[4]=result.getString(5);
				model.addRow(dato);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void cargarTablaEmpleados() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
			
			model=new DefaultTableModel();
			model.addColumn("Nombre");
			model.addColumn("Apellido");
			model.addColumn("DNI");
			model.addColumn("Correo");
			model.addColumn("Teléfono");
			model.addColumn("Cargo");
			model.addColumn("Turno");
			tablaEmpleados.setModel(model);
			
			dato=new String[10];
			stmt=conexion.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * from empleados");
			
			while(result.next()) {
				dato[0]=result.getString(3);
				dato[1]=result.getString(4);
				dato[2]=result.getString(5);
				dato[3]=result.getString(6);
				dato[4]=result.getString(7);
				dato[5]=result.getString(8);
				dato[6]=result.getString(9);
				model.addRow(dato);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void buscarTablaEmpleados(String x, JTextField texto) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
			
			model=new DefaultTableModel();
			model.addColumn("Nombre");
			model.addColumn("Apellido");
			model.addColumn("DNI");
			model.addColumn("Correo");
			model.addColumn("Teléfono");
			model.addColumn("Cargo");
			model.addColumn("Turno");
			tablaEmpleados.setModel(model);
			
			String dato[]=new String[10];
			stmt=conexion.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * from empleados WHERE "+x+"='"+texto.getText()+"'");
			
			while(result.next()) {
				dato[0]=result.getString(3);
				dato[1]=result.getString(4);
				dato[2]=result.getString(5);
				dato[3]=result.getString(6);
				dato[4]=result.getString(7);
				dato[5]=result.getString(8);
				dato[6]=result.getString(9);
				model.addRow(dato);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void buscarTabla2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
			
			model=new DefaultTableModel();
			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Stock");
			model.addColumn("Precio");
			model.addColumn("Fehca de ingreso");
			tablaControlStock_1.setModel(model);
			
			String dato[]=new String[5];
			stmt=conexion.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * from productos WHERE ID='"+ingresoCodigo3.getText()+"'");
			
			while(result.next()) {
				dato[0]=result.getString(1);
				dato[1]=result.getString(2);
				dato[2]=result.getString(3);
				dato[3]=result.getString(4);
				dato[4]=result.getString(5);
				model.addRow(dato);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void buscarTabla3() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
			
			model=new DefaultTableModel();
			model.addColumn("ID");
			model.addColumn("Nombre");
			model.addColumn("Stock");
			model.addColumn("Precio");
			model.addColumn("Fehca de ingreso");
			table.setModel(model);
			
			String dato[]=new String[5];
			stmt=conexion.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * from productos WHERE ID='"+ingresoCodigo1.getText()+"'");
			
			while(result.next()) {
				dato[0]=result.getString(1);
				dato[1]=result.getString(2);
				dato[2]=result.getString(3);
				dato[3]=result.getString(4);
				dato[4]=result.getString(5);
				model.addRow(dato);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
		} catch (Exception e1) {
		}
		
		
		frame2 = new JFrame();
		frame2.setVisible(true);
		frame2.setResizable(false);
		frame2.setContentPane(new JLabel(new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\fondo2.png")));
		frame2.setTitle("Sistema de control de stock y ventas");
		frame2.setBounds(100, 100, 1040, 600);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 62, 1028, 498);
		frame2.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		tabbedPane.addTab("Sistema de ventas", null, panel, null);
		panel.setLayout(null);
		
		JTextPane txtVenta_1 = new JTextPane();
		txtVenta_1.setText("Venta N\u00B0");
		txtVenta_1.setForeground(Color.BLACK);
		txtVenta_1.setEditable(false);
		txtVenta_1.setBackground(SystemColor.control);
		txtVenta_1.setBounds(10, 0, 50, 20);
		panel.add(txtVenta_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.setBounds(10, 21, 370, 83);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane txtVenta = new JTextPane();
		txtVenta.setBounds(15, 11, 50, 20);
		panel_1.add(txtVenta);
		txtVenta.setText("Venta N\u00B0");
		txtVenta.setBackground(SystemColor.control);
		txtVenta.setForeground(Color.BLACK);
		txtVenta.setEditable(false);
		
		textVenta = new JTextField("Aa-"+(int)(Math.random() * 96) + 98);
		textVenta.setEditable(false);
		textVenta.setBounds(80, 11, 114, 20);
		panel_1.add(textVenta);
		textVenta.setColumns(10);
		
		JTextPane txtFactura = new JTextPane();
		txtFactura.setText("Factura N\u00B0");
		txtFactura.setForeground(Color.BLACK);
		txtFactura.setEditable(false);
		txtFactura.setBackground(SystemColor.menu);
		txtFactura.setBounds(11, 44, 59, 20);
		panel_1.add(txtFactura);
		
		textFactura = new JTextField("Aa-"+(int)(Math.random() * 98) + 79);
		textFactura.setEditable(false);
		textFactura.setColumns(10);
		textFactura.setBounds(80, 42, 114, 20);
		panel_1.add(textFactura);
		
		JTextPane txtTipo = new JTextPane();
		txtTipo.setText("Tipo");
		txtTipo.setForeground(Color.BLACK);
		txtTipo.setEditable(false);
		txtTipo.setBackground(SystemColor.menu);
		txtTipo.setBounds(256, 11, 50, 20);
		panel_1.add(txtTipo);
		
		JComboBox comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Contado", "D\u00E9bito", "Cr\u00E9dito", "Mercado Pago", "Mercado Pago (QR)"}));
		comboTipo.setBounds(217, 41, 132, 22);
		panel_1.add(comboTipo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_2.setBounds(398, 22, 370, 83);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JTextPane txtNombre = new JTextPane();
		txtNombre.setText("Nombre");
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setEditable(false);
		txtNombre.setBackground(SystemColor.menu);
		txtNombre.setBounds(15, 11, 44, 20);
		panel_2.add(txtNombre);
		
		ingresoNombreCliente = new JTextField();
		ingresoNombreCliente.setColumns(10);
		ingresoNombreCliente.setBounds(80, 11, 128, 20);
		panel_2.add(ingresoNombreCliente);
		
		JTextPane txtDni = new JTextPane();
		txtDni.setText("DNI");
		txtDni.setForeground(Color.BLACK);
		txtDni.setEditable(false);
		txtDni.setBackground(SystemColor.menu);
		txtDni.setBounds(25, 42, 25, 20);
		panel_2.add(txtDni);
		
		ingresoDniCliente = new JTextField();
		ingresoDniCliente.setColumns(10);
		ingresoDniCliente.setBounds(80, 42, 128, 20);
		panel_2.add(ingresoDniCliente);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Es cliente");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnNewRadioButton.isSelected()) {
					ingresoNombreCliente.setEditable(false);
					ingresoNombreCliente.setText("");
				}
				else {ingresoNombreCliente.setEditable(true);}
			}
		});
		rdbtnNewRadioButton.setBounds(236, 28, 84, 23);
		panel_2.add(rdbtnNewRadioButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_3.setBounds(778, 21, 235, 197);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JTextPane txtDescuento_1 = new JTextPane();
		txtDescuento_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDescuento_1.setText("Descuento");
		txtDescuento_1.setForeground(Color.BLACK);
		txtDescuento_1.setEditable(false);
		txtDescuento_1.setBackground(SystemColor.menu);
		txtDescuento_1.setBounds(10, 54, 68, 20);
		panel_3.add(txtDescuento_1);
		
		JTextPane txtVenta_2_1 = new JTextPane();
		txtVenta_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVenta_2_1.setText("Subtotal");
		txtVenta_2_1.setForeground(Color.BLACK);
		txtVenta_2_1.setEditable(false);
		txtVenta_2_1.setBackground(SystemColor.menu);
		txtVenta_2_1.setBounds(17, 29, 54, 20);
		panel_3.add(txtVenta_2_1);
		
		JTextPane txtVenta_2_1_1 = new JTextPane();
		txtVenta_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVenta_2_1_1.setText("IVA 21%");
		txtVenta_2_1_1.setForeground(Color.BLACK);
		txtVenta_2_1_1.setEditable(false);
		txtVenta_2_1_1.setBackground(SystemColor.menu);
		txtVenta_2_1_1.setBounds(16, 112, 57, 20);
		panel_3.add(txtVenta_2_1_1);
		
		JTextPane txtVenta_2_1_2 = new JTextPane();
		txtVenta_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtVenta_2_1_2.setText("TOTAL");
		txtVenta_2_1_2.setForeground(Color.BLACK);
		txtVenta_2_1_2.setEditable(false);
		txtVenta_2_1_2.setBackground(SystemColor.menu);
		txtVenta_2_1_2.setBounds(13, 156, 62, 20);
		panel_3.add(txtVenta_2_1_2);
		
		txtIva = new JTextField();
		txtIva.setText("0.0");
		txtIva.setEditable(false);
		txtIva.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIva.setBounds(113, 112, 93, 20);
		panel_3.add(txtIva);
		txtIva.setColumns(10);
		
		JTextPane txtVenta_2_1_3 = new JTextPane();
		txtVenta_2_1_3.setText("$");
		txtVenta_2_1_3.setForeground(Color.BLACK);
		txtVenta_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVenta_2_1_3.setEditable(false);
		txtVenta_2_1_3.setBackground(SystemColor.menu);
		txtVenta_2_1_3.setBounds(90, 112, 14, 20);
		panel_3.add(txtVenta_2_1_3);
		
		JTextPane txtVenta_2_1_3_1 = new JTextPane();
		txtVenta_2_1_3_1.setText("$");
		txtVenta_2_1_3_1.setForeground(Color.BLACK);
		txtVenta_2_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVenta_2_1_3_1.setEditable(false);
		txtVenta_2_1_3_1.setBackground(SystemColor.menu);
		txtVenta_2_1_3_1.setBounds(90, 29, 14, 20);
		panel_3.add(txtVenta_2_1_3_1);
		
		JTextPane txtVenta_2_1_3_2 = new JTextPane();
		txtVenta_2_1_3_2.setText("$");
		txtVenta_2_1_3_2.setForeground(Color.BLACK);
		txtVenta_2_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVenta_2_1_3_2.setEditable(false);
		txtVenta_2_1_3_2.setBackground(SystemColor.menu);
		txtVenta_2_1_3_2.setBounds(90, 156, 14, 20);
		panel_3.add(txtVenta_2_1_3_2);
		
		txtSubtotal = new JTextField();
		txtSubtotal.setText("0.0");
		txtSubtotal.setEditable(false);
		txtSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSubtotal.setColumns(10);
		txtSubtotal.setBounds(113, 29, 93, 20);
		panel_3.add(txtSubtotal);
		
		txtTotal = new JTextField();
		txtTotal.setText("0.0");
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setEditable(false);
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTotal.setColumns(10);
		txtTotal.setBounds(113, 151, 93, 30);
		panel_3.add(txtTotal);
		
		txtDescuento = new JTextField();
		txtDescuento.setText("0.0");
		txtDescuento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDescuento.setEditable(false);
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(113, 69, 93, 20);
		panel_3.add(txtDescuento);
		
		JTextPane txtVenta_2_1_3_3 = new JTextPane();
		txtVenta_2_1_3_3.setText("$");
		txtVenta_2_1_3_3.setForeground(Color.BLACK);
		txtVenta_2_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtVenta_2_1_3_3.setEditable(false);
		txtVenta_2_1_3_3.setBackground(SystemColor.menu);
		txtVenta_2_1_3_3.setBounds(90, 69, 14, 20);
		panel_3.add(txtVenta_2_1_3_3);
		
		comboDescuento = new JComboBox();
		comboDescuento.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				calcularTotal();
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
			}
		});
		comboDescuento.setBounds(13, 79, 62, 22);
		comboDescuento.setModel(new DefaultComboBoxModel(new String[] {"0 %", "5 %", "10 %", "15 %", "20 %", "25 %", "30 %", "40 %", "50 %"}));
		panel_3.add(comboDescuento);
		
		JTextPane txtCliente = new JTextPane();
		txtCliente.setText("Cliente");
		txtCliente.setForeground(Color.BLACK);
		txtCliente.setEditable(false);
		txtCliente.setBackground(SystemColor.menu);
		txtCliente.setBounds(398, 2, 50, 20);
		panel.add(txtCliente);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_4.setBounds(10, 134, 758, 325);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JTextPane txtpnCdigo = new JTextPane();
		txtpnCdigo.setText("C\u00F3digo");
		txtpnCdigo.setForeground(Color.BLACK);
		txtpnCdigo.setEditable(false);
		txtpnCdigo.setBackground(SystemColor.menu);
		txtpnCdigo.setBounds(10, 11, 40, 23);
		panel_4.add(txtpnCdigo);
		
		ingresoCodigo1 = new JTextField();
		ingresoCodigo1.setColumns(10);
		ingresoCodigo1.setBounds(53, 11, 224, 23);
		panel_4.add(ingresoCodigo1);
		
		JButton btnMostrarTodos2 = new JButton((Icon) null);
		btnMostrarTodos2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarTabla2(table);
				btnMostrarTodos2.setEnabled(false);
			}
		});
		btnMostrarTodos2.setText("Mostrar todos");
		btnMostrarTodos2.setEnabled(false);
		btnMostrarTodos2.setBounds(386, 11, 102, 23);
		panel_4.add(btnMostrarTodos2);
		
		JButton botonBuscar1 = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\buscar.png").getImage().getScaledInstance(15, 15,java.awt.Image.SCALE_SMOOTH)))));
		botonBuscar1.setText("Buscar");
		botonBuscar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarTabla3();
				btnMostrarTodos2.setEnabled(true);
			}
		});
		botonBuscar1.setBounds(287, 11, 89, 23);
		panel_4.add(botonBuscar1);
		
		table = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex) {return false;}
		};
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_3.setText(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
			}
		});
		
		cargarTabla2(table);
		table.setBounds(10, 57, 738, 98);
		panel_4.add(table);
		
		JTextPane txtpnCantidad = new JTextPane();
		txtpnCantidad.setText("Cantidad");
		txtpnCantidad.setForeground(Color.BLACK);
		txtpnCantidad.setEditable(false);
		txtpnCantidad.setBackground(SystemColor.menu);
		txtpnCantidad.setBounds(169, 166, 50, 20);
		panel_4.add(txtpnCantidad);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(224, 168, 35, 20);
		panel_4.add(spinner);
		
		JButton botonAñadir1 = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\añadir.png").getImage().getScaledInstance(15, 15,java.awt.Image.SCALE_SMOOTH)))));
		botonAñadir1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_3.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingresar código del producto");
				}
				else {
					try {
						int aux=0;
						Class.forName("com.mysql.jdbc.Driver");
						conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
						for(int i=0; i<table.getRowCount(); i++) {
							if(table.getValueAt(i, 0).equals(textField_3.getText())) {aux=i;}
						}
						stmt=conexion.createStatement();
						stmt.executeUpdate("INSERT INTO carrito (ID,Nombre,Stock,Precio,FechaIngreso) values('"+textField_3.getText()+"','"+table.getValueAt(aux,1)+"','"+(Integer)spinner.getValue()+"','"+table.getValueAt(aux,3)+"','"+table.getValueAt(aux,4)+"')");
						stmt=conexion.createStatement();
						stmt.executeUpdate("UPDATE productos SET Stock='"+((Integer.parseInt((String) table.getValueAt(aux,2)))-((Integer)spinner.getValue()))+"' WHERE ID="+textField_3.getText());
						cargarTabla2(table);
						cargarTabla3(table_1);
						textField_3.setText(null);
						spinner.setValue(1);
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Error al agregar el producto");
						e.printStackTrace();
					}
					calcularTotal();
				}
			}
		});
		botonAñadir1.setText("A\u00F1adir");
		botonAñadir1.setBounds(269, 166, 89, 23);
		panel_4.add(botonAñadir1);
		
		JButton botonEliminar1 = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\menos.png").getImage().getScaledInstance(15, 15,java.awt.Image.SCALE_SMOOTH)))));
		botonEliminar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ingresoCodigo2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrsar código del producto");
				}
				else {
					try {
						int aux=0,aux2=0;
						Class.forName("com.mysql.jdbc.Driver");
						conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
						for(int i=0; i<table.getRowCount(); i++) {
							if(table.getValueAt(i, 0).equals(ingresoCodigo2.getText())) {aux=i;}
						}
						for(int i=0; i<table_1.getRowCount(); i++) {
							if(table_1.getValueAt(i, 0).equals(ingresoCodigo2.getText())) {aux2=i;}
						}
						stmt=conexion.createStatement();
						stmt.executeUpdate("UPDATE productos SET Stock='"+((Integer.parseInt((String) table.getValueAt(aux,2)))+(Integer.parseInt((String) table_1.getValueAt(aux2,2)))+"' WHERE ID="+ingresoCodigo2.getText()));
						stmt=conexion.createStatement();
						stmt.executeUpdate("DELETE from carrito WHERE ID="+ingresoCodigo2.getText());
						cargarTabla2(table);
						cargarTabla3(table_1);
						ingresoCodigo2.setText(null);
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Error al agregar el producto");
						e.printStackTrace();
					}
					calcularTotal();
				}
			}
		});
		botonEliminar1.setText("Eliminar");
		botonEliminar1.setBounds(640, 166, 89, 23);
		panel_4.add(botonEliminar1);
		
		ingresoCodigo2 = new JTextField();
		ingresoCodigo2.setColumns(10);
		ingresoCodigo2.setBounds(526, 166, 104, 23);
		panel_4.add(ingresoCodigo2);
		
		JTextPane txtpnCdigo_1 = new JTextPane();
		txtpnCdigo_1.setText("C\u00F3digo");
		txtpnCdigo_1.setForeground(Color.BLACK);
		txtpnCdigo_1.setEditable(false);
		txtpnCdigo_1.setBackground(SystemColor.menu);
		txtpnCdigo_1.setBounds(481, 166, 44, 23);
		panel_4.add(txtpnCdigo_1);
		
		table_1 = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		table_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ingresoCodigo2.setText(String.valueOf(table_1.getValueAt(table_1.getSelectedRow(), 0)));
			}
		});
		table_1.setBounds(10, 198, 738, 113);
		panel_4.add(table_1);
		
		cargarTabla3(table_1);
		
		table_3 = new JTable() {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		table_3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table_3.setRowSelectionAllowed(false);
		table_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_3.setModel(new DefaultTableModel(
				new Object[][] {
					{"ID", "Nombre", "Stock", "Precio", "Fecha de ingreso"},
				},
				new String[] {
					"New column", "New column", "New column", "New column", "New column"
				}
			));
		table_3.setBounds(10, 41, 738, 18);
		panel_4.add(table_3);
		
		JTextPane txtpnCdigo_1_1 = new JTextPane();
		txtpnCdigo_1_1.setText("C\u00F3digo");
		txtpnCdigo_1_1.setForeground(Color.BLACK);
		txtpnCdigo_1_1.setEditable(false);
		txtpnCdigo_1_1.setBackground(SystemColor.menu);
		txtpnCdigo_1_1.setBounds(10, 166, 44, 23);
		panel_4.add(txtpnCdigo_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(55, 166, 104, 23);
		panel_4.add(textField_3);
		
		JTextPane txtProductos = new JTextPane();
		txtProductos.setText("Productos");
		txtProductos.setForeground(Color.BLACK);
		txtProductos.setEditable(false);
		txtProductos.setBackground(SystemColor.menu);
		txtProductos.setBounds(10, 115, 50, 20);
		panel.add(txtProductos);
		
		JTextPane txtpnObservaciones = new JTextPane();
		txtpnObservaciones.setText("Observaciones");
		txtpnObservaciones.setForeground(Color.BLACK);
		txtpnObservaciones.setEditable(false);
		txtpnObservaciones.setBackground(SystemColor.menu);
		txtpnObservaciones.setBounds(778, 229, 78, 20);
		panel.add(txtpnObservaciones);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(778, 249, 235, 83);
		panel.add(panel_2_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textPane.setForeground(Color.BLACK);
		textPane.setBounds(10, 11, 215, 61);
		panel_2_1.add(textPane);
		
		JButton botonImprimir = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\imprimir.png").getImage().getScaledInstance(30, 30,java.awt.Image.SCALE_SMOOTH)))));
		botonImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((!rdbtnNewRadioButton.isSelected() && (ingresoNombreCliente.getText().equals("") || ingresoDniCliente.getText().equals("")))||(rdbtnNewRadioButton.isSelected() && (ingresoDniCliente.getText().equals("")))) {
					JOptionPane.showMessageDialog(null, "Completar datos del cliente");	
				}
				else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
						ResultSet result=stmt.executeQuery("SELECT * from carrito");
						if(!result.absolute(1)) {
							JOptionPane.showMessageDialog(null, "No se encontraron productos en el carrito");	
						}
						else {
							try {
					            PrintWriter writer = new PrintWriter("C:\\Archivos mercado\\Factura.txt", "UTF-8");
					            writer.println("                ******NOMBRE DEL NEGOCIO******");
					            writer.println("");
					            writer.println("       Dirección                   Att al cliente 0800-telfono");
					            writer.println(" N° Fact: "+textFactura.getText()+"         N° Venta: "+textVenta.getText());
					            writer.println("------------------------------------------------------------------");
					            for(int i=0; i<table_1.getRowCount(); i++) {
					            	writer.println("cant. "+table_1.getValueAt(i, 2)+"     "+table_1.getValueAt(i, 1)+"               $"+table_1.getValueAt(i, 3));
					            }
					            writer.println("------------------------------------------------------------------");
					            writer.println("                              subtotal: "+txtSubtotal.getText());
					            writer.println("                             Descuento: "+txtDescuento.getText());
					            writer.println("                                 TOTAL: "+txtTotal.getText());
					            writer.println("    IVA 21 %");
					            writer.println("Pago con "+comboTipo.getSelectedItem());
					            writer.println("Plazo de devolución: 15 días. Conserve ticket");
					            writer.println("");
					            writer.println("");
					            writer.println(new Date());
					            writer.println("Le atedió "+"NOMBRE DE USUARIO");
					            if(textPane.getText().equals("")){writer.println("Observaciones: ninguna");}
					            else {writer.println("Observaciones: "+textPane.getText());}
					            writer.close();
					            
								Class.forName("com.mysql.jdbc.Driver");
								conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
								stmt=conexion.createStatement();
								stmt.executeUpdate("DELETE from carrito");
								cargarTabla3(table_1);
								ingresoNombreCliente.setText("");
								ingresoDniCliente.setText("");
								rdbtnNewRadioButton.setSelected(false);
								ingresoCodigo1.setText("");
								textField_3.setText("");
								ingresoCodigo2.setText("");
								textPane.setText("");
								txtSubtotal.setText("");
								txtDescuento.setText("");
								txtIva.setText("");
								txtTotal.setText("");
								spinner.setValue(1);
								comboDescuento.setSelectedIndex(0);
								
								JOptionPane.showMessageDialog(null, "Compra completada correctamente. Se creó un archivo de texto con la factura");
					        } catch (Exception e) {
					            e.printStackTrace();
					        }
						}
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Error. No se completó la compra");
						e.printStackTrace();
					}
				}
			}
		});
		botonImprimir.setText("Imprimir");
		botonImprimir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonImprimir.setBounds(830, 343, 131, 41);
		panel.add(botonImprimir);
		
		JButton botonCancelar1 = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\eliminar.png").getImage().getScaledInstance(20, 20,java.awt.Image.SCALE_SMOOTH)))));
		botonCancelar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resp=JOptionPane.showConfirmDialog(null,"Se eliminarán los datos registrados, ¿Desea continuar?");
				if(resp==0) {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
						stmt=conexion.createStatement();
						stmt.executeUpdate("DELETE from carrito");
						cargarTabla3(table_1);
						ingresoNombreCliente.setText("");
						ingresoDniCliente.setText("");
						rdbtnNewRadioButton.setSelected(false);
						ingresoCodigo1.setText("");
						textField_3.setText("");
						ingresoCodigo2.setText("");
						textPane.setText("");
						txtSubtotal.setText("");
						txtDescuento.setText("");
						txtIva.setText("");
						txtTotal.setText("");
						spinner.setValue(1);
						comboDescuento.setSelectedIndex(0);
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Error al eliminar los productos");
						e.printStackTrace();
					}
				}
			}
		});
		botonCancelar1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonCancelar1.setText("Cancelar");
		botonCancelar1.setBounds(838, 395, 115, 33);
		panel.add(botonCancelar1);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Control de stock", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_4_1.setBounds(10, 30, 758, 429);
		panel_5.add(panel_4_1);
		panel_4_1.setLayout(null);
		
		ingresoCodigo3 = new JTextField();
		ingresoCodigo3.setBounds(10, 33, 224, 23);
		ingresoCodigo3.setColumns(10);
		panel_4_1.add(ingresoCodigo3);
		
		JTextPane txtpnCdigo_2 = new JTextPane();
		txtpnCdigo_2.setBounds(10, 11, 40, 23);
		txtpnCdigo_2.setText("C\u00F3digo");
		txtpnCdigo_2.setForeground(Color.BLACK);
		txtpnCdigo_2.setEditable(false);
		txtpnCdigo_2.setBackground(SystemColor.menu);
		panel_4_1.add(txtpnCdigo_2);
		
		JButton btnMostrarTodos =new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\ojo.png").getImage().getScaledInstance(25, 25,java.awt.Image.SCALE_SMOOTH)))));
		btnMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarTabla2(tablaControlStock_1);
				btnMostrarTodos.setEnabled(false);
			}
		});
		btnMostrarTodos.setEnabled(false);
		btnMostrarTodos.setText("Mostrar todos");
		btnMostrarTodos.setBounds(343, 33, 102, 23);
		panel_4_1.add(btnMostrarTodos);
		
		JButton botonBuscar2 = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\buscar.png").getImage().getScaledInstance(15, 15,java.awt.Image.SCALE_SMOOTH)))));
		botonBuscar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarTabla2();
				btnMostrarTodos.setEnabled(true);
			}
		});
		botonBuscar2.setBounds(244, 33, 89, 23);
		botonBuscar2.setText("Buscar");
		panel_4_1.add(botonBuscar2);
		
		tablaControlStock_1 = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex) {return false;}
		};
		tablaControlStock_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tablaControlStock_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ingresoCodigo5.setText(String.valueOf(tablaControlStock_1.getValueAt(tablaControlStock_1.getSelectedRow(), 0)));
			}
		});
		tablaControlStock_1.setBounds(10, 85, 738, 163);
		panel_4_1.add(tablaControlStock_1);
		
		cargarTabla2(tablaControlStock_1);
			
		JButton botonAñadir2 = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\añadir.png").getImage().getScaledInstance(15, 15,java.awt.Image.SCALE_SMOOTH)))));
		botonAñadir2.setBounds(560, 278, 89, 23);
		botonAñadir2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ingresoNombre1.getText().equals("")||ingresoStock1.getText().equals("")||ingresoPrecio1.getText().equals("")||ingresoFecha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Completar todos los campos");
				}
				else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
						String nombre=ingresoNombre1.getText();
						int stock=Integer.parseInt(ingresoStock1.getText());
						float precio=Float.parseFloat(ingresoPrecio1.getText());
						String fecha=ingresoFecha.getText();
						
						stmt=conexion.createStatement();
						stmt.executeUpdate("INSERT INTO productos (Nombre,Stock,Precio,FechaIngreso) values('"+nombre+"','"+stock+"','"+precio+"','"+fecha+"')");
						cargarTabla2(tablaControlStock_1);
						ingresoNombre1.setText(null);
						ingresoStock1.setText(null);
						ingresoPrecio1.setText(null);
						ingresoFecha.setText(null);
						JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Error al agregar el producto");
						e.printStackTrace();
					}
				}
			}
		});
		botonAñadir2.setText("A\u00F1adir");
		panel_4_1.add(botonAñadir2);
		
		JButton botonEliminar2 = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\eliminar.png").getImage().getScaledInstance(15, 15,java.awt.Image.SCALE_SMOOTH)))));
		botonEliminar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ingresoCodigo5.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingresar código del producto a eliminar");
				}
				else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
						
						stmt=conexion.createStatement();
						stmt.executeUpdate("DELETE from productos WHERE ID="+ingresoCodigo5.getText());
						cargarTabla2(tablaControlStock_1);
						ingresoCodigo5.setText(null);
						JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
						e.printStackTrace();
					}
				}
			}
		});
		botonEliminar2.setBounds(476, 350, 103, 23);
		botonEliminar2.setText("Eliminar");
		panel_4_1.add(botonEliminar2);
		
		JTextPane txtpnCdigo_3_1 = new JTextPane();
		txtpnCdigo_3_1.setBounds(10, 259, 50, 20);
		txtpnCdigo_3_1.setText("Nombre");
		txtpnCdigo_3_1.setForeground(Color.BLACK);
		txtpnCdigo_3_1.setEditable(false);
		txtpnCdigo_3_1.setBackground(SystemColor.menu);
		panel_4_1.add(txtpnCdigo_3_1);
		
		ingresoNombre1 = new JTextField();
		ingresoNombre1.setBounds(10, 279, 307, 20);
		panel_4_1.add(ingresoNombre1);
		ingresoNombre1.setColumns(10);
		
		ingresoStock1 = new JTextField();
		ingresoStock1.setBounds(316, 279, 66, 20);
		panel_4_1.add(ingresoStock1);
		ingresoStock1.setColumns(10);
		
		ingresoPrecio1 = new JTextField();
		ingresoPrecio1.setBounds(381, 279, 73, 20);
		panel_4_1.add(ingresoPrecio1);
		ingresoPrecio1.setColumns(10);
		
		ingresoFecha = new JTextField();
		ingresoFecha.setBounds(453, 279, 86, 20);
		panel_4_1.add(ingresoFecha);
		ingresoFecha.setColumns(10);
		
		JTextPane txtpnCdigo_3_1_1 = new JTextPane();
		txtpnCdigo_3_1_1.setBounds(316, 259, 50, 20);
		txtpnCdigo_3_1_1.setText("Stock");
		txtpnCdigo_3_1_1.setForeground(Color.BLACK);
		txtpnCdigo_3_1_1.setEditable(false);
		txtpnCdigo_3_1_1.setBackground(SystemColor.menu);
		panel_4_1.add(txtpnCdigo_3_1_1);
		
		JTextPane txtpnCdigo_3_1_2 = new JTextPane();
		txtpnCdigo_3_1_2.setBounds(381, 259, 50, 20);
		txtpnCdigo_3_1_2.setText("Precio");
		txtpnCdigo_3_1_2.setForeground(Color.BLACK);
		txtpnCdigo_3_1_2.setEditable(false);
		txtpnCdigo_3_1_2.setBackground(SystemColor.menu);
		panel_4_1.add(txtpnCdigo_3_1_2);
		
		JTextPane txtpnCdigo_3_1_2_1 = new JTextPane();
		txtpnCdigo_3_1_2_1.setBounds(453, 259, 86, 20);
		txtpnCdigo_3_1_2_1.setText("Fecha ingreso");
		txtpnCdigo_3_1_2_1.setForeground(Color.BLACK);
		txtpnCdigo_3_1_2_1.setEditable(false);
		txtpnCdigo_3_1_2_1.setBackground(SystemColor.menu);
		panel_4_1.add(txtpnCdigo_3_1_2_1);
		
		JTextPane txtpnCdigo_3_2 = new JTextPane();
		txtpnCdigo_3_2.setBounds(10, 331, 50, 20);
		txtpnCdigo_3_2.setText("C\u00F3digo");
		txtpnCdigo_3_2.setForeground(Color.BLACK);
		txtpnCdigo_3_2.setEditable(false);
		txtpnCdigo_3_2.setBackground(SystemColor.menu);
		panel_4_1.add(txtpnCdigo_3_2);
		
		ingresoCodigo5 = new JTextField();
		ingresoCodigo5.setBounds(10, 351, 176, 20);
		ingresoCodigo5.setColumns(10);
		panel_4_1.add(ingresoCodigo5);
		
		JCheckBox tickStock = new JCheckBox("Modificar stock");
		tickStock.setBounds(348, 350, 97, 23);
		panel_4_1.add(tickStock);
		
		JCheckBox tickPrecio = new JCheckBox("Modificar precio");
		tickPrecio.setBounds(348, 377, 103, 23);
		panel_4_1.add(tickPrecio);
		
		JButton botonModificar = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\modificar.png").getImage().getScaledInstance(15, 15,java.awt.Image.SCALE_SMOOTH)))));
		botonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ingresoCodigo5.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingresar código del producto a modificar");
				}
				else {
					if(tickStock.isSelected() && !tickPrecio.isSelected()) {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
							
							stmt=conexion.createStatement();
							stmt.executeUpdate("UPDATE productos SET Stock='"+ingresoStock2.getText()+"' WHERE ID="+ingresoCodigo5.getText());
							cargarTabla2(tablaControlStock_1);
							ingresoCodigo5.setText(null);
							ingresoStock2.setText(null);
							ingresoPrecio2.setText(null);
							JOptionPane.showMessageDialog(null, "Producto modificado correctamente");
						} catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Error al modificar el producto");
							e.printStackTrace();
						}
					}
					else if(!tickStock.isSelected() && tickPrecio.isSelected()) {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
							
							stmt=conexion.createStatement();
							stmt.executeUpdate("UPDATE productos SET Precio='"+ingresoPrecio2.getText()+"' WHERE ID="+ingresoCodigo5.getText());
							cargarTabla2(tablaControlStock_1);
							ingresoCodigo5.setText(null);
							ingresoStock2.setText(null);
							ingresoPrecio2.setText(null);
							JOptionPane.showMessageDialog(null, "Producto modificado correctamente");
						} catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Error al modificar el producto");
							e.printStackTrace();
						}
					}
					else if(tickStock.isSelected() && tickPrecio.isSelected()) {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
							
							stmt=conexion.createStatement();
							stmt.executeUpdate("UPDATE productos SET Stock='"+ingresoStock2.getText()+"',Precio='"+ingresoPrecio2.getText()+"' WHERE ID="+ingresoCodigo5.getText());
							cargarTabla2(tablaControlStock_1);
							ingresoCodigo5.setText(null);
							ingresoStock2.setText(null);
							ingresoPrecio2.setText(null);
							JOptionPane.showMessageDialog(null, "Producto modificado correctamente");
						} catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Error al modificar el producto");
							e.printStackTrace();
						}
					}
					else {JOptionPane.showMessageDialog(null, "Seleccione si desea modificar el stock, el precio o ambos");}
				}
			}
		});
		botonModificar.setBounds(476, 377, 103, 23);
		botonModificar.setText("Modificar");
		panel_4_1.add(botonModificar);
		
		JTextPane txtpnCdigo_3_1_1_1 = new JTextPane();
		txtpnCdigo_3_1_1_1.setBounds(184, 331, 50, 20);
		txtpnCdigo_3_1_1_1.setText("Stock");
		txtpnCdigo_3_1_1_1.setForeground(Color.BLACK);
		txtpnCdigo_3_1_1_1.setEditable(false);
		txtpnCdigo_3_1_1_1.setBackground(SystemColor.menu);
		panel_4_1.add(txtpnCdigo_3_1_1_1);
		
		ingresoStock2 = new JTextField();
		ingresoStock2.setBounds(184, 351, 66, 20);
		ingresoStock2.setColumns(10);
		panel_4_1.add(ingresoStock2);
		
		JTextPane txtpnCdigo_3_1_2_2 = new JTextPane();
		txtpnCdigo_3_1_2_2.setBounds(245, 331, 50, 20);
		txtpnCdigo_3_1_2_2.setText("Precio");
		txtpnCdigo_3_1_2_2.setForeground(Color.BLACK);
		txtpnCdigo_3_1_2_2.setEditable(false);
		txtpnCdigo_3_1_2_2.setBackground(SystemColor.menu);
		panel_4_1.add(txtpnCdigo_3_1_2_2);
		
		ingresoPrecio2 = new JTextField();
		ingresoPrecio2.setBounds(245, 351, 73, 20);
		ingresoPrecio2.setColumns(10);
		panel_4_1.add(ingresoPrecio2);
		
		JButton botonExcel1 = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\excel.png").getImage().getScaledInstance(25, 25,java.awt.Image.SCALE_SMOOTH)))));
		botonExcel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file=new File("C:\\Archivos mercado\\Excel Productos.xls");
				int row=1;
				WritableWorkbook workBook=null;
				WritableSheet excelSheet=null;
				try {
					workBook=Workbook.createWorkbook(file);
					workBook.createSheet("Productos", 0);
					excelSheet=workBook.getSheet(0);
				}catch(IOException ex) {
					System.err.println(ex.getMessage());
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
					stmt=conexion.createStatement();
					ResultSet result=stmt.executeQuery("SELECT * from productos");
					excelSheet.addCell(new Label(0, 0, "ID"));
					excelSheet.addCell(new Label(1, 0, "Nombre"));
					excelSheet.addCell(new Label(2, 0, "Stock"));
					excelSheet.addCell(new Label(3, 0, "Precio"));
					excelSheet.addCell(new Label(4, 0, "Fecha de ingreso"));
					while(result.next()) {
						excelSheet.addCell(new Number(0, row, result.getInt("ID")));
						excelSheet.addCell(new Label(1, row, result.getString("Nombre")));
						excelSheet.addCell(new Label(2, row, result.getString("Stock")));
						excelSheet.addCell(new Label(3, row, result.getString("Precio")));
						excelSheet.addCell(new Label(4, row, result.getString("FechaIngreso")));
						row++;
					}
					result.close();
					workBook.write();
					workBook.close();
					JOptionPane.showMessageDialog(null,"Archivo de Excel generado correctamente");
				}catch(Exception e) {
				}
			}
		});
		botonExcel1.setBounds(613, 356, 121, 36);
		botonExcel1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonExcel1.setText("Ver Excel");
		panel_4_1.add(botonExcel1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 318, 758, 2);
		separator_1.setBackground(UIManager.getColor("CheckBox.background"));
		panel_4_1.add(separator_1);
		
		table_2 = new JTable();
		table_2_1 = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex) {return false;}
		};
		table_2_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table_2_1.setRowSelectionAllowed(false);
		table_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_2_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Nombre", "Stock", "Precio", "Fecha de ingreso"},
			},
			new String[] {
				"ID", "New column", "New column", "New column", "New column"
			}
		));
		table_2_1.setBounds(10, 69, 738, 16);
		panel_4_1.add(table_2_1);
		
		JTextPane txtProductos_1 = new JTextPane();
		txtProductos_1.setText("Productos");
		txtProductos_1.setForeground(Color.BLACK);
		txtProductos_1.setEditable(false);
		txtProductos_1.setBackground(SystemColor.menu);
		txtProductos_1.setBounds(10, 11, 50, 20);
		panel_5.add(txtProductos_1);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Registro de empleados", null, panel_6, null);
		panel_6.setLayout(null);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_4_1_1.setBounds(10, 30, 1003, 429);
		panel_6.add(panel_4_1_1);
		
		ingresoDni3 = new JTextField();
		ingresoDni3.setColumns(10);
		ingresoDni3.setBounds(10, 395, 73, 22);
		panel_4_1_1.add(ingresoDni3);
		
		ingresoNombre = new JTextField();
		ingresoNombre.setColumns(10);
		ingresoNombre.setBounds(10, 33, 153, 23);
		panel_4_1_1.add(ingresoNombre);
		
		JTextPane txtpnCdigo_2_1_1_1_1 = new JTextPane();
		txtpnCdigo_2_1_1_1_1.setText("DNI");
		txtpnCdigo_2_1_1_1_1.setForeground(Color.BLACK);
		txtpnCdigo_2_1_1_1_1.setEditable(false);
		txtpnCdigo_2_1_1_1_1.setBackground(SystemColor.menu);
		txtpnCdigo_2_1_1_1_1.setBounds(10, 375, 40, 23);
		panel_4_1_1.add(txtpnCdigo_2_1_1_1_1);
		
		JTextPane txtpnCdigo_2_1 = new JTextPane();
		txtpnCdigo_2_1.setText("Apellido");
		txtpnCdigo_2_1.setForeground(Color.BLACK);
		txtpnCdigo_2_1.setEditable(false);
		txtpnCdigo_2_1.setBackground(SystemColor.menu);
		txtpnCdigo_2_1.setBounds(10, 11, 63, 23);
		panel_4_1_1.add(txtpnCdigo_2_1);
		
		JButton btnMostrarTodos_1 = new JButton((Icon) null);
		btnMostrarTodos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarTablaEmpleados();
				btnMostrarTodos_1.setEnabled(false);
			}
		});
		btnMostrarTodos_1.setText("Mostrar todos");
		btnMostrarTodos_1.setEnabled(false);
		btnMostrarTodos_1.setBounds(355, 33, 102, 23);
		panel_4_1_1.add(btnMostrarTodos_1);
		
		JButton botonBuscar3 = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\buscar.png").getImage().getScaledInstance(15, 15,java.awt.Image.SCALE_SMOOTH)))));
		botonBuscar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!ingresoNombre.getText().equals("") && ingresoDni.getText().equals("")) {buscarTablaEmpleados("Apellido",ingresoNombre);}
				else if(ingresoNombre.getText().equals("") && !ingresoDni.getText().equals("")) {buscarTablaEmpleados("DNI",ingresoDni);}
				else if(ingresoNombre.getText().equals("") && ingresoDni.getText().equals("")) {JOptionPane.showMessageDialog(null, "Ingrese apellido o DNI para buscar");}
				btnMostrarTodos_1.setEnabled(true);
			}
		});
		botonBuscar3.setText("Buscar");
		botonBuscar3.setBounds(256, 33, 89, 23);
		panel_4_1_1.add(botonBuscar3);
		
		tablaEmpleados = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex) {return false;}
		};
		tablaEmpleados.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tablaEmpleados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ingresoDni3.setText(String.valueOf(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 2)));
			}
		});
		tablaEmpleados.setBounds(10, 82, 983, 166);
		panel_4_1_1.add(tablaEmpleados);
		
		cargarTablaEmpleados();
		
		JTextPane txtpnCdigo_3_3 = new JTextPane();
		txtpnCdigo_3_3.setText("Nombre");
		txtpnCdigo_3_3.setForeground(Color.BLACK);
		txtpnCdigo_3_3.setEditable(false);
		txtpnCdigo_3_3.setBackground(SystemColor.menu);
		txtpnCdigo_3_3.setBounds(10, 259, 50, 20);
		panel_4_1_1.add(txtpnCdigo_3_3);
		
		JComboBox comboTurno = new JComboBox();
		comboTurno.setModel(new DefaultComboBoxModel(new String[] {"Ma\u00F1ana", "Tarde", "Noche", "Sin horario"}));
		comboTurno.setBounds(444, 330, 111, 22);
		panel_4_1_1.add(comboTurno);
		
		JComboBox comboCargo = new JComboBox();
		comboCargo.setModel(new DefaultComboBoxModel(new String[] {"Vendedor/a", "Encargado/a de stock", "Administrador/a"}));
		comboCargo.setBounds(444, 281, 111, 22);
		panel_4_1_1.add(comboCargo);
		
		JButton botonAñadir3 = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\añadir.png").getImage().getScaledInstance(25, 25,java.awt.Image.SCALE_SMOOTH)))));
		botonAñadir3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ingresoNombre2.getText().equals("")||ingresoApellido2.getText().equals("")||ingresoDni2.getText().equals("")||ingresoCorreo.getText().equals("")||ingresoTelefono.getText().equals("")||ingresoContraseña2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Completar todos los campos");
				}
				else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
						String nombre=ingresoNombre2.getText();
						String apellido=ingresoApellido2.getText();
						int dni=Integer.parseInt(ingresoDni2.getText());
						String correo=ingresoCorreo.getText();
						String telefono=ingresoTelefono.getText();
						String turno=(String) comboTurno.getSelectedItem();
						String cargo=(String) comboCargo.getSelectedItem();
						String contraseña=ingresoContraseña2.getText();
						
						
						
						stmt=conexion.createStatement();
						stmt.executeUpdate("INSERT INTO empleados (Usuario,Contraseña,Nombre,Apellido,DNI,Correo,Telefono,Cargo,Turno) values('"+nombre.substring(0, 3)+apellido.substring(apellido.length()-3, apellido.length())+"','"+contraseña+"','"+nombre+"','"+apellido+"','"+dni+"','"+correo+"','"+telefono+"','"+cargo+"','"+turno+"')");
						cargarTablaEmpleados();
						ingresoNombre2.setText(null);
						ingresoApellido2.setText(null);
						ingresoDni2.setText(null);
						ingresoCorreo.setText(null);
						ingresoTelefono.setText(null);
						ingresoContraseña2.setText(null);
						JOptionPane.showMessageDialog(null, "Empleado añadido correctamente");
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Error al añadir empleado");
						e.printStackTrace();
					}
				}
			}
		});
		botonAñadir3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonAñadir3.setText("A\u00F1adir");
		botonAñadir3.setBounds(593, 294, 121, 36);
		panel_4_1_1.add(botonAñadir3);
		
		JButton botonEliminar3 = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\menos.png").getImage().getScaledInstance(25, 25,java.awt.Image.SCALE_SMOOTH)))));
		botonEliminar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ingresoDni3.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingresar DNI del empleado a eliminar");
				}
				else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
						
						stmt=conexion.createStatement();
						stmt.executeUpdate("DELETE from empleados WHERE DNI="+ingresoDni3.getText());
						cargarTablaEmpleados();
						ingresoDni2.setText(null);
						JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente");
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Error al eliminar empleado");
						e.printStackTrace();
					}
				}
			}
		});
		botonEliminar3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonEliminar3.setText("Eliminar");
		botonEliminar3.setBounds(93, 381, 121, 36);
		panel_4_1_1.add(botonEliminar3);
		
		JTextPane txtpnCdigo_3_1_3 = new JTextPane();
		txtpnCdigo_3_1_3.setText("Apellido");
		txtpnCdigo_3_1_3.setForeground(Color.BLACK);
		txtpnCdigo_3_1_3.setEditable(false);
		txtpnCdigo_3_1_3.setBackground(SystemColor.menu);
		txtpnCdigo_3_1_3.setBounds(138, 259, 50, 20);
		panel_4_1_1.add(txtpnCdigo_3_1_3);
		
		ingresoNombre2 = new JTextField();
		ingresoNombre2.setColumns(10);
		ingresoNombre2.setBounds(10, 279, 129, 22);
		panel_4_1_1.add(ingresoNombre2);
		
		JTextPane txtpnCdigo_3_2_1 = new JTextPane();
		txtpnCdigo_3_2_1.setText("Correo electr\u00F3nico");
		txtpnCdigo_3_2_1.setForeground(Color.BLACK);
		txtpnCdigo_3_2_1.setEditable(false);
		txtpnCdigo_3_2_1.setBackground(SystemColor.menu);
		txtpnCdigo_3_2_1.setBounds(10, 310, 103, 20);
		panel_4_1_1.add(txtpnCdigo_3_2_1);
		
		ingresoCorreo = new JTextField();
		ingresoCorreo.setColumns(10);
		ingresoCorreo.setBounds(10, 330, 164, 22);
		panel_4_1_1.add(ingresoCorreo);
		
		JButton botonExcel2 = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\excel.png").getImage().getScaledInstance(25, 25,java.awt.Image.SCALE_SMOOTH)))));
		botonExcel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file=new File("C:\\Archivos mercado\\Excel Empleados.xls");
				int row=1;
				WritableWorkbook workBook=null;
				WritableSheet excelSheet=null;
				try {
					workBook=Workbook.createWorkbook(file);
					workBook.createSheet("Empleados", 0);
					excelSheet=workBook.getSheet(0);
				}catch(IOException ex) {
					System.err.println(ex.getMessage());
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
					stmt=conexion.createStatement();
					ResultSet result=stmt.executeQuery("SELECT * from empleados");
					excelSheet.addCell(new Label(0, 0, "Nombre"));
					excelSheet.addCell(new Label(1, 0, "Apellido"));
					excelSheet.addCell(new Label(2, 0, "DNI"));
					excelSheet.addCell(new Label(3, 0, "Correo electrónico"));
					excelSheet.addCell(new Label(4, 0, "Cargo"));
					excelSheet.addCell(new Label(5, 0, "Turno"));
					while(result.next()) {
						excelSheet.addCell(new Label(0, row, result.getString("Nombre")));
						excelSheet.addCell(new Label(1, row, result.getString("Apellido")));
						excelSheet.addCell(new Label(2, row, result.getString("DNI")));
						excelSheet.addCell(new Label(3, row, result.getString("Correo")));
						excelSheet.addCell(new Label(4, row, result.getString("Telefono")));
						excelSheet.addCell(new Label(5, row, result.getString("Cargo")));
						excelSheet.addCell(new Label(6, row, result.getString("Turno")));
						row++;
					}
					result.close();
					workBook.write();
					workBook.close();
					JOptionPane.showMessageDialog(null,"Archivo de Excel generado correctamente");
				}catch(Exception e) {
				}
			}
		});
		botonExcel2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botonExcel2.setText("Ver Excel");
		botonExcel2.setBounds(541, 375, 121, 36);
		panel_4_1_1.add(botonExcel2);
		
		ingresoDni = new JTextField();
		ingresoDni.setColumns(10);
		ingresoDni.setBounds(173, 33, 73, 23);
		panel_4_1_1.add(ingresoDni);
		
		JTextPane txtpnCdigo_2_1_1 = new JTextPane();
		txtpnCdigo_2_1_1.setText("DNI");
		txtpnCdigo_2_1_1.setForeground(Color.BLACK);
		txtpnCdigo_2_1_1.setEditable(false);
		txtpnCdigo_2_1_1.setBackground(SystemColor.menu);
		txtpnCdigo_2_1_1.setBounds(173, 11, 40, 23);
		panel_4_1_1.add(txtpnCdigo_2_1_1);
		
		ingresoApellido2 = new JTextField();
		ingresoApellido2.setColumns(10);
		ingresoApellido2.setBounds(138, 279, 153, 22);
		panel_4_1_1.add(ingresoApellido2);
		
		JTextPane txtpnCdigo_3_1_3_1 = new JTextPane();
		txtpnCdigo_3_1_3_1.setText("Cargo");
		txtpnCdigo_3_1_3_1.setForeground(Color.BLACK);
		txtpnCdigo_3_1_3_1.setEditable(false);
		txtpnCdigo_3_1_3_1.setBackground(SystemColor.menu);
		txtpnCdigo_3_1_3_1.setBounds(444, 262, 50, 20);
		panel_4_1_1.add(txtpnCdigo_3_1_3_1);
		
		JTextPane txtpnCdigo_3_1_3_1_1 = new JTextPane();
		txtpnCdigo_3_1_3_1_1.setText("Turno");
		txtpnCdigo_3_1_3_1_1.setForeground(Color.BLACK);
		txtpnCdigo_3_1_3_1_1.setEditable(false);
		txtpnCdigo_3_1_3_1_1.setBackground(SystemColor.menu);
		txtpnCdigo_3_1_3_1_1.setBounds(444, 311, 50, 20);
		panel_4_1_1.add(txtpnCdigo_3_1_3_1_1);
		
		ingresoDni2 = new JTextField();
		ingresoDni2.setColumns(10);
		ingresoDni2.setBounds(290, 279, 73, 22);
		panel_4_1_1.add(ingresoDni2);
		
		JTextPane txtpnCdigo_2_1_1_1 = new JTextPane();
		txtpnCdigo_2_1_1_1.setText("DNI");
		txtpnCdigo_2_1_1_1.setForeground(Color.BLACK);
		txtpnCdigo_2_1_1_1.setEditable(false);
		txtpnCdigo_2_1_1_1.setBackground(SystemColor.menu);
		txtpnCdigo_2_1_1_1.setBounds(290, 259, 40, 23);
		panel_4_1_1.add(txtpnCdigo_2_1_1_1);
		
		JTextPane txtpnCdigo_3_1_3_2 = new JTextPane();
		txtpnCdigo_3_1_3_2.setText("N\u00FAmero de tel\u00E9fono");
		txtpnCdigo_3_1_3_2.setForeground(Color.BLACK);
		txtpnCdigo_3_1_3_2.setEditable(false);
		txtpnCdigo_3_1_3_2.setBackground(SystemColor.menu);
		txtpnCdigo_3_1_3_2.setBounds(171, 310, 111, 20);
		panel_4_1_1.add(txtpnCdigo_3_1_3_2);
		
		ingresoTelefono = new JTextField();
		ingresoTelefono.setColumns(10);
		ingresoTelefono.setBounds(171, 330, 138, 22);
		panel_4_1_1.add(ingresoTelefono);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setForeground(UIManager.getColor("CheckBox.background"));
		separator.setBounds(0, 361, 1003, 2);
		panel_4_1_1.add(separator);
		
		table_4 = new JTable() {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		table_4.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table_4.setRowSelectionAllowed(false);
		table_4.setModel(new DefaultTableModel(
				new Object[][] {
					{"Nombre", "Apellido", "DNI", "Correo", "Teléfono","Cargo","Turno"},
				},
				new String[] {
					"New column", "New column", "New column", "New column", "New column","New column","New column"}
			));
		table_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		table_4.setBounds(10, 67, 983, 16);
		panel_4_1_1.add(table_4);
		
		ingresoContraseña2 = new JPasswordField();
		ingresoContraseña2.setBounds(308, 330, 111, 22);
		panel_4_1_1.add(ingresoContraseña2);
		
		JTextPane txtpnCdigo_2_1_1_1_2 = new JTextPane();
		txtpnCdigo_2_1_1_1_2.setText("Contrase\u00F1a");
		txtpnCdigo_2_1_1_1_2.setForeground(Color.BLACK);
		txtpnCdigo_2_1_1_1_2.setEditable(false);
		txtpnCdigo_2_1_1_1_2.setBackground(SystemColor.menu);
		txtpnCdigo_2_1_1_1_2.setBounds(310, 310, 63, 23);
		panel_4_1_1.add(txtpnCdigo_2_1_1_1_2);
		
		JTextPane txtProductos_1_1 = new JTextPane();
		txtProductos_1_1.setText("Empleados");
		txtProductos_1_1.setForeground(Color.BLACK);
		txtProductos_1_1.setEditable(false);
		txtProductos_1_1.setBackground(SystemColor.menu);
		txtProductos_1_1.setBounds(10, 11, 58, 20);
		panel_6.add(txtProductos_1_1);
	}
}
