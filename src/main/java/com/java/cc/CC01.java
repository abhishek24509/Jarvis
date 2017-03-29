package com.java.cc;

public class CC01 {

	public static int count;
	public static void main(String[] args) {
		String s = "GameporterAbhishek@123";
		//premutations(s,"");
		int n = 20;
		int[] ar = new int[n+1];
		System.out.println(fib(n,ar));
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
	
	public static int fib(int n,int[] ar){// O(n) is the time complexity highly efficient than O(2^n) 
		if(n<=0){
			return 0;
		}else if(n==1){
			return 1;
		}else {
			if(ar[n]>0){
				return ar[n];
			}
			return ar[n]=fib(n-1,ar)+fib(n-2,ar);
			
		}
	}

}
//GameporterAbs12h3ike@h