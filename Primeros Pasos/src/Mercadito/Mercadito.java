package Mercadito;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Mercadito {

	private JFrame frmMercadito;
	private JTextField username;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mercadito window = new Mercadito();
					window.frmMercadito.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mercadito() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMercadito = new JFrame();
		frmMercadito.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\enzzo\\OneDrive\\Escritorio\\Curso de Java\\Primeros Pasos\\src\\graficos\\iron carita.png"));
		frmMercadito.setTitle("Mercadito \"Salta\"");
		frmMercadito.setBounds(100, 100, 450, 300);
		frmMercadito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMercadito.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de Usuario:");
		lblNewLabel.setBounds(32, 87, 114, 20);
		frmMercadito.getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(64, 138, 82, 20);
		frmMercadito.getContentPane().add(lblContrasea);
		
		username = new JTextField();
		username.setBounds(150, 87, 155, 20);
		frmMercadito.getContentPane().add(username);
		username.setColumns(10);
		
		JButton btnLoggin = new JButton("Ingresar");
		btnLoggin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname=username.getText();
				String pad=passwordField.getText();
				
				if(uname.equals("name") && pad.equals("password")) {
					
					JOptionPane.showMessageDialog(frmMercadito, "Bienvenido");
				}
				else {
					JOptionPane.showMessageDialog(frmMercadito, "Usuario o Contraseña Invalidos");

				}
			}
		});
		btnLoggin.setBounds(152, 190, 89, 23);
		frmMercadito.getContentPane().add(btnLoggin);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		passwordField.setBounds(150, 138, 155, 20);
		frmMercadito.getContentPane().add(passwordField);
	}
}
