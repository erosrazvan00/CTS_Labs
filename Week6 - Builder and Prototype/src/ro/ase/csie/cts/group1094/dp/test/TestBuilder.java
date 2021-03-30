package ro.ase.csie.cts.group1094.dp.test;

import ro.ase.csie.cts.group1094.dp.builder.Pistol;
import ro.ase.csie.cts.group1094.dp.builder.SuperHero;
import ro.ase.csie.cts.group1094.dp.builder.SuperHero.SuperHeroBuilder;

public class TestBuilder {

	public static void main(String[] args) {
		
		//1. create the object
		//SuperHero superHero = new SuperHero();
		
		//2.Init the object
		//To do: don't forget
		//superHero.name = "Superman";
		//superHero.lifePoints = 100;
		//superHero.superPower = "Can't fly";
  		//superHero.superPower = "Lase eyes";
  		
		//SuperHero superHero = 
				//new SuperHero("Superman", 100, false, false, null, new Pistol(), "Laser eyes", null);
		
  		SuperHero superman = new SuperHero.SuperHeroBuilder("Superman", 100)
  				.addSuperPower("Fly")
  				.addLeftWeapon(new Pistol())
  				.build();

  		SuperHero joker = new SuperHero.SuperHeroBuilder("Joker", 200)
  				.isVillan()
  				.addLeftWeapon(new Pistol())
  				.addRightWeapon(new Pistol())
  				.build();
  		
	}

}
