import java.util.Scanner;

//Given an array of integers, print out the smallest two
public class KSmallestElements {
	
	public static void main(String[] args) {
		//We'll use a Minimum heap for this and assuming there are
		//only 10 integers
		
		MinimumHeap mh = new MinimumHeap(10);
		
		mh.insert(191);
		mh.insert(157);
		mh.insert(67);
		mh.insert(12);
		mh.insert(83);
		mh.insert(235);
		mh.insert(66);
		mh.insert(-5);
		mh.insert(10);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter k: ");
		
		int k = sc.nextInt();
		
		int i = -1;
		
		while(i++ < k){
			System.out.println(mh.extract_minimum());
		}
		
	}

}
