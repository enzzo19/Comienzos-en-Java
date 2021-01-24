package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CreandoMarcoCentrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCentrado mimarco1=new MarcoCentrado();
		
		mimarco1.setVisible(true);//Que el marco sea Visible
		
		mimarco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Al apretar el close termina la ejecucion del programa
		
	}

}

class MarcoCentrado extends JFrame{
	public MarcoCentrado() {
		Toolkit mipantalla= Toolkit.getDefaultToolkit();//Instanciamos el objeto
		Dimension tamañoPantalla=mipantalla.getScreenSize();//Devuelve el tamaño de la pantalla principal
		
		int alturaPantalla=tamañoPantalla.height;//devuelve el alto de la pantalla
		int anchoPantalla=tamañoPantalla.width;//devuelve el ancho de la pantalla
		
		setSize(anchoPantalla/2,alturaPantalla/2);//Mitad del tamaño total de la pantalla
		
		setLocation(anchoPantalla/4,alturaPantalla/4);//Para ubicarlo en el centro de la pantalla
		//Para cambiar el titulo del Frame
		setTitle("Marco Centrado :) ");
		//
		Image miIcono=mipantalla.getImage("iron carita.png");//Ubicacion del icono
		
		setIconImage(miIcono);//establecer el Icono 
	}
}