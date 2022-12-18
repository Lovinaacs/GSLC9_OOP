package gslc;

public class Latte extends Drinks{
	private String milk;

	public Latte(int num, String name, String type, String milk) {
		super(num, name, type);
		this.milk = milk;
	}

	public String getMilk() {
		return milk;
	}

	public void setMilk(String milk) {
		this.milk = milk;
	}

	@Override
	public int genPrice() {
		int temp=0;
		if(this.milk.equals("Normal")) {
			temp=23000;
		}else if(this.milk.equals("Almond")) {
			temp=33000;
		}else if(this.milk.equals("Oats")) {
			temp=27000;
		}
		return temp;
	}
}
