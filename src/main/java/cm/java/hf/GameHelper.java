package cm.java.hf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameHelper {
	
	public static String getUserInout(String prompt) throws IOException{
		System.out.println(prompt +" ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}

}
