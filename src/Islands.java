/*
A group of connected 1s forms an island now your task is
to complete the method findIslands which returns the no of islands present.
The function  takes three arguments the first is the boolean matrix A and then
the next two arguments are N and M denoting the size of the matrix A .
*/

/*
	1 1 0
	0 0 1
	1 0 0
*/

//Make a boolean array which represents where the islands have been seen earlier
//Initialize these with false(no islands has been found initially)
//Iterate for every cell and do:
//		if the cell is a 1 and the value of the boolean array is false for that cell
//			increment counter
//			check if it has any surrounding 1s
//				if it does, for the cell and each of the surrounding 1s, update
//				the value at the boolean array for the positions and
//				for their surrounding 1s and so on as true
//				which means that this is a part of an island that has been seen before

public class Islands {
	
	public static boolean hasNeighbor1(int[][] arr, int positionx, int positiony){		
		//Check upper
		if(isSafe(arr, positionx - 1, positiony) && arr[positionx - 1][positiony] == 1)
			return true;
		//Check lower
		if(isSafe(arr, positionx + 1, positiony) && arr[positionx + 1][positiony] == 1)
			return true;
		//Check left
		if(isSafe(arr, positionx, positiony - 1) && arr[positionx][positiony - 1] == 1)
			return true;
		//Check right
		if(isSafe(arr, positionx, positiony + 1) && arr[positionx][positiony + 1] == 1)
			return true;
		//Check upper-left
		if(isSafe(arr, positionx - 1, positiony - 1) && arr[positionx - 1][positiony - 1] == 1)
			return true;
		//Check upper-right
		if(isSafe(arr, positionx - 1, positiony + 1) && arr[positionx - 1][positiony + 1] == 1)
			return true;
		//Check lower-left
		if(isSafe(arr, positionx + 1, positiony - 1) && arr[positionx + 1][positiony - 1] == 1)
			return true;
		//Check lower right
		if(isSafe(arr, positionx + 1, positiony + 1) && arr[positionx + 1][positiony + 1] == 1)
			return true;
		
		//There is none
		return false;
	}
	
	public static void fillUpBoolean(int[][] arr, int positionx, int positiony, boolean[][] positions) {
		if(isSafe(arr, positionx, positiony) && hasNeighbor1(arr, positionx, positiony) && arr[positionx][positiony] == 1 && positions[positionx][positiony] == false)
		{
			positions[positionx][positiony] = true;
			fillUpBoolean(arr, positionx - 1, positiony, positions);
			fillUpBoolean(arr, positionx + 1, positiony, positions);
			fillUpBoolean(arr, positionx, positiony - 1, positions);
			fillUpBoolean(arr, positionx, positiony + 1, positions);
			fillUpBoolean(arr, positionx - 1, positiony - 1, positions);
			fillUpBoolean(arr, positionx - 1, positiony + 1, positions);
			fillUpBoolean(arr, positionx + 1, positiony - 1, positions);
			fillUpBoolean(arr, positionx + 1, positiony + 1, positions);
		}
	}
	
	public static boolean isSafe(int[][] arr, int positionx, int positiony){
		return (positionx < arr.length && positiony < arr[0].length
				&& positionx >= 0 && positiony >= 0);
	}
	
	public static int findIslands(int[][] arr, int n, int m){
		boolean[][] positions = new boolean[n][m];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				positions[i][j] = false;
			}
		}
		
		//Number of islands
		int counter = 0;
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(arr[i][j] == 1 && positions[i][j] == false){
					counter++;
					
					fillUpBoolean(arr, i, j, positions);
				}
			}
		}
		
		return counter;
	}
	
	public static void main(String[] args) {
		int[][] arr = {	{1, 1, 1},
						{0, 0, 0},
						{1, 0, 1}};
		
		System.out.println(findIslands(arr, 3, 3));
	}
}






















