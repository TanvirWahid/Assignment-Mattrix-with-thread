import java.util.Scanner;
public class Mattrix {

	static int[][] matrix=new int[4][4];
	static int[][] matrix2=new int[4][4];
	static int[][] matrix3=new int[4][4];
	
	static Thread t1=new Thread(new Runnable(){
	public void run(){
		
		for(int i=0; i<3; i++){
			int p=0;
			for(int j=0; j<3; j++){
				p+=matrix[0][j]*matrix2[j][i];
			}
			matrix3[0][i]=p;
		}
	}});
	
	static Thread t2=new Thread(new Runnable(){
		public void run(){
			
			for(int i=0; i<3; i++){
				int p=0;
				for(int j=0; j<3; j++){
					p+=matrix[1][j]*matrix2[j][i];
				}
				matrix3[1][i]=p;
			}
		}});
	static Thread t3=new Thread(new Runnable(){
		public void run(){
			
			for(int i=0; i<3; i++){
				int p=0;
				for(int j=0; j<3; j++){
					p+=matrix[2][j]*matrix2[j][i];
				}
				matrix3[2][i]=p;
			}
		}});
		
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter matrix1 \n");
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++)matrix[i][j]=sc.nextInt();
			
		}
		System.out.println("Enter matrix2 \n");
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++)matrix2[i][j]=sc.nextInt();
			
		}
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The final matrix is \n");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(matrix3[i][j] + " ");
			}
			System.out.println("");
		}
		
	}

}
