import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.mysql.jdbc.Statement;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextPane;
import java.awt.Font;

public class frmInicioDeSesin {

	private JFrame frmInicioDeSesin;
	private JFrame frame2;
	private JPasswordField loginContraseña;
	private JTextField loginNombre;
	private java.sql.Statement stmt;

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
					frmInicioDeSesin window = new frmInicioDeSesin();
					window.frmInicioDeSesin.setVisible(true);
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
	public frmInicioDeSesin() {
		initializeLogin();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeLogin() {
		frmInicioDeSesin = new JFrame();
		frmInicioDeSesin.setResizable(false);
		frmInicioDeSesin.setContentPane(new JLabel(new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\fondo1.png")));
		frmInicioDeSesin.setTitle("Inicio de sesi\u00F3n");
		frmInicioDeSesin.setBounds(100, 100, 487, 322);
		frmInicioDeSesin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton loginIngresar = new JButton(new ImageIcon(((new ImageIcon("C:\\Users\\sebat\\eclipse-workspace\\Minimercado\\src\\Imagenes\\ingresar.png").getImage().getScaledInstance(25, 25,java.awt.Image.SCALE_SMOOTH)))));
		loginIngresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginIngresar.setText("Ingresar");
		loginIngresar.setBounds(178, 217, 114, 40);
		loginIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/baseproductos","root", "");
					stmt=conexion.createStatement();
					ResultSet result=stmt.executeQuery("SELECT * FROM empleados WHERE Usuario='"+loginNombre.getText()+"' AND Contraseña='"+loginContraseña.getText()+"'");
					if(!result.absolute(1)) {
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");}
					else {
						frame2 abrir=new frame2();
						frmInicioDeSesin.setVisible(false);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		frmInicioDeSesin.getContentPane().setLayout(null);
		frmInicioDeSesin.getContentPane().add(loginIngresar);
		
		loginContraseña = new JPasswordField();
		loginContraseña.setBounds(239, 170, 140, 20);
		frmInicioDeSesin.getContentPane().add(loginContraseña);
		
		loginNombre = new JTextField();
		loginNombre.setBounds(239, 129, 140, 20);
		frmInicioDeSesin.getContentPane().add(loginNombre);
		loginNombre.setColumns(10);
		
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 554, 375);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
