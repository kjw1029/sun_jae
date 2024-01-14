
public class Customer extends Person{
	private int unit;
	
	public Customer(String name, String number) {
		super(name, number);
	}
		
	public Customer(String name, String number, int unit) {
		super(name, number);
		this.unit = unit;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}
	
	

}
