import javax.swing.JOptionPane;

public class UsodeArrays2 {
	public static void main(String args[]) {
		
		String [] paises=new String[8];
		/*
		paises[0]="Argentina";
		paises[1]="Bolivia";
		paises[2]="España";
		paises[3]="Mexico";
		paises[4]="Colombia";
		paises[5]="Peru";
		paises[6]="Chile";
		paises[7]="Ecuador";
		*/
		/*
		for(int i=0;i<8;i++) {
			paises[i]=JOptionPane.showInputDialog("Introduce Pais"+(i+1));
			
		}
		
		//String [] paises= {"España","Chile","Argentina","Colombia"};
		//Otra forma de recorrer el Array sin decir cual es el inicio y el final
		for(String i:paises) {
			System.out.println("Pais: "+i);
		}
		*/
		////////////////////////////////////////////////////
		
		int [ ] matrizaleatorios=new int[150]; 
		
		for(int i=0;i<matrizaleatorios.length;i++) {
			matrizaleatorios[i]=(int)Math.round(Math.random()*100);
		}
		for(int j:matrizaleatorios) {
			System.out.print(j+" ");
		}
		
	}
}
