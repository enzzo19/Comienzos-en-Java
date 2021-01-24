package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Persona {

	public static void main(String[] args) {
		
		Persona[] las_personas=new Persona[2];
		
		las_personas[0]=new Empleado2("Enzo Juarez",50000,2000,5,19);
		las_personas[1]=new Alumno("Josecito","Enfermeria");
		
		for(Persona p:las_personas) {
			System.out.println(p.dame_nombre()+", "+p.dame_descripcion());
		}
	}
}

abstract class Persona {
	
	public Persona(String nom) {
		nombre=nom;
	}
	
	public String dame_nombre() {
		return nombre;
	}
	
	
	public abstract String dame_descripcion();//Una clase abstracta es la que marca el diseño en la Jerarquia de clases
	
	private String nombre;
}




class Empleado2 extends Persona{
	
	public Empleado2(String nombre_p,double sueldo_p,int año_p,int mes_p, int dia_p){
		
		super(nombre_p);
		sueldo=sueldo_p;
		GregorianCalendar calendario= new GregorianCalendar(año_p,mes_p-1,dia_p);
		altaContrato= calendario.getTime();
		++IDSiguiente;
		ID=IDSiguiente;
	}
	/*
	public Empleado2(String nombre_p){//Sobrecarga de Constructores
		//nombre=nombre_p;
		this(nombre_p,30000,2000,01,01);//En este caso innvoca al otro constructor cuando utilizamos parametros identicos en algunos casos
	}
	*/

	public String dame_descripcion() {
		return "Este empleado tiene un ID: "+ID+" con un sueldo de:$"+sueldo;
	}
	
	
	public double dame_sueldo() {//getter
		return sueldo;
	}
	
	public Date dame_altaContrato() {//getter
		return altaContrato;
	}
	
	public void sube_sueldo(double porcentaje) {//setter
		double aumento=sueldo*(porcentaje/100);
		sueldo+=aumento;
		
	}
	
	
	//private String nombre;
	private double  sueldo;
	private Date altaContrato;
	private String seccion;
	private int ID;
	private static int IDSiguiente=1;
	

	
	public void cambia_seccion(String seccion) {
		this.seccion=seccion;
	}
	
}

class Alumno extends Persona {
	public Alumno(String nombre,String carrera) {
		
		super(nombre);
		 this.carrera=carrera;
		
	}
	
	public String dame_descripcion() {
		return "Este alumno esta estudiando la carrera de: "+carrera;
	}
	
	private String carrera;
}
