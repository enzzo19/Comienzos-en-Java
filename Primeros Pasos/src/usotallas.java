import java.util.*;
public class usotallas {
	
	//enum Talla {mini,mediano,grande,muygrande}
	
	enum Talla{
		
		mini("S"),mediano("M"),grande("L"),muygrande("XL");
		private Talla(String abreviatura) {
			this.abreviatura=abreviatura;
		}
		private String abreviatura;
		
		public String devuelve_abreviatura() {
			return abreviatura;
		}
			
	}
	
	public static void main(String[] args) {
		/*
		Talla s=Talla.mini;
		Talla m=Talla.mediano;
		Talla l=Talla.grande;
		Talla xl=Talla.muygrande;
		*/
		Scanner entrada=new Scanner(System.in);
		System.out.println("Escribe una talla: mini-mediano-grande-muygrande");
		
		String entrada_datos=entrada.next().toLowerCase();
		
		Talla la_talla=Enum.valueOf(Talla.class, entrada_datos);
		System.out.println("La talla es: "+ la_talla);
		System.out.println("Abreviatura: "+la_talla.devuelve_abreviatura());
		
	}

}
