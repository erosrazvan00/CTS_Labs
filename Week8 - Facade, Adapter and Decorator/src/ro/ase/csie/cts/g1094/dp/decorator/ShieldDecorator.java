package ro.ase.csie.cts.g1094.dp.decorator;

import ro.ase.csie.cts.g1094.dp.adapter.ACMESuperHero;

public class ShieldDecorator extends AbstractDecorator{

	int shieldPoints;
	
	
	
	public ShieldDecorator(ACMESuperHero hero, int shieldPoints) {
		super(hero);
		this.shieldPoints = shieldPoints;
	}

	public ShieldDecorator(ACMESuperHero hero) {
		super(hero);

	}

	@Override
	public void takeAHit(int points) {
		int lostPoints = points - shieldPoints;
		if(lostPoints>0)
			super.takeAHit(points);
		
	}
	
	
}
