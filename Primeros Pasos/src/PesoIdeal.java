import javax.swing.*;
public class PesoIdeal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String genero="";
		do {
			genero=JOptionPane.showInputDialog("Introduce tu genero(H/M)");
			
			
		}while(genero.equalsIgnoreCase("H")==false && genero.equalsIgnoreCase("M")==false);
		
		int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura en cm"));
		
		if(genero=="H"||genero=="h") { //Esta linea se puede poner como ---genero.equalsIgnoreCase("H")---
			System.out.println("Tu peso ideal es: "+(altura-110));
		}
		else {
			System.out.println("Tu peso ideal es: "+(altura-120));

		}
		
		
		
		
		
		
	}

}
