package cm.java.hf.dp.strategy;

public  abstract class Character {
	private WeaponBehaviour weaponBehaviour;   // this is composition

	public void setWeaponBehaviour(WeaponBehaviour weaponBehaviour) {
		this.weaponBehaviour = weaponBehaviour;
	}
	
	public abstract void fight();

	public WeaponBehaviour getWeaponBehaviour() {
		return weaponBehaviour;
	}
	

}
