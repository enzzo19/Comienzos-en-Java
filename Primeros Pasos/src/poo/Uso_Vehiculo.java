package poo;

public class Uso_Vehiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Coche Renault=new Coche();//Instanciar una Clase es decir es un ejemplar de una clase
		
		
		//System.out.println("Este coche tiene "+Renault.ruedas+" ruedas"); //Para acceder a una propiedad de un objeto se hace con "Objeto.propiedad"
	System.out.println(Renault.dimelargo());	
	
	Coche micoche=new Coche();
	System.out.println(micoche.dimecolor());
	
	micoche.establece_color("Morado");
	System.out.println(micoche.dimecolor());	
	
	//micoche.Color="Rosa";//Esto es un Problema de Encapsulacion, no se deberia poder alterar los valores directamente
	//System.out.println(micoche.dimecolor());	
	
	
	System.out.println(micoche.dime_datos_generales());
	
	micoche.establece_asientosdecuero("si");
	System.out.println(micoche.dime_asientos());
	
	micoche.establece_climatizador("si");
	System.out.println(micoche.dime_climatizador());
	
	System.out.println(micoche.dime_pesocoche());
	
	System.out.println("El precio del coche es: "+micoche.dime_preciocoche());
	
	*/
		
	Coche micoche1=new Coche();
	micoche1.establece_color("naranja");
		
	Furgoneta mifurgoneta1=new Furgoneta(3,400);
	mifurgoneta1.establece_color("Rosado");
	
	mifurgoneta1.establece_asientosdecuero("Si");
	mifurgoneta1.establece_climatizador("Si");
	
	System.out.println(micoche1.dime_datos_generales()+micoche1.dimecolor());
	
	System.out.println(mifurgoneta1.dime_datos_generales()+" "+mifurgoneta1.dimecolor()+" "+mifurgoneta1.dime_datosFurgoneta());

	
	
	
	
	}
}
