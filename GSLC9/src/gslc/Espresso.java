package gslc;

public class Espresso extends Drinks {
	private int shots;

	public Espresso(int num, String name, String type, int shots) {
		super(num, name, type);
		this.shots = shots;
	}

	public int getShots() {
		return shots;
	}

	public void setShots(int shots) {
		this.shots = shots;
	}

	@Override
	public int genPrice() {
		int temp=0;
		if(this.shots==1) {
			temp=20000;
		}else if(this.shots==2){
			temp=25000;
		}else if(this.shots==3) {
			temp=30000;
		}
		return temp;
	}
}
