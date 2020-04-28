package sparsearray;

public class SparseArray {
	
	public static void main(String[] args) {
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		
		System.out.println("the Original 2D array:");
		for(int[] row : chessArr1) {
			for(int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
	//1.convert 2D array to sparse array
	//Go through the 2D array and get the non-0 elements
		int sum =0;
		//Go through rows
		for (int i = 0; i < 11; i++) {
			//Go through columns
			for(int j = 0; j < 11; j++) {
				if(chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}
			System.out.println("sum =" + sum);
	//2.Correct the corresponding sparse array
		int sparseArr[][] = new int[sum + 1][3];
		//load the sparseArray
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		//Go through the 2D array, load the sparse array with non-0 elements
		int count = 0;
		for (int i = 0; i < 11; i++) {
			//Go through columns
			for(int j = 0; j < 11; j++) {
				if(chessArr1[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr1[i][j];
				}
			}
		}
		//output the sparse array
		System.out.println();
		System.out.println("The sparse array is:");
		for (int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n ",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
		}
		System.out.println();
		//Convert the sparse array into the original 2D array
		//1.Read the first line of sparse array to create the 2D array
		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		//2.Read the next lines (starting from the 2nd line) of sparse array and sign the non-0 elements to the 2-D array
		for (int i = 1; i < sparseArr.length; i++) {
			System.out.println("sparseArr.length " + sparseArr.length);
			 chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		
		
		System.out.println();
		System.out.println("Recovered 2D array:");
		for(int[] row : chessArr2) {
			for(int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
	
	}
}
