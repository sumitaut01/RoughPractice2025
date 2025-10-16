package basics;

import java.util.regex.Pattern;
import java.util.regex.Matcher;;

public class RegexExamples {

	int count = 0;
	
	static int Count=0;
	

	public static void main(String[] args) {
	Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher("This is 123 and request is 3434. Test 123");
		Matcher m2 = p.matcher("This is 123 and request is 3434. Test 123");
		while (m.find()) {

			System.out.println("start"+m.start());
			System.out.println("end"+m.end());
		System.out.println(m.group());
//			start8
//					end11
//			123
//			start27
//					end31
//			3434
//			start38
//					end41
//			123
		
	
		
	}
		
	
	
	
	
	
		
	}	
	
}
