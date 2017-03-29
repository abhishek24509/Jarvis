package cm.java.hf;

public class GuessGame extends Game{


	public GuessGame(int nop){
		super(nop);
	}
	public void startGame(){
		int target = (int)(Math.random()*10);
		System.out.println("About to guess the number ::");
		while(true){
			System.out.println("Number to guess is ::: "+target);
			int c =1;
			boolean winnerSelected = false;
			int winner = -1;
			for(Player p : players){
				p.guess();
				System.out.println("Player "+c+" Guessed "+p.number);
				if(p.number == target){
					winnerSelected = true;
					winner = c;
				}
				c++;
			}
			if(winnerSelected){
				System.out.println("Player "+winner+" Won ");
				System.out.println("Game is Over");
				break;
			}else{
				System.out.println(" No Winner Yet Player need to try again ");
			}
		}
	}

}
