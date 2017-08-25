
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//Given a dictionary that contains mapping of employee and his manager as a number of (employee, manager) pairs like below. 
//
//{ "A", "C" },
//{ "B", "C" },
//{ "C", "F" },
//{ "D", "E" },
//{ "E", "F" },
//{ "F", "F" } 
//
//In this example C is manager of A, 
//C is also manager of B, F is manager 
//of C and so on.

//Write a function to get no of employees under each manager in the hierarchy not just their direct reports.
//It may be assumed that an employee directly reports to only one manager.
//In the above dictionary the root node/ceo is listed as reporting to himself.

//Output should be a Dictionary that contains following.
//A - 0  
//B - 0
//C - 2
//D - 0
//E - 1
//F - 5 

//Algorithm:

//1)create an empty map
//2)Put the direct elements
//3)Put the element for which the boss is indirect

public class FIndManagers {
	public static void printNumberOfEmployees(HashMap<String, String> map)
	{
		HashMap<String, ArrayList<String>> empNos = new HashMap<>();
		
		for(HashMap.Entry<String, String> entry: map.entrySet()){
			if(!empNos.containsKey(entry.getValue())) {
				ArrayList<String> toadd = new ArrayList<>();
				
				toadd.add(entry.getValue());
				empNos.put(entry.getValue(), toadd);
			} else{
				empNos.get(entry.getValue()).add(entry.getKey());
			}
		}
		
		//Add extras now
		
		
		for(HashMap.Entry<String, ArrayList<String>> entry: empNos.entrySet()){
			String employeeName = entry.getKey();
			ArrayList<String> listOfEmployees = entry.getValue();
			
			for(String employee: listOfEmployees){
				
			}

		}
		
		System.out.println(empNos);
	}
	
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("A", "C");
		map.put("B", "C");
		map.put("C", "F");
		map.put("D", "E");
		map.put("E", "F");
		map.put("F", "F");
		
		printNumberOfEmployees(map);
	}
}
