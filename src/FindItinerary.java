import java.util.*;

//Refer the example:

//Input:
//"Chennai" -> "Banglore"
//"Bombay" -> "Delhi"
//"Goa"    -> "Chennai"
//"Delhi"  -> "Goa"
//
//Output: 
//Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,


public class FindItinerary {
	
	public static void printItinerarry(HashMap<String, String> map){
		HashMap<String, String> reverseMap = new HashMap<>();
				
		for(HashMap.Entry<String, String> entry : map.entrySet()) {			
			reverseMap.put(entry.getValue(), entry.getKey());
		}
				
		String firstStation = "";
		
		for(HashMap.Entry entry: map.entrySet()){
			if(!reverseMap.containsKey(entry.getKey()))
			{
				firstStation = (String)entry.getKey();
				break;
			}
		}
		
		String currStation = firstStation;
		
		while(map.containsKey(currStation))
		{
			System.out.print((currStation == firstStation? currStation : "") + " -> " + map.get(currStation) + " ");
			currStation = map.get(currStation);
		}
		
	}
	
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		
		map.put("Chennai", "Bangalore");
		map.put("Bombay", "Delhi");
		map.put("Goa", "Chennai");
		map.put("Delhi", "Goa");
		
		printItinerarry(map);
		System.out.println();
	}
}