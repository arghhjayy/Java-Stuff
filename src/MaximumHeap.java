public class MaximumHeap {
	//Total capacity to hold
	public int capacity;
	//An array to hold
	public int[] arr;
	//Current size of the array
	public int size;
	
	public MaximumHeap(int capacity) {
		this.capacity = capacity;
		size = 0;
		arr = new int[capacity];
	}
	
	public int parent_position(int i){
		return (i - 1) / 2;
	}
	
	public int left_node_position(int i){
		return (2 * i) + 1;
	}
	
	public int right_node_position(int i){
		return (2 * i) + 2;
	}
	
	public void swap_data(int pos1, int pos2){
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
	
	public void insert(int key){
		if(size == capacity){
			System.out.println("No more space.");
			return;
		}
		
		arr[size] = key;
		size++;
		
		int i = size - 1;
		
		while(i != 0 && arr[i] > arr[parent_position(i)])
		{
			swap_data(i, parent_position(i));
			i = parent_position(i);
		}
	}
	
	public void delete_key(int position){
		if(size <= 0) {
			System.out.println("Nothing to delete from.");
			return;
		}
		change_key(position, Integer.MIN_VALUE);
		extract_maximum();
	}
	
	public void change_key(int position, int by){
		arr[position] = by;
	}
	
	//Decrease some key at position "position" BY some value
	public void mod_key(int position, int by, int op){
		
		switch(op){
			case 1:
				arr[position] += by;
				break;
			case 2:
				arr[position] -= by;
				break;
			case 3:
				arr[position] *= by;
				break;
			case 4:
				arr[position] += by;
				break;
		}
		
		//Fix the changed tree: bottom -> up
		int i = position;
		while(i != 0 && arr[i] < arr[parent_position(i)])
		{
			swap_data(i, parent_position(i));
			i = parent_position(i);
		}
	}
	
	public int get_maximum(){
		return arr[0];
	}
	
	public int extract_maximum(){
		if(size <= 0) {
			return Integer.MAX_VALUE;
		}
		if(size == 1) {
			size = 0;
			return arr[0];
		}
		
		int smallest = arr[0];
		
		//Let the rightmost/ node at the very end be the maximum element - (1) 
		arr[0] = arr[size - 1];
		
		size--;
		
		//Now we check whether the decision made in (1) randomly was correct or
		//not by calling minHeapify given the root index.
		//If it isn't correct, it is changed by the correct value
		maxHeapify(0);
		
		return smallest;
	}
	
	//Fix the tree: top -> bottom
	public void maxHeapify(int root_index){
		int left = left_node_position(root_index);
		int right = right_node_position(root_index);
		
		int smallest_index = root_index;
		
		if(left < size && arr[left] > arr[smallest_index]) {
			smallest_index = left;
		}
		
		if(right < size && arr[right] > arr[smallest_index]) {
			smallest_index = right;
		}
		
		if(smallest_index != root_index){
			swap_data(smallest_index, root_index);
			maxHeapify(smallest_index);
		}
	}
	
	public void show(){
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MaximumHeap mh = new MaximumHeap(11);
		
		mh.insert(1);
		mh.insert(2);
		mh.insert(3);
		
		System.out.println(mh.extract_maximum());
		System.out.println(mh.extract_maximum());
	}
}