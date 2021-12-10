package samplepackage;

import java.util.Arrays;
import java.util.Scanner;

public class ReversingString {
	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		System.out.println("enter the string to reverse");
//		String str=sc.nextLine();
//		String[] strArr=str.split("");
		String[] strArr={"h","e","l","l","o"};
		String[] result=new String[strArr.length];
		int i=strArr.length-1;
		for(String str:strArr) {
			result[i]=str;
			i--;
		}
		Arrays.stream(result).forEach(System.out::println);
		
		
		                 //or//
		
//		StringBuilder str=new StringBuilder("hello");
//		String resultstr=str.reverse().toString();
		
	}
}
