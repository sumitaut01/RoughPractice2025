package basics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
		  public static void main(String args[]) throws ParseException 
	  { 
	    // Formatting as per given pattern in the argument 
	    SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy"); 
	    String str = ft.format(new Date()); 
	    System.out.println("Formatted Date : " + str); //Formatted Date : 25-08-2026
	  
	    // parsing a given String 
	    str = "02/18/1995"; 
	    ft = new SimpleDateFormat("MM/dd/yyyy"); 
	    Date date = ft.parse(str); //Parsed Date : Sat Feb 18 00:00:00 IST 1995
	  
	    // this will print the date as per parsed string 
	    System.out.println("Parsed Date : " + date); 
	  } 
	} 


