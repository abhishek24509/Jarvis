package com.java.he;

public class Test {
	
	public static void main(String[] args){
		try{
			int a = 2/0;
		}catch(Exception e){
			System.out.println("Inside catch");
		}
		
		
		finally{
			System.out.println("In finallly");
		}
		
		System.out.println("Outside catch");
	}

}
