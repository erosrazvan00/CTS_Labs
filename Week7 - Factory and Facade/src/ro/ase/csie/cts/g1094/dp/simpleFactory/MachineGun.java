package ro.ase.csie.cts.g1094.dp.simpleFactory;

public class MachineGun extends AbstractWeapon{

	int noBullets;
	
	public MachineGun(int power, int ammo) {
		this.description="MG";
		this.powerLevel=power;
		this.noBullets=ammo;
	}
	@Override
	public void pewPew() {
		
	}

}
