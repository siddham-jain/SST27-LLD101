package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		Beverage cappuccino = new Cappuccino();
		System.out.println("Plain Cappuccino cost: " + cappuccino.cost());
		Beverage cappuccinoWithMilk = new Milk(cappuccino);
		System.out.println("Cappuccino + Milk cost: " + cappuccinoWithMilk.cost());
		Beverage cappuccinoWithMilkAndSugar = new Sugar(cappuccinoWithMilk);
		System.out.println("Cappuccino + Milk + Sugar cost: " + cappuccinoWithMilkAndSugar.cost());
		Beverage latte = new Latte();
		Beverage customLatte = new Sugar(new Milk(latte));
		System.out.println("Latte + Milk + Sugar cost: " + customLatte.cost());
	}

}