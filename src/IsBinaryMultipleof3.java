public class IsBinaryMultipleof3 {
	
	public static boolean isBinaryDivisibleBy3(String binNum){
		int num = 0;
		
		//This follows the DFA algo for the same question as follows:
		//If a binary stream is appended with 1, it becomes 2 * num + 1
		//If a binary stream is appended with 0, it becomes 2 * num
		//Hence, if we just find the modulo 3 every time a bit is appended to
		//the binary string, we can then get the answer by checking
		//whether the value so obtained is divisible by 3 or not
		
		//For every bit
		for(int i = 0; i < binNum.length(); i++){
			//If the bit is 1
			if(binNum.charAt(i) - 48 == 1)
				//Make the value (2 * val + 1) mod 3
				num = (2 * num + 1) % 3;
			else
				//Make the value (2 * val) mod 3				
				num = (2 * num) % 3;
		}
		
		return num % 3 == 0;
	}
	
	//Checking if a decimal number is divisible by 3 or not
	public static boolean isDivisibleBy3(String num){
		
		int sum = 0;
		
		for(int i = 0; i < num.length(); i++){
			//Converting unicode characters to decimal integers
			sum += (num.charAt(i) - 48);
		}
		
		return sum % 3 == 0;
	}
	
	public static void main(String[] args) {
		
		String test = "1001";
		
		System.out.println(isDivisibleBy3("31269"));
				
		System.out.println(isBinaryDivisibleBy3("111101000100101"));
	}
}

/*
0 0 0 0
0 0 0 1
0 0 1 0
0 0 1 1
0 1 0 0
0 1 0 1
0 1 1 0
0 1 1 1
1 0 0 0
1 0 0 1
1 0 1 0
1 0 1 1
1 1 0 0
1 1 0 1
1 1 1 0
1 1 1 1
*/

//0
//11
//1001
//1100
//1111
//