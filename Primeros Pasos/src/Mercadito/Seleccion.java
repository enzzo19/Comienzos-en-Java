package Mercadito;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Seleccion {

	private JFrame frmSeleccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seleccion window = new Seleccion();
					window.frmSeleccion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Seleccion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeleccion = new JFrame();
		frmSeleccion.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\enzzo\\OneDrive\\Escritorio\\Curso de Java\\Primeros Pasos\\src\\graficos\\iron carita.png"));
		frmSeleccion.setTitle("Seleccion");
		frmSeleccion.setBounds(100, 100, 736, 384);
		frmSeleccion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSeleccion.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido! Por favor, Seleccione una de las Categorias");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel.setBounds(67, 30, 530, 23);
		frmSeleccion.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Facturacion");
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnNewButton.setBounds(240, 105, 186, 32);
		frmSeleccion.getContentPane().add(btnNewButton);
		
		JButton btnFacturacion = new JButton("Control de Stock");
		btnFacturacion.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnFacturacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFacturacion.setBounds(240, 166, 186, 32);
		frmSeleccion.getContentPane().add(btnFacturacion);
		
		JButton btnRegistroDeEmpleados = new JButton("Registro de Empleados");
		btnRegistroDeEmpleados.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnRegistroDeEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistroDeEmpleados.setBounds(224, 226, 216, 32);
		frmSeleccion.getContentPane().add(btnRegistroDeEmpleados);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnSalir.setBounds(615, 302, 80, 32);
		frmSeleccion.getContentPane().add(btnSalir);
	}

}
