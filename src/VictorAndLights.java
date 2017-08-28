public class VictorAndLights {
	
	//Is a string palindrome?
	public static boolean isPalindrome(String s){
		int left = 0;
		int right = s.length() - 1;
		
		while(left < s.length() / 2){
			if(s.charAt(left++) != s.charAt(right--))
				return false;
		}
		return true;
	}
	
	//Can a string be converted to a palindrome?
	public static boolean canBePalindromed(String s){
		//0 through 9
		int[] freq = new int[10];
		
		for(int i = 0; i < s.length(); i++){
			//s.charAt(i) - 48 to convert an character to integer equivalent
			//E.g. : '2' -> 2
			freq[s.charAt(i) - 48]++;
		}
		
		int count_odds = 0;
		for(int i = 0; i < 10; i++){
			if(freq[i] % 2 != 0)
				count_odds += 1;
		}
		
		return count_odds <= 1;
	}
	
	public static void printLightCombos(String s){
		int len_sub = 1;
		
		while(len_sub <= s.length()){
			int start = 0;
			
			while(start + len_sub <= s.length()){
				String use = s.substring(start, start + len_sub);
			
				if(isPalindrome(use) || canBePalindromed(use))
					System.out.println(use);
				
				start++;
			}
			len_sub++;
		}
	}
	
	public static void main(String[] args) {
		printLightCombos("02002");
	}
}