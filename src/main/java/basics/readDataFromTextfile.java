package basics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class readDataFromTextfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println(System.getProperty("user.dir")); // H:\eclipseWin10\com.resurrectionJavaPgm.af

		FileReader file = new FileReader("H:\\eclipseWin10\\com.resurrectionJavaPgm.af\\Files\\demo.txt");
		BufferedReader br = new BufferedReader(file);
		String str;
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
		
		
		
		
		
		
		//Method 2:
		//File+Scanner
		File f=new File("H:\\eclipseWin10\\com.resurrectionJavaPgm.af\\Files\\demo2.txt");
		Scanner sc=new Scanner(f);
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		
		sc.close();
		
	}

}
