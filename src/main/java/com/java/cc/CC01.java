package com.java.cc;

public class CC01 {

	public static int count;
	public static void main(String[] args) {
		String s = "GameporterAbhishek@123";
		premutations(s,"");
	}

	public static void premutations(String s , String p){
		if(s.length()==0){
			count++;
			if(count==1000000){
				System.out.println(p);
				System.exit(0);
			}
		}else {
			for(int i=0;i<s.length();i++){
				String rem = s.substring(0, i)+s.substring(i+1);
				premutations(rem,p+s.charAt(i));
			}
		}
	}

}
//GameporterAbs12h3ike@h