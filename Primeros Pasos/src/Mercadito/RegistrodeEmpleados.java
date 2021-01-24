package Mercadito;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrodeEmpleados {

	private JFrame frmRegistroDeEmpleados;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrodeEmpleados window = new RegistrodeEmpleados();
					window.frmRegistroDeEmpleados.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistrodeEmpleados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDeEmpleados = new JFrame();
		frmRegistroDeEmpleados.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\enzzo\\OneDrive\\Escritorio\\Curso de Java\\Primeros Pasos\\src\\graficos\\iron carita.png"));
		frmRegistroDeEmpleados.setTitle("Registro de Empleados");
		frmRegistroDeEmpleados.setBounds(100, 100, 571, 277);
		frmRegistroDeEmpleados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDeEmpleados.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(299, 49, 46, 14);
		frmRegistroDeEmpleados.getContentPane().add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(299, 74, 46, 14);
		frmRegistroDeEmpleados.getContentPane().add(lblApellido);
		
		JLabel lblIdUsuario = new JLabel("ID usuario:");
		lblIdUsuario.setBounds(289, 24, 75, 14);
		frmRegistroDeEmpleados.getContentPane().add(lblIdUsuario);
		
		JLabel lblTurno = new JLabel("Turno:");
		lblTurno.setBounds(318, 125, 46, 14);
		frmRegistroDeEmpleados.getContentPane().add(lblTurno);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Ma\u00F1ana");
		rdbtnNewRadioButton.setBounds(370, 95, 109, 23);
		frmRegistroDeEmpleados.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnTarde = new JRadioButton("Tarde");
		rdbtnTarde.setBounds(370, 121, 109, 23);
		frmRegistroDeEmpleados.getContentPane().add(rdbtnTarde);
		
		JRadioButton rdbtnNoche = new JRadioButton("Noche");
		rdbtnNoche.setBounds(370, 147, 109, 23);
		frmRegistroDeEmpleados.getContentPane().add(rdbtnNoche);
		
		JLabel lblNewLabel_1 = new JLabel("Registro");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1.setBounds(360, 0, 76, 23);
		frmRegistroDeEmpleados.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.setBounds(328, 177, 89, 23);
		frmRegistroDeEmpleados.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(370, 21, 126, 20);
		frmRegistroDeEmpleados.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(370, 46, 126, 20);
		frmRegistroDeEmpleados.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(370, 71, 126, 20);
		frmRegistroDeEmpleados.getContentPane().add(textField_2);
		
		JButton button = new JButton("SALIR");
		button.setFont(new Font("Arial Black", Font.BOLD, 13));
		button.setBounds(465, 200, 80, 32);
		frmRegistroDeEmpleados.getContentPane().add(button);
		
		JLabel lblBusqueda = new JLabel("Busqueda");
		lblBusqueda.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblBusqueda.setBounds(49, 0, 76, 23);
		frmRegistroDeEmpleados.getContentPane().add(lblBusqueda);
		
		JLabel label = new JLabel("ID usuario:");
		label.setBounds(10, 24, 73, 14);
		frmRegistroDeEmpleados.getContentPane().add(label);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(93, 21, 114, 20);
		frmRegistroDeEmpleados.getContentPane().add(textField_3);
		
		JLabel lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblDatosPersonales.setBounds(44, 49, 132, 23);
		frmRegistroDeEmpleados.getContentPane().add(lblDatosPersonales);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setBounds(10, 74, 46, 14);
		frmRegistroDeEmpleados.getContentPane().add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(66, 74, 126, 20);
		frmRegistroDeEmpleados.getContentPane().add(textField_4);
		
		JLabel label_2 = new JLabel("Apellido:");
		label_2.setBounds(10, 104, 46, 14);
		frmRegistroDeEmpleados.getContentPane().add(label_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(66, 105, 126, 20);
		frmRegistroDeEmpleados.getContentPane().add(textField_5);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\enzzo\\OneDrive\\Escritorio\\Curso de Java\\Primeros Pasos\\src\\Mercadito\\Sin t\u00EDtulo2.png"));
		button_1.setBounds(217, 11, 40, 31);
		frmRegistroDeEmpleados.getContentPane().add(button_1);
		
		JLabel lblDatosPersonales_1 = new JLabel("Registro");
		lblDatosPersonales_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblDatosPersonales_1.setBounds(59, 133, 66, 23);
		frmRegistroDeEmpleados.getContentPane().add(lblDatosPersonales_1);
		
		JLabel lblCantDiasRegistrados = new JLabel("Cant. dias Registrados:");
		lblCantDiasRegistrados.setBounds(10, 164, 123, 14);
		frmRegistroDeEmpleados.getContentPane().add(lblCantDiasRegistrados);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(132, 161, 66, 20);
		frmRegistroDeEmpleados.getContentPane().add(textField_6);
		
		JButton btnVerPdf = new JButton("Ver PDF");
		btnVerPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerPdf.setFont(new Font("Arial Black", Font.BOLD, 10));
		btnVerPdf.setBounds(10, 207, 76, 23);
		frmRegistroDeEmpleados.getContentPane().add(btnVerPdf);
		
		JButton btnVerExcel = new JButton("Ver Excel");
		btnVerExcel.setFont(new Font("Arial Black", Font.BOLD, 10));
		btnVerExcel.setBounds(86, 207, 94, 23);
		frmRegistroDeEmpleados.getContentPane().add(btnVerExcel);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial Black", Font.BOLD, 10));
		btnNuevo.setBounds(181, 207, 76, 23);
		frmRegistroDeEmpleados.getContentPane().add(btnNuevo);
	}

}
