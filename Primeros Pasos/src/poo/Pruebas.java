package poo;

public class Pruebas {

	public static void main(String[] args) {

		Empleados trabajador1=new Empleados("Pepe");
		Empleados trabajador2=new Empleados("Jose");
		Empleados trabajador3=new Empleados("Antonio");
		Empleados trabajador4=new Empleados("Maria");

		System.out.println(trabajador1.dame_datos()+"\n"+
				trabajador2.dame_datos()+"\n"+
				trabajador3.dame_datos()+"\n"+
				trabajador4.dame_datos()+"\n");
			
		System.out.println(Empleados.dame_IDSiguiente());
	}

}


class Empleados{
	
	final private String nombre;
	private String seccion;
	private int ID;
	private static int IDSiguiente=1;
	
	public Empleados(String nombre_p) {
		nombre=nombre_p;
		seccion="Administracion";
		ID=IDSiguiente;
		IDSiguiente++;
	}
	
	public void cambia_seccion(String seccion) {
		this.seccion=seccion;
	}
	/*
	public void cambia_nombre(String nombre) {
		//this.nombre=nombre; // Como la variable nombre esta declarada como final no se deberia poder cambiar 
	}
	*/
	public String dame_datos() {
		
		return "El nombre es "+nombre+" y la seccion es: "+seccion+" y el ID:"+ID;
	}
	
	public static String dame_IDSiguiente() {
		
		return "El ID siguiente es: "+IDSiguiente;
		
		
	}
	
}