/*
Given a string and text output the smallest window in the string
which covers all the characters present in the text.
Both the string and text contains small case letters.
If such window doesn`t exist or
this task can not be done then print -1.
*/

public class SmallestSubstring {
	
	public static final int NUMBER_OF_CHARACTERS = 256;
	
	public static void dummyPrint(String str, String pattern){
		int[] hash_patt = new int[NUMBER_OF_CHARACTERS];
		int[] hash_str = new int[NUMBER_OF_CHARACTERS];
		
		//Fill up the pattern hash
		for(int i = 0; i < pattern.length(); i++){
			hash_patt[pattern.charAt(i)]++;
		}
		
		for(int i = 0; i < hash_patt.length; i++){
			if(hash_patt[i] != 0)
				System.out.println((char) i + " -> " + hash_patt[i]);
		}
	}
	
	public static void findSmallestSubstring(String str, String pattern){
		//Create two hash-like-arrays: one for the string and another for the pattern
		int[] hash_patt = new int[NUMBER_OF_CHARACTERS];
		int[] hash_str = new int[NUMBER_OF_CHARACTERS];
		
		//Fill up the pattern hash
		for(int i = 0; i < pattern.length(); i++){
			hash_patt[pattern.charAt(i)]++;
		}
		
		//start -> the current starting index
		//final_start_index -> the minimal-length starting index
		//min_len -> minimum length of the window
		//count -> number of characters counted so far in the string of the pattern
		int start = 0, final_start_index = -1, min_len = Integer.MAX_VALUE, count = 0;
	
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			
			hash_str[c]++;
			
			//If the current character count matches, we increment count by 1
			if(hash_patt[c] > 0 && hash_str[c] <= hash_patt[c])
				count++;
			
			//If count equals pattern's length, we have found a window!
			if(count == pattern.length()){
				//Now we'll try to minimize it by squeezing the length of it
				//we start by checking if the count of a character in pattern
				//is greater than the count of the same character in the string
				//If it is, we increment the start index by 1 implicating that
				//the window will now start at one position further than it did
				//earlier
				
				while(hash_str[str.charAt(start)] > hash_patt[str.charAt(start)]
						// current character doesn't exist at all in the pattern
						|| hash_patt[str.charAt(start)] == 0)
				{
					//If the character exists
					if(hash_str[str.charAt(start)] > hash_patt[str.charAt(start)])
						hash_str[str.charAt(start)]--;
					start++;
				}
				
				//Calculate the minimum length obtained so far
				int window_length = i - start + 1;
				//If the new window length is smaller than the previous, change it
				if(min_len > window_length){
					final_start_index = start;
					min_len = window_length;
				}
			}
		}
		
		if(final_start_index == -1){
			System.out.println("No such window");
		}
		else{
			System.out.println(str.substring(final_start_index, final_start_index + min_len));
		}
	}
	
	public static void main(String[] args) {
		String s1 = "procaestrination";
		String s2 = "protein";
		
		dummyPrint(s1, s2);
		
//		findSmallestSubstring(s1, s2);
	}
}
