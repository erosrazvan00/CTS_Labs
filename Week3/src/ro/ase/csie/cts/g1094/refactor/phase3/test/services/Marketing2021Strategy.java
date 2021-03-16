package ro.ase.csie.cts.g1094.refactor.phase3.test.services;


public class Marketing2021Strategy implements MaketingServiceInterface {

	@Override
	public float getFidelityDiscount(int accountAge) {
		return (accountAge > MAX_AGE_ACCOUNT) ? MAX_FIDELITY_DISCOUNT : (float)accountAge/100;
	}
}
