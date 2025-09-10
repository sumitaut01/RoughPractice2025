package basics;

import java.util.regex.Pattern;
import java.util.regex.Matcher;;

public class RegexExamples2 {

	int count = 0;
	
	static int Count=0;
	

	public static void main(String[] args) {
	Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher("This is 123 and request is 3434. Test 123");
		Matcher m2 = p.matcher("This is 123 and request is 3434. Test 123");
		while (m.find()) {
		System.out.println(m.group());
		
	}	
		
	}	
	
}
