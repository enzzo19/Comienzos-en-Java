import java.util.*;
public class EvaluaEdad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada=new Scanner (System.in);
		System.out.println("Introduce tu edad, por favor");
		int edad=entrada.nextInt();
		
		//Uso de Condicional con una sola condicion
		if(edad<18) {  //condicion
			System.out.println("Eres menor de edad");//Instrucciones para condicion Vedadera
		}
		else {
			System.out.println("Eres mayor de edad");//Instrucciones para condicion Falsa
		}
		
		//Uso de Condicional con varias Condiciones
		
		Scanner entrada2=new Scanner (System.in);
		System.out.println("Introduce tu edad, por favor");
		int edad2=entrada2.nextInt();
		
		if(edad<18) {//Primera Condicion
			System.out.println("Eres un adolescente");
		}
		else if(edad<40) {//Segunda Condicion
			System.out.println("Eres joven");
		}
		else if(edad<65) {//Tercera Condicion
			System.out.println("Eres Maduro");
		}
		else {//Condicion Final
			System.out.println("Cuidate");
		}
	}

}
