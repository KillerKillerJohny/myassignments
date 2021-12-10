package samplepackage;

import java.util.regex.Pattern;

public class ReformatingString {

	public static void main(String[] args) {
		String str="234564abcd";
		if(checkAllConditions(str.toLowerCase())) {
			System.out.println("list of all possible patterns");
			printPermutn(str,"");
		}
	}
	
	static boolean checkAllConditions(String str) {
		Pattern p=Pattern.compile("[0-9]+");
		Pattern p2=Pattern.compile("[a-z]+");
		if(p.matcher(str).matches()||p2.matcher(str).matches()) {
			System.out.println("given string should be alphanumeric");return false;
		}
		
		else {
			int numCount=0,alphaCount=0;
			for(int i=0;i<str.length();i++) {
				if(Character.isAlphabetic(str.charAt(i)))alphaCount++;
				if(Character.isDigit(str.charAt(i)))numCount++;
			}
			if(alphaCount==numCount || alphaCount==numCount-1 || alphaCount-1==numCount)return true;
			else {
				System.out.println("alternative alphabetic and numeric pattern not possible with the given string as alphabetic and numeric count doesnt match");
			}
		}
		
		return false;
	}
	
	 static void printPermutn(String str, String ans)
	    {
	        if (str.length() == 0) {
	            if(checkReformat(ans))
	            	System.out.println(ans+" ");
	            return;
	        }
	  
	        for (int i = 0; i < str.length(); i++) {
	        	
	            char ch = str.charAt(i);
	            String ros = str.substring(0, i) +  str.substring(i + 1);
	            printPermutn(ros, ans + ch);
	        }
	    }
	 
	 static boolean checkReformat(String str) {
		 
		 for(int i=0;i<str.length()-1;i++) {
			 if(Character.isAlphabetic(str.charAt(i))&&Character.isAlphabetic(str.charAt(i+1))||
					 Character.isDigit(str.charAt(i))&&Character.isDigit(str.charAt(i+1))) {
				 return false;
			 }
		 }
		 return true;
	 }
}



