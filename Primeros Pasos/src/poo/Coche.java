package poo;
//Suponiendo que creamos una clase para entender poo utilizando como ejemplo un Auto
public class Coche {
	private int ruedas; //Encapsular una propiedad para acceder desde la propia clase unicamente
	private int largo;
	private int ancho;
	private int motor;
	private int peso_plataforma;
	
	private String Color;
	private int peso_total;
	private boolean asientos_cuero,climatizador;
	
	
	//Metodo Constructor es un metodo capaz de construir el objeto en cuestion, dando un estado inicial
	 
	public Coche(){
		ruedas=4;
		largo=3000;
		ancho=1700;
		motor=1600;
		peso_plataforma=500;
		
	}
	
	public String dimelargo() {//Getter
	return "El largo del coche es "+largo;
	}
	
	public String dimecolor() {//Getter
		return "El color del coche es "+Color;
		}
	
	public String dime_datos_generales() {
		return "La plataforma del vehiculo tiene "+ruedas+" ruedas"+
				".Mide "+ largo/1000+ " metros con un ancho de "+ancho+
				" cm y un peso de plataforma de "+peso_plataforma+" Kg";
	}
		
	public void establece_color(String color_coche) {//Setter
		//Color="azul";
		
		Color=color_coche;
	
	}
	
	public void establece_asientosdecuero(String asientos_cuero) {
		if(asientos_cuero=="si") {
			this.asientos_cuero=true;	
		}else {
			this.asientos_cuero=false;
		}
		
	}
	
	public String dime_asientos() {
		if(asientos_cuero==true) {
			return "El coche tiene asientos de cuero";
		}else {
			return "El coche tiene asientos de serie";
		}
	}
	
	public void establece_climatizador(String climatizador) {
		
		if(climatizador=="si") {
			this.climatizador=true;
		}else {
			this.climatizador=false;
		}
	}
	
	public String dime_climatizador() {
		if(climatizador==true) {
			return"El coche incorpora Climatizador";
		}else {
			return "El coche no incopora Climatizador";
		}
	}
	
	public String dime_pesocoche() {
		int peso_carroceria=500;
		peso_total=peso_plataforma+peso_carroceria;
		if(asientos_cuero==true) {
			peso_total=peso_total+50;
		}
		if(climatizador==true) {
			peso_total=peso_total+20;
		}
	return "El peso del coche es "+peso_total+" Kg";	
	}
	
	public int dime_preciocoche() {
		int precio_final=10000;
		if(asientos_cuero==true) {
			precio_final+=2000;
		}
		if(climatizador==true) {
			peso_total+=1500;
		}
		return precio_final;
	}
	
}
