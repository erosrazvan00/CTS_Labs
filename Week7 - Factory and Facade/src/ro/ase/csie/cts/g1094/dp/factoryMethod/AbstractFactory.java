package ro.ase.csie.cts.g1094.dp.factoryMethod;

import ro.ase.csie.cts.g1094.dp.simpleFactory.AbstractWeapon;
import ro.ase.csie.cts.g1094.dp.simpleFactory.WeaponType;

public abstract class AbstractFactory {

	public abstract AbstractWeapon getWeapon(WeaponType type, String description);
	
}
