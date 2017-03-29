package cm.java.hf;

public class SingleDotCom {

	private int[] cellLocation;
	private int noOfHits;
	private int previous = -1;

	public void setCellLocation(int[] cellLocation) {
		this.cellLocation = cellLocation;
	} 

	String checkYourself(String guess){
		String result = "miss";
		int gues = Integer.parseInt(guess);
		for(int cell : cellLocation){
			if(gues == cell && cell!=previous){
				result = "hit";
				noOfHits++;
				previous = cell;
				break;
			}
		}
		if(noOfHits == 3){
			result ="kill";
		}
		return result;
	}



}
