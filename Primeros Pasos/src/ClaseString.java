
public class ClaseString {
	public static void main(String args[]) {
		
		String nombre="enzo";// los datos tipos String deben ir entre comillas dobles
		System.out.println(nombre);
		
		//metodo length() de la clase String devuelve la cantidad de caracteres de una cadena
		System.out.println("Mi nombre tiene "+ nombre.length()+" letras");
		
		//metodo charAt() de la clase String devuelve la letra en la posicion que le indicamos como parametro
		System.out.println("La primera letra de "+ nombre +" es la: "+nombre.charAt(0));

		//Como obtener el ultimo caracter de una cadena "cadena.charAt(cadena.length()-1)"
		System.out.println("La primera letra de "+ nombre +" es la: "+nombre.charAt(nombre.length()-1));

		//metodo substring(inicial,final) que nos devuelve una subcadena de acuerdo a la posicion inicial y final que le pasamos como parametros
		String frase="Hoy es un stupendo dia para aprender a programar en Java";
		String frase2=frase.substring(4, 18);
		System.out.println(frase2);
		//metodo substring(index) que nos devuelve una subcadena de acuerdo a la posicion que le pasamos hasta el final
		String frase3=frase.substring(4);
		System.out.println(frase3);
		
		//Concatenar cadenas
		String frase4,frase5;
		frase4="Bienvenidos a mi hogar";
		frase5=",espero que lo disfruten";
		System.out.println(frase4+frase5);
		
		//metodo equals() compara 2 cadenas y distingue mayusculas de minusculas retorna true o flase
		
		String alumno1,alumno2;
		alumno1="pedrito";
		alumno2="pedrito";
		System.out.println(alumno1.equals(alumno2));
		
		//metodo equalsIgnoreCase() igual que equals solo que no distingue entre mayusculas y minusculas
		String alumno3,alumno4;
		alumno3="pedrito";
		alumno4="Pedrito";
		System.out.println(alumno3.equalsIgnoreCase(alumno4));
		
	}
}
