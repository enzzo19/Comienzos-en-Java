
public class MatricesBidimensionales {
	public static void main(String args[]) {
		/*
		int [][] matriz= new int[4][5];
		
		matriz [0][0]=15;
		matriz [0][1]=30;
		matriz [0][2]=89;
		matriz [0][3]=65;
		matriz [0][4]=112;
		
		matriz [1][0]=2;
		matriz [1][1]=455;
		matriz [1][2]=23;
		matriz [1][3]=87;
		matriz [1][4]=434;
		
		
		matriz [2][0]=75;
		matriz [2][1]=332;
		matriz [2][2]=764;
		matriz [2][3]=576;
		matriz [2][4]=726;
		
		matriz [2][0]=986;
		matriz [2][1]=453;
		matriz [2][2]=241;
		matriz [2][3]=7;
		matriz [2][4]=6;
		
		matriz [3][0]=876;
		matriz [3][1]=465;
		matriz [3][2]=923;
		matriz [3][3]=452;
		matriz [3][4]=123;
		*/
		//System.out.print("Valor almacenado en la posicion [2][1]: "+matriz[2][1]);
		int [][] matriz= {
				{10,15,20,25,30},
				{35,40,45,50,55},
				{1,2,3,4,5},
				{23,34,45,67,78}
		};
		/*
		for(int i=0;i<4;i++) {
			for(int j=0;j<5;j++) {
				
				System.out.print(matriz[i][j]+" ");
				
			}
			System.out.println("");
				
		}*/
		//For-each en matrices Bidimensionales
		for(int[]fila:matriz) {
			for(int columna:fila) {
				System.out.print(columna+" ");
			}
			System.out.println(" ");
		}
		
	}
}
