package gslc;

public class SweetTea extends Drinks{
	private String sugar;

	public SweetTea(int num, String name, String type, String sugar) {
		super(num, name, type);
		this.sugar = sugar;
	}

	public String getSugar() {
		return sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	@Override
	public int genPrice() {
		int temp=0;
		if(this.sugar.equals("Normal")) {
			temp=17000;
		}else if(this.sugar.equals("Less")) {
			temp=16500;
		}else if(this.sugar.equals("Half")) {
			temp=16000;
		}
		return temp;
	}
	
}
