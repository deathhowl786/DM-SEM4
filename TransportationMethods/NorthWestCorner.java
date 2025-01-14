package lib;

public class NorthWestCorner extends CostMatrix{
	
	
	NorthWestCorner(double[][] matrix, double[] rqrmnts, double[] avlblty) {
		super(matrix, rqrmnts, avlblty);
	}
	
	void distribute() {
		
		double[] a = Methods.newArr(avlblty);
		double[] r = Methods.newArr(rqrmnts);
		
		int i = 0;
		int j = 0;
		
		while(true) {
			
			if(i >= a.length || j >= r.length) {
				break;
			}
			
			if(a[i] > r[j]) {
				alloc.put(new int[] {i, j}, r[j]);
				a[i] -= r[j];
				r[j++] = 0;
			}else if(a[i] < r[j]){
				alloc.put(new int[] {i, j}, a[i]);
				r[j] -= a[i];
				a[i++] = 0;
			}else {
				alloc.put(new int[] {i, j}, a[i]);
				a[i++] = 0;
				r[j++] = 0;
			}	
		}
	}
	
	void solve() {
		System.out.println("\t" + "# Cost Matrix  #" + "\t");
		this.printMatrix();
		System.out.println();
		
		if(this.checkTotals()) {
			System.out.println("#Distribution using North West Corner Method");
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
			{5, 3, 6, 2},
			{4, 7, 9, 1},
			{3, 4, 7, 5}
		};
		
		double[] a = new double[] {
				19, 37, 34
		};
		
		double[] r = new double[] {
				16, 18, 31, 25
		};		
		NorthWestCorner nwc = new NorthWestCorner(matrix, r, a);
		nwc.solve();
	}

}
