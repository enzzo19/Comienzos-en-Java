package poo;

//En este caso tenemos como clase padre a Coche y como clase hijo a Furgoneta
public class Furgoneta extends Coche{
	
	private int capacidad_carga;
	private int plazas_extra;
	
	public Furgoneta(int plazas_extra,int capacidad_carga) {
		
		super();//llama al constructor de la clase padre
		
		this.capacidad_carga=capacidad_carga;
		this.plazas_extra=plazas_extra;
		
	}
	
	
	public String dime_datosFurgoneta() {
		return "La capacidad de carga es: "+ capacidad_carga+" y las plazas son "+plazas_extra;
	}
	
}
