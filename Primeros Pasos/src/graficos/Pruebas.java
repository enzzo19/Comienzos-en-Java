package graficos;

import java.awt.GraphicsEnvironment;
import javax.swing.*;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fuente=JOptionPane.showInputDialog("Introduce Fuente");
		
		boolean estalafuente=false;
		
		
		String [] nombresDeFuentes=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for(String nombredelafuente:nombresDeFuentes) {
			
			if (nombredelafuente.equals(fuente)) {
				estalafuente=true;
			}
			//System.out.println(nombredelafuente);
		}
		if(estalafuente) {
			System.out.println("Esta la fuente");
		}else {
			System.out.println("NO Esta la fuente");
		}
	}

}
