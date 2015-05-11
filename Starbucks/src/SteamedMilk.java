
public class SteamedMilk extends CondimentDecorator {

	Beverage base;
	
	public SteamedMilk(Beverage b) {
		base = b;
	}
	
	@Override
	public String getDescription() {
		return base.getDescription() +
				" + ����� ������ũ";
	}

	@Override
	public int cost() {
		return base.cost() + 500;
	}
	
}
