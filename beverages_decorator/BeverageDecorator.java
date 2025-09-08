package beverages_decorator;

public abstract class BeverageDecorator extends Beverage {
	protected final Beverage beverage;

	public BeverageDecorator(Beverage beverage) {
		this.beverage = beverage;
	}
}


