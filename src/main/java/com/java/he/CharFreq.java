package com.java.he;

public class CharFreq {
	
	public static void main(String[] args){
		String s ="aaaaabbbhslkslweqsdsdc";
		//new CharFreq().doIt(s);
		new CharFreq().doItHash(s);
	}
	private void doIt(String s){
		char[] ch = s.toCharArray();
		for(int i=97;i<=122;i++ ){
			int freq =0;
			for(int j=0;j<ch.length;j++){
				if(ch[j]==i){
					freq++;
				}
			}
			if(freq>0)
			System.out.println("Frequency of "+(char)i +" is " + freq);
		}
	}
	
	private void doItHash(String s){
		char[] ch = s.toCharArray();
		int[] freq = new int[26];
		for(int i=0;i<ch.length;i++){
			int idx = getHash(ch[i]);
			freq[idx] = freq[idx]+1;
		}
		int x=0;
		for(int i : freq){
			System.out.println("Frequency of "+(char)(x+'a') +" is " + i);
			x++;
		}
		
	}
	private int getHash(char c){
		return c-'a';
	}

}
