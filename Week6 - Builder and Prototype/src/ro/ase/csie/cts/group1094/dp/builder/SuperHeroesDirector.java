package ro.ase.csie.cts.group1094.dp.builder;

public class SuperHeroesDirector {

	SuperHero.SuperHeroBuilder builder;
	
	public SuperHeroesDirector(SuperHero.SuperHeroBuilder builder) {
		this.builder=builder;
	}
	
	public SuperHero buildJoker() {
		return builder
				.isVillan()
  				.addLeftWeapon(new Pistol())
  				.addRightWeapon(new Pistol())
  				.build();
	}
	
	public SuperHero buildSuperman() {
		return builder
  				.addSuperPower("Fly")
  				.addLeftWeapon(new Pistol())
  				.build();
	}
}
