package gslc;

public class MilkTea extends Drinks implements Special{
	private String topping;

	public MilkTea(int num, String name, String type, String topping) {
		super(num, name, type);
		this.topping = topping;
	}
	
	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	@Override
	public int genPrice() {
		int temp=0;
		if(this.topping.equals("Bubble")) {
			temp=33000;
		}else if(this.topping.equals("Pudding")) {
			temp=30000;
		}
		return temp;
	}

	@Override
	public void announce() {
		System.out.println("Congratuliations!! You have purchase a milk tea menu, you are qualified to get a 5% discount from your order");
	}
	@Override
	public double disc() {
		double disc;
		disc=0.05;
		return disc;
	}
}
