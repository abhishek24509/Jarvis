package cm.java.hf;

import java.io.IOException;

public class SingleDotComGame {

	public static void main(String[] args){
		int noOfGuess=1;
		SingleDotCom s = new SingleDotCom();
		int rand = (int)(Math.random()*5);
		int[] cellLocation = {rand,rand+1,rand+2};
		s.setCellLocation(cellLocation);
		while(true){
			try{
				String userGuess = GameHelper.getUserInout("Input your Guess");
				String res = s.checkYourself(userGuess);
				System.out.println(res.toUpperCase());
				if(res.equals("kill")){
					System.out.println("You Guessed right after "+noOfGuess+ "Guesses");
					break;
				}else{
					System.out.println();
					noOfGuess++;
				}
			}catch(IOException e){
				e.printStackTrace();
			}

		}

	}

}
