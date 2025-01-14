package lib;

public class Methods {

	static void appendArr(int val, int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == -1) {
				arr[i] = val;
				break;
			}
		}
	}
	
	static boolean isIn(int val, int[] target) {
		for(int i = 0; i < target.length; i++) {
			if(val == target[i]) {
				return true;
			}
		}
		return false;
	}
	
	static int[] nullIni(int length) {
		int[] temp = new int[length];
		for(int i = 0; i < length; i++) {
			temp[i] = -1;
		}
		return temp;
	}
	
	static String ArrToStr(int[] arr, String delimeter) {
		String temp = "";
		String d = delimeter;
		for(int i = 0; i < arr.length; i++) {
			if(i == arr.length-1) {
				d = "";
			}
			temp += arr[i] + d;				
		}
		return temp;
	}
	
	static double sumOf(double[] arr) {
		double sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	static double[] newArr(double[] arr) {
		double[] temp = new double[arr.length];
		for(int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		return temp;
	}
	
}
