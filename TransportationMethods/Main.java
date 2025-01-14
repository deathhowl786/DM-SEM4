package lib;

public class Main {

	public static void main(String[] args) {
		double[][] m1 = new double[][] {
			{5, 3, 6, 2},
			{4, 7, 9, 1},
			{3, 4, 7, 5}
		};
		
		double[] a1 = new double[] {
				19, 37, 34
		};
		
		double[] r1 = new double[] {
				16, 18, 31, 25
		};	
		
		double[][] m2 = new double[][] {
			{20, 22, 17, 4},
			{24, 37, 9, 7},
			{32, 37, 20, 15}
		};
		
		double[] a2 = new double[] {
				120, 70, 50
		};
		
		double[] r2 = new double[] {
				60, 40, 30, 110
		};
		
		
	System.out.println("1. First Matrix using Both Matrix");
		NorthWestCorner nwc1 = new NorthWestCorner(m1, r1, a1);
		nwc1.solve();
		System.out.println();
		MatrixMinima mm1 = new MatrixMinima(m1, r1, a1);
		mm1.solve();
		
		System.out.println("2. Second"
				+ " Matrix using Both Matrix");
		NorthWestCorner nwc2 = new NorthWestCorner(m2, r2, a2);
		nwc2.solve();
		System.out.println();
		MatrixMinima mm2 = new MatrixMinima(m2, r2, a2);
		mm2.solve();
	}

}
