
public class SteamedMilk extends CondimentDecorator {

	Beverage base;
	
	public SteamedMilk(Beverage b) {
		base = b;
	}
	
	@Override
	public String getDescription() {
		return base.getDescription() +
				" + 고소한 스팀밀크";
	}

	@Override
	public int cost() {
		return base.cost() + 500;
	}
	
}
