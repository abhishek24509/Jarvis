package com.java.he;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class MonkHash {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	//	String[][] store = new String[100][150];
		Hashtable<Integer,String> table = new Hashtable<Integer, String>();
		char[][] store = new char[10000][25];
		while(n-- >0){
			String[] input = br.readLine().split("\\s+");
			int rn = Integer.parseInt(input[0]);
			String name = input[1];
			//int hash1 = getHash(rn);
			//int hash2 = get2Hash(rn);
			//store[hash1][hash2]=name;
			table.put(rn, name);
			store[Long.hashCode(rn)] = name.toCharArray();
		
		}
		int q = Integer.parseInt(br.readLine());
		while (q-->0){
			int r = Integer.parseInt(br.readLine());
			//System.out.println(store[getHash(r)][get2Hash(r)]);
			char[] c = store[r%10000];
			for(char ch :c)
			System.out.print(ch);
			System.out.println();
		}
	}
	
	public static int getHash(int r){
		int rs = 0;
		while (r>0){
			rs += r%10;
			r /= 10;
		}
		return rs%2069;
	}
	
	public static int get2Hash(int r){
		return r%1000000000+(r/3000000)*31;
	}

}
