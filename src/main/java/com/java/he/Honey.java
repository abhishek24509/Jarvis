package com.java.he;


import java.io.IOException;
import java.util.Scanner;


 public class Honey {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n+1];
		for(int i =1;i<A.length;i++){
			A[i]=sc.nextInt();
		}
		int q = sc.nextInt();
		while(q-- >0){
			 int l = sc.nextInt();
			 int r = sc.nextInt();
			 while(l<=r){
				 swap(l,A,n);
				 l++;
			 }
		}
		for(int a=1;a<A.length; a++){
		System.out.print(A[a]+" ");
		}
	}
	public static void swap(int l,int[] A,int n){
		int r = n+1-l;
		int temp = A[r];
		A[r]=A[l];
		A[l]=temp;
	}

}
