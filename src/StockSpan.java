public class StockSpan {
	
	public static int findSpan(int position, int[] stocks, int original_position){
		if(position < 0) {
			return 0;
		} else{
			if(stocks[position] > stocks[original_position])
				return 0;
			else
				return 1 + findSpan(position - 1, stocks, original_position);
		}
	}
	
	public static void main(String[] args) {
		int[] stocks = {10, 4, 5, 90, 120, 80};
		
		for(int i = 0; i < stocks.length; i++)
			System.out.print(findSpan(i, stocks, i) + " ");
		
		System.out.println();
	}
}
