package cm.java.hf;

public class SingleDotComTestDrive {

	public static void main(String[] args){
		SingleDotCom s = new SingleDotCom();
		int[] cellLocation = {2,3,4};
		s.setCellLocation(cellLocation);
		String result = s.checkYourself("5");
		if(result.equals("miss")){
			System.out.println("Test Passed");
		}
		else{
			System.out.println("Test Failed");
		}
	}

}
