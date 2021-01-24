import javax.swing.JOptionPane;

public class CompruebaMail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean arroba=false;
		boolean punto=false;
		String mail=JOptionPane.showInputDialog("Introduce mail");
		int cantdearroba=0;
		for(int i=0;i<mail.length();i++) {
			if(mail.charAt(i)=='@') {
				cantdearroba++;
			}
			if(mail.charAt(i)=='.') {
				punto=true;
			}
		}
		if(cantdearroba==1) {
			arroba=true;
		}
		if(arroba==true && punto==true) {
			System.out.println("El Mail es Correcto");
		}
		else {
			System.out.println("El Mail es Incorrecto");
		}
	}
	
	
}
