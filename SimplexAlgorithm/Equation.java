package lib;

public class Equation {
	
	double[] constants;
	double rhs;

	Equation(double[] constants, double rhs){
		this.constants = constants;
		this.rhs = rhs;
	}
	
	public String toString() {
		String eq = "";
		String[] codes = {
				"\u2081",
				"\u2082",
				"\u2083",
				"\u2084",
				"\u2085",
				"\u2086",
				"\u2087",
				"\u2088",
				"\u2089"
		}; 
		
		for(int i = 0; i < this.constants.length; i++) {
			
			eq += "("+ round(this.constants[i], 2) + ")X" + codes[i];
			eq += (i == this.constants.length-1)?" = ":" + ";
		}
		return (eq + round(this.rhs, 2));
		
	}	
	
	static String round(double n, int decimal) {
		return String.format("%."+decimal+"f", n);
	}
	
}
