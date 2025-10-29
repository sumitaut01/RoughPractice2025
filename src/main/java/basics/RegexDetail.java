package basics;

import org.testng.annotations.Test;

import java.util.regex.*;
public class RegexDetail {

	public static void main(String[] args) {
		
	
		//Example 1
	 Pattern p=	 Pattern.compile("b");
		Matcher m= p.matcher("abbbbb");
		while(m.find()) {
			System.out.println("Start with "+m.start() +" Ends at "+m.end() + "m.group returns "+m.group());
		}
		
//		Start with 1 Ends at 2m.ground returns b
//		Start with 2 Ends at 3m.ground returns b
//		Start with 3 Ends at 4m.ground returns b
//		Start with 4 Ends at 5m.ground returns b
//		Start with 5 Ends at 6m.ground returns b	 

		
		//Example 2
		 java.util.regex.Pattern p2=	 java.util.regex.Pattern.compile("x");	 
			Matcher m2= p2.matcher("abbbbb");		
			System.out.println("is x present in abbbbb "+m.find()); //false
			
			
			while(m2.find()) {
				System.out.println("Start with "+m2.start() +" Ends at "+m2.end() + "m2.ground returns "+m2.group());
			}
			
		
	}


	@Test
	public void Rough(){


		String str="sumit raut";
		String pattern="t";


		Pattern p=Pattern.compile(pattern);
		Matcher m=p.matcher(str);

		int count=0;
		while(m.find()){

			System.out.println(m.start() + " "+m.end());
			count++;
		}

		System.out.println(count);
	}


	//4 5
	//9 10
	//2


}
