package gslc;

public abstract class Drinks {
	private int num;
	private String name;
	private String type;
	public Drinks(int num, String name, String type) {
		super();
		this.num = num;
		this.name = name;
		this.type = type;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public abstract int genPrice();

	
}
