import javax.swing.*; //importar paquete para utilizar el JOptionPane
public class EntradaNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x=10000.0;
		System.out.printf("%1.2f",x/3);//metodo ,printf da formato numerico a lo que queremos imprimir en consola
		
		String numero1=JOptionPane.showInputDialog("Introduce un numero");
		
		double numero2=Double.parseDouble(numero1);
		System.out.print("La raiz de "+numero2+" es ");
		System.out.printf("%1.4f",Math.sqrt(numero2));
		
		
	}

}
