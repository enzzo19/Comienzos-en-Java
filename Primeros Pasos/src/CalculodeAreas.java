import javax.swing.*;
import java.util.*;
public class CalculodeAreas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada= new Scanner(System.in);
		
		System.out.println("Elige una opcion: \n1:Cuadrado  \n2:Reactangulo  \n3:Triangulo  \n4:Circulo");
		 
		int figura = entrada.nextInt();
		//Uso de Switch Case  -  Recordar que cada case debe llevar tambien la instruccion de break;
		switch(figura) {
		
		case 1://Analiza la variable que seleccionamos en el switch y compara el valor
			int lado=Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
			
			System.out.println("El area del cuadrado es: "+Math.pow(lado, 2));
			break;//Instruccion de Cierre de case
		case 2:
			int base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
			
			int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
			
			System.out.println("El Area del Rectangulo es: "+base*altura);
			break;
		case 3:
			
			 base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
			
			 altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
			
			 System.out.println("El Area del Triangulo es: "+(base*altura)/2);
			 break;
		case 4:
			int radio=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
			
			System.out.print("El Area del Circulo es: ");
			System.out.printf("%1.2f",Math.PI*(Math.pow(radio, 2)));
			break;
		}
		
		
		
	}

}
