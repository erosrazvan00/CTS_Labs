package ro.ase.csie.cts.g1094.refactor.phase3;

import ro.ase.csie.cts.g1094.refactor.exceptions.InvalidAgeException;
import ro.ase.csie.cts.g1094.refactor.exceptions.InvalidPriceException;
import ro.ase.csie.cts.g1094.refactor.phase3.test.TestProduct;
import ro.ase.csie.cts.g1094.refactor.phase3.test.services.MaketingServiceInterface;
import ro.ase.csie.cts.g1094.refactor.phase3.test.services.ValidatorServiceInterface;

public class Product {
	
	MaketingServiceInterface mkService = null;
	ValidatorServiceInterface validator = null;
	
	public Product(MaketingServiceInterface mkService,
			ValidatorServiceInterface validator) {
		
		  //if(mkService == null) { throw new NullPointerException(); } this.mkService = mkService;
		
		this.setMarketingService(mkService);
		this.validator = validator;
	}
	
	//version 4 - use the global service collection
		public Product() {
			//dependency injection based on the global services collection
			for(Object service : TestProduct.services) {
				if(service instanceof MaketingServiceInterface) {
					this.setMarketingService((MaketingServiceInterface)service);
				}
				if(service instanceof ValidatorServiceInterface) {
					this.validator = (ValidatorServiceInterface) service;
				}
			}
			
			if(this.mkService == null) {
				throw new UnsupportedOperationException();
			}
			if(this.validator == null) {
				throw new UnsupportedOperationException();
			}
		}
	
	//optional - set on design specs
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
       
    	validator.validatePrice(price);
    	validator.validateAge(accountAge);

        float fidelityDiscount 
        = productType == ProductType.NEW? 0: mkService.getFidelityDiscount(accountAge);
        return getFinalPrice(price, fidelityDiscount, productType);

    }
}