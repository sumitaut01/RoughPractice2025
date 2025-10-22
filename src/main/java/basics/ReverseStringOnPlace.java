package basics;

import org.testng.annotations.Test;

public class ReverseStringOnPlace {

	public static void main(String[] args) {

		String text = "this is sparta for you";
        String[] arr = text.split(" ");
        StringBuffer sb = new StringBuffer();
        
    
        for (String str : arr) {
			System.out.println(str);
			sb = sb.append(new StringBuffer(str).reverse().append(" "));
		}

		System.out.println(sb.toString().trim());

	
	
	
	
	//# Method 2 Split and revrse loop
	
	String text2 = "i love you baby";
	
	String []arrText=text2.split(" ");
    String reverse="";
	
	for(String s:arrText) {
		
		  for(int r=s.length()-1;r>=0;r--) {
			  
			reverse= reverse+s.charAt(r);
			  
		  }
		  reverse=reverse+" ";
		
	}
	System.out.println("Original:"+text2);
	System.out.println("reverse:"+reverse); //i evol uoy ybab 
	
}


@Test
	public void Rough(){
	String text = "this is sparta for you";
	String rev="";
	for(String s: text.split(" ")){
		rev=rev+" "+ new StringBuffer(s).reverse();
	}
	System.out.println(rev.trim());//siht si atraps rof uoy






}
}
