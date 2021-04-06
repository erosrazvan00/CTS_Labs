package ro.ase.csie.cts.g1094.dp.factoryMethod;

import ro.ase.csie.cts.g1094.dp.simpleFactory.AbstractWeapon;
import ro.ase.csie.cts.g1094.dp.simpleFactory.Bazooka;
import ro.ase.csie.cts.g1094.dp.simpleFactory.MachineGun;
import ro.ase.csie.cts.g1094.dp.simpleFactory.Pistol;
import ro.ase.csie.cts.g1094.dp.simpleFactory.WeaponType;

public class RealWeaponsFactory extends AbstractFactory {

	@Override
	public AbstractWeapon getWeapon(WeaponType type, String description) {
		
		
		AbstractWeapon weapon = null;
        switch (type) {
            case PISTOL:
                weapon = new Pistol(description, 100);
                break;
            case MACHINE_GUN:
                weapon = new MachineGun(100, 1000);
                weapon.setDescription(description);
                break;
            case BAZOOKA:
                weapon = new Bazooka();
                weapon.setDescription(description);
            default:
                throw new UnsupportedOperationException("Type not covered");
	}

	return weapon;
	}
}
