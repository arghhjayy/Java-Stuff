/**
 *
 * @author arghhjayy
 */

class SelfException extends Exception {
	String message;
	
	SelfException(String message){
		this.message = message;
	}
}
