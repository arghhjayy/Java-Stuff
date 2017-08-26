/*
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.

Insert
Remove
Replace
All of the above operations are of cost=1.
Both the strings are of lowercase.
*/

public class EditDistance {
	
	public static int minimum(int a, int b, int c){
		return a < b && a < c ? a : ((b < c && b < a) ? b : c);
	}
	
	public static int findEditDistance(String first, String second){
		//Using dynamic programming
		int[][] result = new int[first.length()][second.length()];
		
		//Both strings are empty, no steps are required
		result[0][0] = 0;
		
		for(int i = 0; i < first.length(); i++){
			for(int j = 0; j < second.length(); j++){
				//If first string is empty
				if(j == 0){
					result[i][j] = i;
					continue;
				}
				
				//If second string is empty
				if(i == 0){
					result[i][j] = j;
					continue;
				}
				
				//If the last characters of both the strings are equals
				if(first.charAt(i) == second.charAt(j))
				{
					//Then the result would be equal to the result calculated
					//if we leave out the current matching character from both
					//the strings
					result[i][j] = result[i-1][j-1];
					continue;
				}
				
				//If the last characters aren't matching
				if(first.charAt(i) != second.charAt(j)){
					//Then try all of the edit operations that are
					//Insertion, deletion and replacement
					//and find the "minimum()" out of them
					result[i][j] = 1 + minimum(result[i - 1][j - 1],
											   result[i - 1][j],
											   result[i][j - 1]
					);
					continue;
				}
			}
		}
		
		//Return the last element which is the result
		return result[first.length() - 1][second.length() - 1];
	}
	
	public static void main(String[] args) {
		String s1 = "geek";
		String s2 = "gesek";
		
		System.out.println(findEditDistance(s1, s2));
	}
}
