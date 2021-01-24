
public class CalculosconMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Metodo .sqrt para sacar raiz cuadrada de un numero en tipo double
		double raiz=Math.sqrt(9);//metodo de la clase Math 
		System.out.println(raiz);
		
		//Metodo .round para redondear un numero, parametro en float y return en int
		float numero1=5.85F;
		int resultado=Math.round(numero1);//metodo de la clase math 
		System.out.println(resultado);
		
		
		//Refundiciones
		
		double raiz2=5.86;
		int resultado2=(int)Math.round(raiz2);//poniendo entre parentesis el tipo de dato al que quremos convertir
		
		//Metodo .pow para conocer la potencia de un numero sabiendo la base y el exponente devuelve un tipo double
		
		double base=5;
		double exponente =3;
		int resultado3=(int)Math.pow(base, exponente);//metodo de la clase math
		System.out.println("El resultado de base "+base+" elevado a "+exponente+ " es "+resultado3);
		
		//El metodo Mat.sin() es un metodo que devuelve el seno de un angulo de la misma forma con coseno
		//El mmetodo Math.PI() es un metodo de constante de clase del numero pi=3,14....		

		
	}

}
