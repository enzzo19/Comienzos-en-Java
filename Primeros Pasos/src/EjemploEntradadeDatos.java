import java.util.Scanner;
public class EjemploEntradadeDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//metodo nextLine de la clase Scanner devuelve un texto que introduzca un usuario
		Scanner entrada= new Scanner(System.in);
		System.out.println("Introduce tu nombre, por favor");
		String usuario= entrada.nextLine();
		
		//metodo nextInt de la clase Scanner devuelve un entero que introduzca un usuario
		System.out.println("Introduce edad, por favor");
		int edad=entrada.nextInt();
		System.out.println("Hola "+ usuario+" tu edad es: "+edad+" años" );
	}

}
