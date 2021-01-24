package poo;

import java.util.*;

public class Uso_Empleado {

	public static void main(String[] args) {
		/*
		Empleado empleado1= new Empleado ("Pedro",45000.50,2014,03,04);
		
		Empleado empleado2= new Empleado ("Jose",20000,2005,06,02);
		
		Empleado empleado3= new Empleado ("Tiago",60000.8,2007,9,15);
		
		
		
		empleado1.sube_sueldo(5);
		empleado2.sube_sueldo(5);
		empleado3.sube_sueldo(5);
		
		System.out.println("Nombre:"+empleado1.dame_nombre()+"  Sueldo:$"+empleado1.dame_sueldo()+"  Fecha de Alta: "+empleado1.dame_altaContrato());
		System.out.println("Nombre:"+empleado2.dame_nombre()+"  Sueldo:$"+empleado2.dame_sueldo()+"  Fecha de Alta: "+empleado2.dame_altaContrato());
		System.out.println("Nombre:"+empleado3.dame_nombre()+"  Sueldo:$"+empleado3.dame_sueldo()+"  Fecha de Alta: "+empleado3.dame_altaContrato());
		*/
		Jefatura jefeRHH=new Jefatura("Enzo",45600,2004,5,12);
		Empleado [] misEmpleados=new Empleado[6];
		misEmpleados[0]=new Empleado("Pedro",45000.50,2014,03,04);
		misEmpleados[1]=new Empleado("Jose",20000,2005,06,02);
		misEmpleados[2]=new Empleado("Tiago",60000.8,2007,9,15);
		misEmpleados[3]=new Empleado("Joaquin");
		misEmpleados[4]=jefeRHH; //Polimorfismo en accion---Principio de Sustitucion
		misEmpleados[5]=new Jefatura("Juanita",95000,2003,4,23);//Polimorfismo
		
		
		jefeRHH.establece_incentivo(15000.5);//metodo propio
		
		Jefatura jefa_finanzas=(Jefatura) misEmpleados[5];
		
		jefa_finanzas.establece_incentivo(550000);
		
		
		//System.out.println(jefeRHH.dame_nombre());//Metodo heredado de la clase empleado
		/*
		for(int i=0;i<3;i++) {
			misEmpleados[i].sube_sueldo(5);
		}
		*/
		Empleado director_comercial=new Jefatura("Luquicha",30000,2004,3,12);
		
		Comparable ejemplo=new Empleado("Elisabeth",75000,2002,06,5);
		
		if(director_comercial instanceof Empleado) {//Para saber si un objeto pertenece a una clase
			
			System.out.println("Es de tipo Jefatura");
			
		}
		
		if (ejemplo instanceof Comparable) {//Para saber si una objeto pertenece a una clase 
			System.out.println("Implementa la Interfaz Comparable");
			
		}
		
		
		System.out.println(jefa_finanzas.tomar_decisiones("Dar mas dias de vacaciones a los empleados"));
		
		
		for(Empleado e: misEmpleados) {//Creamos una Variable del tipo de la Clase Empleado para el uso del for simplificado
			e.sube_sueldo(5);
		}
		/*
		for(int i=0;i<3;i++) {
			System.out.println("Nombre:"+misEmpleados[i].dame_nombre()+"  Sueldo:$"+misEmpleados[i].dame_sueldo()+"  Fecha Alta: "+misEmpleados[i].dame_altaContrato());
		}
		*/
		
		Arrays.sort(misEmpleados);
		
		for(Empleado e: misEmpleados) {//Creamos una Variable del tipo de la Clase Empleado para el uso del for simplificado
			System.out.println("Nombre:"+e.dame_nombre()+"  Sueldo:$"+e.dame_sueldo()+"  Fecha Alta: "+e.dame_altaContrato());
		}
		
	}

}

//Si existiera una clase sin constructor se utiliza el constructor por defecto
class Empleado implements Comparable{//Interfaz de la clase Comparable que utilizamos para ordenar los ARRAYS
	
	public Empleado(String nombre_p,double sueldo_p,int año_p,int mes_p, int dia_p){
		
		nombre=nombre_p;
		sueldo=sueldo_p;
		GregorianCalendar calendario= new GregorianCalendar(año_p,mes_p-1,dia_p);
		altaContrato= calendario.getTime();
	}
	
	public Empleado(String nombre_p){//Sobrecarga de Constructores
		//nombre=nombre_p;
		this(nombre_p,30000,2000,01,01);//En este caso innvoca al otro constructor cuando utilizamos parametros identicos en algunos casos
	}
		
	public String dame_nombre() {//getter
		return nombre;
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
	
	private String nombre;
	private double  sueldo;
	private Date altaContrato;
	
	
	//Metodo para ordenar por un parametro o patron definido
	public int compareTo(Object miObjeto) {//Debe pasarse como parametro un tipo objeto 
		Empleado otroEmpleado=(Empleado) miObjeto;
		
		if(this.sueldo<otroEmpleado.sueldo) {
			return -1;
		}
		if(this.sueldo>otroEmpleado.sueldo) {
			return 1;
		}
		return 0;
	}
	
	
	
}

class Jefatura extends Empleado implements Jefes{
	
	public Jefatura(String Nombre,double sueldo,int año,int mes,int dia) {
		
		super(Nombre, sueldo, año, mes, dia);
		
	}
	public void establece_incentivo(double b) {
		incentivo=b;
	}
	public double dame_sueldo() {
		double sueldo_jefe=super.dame_sueldo();//Enlazado Dinamico
		
		return sueldo_jefe+incentivo;
	}
	
	public String tomar_decisiones(String decision) {
		return "Un miembro de la direccion a tomado la decision de: "+decision;
	}
	
	private double incentivo;
	
}

class Director extends Jefatura{
	public Director(String Nombre,double sueldo,int año,int mes,int dia) {
		super(Nombre, sueldo, año, mes, dia);
	}
	
	
	
}

