
public class DeclaracionesOperadores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=5;
		
		int b;
		b=7;
		
		int c= b+a;//c toma el valor de b+a es decir 5+7 y su valor es 12
		System.out.println(c);
		
		c++;//c incrementa en uno su nuevo valor es 13
		System.out.println(c);
		
		c+=5;//incrementa en 5 la variable c y su nuevo valor es 18
		System.out.println(c);
		
		c=a*b;//multiplica el valor de a*b y asigna el valor a c su valor es 35
		System.out.println(c);
		
		c=b/a;//divide el valor de b en a y por el tipo de dato nos entrega la parte entera del dato e ignora la decimal
		System.out.println(c);
		
		//Declaracion de Constantes
		
		
		final int f=5;//la palabra final nos dice que eso es una constante y su valor no debe cambiar
		System.out.println(f);
		
		final double apulgadas=2.54;//valor constante de equivalencia entre cm y pulgadas
		
		double cm=6;
		
		double resultado=cm/apulgadas;
		System.out.println("En "+cm+"cm hay "+resultado+"pulgadas");//entra en accion el operador concatenar
		
		//Declaracion de Variables
		int d,g,h;
		d=10;
		g=6;
		h=4;
		//Se puede inicializar varias variables como un mismo tipo de dato como enla linea 39 y declararlas luego
		
	}

}
