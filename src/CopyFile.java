/**
 *
 * @author arghhjayy
 */

import java.io.*;

public class CopyFile {
	
	public static int dude = 20;
	
	public static void main(String[] args) throws IOException {
		FileReader freader = new FileReader("/home/arghhjayy/Foo/file1.txt");
		FileWriter fwriter = new FileWriter("/home/arghhjayy/Foo/file2.txt");
		
		int ch = freader.read();
		
		while(ch != -1)
		{
			fwriter.write(ch);
			ch = freader.read();
		}
		
		freader.close();
		fwriter.close();
		
		System.out.println("Done");
	}
}
