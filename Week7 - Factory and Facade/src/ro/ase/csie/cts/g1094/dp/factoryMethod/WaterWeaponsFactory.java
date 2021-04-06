package ro.ase.csie.cts.g1094.dp.factoryMethod;

import ro.ase.csie.cts.g1094.dp.simpleFactory.AbstractWeapon;

import ro.ase.csie.cts.g1094.dp.simpleFactory.WeaponType;

public class WaterWeaponsFactory extends AbstractFactory {

	@Override
	public AbstractWeapon getWeapon(WeaponType type, String description) {
		
		AbstractWeapon weapon = null;
		switch(type) {
		case PISTOL:
			weapon = new WaterPistol();
			break;
		case MACHINE_GUN:
			weapon = new WaterBaloon();
			break;
		case BAZOOKA:
			weapon = new WaterBucket();
			break;
			default:
				throw new UnsupportedOperationException();
		}
		return weapon;
	}

}
