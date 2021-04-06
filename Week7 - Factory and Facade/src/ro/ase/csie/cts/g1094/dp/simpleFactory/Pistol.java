package ro.ase.csie.cts.g1094.dp.simpleFactory;

public class Pistol extends AbstractWeapon{

	public Pistol(String desc, int power) {
		this.description=desc;
		this.powerLevel=power;
	}
	
	@Override
	public void pewPew() {
		
	}
	
}
