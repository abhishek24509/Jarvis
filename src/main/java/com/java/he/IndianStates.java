package com.java.he;

enum IndianState {

	KARNATAKA("Bangalore","Tamil Nadu") {
		@Override
		public String getRegionalLangauage() {
			return "Kannada";
		}
	},
	UTTARPRADESH("Lucknow","Bihar") {
		@Override
		public String getRegionalLangauage() {
			return "Hindi";
		}
	},
	GUJRAT("Gandhinagar","Maharastra") {
		@Override
		public String getRegionalLangauage() {
			return "Gujrathi";
		}
	},
	RAJASTHAN("Jaipur","Madhya Pradesh") {
		@Override
		public String getRegionalLangauage() {
			return "Rajasthani";
		}
	},
	PUNJAB("Chandigarh","Haryana") {
		@Override
		public String getRegionalLangauage() {
			return "Punjabi";
		}
	};

	private String capital;
	private String neighbour;

	private IndianState(String capital,String neighbour) {
		this.capital = capital;
		this.neighbour = neighbour;
	}

	public String getCapital(){
		return capital;
	}

	public String getNeighbour(){
		return neighbour;
	}

	public abstract String getRegionalLangauage();
}

public class IndianStates {
	public static void main(String[] args){
		for(IndianState state : IndianState.values()){
			System.out.printf("For state %s capital is %s , regional language is %s and one of the neighbour is %s%n"
					,state,state.getCapital(),state.getRegionalLangauage(),state.getNeighbour());
		}
	}
}
