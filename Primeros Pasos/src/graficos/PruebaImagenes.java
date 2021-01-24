package graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.*;
public class PruebaImagenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConImagen mimarco=new MarcoConImagen();
		
		mimarco.setVisible(true);
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoConImagen extends JFrame{
	public MarcoConImagen() {
		setTitle("Prueba con Imagen");
		setBounds(750,300,240,260);
		setVisible(true);
		LaminaConImagen milamina=new LaminaConImagen();
		add(milamina);
		
		//milamina.setForeground(Color.blue);//Establecer como color pordefecto a todo lo que escribamos sobre la lamina
		//milamina.setBackground(Color.GRAY);//Color de fondo de la lamina
		
		//milamina.setBackground(SystemColor.window);//Color por defecto del SO huesped
	}
}

class LaminaConImagen extends JPanel{
	
	public LaminaConImagen() {
		try {
			imagen=ImageIO.read(new File("src/graficos/descarga.png"));	
		}
		catch(IOException e) {
			System.out.println("La imagen no se encuentra");
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//File miimagen=new File("src/graficos/descarga.png");
		
		int anchuraimagen=imagen.getWidth(this);
		int alturaimagen=imagen.getHeight(this);
		
		g.drawImage(imagen,0,0,null);
		
		for (int i=0;i<300;i++) {
			for(int j=0;j<200;j++) {
				g.copyArea(0, 0, anchuraimagen,alturaimagen, anchuraimagen*i, alturaimagen*j);
			}
		}
		
		}
	private Image imagen;
}

	