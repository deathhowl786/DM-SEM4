package lib;

//import java.util.Dictionary;
import java.util.HashMap;
//import java.util.Hashtable;
import java.util.Map.Entry;

public abstract class CostMatrix {

	double[][] matrix;
	double[] rqrmnts;
	double[] avlblty;
	HashMap<int[], Double> alloc = new HashMap<int[], Double>();
	
	CostMatrix(double[][] matrix, double[] rqrmnts, double[] avlblty){
		this.matrix = matrix;
		this.rqrmnts = rqrmnts;
		this.avlblty = avlblty;
	}
	
	void printMatrix() {
		for(int i = 0; i < this.rqrmnts.length ; i++) {
			System.out.print("\t"+ " D" + (i+1));
		}
		System.out.println("\t" + "  A");
		
		for(int i = 0; i < this.matrix.length ; i++) {
			double[] row = this.matrix[i];
			System.out.print("S" + (i+1) + "\t");			
			for(int j = 0; j < row.length; j++) {
				System.out.print(row[j] + "\t");
			}
			System.out.println(this.avlblty[i]);
		}
		
		System.out.print("R");
		for(int i = 0; i < this.rqrmnts.length ; i++) {
			System.out.print("\t" + this.rqrmnts[i]);
		}
		System.out.println("\t" + Methods.sumOf(this.rqrmnts));
	}
	
	void printAlloc() {

		for (Entry<int[], Double> entry : alloc.entrySet()) {
		    int[] cords = entry.getKey();
		    double element = this.matrix[cords[0]][cords[1]];
		    double val = entry.getValue();
		    System.out.println(element +" ["+Methods.ArrToStr(cords, ",") + "] => " + val);
		}
	}
	
	double getAllocTotal() {

		double total = 0;
		for (Entry<int[], Double> entry : alloc.entrySet()) {
		    total += entry.getValue();
		}
		return total;
	}
	
	double calcZMax() {
		
		double total = 0;
		for (Entry<int[], Double> entry : alloc.entrySet()) {
		    int[] key = entry.getKey();
		    double val = entry.getValue();
		    total += this.matrix[key[0]][key[1]] * val;
		}
		
		return total;
	}

	boolean checkTotals() {
		return Methods.sumOf(avlblty) == Methods.sumOf(rqrmnts);
	}
	
	abstract void distribute();
	
	abstract void solve();

}
