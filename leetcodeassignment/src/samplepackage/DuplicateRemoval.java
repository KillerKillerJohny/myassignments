package samplepackage;

public class DuplicateRemoval {
	public static void main(String[] args) {
		StringBuilder str=new StringBuilder("kllkikkhnkkfissskdiiddd");
		System.out.println(dupRemover(str));
	}
	
	public static String dupRemover(StringBuilder str) {
		int i=0;
		for(i=0;i<str.length()-1;i++) {
			if(str.charAt(i)==str.charAt(i+1)) {
				str.delete(i, i+2);
				i=0;
			}
		}
		if(str.charAt(0)==str.charAt(1))
			return str.delete(0, 2).toString();
		else
			return str.toString();
		
	}
	
}
