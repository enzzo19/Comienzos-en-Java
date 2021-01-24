package graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoConFuentes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConFuentes mimarco=new MarcoConFuentes();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
/**
 * @author enzzo
 *
 */
class MarcoConFuentes extends JFrame{
	public MarcoConFuentes() {
		setTitle("Prueba con Fuentes");
		setSize(400,400);
		setVisible(true);
		LaminaConFuentes milamina=new LaminaConFuentes();
		add(milamina);
		
		milamina.setForeground(Color.blue);//Establecer como color pordefecto a todo lo que escribamos sobre la lamina
		//milamina.setBackground(Color.GRAY);//Color de fondo de la lamina
		
		//milamina.setBackground(SystemColor.window);//Color por defecto del SO huesped
	}
}

class LaminaConFuentes extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D) g;
		
	Font mifuente= new Font("Courier",Font.ITALIC,26);
	g2.setFont(mifuente);
	//g2.setColor(Color.black);
	g2.drawString("Enzo",100,100);
	g2.drawString("Curso Swing",200,200);
	}
}