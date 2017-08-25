public class NextLargerElement {
	
	public static int findNextLargest(int for_position, int[] nums, int position){
		if(position == nums.length) {
			return -1;
		} else {
			if(nums[position] > nums[for_position])
				return nums[position];
			else
				return findNextLargest(for_position, nums, position + 1);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 3, 2, 4};
		
		for(int i = 0; i < nums.length; i++){
			System.out.print(findNextLargest(i, nums, i) + " ");
		}
		
		System.out.println();
	}
}
