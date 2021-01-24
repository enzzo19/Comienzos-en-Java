package graficos;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
public class PruebaDibujo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoConDibujos mimarco=new MarcoConDibujos();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
class MarcoConDibujos extends JFrame{
	public MarcoConDibujos() {
		setTitle("Prueba de Dibujo");
		setSize(400,400);
		setVisible(true);
		LaminaConFiguras milamina=new LaminaConFiguras();
		add(milamina);
		//milamina.setBackground(Color.GRAY);//Color de fondo de la lamina
		
		milamina.setBackground(SystemColor.window);//Color por defecto del SO huesped
	}
}

class LaminaConFiguras extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//g.drawRect(50, 50, 200, 200);//Dibujamos un cuadrado
		
		//g.drawLine(100, 100, 300, 300);//Dibujar una linea
		
		//g.drawArc(50, 100, 100, 200, 120, 150);//Dibuja un Arco
		
		Graphics2D g2=(Graphics2D) g;
		
		Rectangle2D rectangulo=new Rectangle2D.Double(100, 100, 200, 200);
		//g2.setPaint(Color.blue);//Cambia el color del trazo
		//g2.draw(rectangulo);
		g2.setPaint(Color.red);//Cambia el color del trazo
		g2.fill(rectangulo);
		//g2.draw(rectangulo);
		Ellipse2D elipse= new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		Color micolor=new Color(109,172,59);
		
		g2.setPaint(micolor);//Dar color con los valores de rgb
		g2.fill(elipse);
		
		
		//g2.draw(elipse);
		
		//g2.draw(new Line2D.Double(100, 100, 300, 250));
		
		//double CentroenX=rectangulo.getCenterX();
		//double CentroenY=rectangulo.getCenterY();
		
		//double radio=150;
		//Ellipse2D circulo=new Ellipse2D.Double();
		//circulo.setFrameFromCenter(CentroenY, CentroenY, CentroenX+radio, CentroenY+radio);
		//g2.draw(circulo);
	}
}