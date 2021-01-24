import java.util.*;
public class AdivinaNumero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int aleatorio= (int)(Math.random()*100);
		//System.out.println("El numero generado es: "+ aleatorio);
		Scanner entrada= new Scanner (System.in);
		int numero=0;
		int intentos=0;
		//Codigo echo con el Bucle While ger¿nera error si justoe el numero aleatorio es el 0
	/*	while(numero!=aleatorio) {
			intentos ++;
			System.out.println("Introduce un numero, por favor: ");
			numero=entrada.nextInt();
			
			if(aleatorio<numero) {
				System.out.println("Mas bajo");
			}
			else if(aleatorio>numero) {
				System.out.println("Mas alto");
			}
		}
		
		*/
		//Codigo echo con Do-while 
		do {
			intentos ++;
			System.out.println("Introduce un numero, por favor: ");
			numero=entrada.nextInt();
			
			if(aleatorio<numero) {
				System.out.println("Mas bajo");
			}
			else if(aleatorio>numero) {
				System.out.println("Mas alto");
			}
		}while(numero!=aleatorio);
		
		System.out.println("Correcto, lo has conseguido en: "+intentos+" intentos" );
	}
}
