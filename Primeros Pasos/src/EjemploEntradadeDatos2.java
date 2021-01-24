import javax.swing.*;
public class EjemploEntradadeDatos2 {
	public static void main(String args[]) {
		
		String nombreusuario=JOptionPane.showInputDialog("Introduce tu nombre, por favor");
		
		String edad= JOptionPane.showInputDialog("Introduce tu edad, por favor");
		
		int edad_usuario=Integer.parseInt(edad);//metodo .parseInt() de la clase Integer que devuelve un valor entero pasandole un parametro como String
		edad_usuario++;
		System.out.println("Hola "+nombreusuario+" el año que viene tendras "+edad_usuario+" años");
		
		
		
	}
}
