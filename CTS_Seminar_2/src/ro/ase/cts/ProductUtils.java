package ro.ase.cts;

public class ProductUtils {
	
	
	public static float computeFinalPrice(ProductCategory category, float price, float customerSalary) throws InvalidProductCategoryException{
		float finalPrice = 0.0f;
		float clientDiscount = computeDiscountForClientSalary(price, customerSalary);
		float productDiscount = computeDiscountForProductCategory(category, price);
		finalPrice = price - clientDiscount - productDiscount;
			
		return finalPrice;
	}
	
	
	public static float computeDiscountForProductCategory(ProductCategory category, float productPrice) throws InvalidProductCategoryException {
		float productDicount = 0.0f;
		
		switch(category) {
		case SMARTPHONE: productDicount = productPrice  * 0.03f;
			break;
		case TABLET: productDicount = productPrice * 0.05f;	
			break;
		case LAPTOP: productDicount = productPrice * 0.07f;
			break;
		case DESKTOP: productDicount = productPrice * 0.1f;
			break;
		default:
			throw new InvalidProductCategoryException("No implementation for the specific category");
		}
		return productDicount;
	}
	
	public static float computeDiscountForClientSalary(float productPrice, float customerSalary) {
		
		float clientDiscount = 0.0f;
		if( customerSalary>=2000 && customerSalary<=10000) {
			clientDiscount = productPrice*0.05f;
		} else {
			clientDiscount = productPrice*0.02f;
		}
			
		return clientDiscount;
	}
}
