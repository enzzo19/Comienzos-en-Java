package graficos;
import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		miMarco marco1=new miMarco();
		marco1.setVisible(true);//Que el marco sea Visible
		
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Al apretar el close termina la ejecucion del programa
		
	}

}


class miMarco extends JFrame {
	
	public miMarco() {
		//setSize(500,300);//Instaciamos el tamaño del marco ya que por defecto es invisible y size 0x0
		//setLocation(500,300);
		setBounds(500,300,500,250);//Para dar ubicacion y tamaño al marco
		
		//setResizable(false);//Redimenzionar un marco
		
		//setExtendedState(Frame.MAXIMIZED_BOTH);//Nombre del parametro como tal
		//setExtendedState(6);//Valor del parametro para pantalla completa
		setTitle("Mi ventana");
		
	}
	
}