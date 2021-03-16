package ro.ase.csie.cts.g1094.refactor.phase3;

public interface MarketingInterface {

	 public  static final int MAX_AGE_ACCOUNT = 10;
	 public  static  final float MAX_FIFELITY_DISCOUNT = 0.15f;
	
	 public float getFidelityDiscount(int accountAge);
	 
}
