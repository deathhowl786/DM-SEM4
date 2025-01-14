package lib;

public class MatrixMinima extends CostMatrix{
	
	
	MatrixMinima(double[][] matrix, double[] rqrmnts, double[] avlblty) {
		super(matrix, rqrmnts, avlblty);
	}
	
	int[] findLowest(int[] blocked_rows, int[] blocked_cols) {
		
		
		double l = Double.MAX_VALUE;
		int[] li = new int[]{-1, -1};
		
		for(int i = 0; i < matrix.length; i++) {
			if(Methods.isIn(i, blocked_rows)) {
				continue;
			}
			for(int j = 0; j < matrix[i].length; j++) {
					
					if(Methods.isIn(j, blocked_cols)){
						continue;
					}else {
						if(l > matrix[i][j]){
							l = matrix[i][j];
							li[0] = i; li[1] = j;
						}
					}
					
				}
		}
		return li;
	}	
	
	void distribute() {
		
		int[] blocked_rows = Methods.nullIni(avlblty.length);
		int[] blocked_cols = Methods.nullIni(rqrmnts.length);
		
		double[] a = Methods.newArr(avlblty);
		double[] r = Methods.newArr(rqrmnts);
		double flag = Methods.sumOf(r);
		
		while(flag!=getAllocTotal()) {
			
			int[] lowest_cords = this.findLowest(blocked_rows, blocked_cols);
			int i = lowest_cords[0];
			int j = lowest_cords[1];
			
			if(flag==getAllocTotal() || i == -1) {
				break;
			}
			
			if(a[i] > r[j]) {
				alloc.put(new int[] {i, j}, r[j]);
				a[i] -= r[j];
				r[j] = 0;
				Methods.appendArr(j, blocked_cols);
			}else if(a[i] < r[j]){
				alloc.put(new int[] {i, j}, a[i]);
				r[j] -= a[i];
				a[i] = 0;
				Methods.appendArr(i, blocked_rows);
			}else {
				alloc.put(new int[] {i, j}, a[i]);
				a[i] = 0;
				r[j] = 0;
				Methods.appendArr(i, blocked_rows);
				Methods.appendArr(j, blocked_cols);
			}	
		}
	}
	
	void solve() {
		System.out.println("\t" + "# Cost Matrix  #" + "\t");
		this.printMatrix();
		System.out.println();
		if(this.checkTotals()) {
			System.out.println("#Distribution using Matrix Minima Method");
			this.distribute();
			this.printAlloc();
			System.out.println();
			System.out.println("Zmax = " + this.calcZMax());
		}else {
			System.out.println("Sum of Availability does not match with Requirements.");
			System.out.println("Please make adjustments and Try Again.");
		}
	}
	
	
	public static void main(String[] args) {
		
			double[][] matrix = new double[][] {
				{20, 22, 17, 4},
				{24, 37, 9, 7},
				{32, 37, 20, 15}
			};
			
			double[] a = new double[] {
					120, 70, 50
			};
			
			double[] r = new double[] {
					60, 40, 30, 110
			};
			MatrixMinima mm = new MatrixMinima(matrix, r, a);
			mm.solve();

	}

}
