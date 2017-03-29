package cm.java.hf;

public abstract class Game {

	int noOfPlayers;
	Player[] players;

	public Game(int nop){
		this.noOfPlayers = nop;
		players = new Player[nop];
		for(int i =0;i<nop;i++){
			players[i]=new Player();
		}
	}
	public abstract void startGame();

}
