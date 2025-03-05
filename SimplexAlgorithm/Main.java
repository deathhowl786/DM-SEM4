package lib; // Enter your package name

//Copy paste equations class here if dont want to make two diff files.


//make sure file name is same as class name here
//example Main.java must have Main class
// Simplex.java must have Simplex class
public class Main {

	public static void main(String[] args) {
		
		//Q.
//		Equation z = new Equation(new double[]{4, 3, 0, 0, 0, 0}, 000);		
//		Equation a = new Equation(new double[]{2, 1, 1, 0, 0, 0}, 1000);
//		Equation b = new Equation(new double[]{1, 1, 0, 1, 0, 0}, 800);
//		Equation c = new Equation(new double[]{1, 0, 0, 0, 1, 0}, 400);
//		Equation d = new Equation(new double[]{0, 1, 0, 0, 0, 1}, 700);
//		Equation[] eqs = {a, b, c, d};
		
		
		//416.
//		Equation z = new Equation(new double[]{1, 2, 3, 0, 0}, 0);
//		Equation a = new Equation(new double[]{1, 2, 3, 1, 0}, 10);
//		Equation b = new Equation(new double[]{1, 1, 0, 0, 1}, 5);
//		Equation[] eqs = {a, b};
		
		
		//417.
//		Equation z = new Equation(new double[]{2, -1, 1, 0, 0, 0}, 0);
//		Equation a = new Equation(new double[]{3, 1, 1, 1, 0, 0}, 60);
//		Equation b = new Equation(new double[]{1, -1, 2, 0, 1, 0}, 10);
//		Equation c = new Equation(new double[]{1, 1, -1, 0, 0, 1}, 20);
//		Equation[] eqs = {a, b, c};
		
		//418.
//		Equation z = new Equation(new double[]{3, 2, 5, 0, 0, 0}, 0);
//		Equation a = new Equation(new double[]{1, 2, 1, 1, 0, 0}, 430);
//		Equation b = new Equation(new double[]{3, 0, 2, 0, 1, 0}, 460);
//		Equation c = new Equation(new double[]{1, 0, 4, 0, 0, 1}, 420);
//		Equation[] eqs = {a, b, c};
		 
	
		//420.
//		Equation z = new Equation(new double[]{4, 3, 4, 6, 0, 0, 0}, 0);
//		Equation a = new Equation(new double[]{1, 2, 2, 4, 1, 0, 0}, 80);
//		Equation b = new Equation(new double[]{2, 0, 2, 1, 0, 1, 0}, 60);
//		Equation c = new Equation(new double[]{3, 3, 1, 1, 0, 0, 1}, 80);
//		Equation[] eqs = {a, b, c};
		
		//421.
		Equation z = new Equation(new double[]{4, 5, 9, 11, 0, 0, 0}, 0);
		Equation a = new Equation(new double[]{1, 1, 1, 1, 1, 0, 0}, 15);
		Equation b = new Equation(new double[]{7, 5, 3, 2, 0, 1, 0}, 120);
		Equation c = new Equation(new double[]{3, 5, 10, 15, 0, 0, 1}, 100);
		Equation[] eqs = {a, b, c};
		
		//18/12/24
//		Equation z = new Equation(new double[]{3, 5, 4, 0, 0, 0}, 0);
//		Equation a = new Equation(new double[]{2, 3, 0, 1, 0, 0}, 8);
//		Equation b = new Equation(new double[]{0, 2, 5, 0, 1, 0}, 10);
//		Equation c = new Equation(new double[]{3, 2, 4, 0, 0, 1}, 15);
//		Equation[] eqs = {a, b, c};
		
		
		
		int N = eqs.length;
		double[] slacks = new double[N];
		String[] slack_ids = new String[N];
		
		for(int i=0; i<N; i++) {
			slacks[i] = 0.0;
			slack_ids[i] = "X" + String.valueOf(N+i+1);
		}
		
		
		int pivotalColumnIndex = 0;
		int iteration = 0;
		do{
			System.out.println("Iteration = " + (++iteration));
			System.out.println();
			
			printEquations(eqs);
			
			System.out.println("Slacks");
			System.out.println(getSlacks(slack_ids, slacks));
			System.out.println();

			double[] Zj_Cj_res = 	getZj_Cj(eqs, z, slacks);
			System.out.println("Zj-Cj");
			dispElements(Zj_Cj_res);
			
			
			pivotalColumnIndex = getPivotalColumnIndex(Zj_Cj_res);
			
			if(pivotalColumnIndex == -1) {	
				break;
			}
			
			double[] Xb_Yij_res = getXb_Yij(eqs, z, pivotalColumnIndex);
			System.out.println("Xb/Yij");
			dispElements(Xb_Yij_res);
			System.out.println();
			
			
			int pivotalRowIndex = getPivotalRowIndex(Xb_Yij_res);
			double pivotalValue = getPivotalValue(eqs, pivotalRowIndex, pivotalColumnIndex);
			System.out.println("Pivotal Row = " + pivotalRowIndex);
			System.out.println("Pivotal Column = " + pivotalColumnIndex);
			System.out.println("Pivotal Value = " + round(pivotalValue, 2));
			System.out.println();

			//Checking if Value is 1 els modifying.
			checkRowValidity(eqs[pivotalRowIndex], pivotalValue);
//			dispElements(eqs[pivotalRowIndex].constants);
			
			// Swapping slack variables.
			slacks[pivotalRowIndex] = z.constants[pivotalColumnIndex];
			slack_ids[pivotalRowIndex] =  "X" + String.valueOf(pivotalColumnIndex+1);
			

			
			
			for(int i = 0; i < eqs.length; i++) {
				
				if(i!=pivotalRowIndex) {
					Equation b1 = eqs[i];
					Equation a1 = eqs[pivotalRowIndex];
					double factor = b1.constants[pivotalColumnIndex]/a1.constants[pivotalColumnIndex];
					rowOperation(b1, a1, factor);
				}
				continue;
			}
			
			if(iteration > 9) {
				break;
			}
		}while(pivotalColumnIndex!=-1);
		
		
	
		System.out.println();
		
		double z_total = calculateZmax(eqs, slacks);
		System.out.println("Zmax = " + round(z_total, 2));
		System.out.println(getSlacks(slack_ids, slacks));
		
	}

