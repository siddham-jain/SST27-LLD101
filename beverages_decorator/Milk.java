package beverages_decorator;

public class Milk extends BeverageDecorator {

	public Milk(Beverage beverage) {
		super(beverage);
	}

	@Override
	public int cost() {
		return beverage.cost() + 3;
	}
}


