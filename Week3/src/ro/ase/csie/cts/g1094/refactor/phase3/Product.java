package ro.ase.csie.cts.g1094.refactor.phase3;

import ro.ase.csie.cts.g1094.refactor.exceptions.InvalidAgeException;
import ro.ase.csie.cts.g1094.refactor.exceptions.InvalidPriceException;
import ro.ase.csie.cts.g1094.refactor.phase3.test.services.MaketingServiceInterface;

public class Product {
	
	MaketingServiceInterface mkService = null;
	
	public Product(MaketingServiceInterface mkService) {
		
		  //if(mkService == null) { throw new NullPointerException(); } this.mkService = mkService;
		
		this.setMarketingService(mkService);
	}
	
	public void setMarketingService(MaketingServiceInterface mkService) {
		if(mkService == null) {
			throw new NullPointerException();
		}
		this.mkService = mkService;

	}

    private static float getDiscountValue(float price, float discount){
        return  discount*price;
    }
    
    private static float getPriceWithDiscountAndFidelity(float price, float discountValue, float fidelityDiscount){
        return (price - discountValue)*(1-fidelityDiscount) ;
    }

    private static float getFinalPrice(float price, float fidelityDiscount, ProductType type){
        float discountValue = getDiscountValue(price,type.getDiscount());
        return getPriceWithDiscountAndFidelity(price, discountValue, fidelityDiscount);
    }
    

    public float computePriceWithDiscount(ProductType productType, float price, int accountAge) throws InvalidPriceException, InvalidAgeException {
        if(price <=0){
            throw  new InvalidPriceException();
        }
        if(accountAge <0){
            throw  new InvalidAgeException();
        }

        float fidelityDiscount 
        = productType == ProductType.NEW? 0: mkService.getFidelityDiscount(accountAge);
        return getFinalPrice(price, fidelityDiscount, productType);

    }
}