	static void printEquations(Equation[] eqs) {
		for(int i = 0; i < eqs.length; i++) {
			System.out.println(eqs[i].toString());
		}
		System.out.println();
	}
	
	
	static double calculateZmax(Equation[] eqs, double[] slacks) {
		double temp = 0;
		for(int i = 0; i < eqs.length; i++) {
			temp += eqs[i].rhs * slacks[i];
		}
		return temp;
	}
	
	static String getSlacks(String[] slack_ids, double[] slacks) {
		String temp = "(" + slack_ids[0];
		
		for(int i = 1; i < slack_ids.length; i++) {
			temp +=  ", " + slack_ids[i];
		}
		
		temp += ") = (" + slacks[0];
		
		for(int i = 1; i < slacks.length; i++) {
			temp +=  ", " + slacks[i];
		}
		temp += ")";
		
		return temp;
	}
	
	static double[] getZj_Cj(Equation[] eqs, Equation z, double[] slacks){
		
		double[] temp = new double[eqs[0].constants.length];
		for(int i = 0; i < eqs[0].constants.length; i++) {
			double sum = 0;
			for(int j = 0; j < eqs.length; j++) {
				sum += eqs[j].constants[i] * slacks[j];				
			}		
			temp[i] = (sum-z.constants[i]);
		}
		return temp;
	}
	
	static double[] getXb_Yij(Equation[] eqs, Equation z,int pivotalColumn){
		
		double[] temp = new double[eqs.length];
		for(int i = 0; i < eqs.length; i++) {
			if(eqs[i].constants[pivotalColumn] > 0) {				
				temp[i] = eqs[i].rhs / eqs[i].constants[pivotalColumn];
			}else {
				temp[i] = -1;
			}
		}
		return temp;
	
	}
	
	static void dispElements(double[] a) {
		for(int i = 0; i< a.length; i++) {			
			System.out.print(round(a[i], 2) + " ");
		}
		System.out.println();
	}
	
	static int getMinMaxIndex(double[] a, String min_max, int ignore) {
		int sign = (min_max.equals("max"))?1:-1;
		
		double g = a[0];
		int gi = 0;
		
		while(g==ignore) {
			g = a[++gi];
		}
		
		
		for(int i = 1; i < a.length; i++) {
			if(g*sign < a[i]*sign && a[i]!=ignore) {
				g = a[i];
				gi = i;
			}
		}
		return gi;
	}
	
	static int getMinMaxIndexCol(double[] a, String min_max) {
		int sign = (min_max.equals("max"))?1:-1;
		
		double g = a[0];
		int gi = 0;
	
		for(int i = 1; i < a.length; i++) {
			if(g*sign < a[i]*sign) {
				g = a[i];
				gi = i;
			}
		}
		return gi;
	}
	
	static boolean hasNegative(double a[]) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] < 0) {
				return true;
			}
		}
		return false;
	}
	
	static int getPivotalColumnIndex(double[] a){
		return (!hasNegative(a))?-1:getMinMaxIndex(a, "min", 0);
	}
	
	static int getPivotalRowIndex(double[] a) {
		return getMinMaxIndex(a, "min", -1);
	}
	
	static double getPivotalValue(Equation[] a, int row, int col) {
		return a[row].constants[col];
	}

	static void checkRowValidity(Equation a, double pivotalValue) {
		if(pivotalValue!=1) {
			a.rhs /= pivotalValue;
			for(int i = 0; i < a.constants.length; i++) {
				a.constants[i] /= pivotalValue;
			}
		}
	}
	
	static void rowOperation(Equation b, Equation a, double factor) {
		
		b.rhs -= (a.rhs*factor);
		
		for(int i = 0; i < b.constants.length; i++) {
			b.constants[i] -= (a.constants[i]*factor);
		}
	}
	
	static String round(double n, int decimal) {
		return String.format("%."+decimal+"f", n);
	}
	
}
