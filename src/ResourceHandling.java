import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class ExceptionA extends Exception{
	String message;
	
	ExceptionA(String message){
		this.message = message;
	}
	
	@Override
	public void printStackTrace(){
		System.out.println(this.message);
	}
}


class ExceptionB extends Exception{
	
}

class MyResource{
	File f;
	FileReader fr;
	
	public void doSomeWork() throws FileNotFoundException, ExceptionA, IOException{
		f = new File("/home/arghhjayy/Desktop/bro.txt");
		fr = new FileReader(f);
		
		while(fr.ready()){
			System.out.print((char)fr.read());
		}
		
		closeResource();
	}
	
	public void closeResource() throws ExceptionA, IOException{
		if(fr != null){
			fr.close();
			throw new ExceptionA("File reference weren't released, now released");
		}
	}
}

class OldTryDemo{
	public static void main(String[] args) throws ExceptionA, IOException {
		MyResource mr = new MyResource();
		mr.doSomeWork();
	}
}