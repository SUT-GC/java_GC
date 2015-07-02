package Terminal.Simulation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Terminal {
	public static LinkedList<File> queue = new LinkedList<>();
	public static void bfs(File file){
		String[] files = file.list();
		for(String filename: files){
			File nowFile = new File(file.getAbsolutePath()+"/"+filename);
			if(nowFile.isDirectory()){
				bfs(nowFile);
			}else{
				System.out.println(file.getAbsolutePath()+"/"+filename);
			}
		}
	}
	public static void main(String[] args) {
		String fileadd = ".";
		
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			fileadd = sc.next();
			File file = new File(fileadd);
			bfs(file);
			
		}
//		try {
//			FileInputStream fis = new FileInputStream(new File("/home/gc/java/1.txt"));
//			FileOutputStream fos = new FileOutputStream(new File("/home/gc/java/2.txt"));
//			
//			int count = 0;
//			byte[] bytes = new byte[1024];
//			while((count = fis.read(bytes))>0){
//				fos.write(bytes, 0, count);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}
}
