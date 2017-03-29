package cm.java.hf.dp.strategy;

public class CharacterTestDrive {
	
	public static void main(String[] args){
		Character c = new King();
		c.setWeaponBehaviour(new AxeBehaviour());
		c.fight();
		c.getWeaponBehaviour().useWeapon();
		c.setWeaponBehaviour(new SwordBehavior());
		c.getWeaponBehaviour().useWeapon();
	}

}
