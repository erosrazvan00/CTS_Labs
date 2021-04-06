package ro.ase.csie.cts.g1094.dp.factoryMethod;

import ro.ase.csie.cts.g1094.dp.simpleFactory.SuperHero;
import ro.ase.csie.cts.g1094.dp.simpleFactory.WeaponType;
import ro.ase.csie.cts.g1094.dp.simpleFactory.WeaponsFactory;

public class testFactory {

	public static void main(String[] args) {

		boolean kidsMode = true;
		SuperHero superman = null;
		
		if(kidsMode) {
			superman = new SuperHero("Superman", new WaterPistol());
			
		}
		else
		{
			superman = new SuperHero("Supermna", WeaponsFactory.getWeapon(WeaponType.PISTOL, ""));
			
		}

		AbstractFactory weaponFactory = (kidsMode==true) ? new WaterWeaponsFactory() : new RealWeaponsFactory();
		superman= new SuperHero("Superman", weaponFactory.getWeapon(WeaponType.PISTOL,"piatol"));
		superman.setWeapon(weaponFactory.getWeapon(WeaponType.BAZOOKA, ""));
	}

}
