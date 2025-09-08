package beverages_decorator;

public class Sugar extends BeverageDecorator {

	public Sugar(Beverage beverage) {
		super(beverage);
	}

	@Override
	public int cost() {
		return beverage.cost() + 2;
	}
}


