/**
 *
 * @author arghhjayy
 */

import java.io.File;

public class FileDemo {
	public static void main(String[] args) {
		File f = new File("/home/arghhjayy");
		int no_files = 0, no_directories = 0;
		int max_size_file = 0;
		
		for(File file: f.listFiles()) {
			if(file.isDirectory()) {
				no_directories++;
			} else{
				no_files++;
				max_size_file = (int)Math.max(max_size_file, file.length());
			}
		}
		
		System.out.println("Number of directories: " + no_directories);
		System.out.println("Number of files: " + no_files);
		System.out.println("Maximum file size: " + max_size_file);
	}
}
