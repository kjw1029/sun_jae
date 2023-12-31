
public class Customer extends Person {
	
	public int roomUnit;
	private String reservationState;
	
	public Customer(String name, String number, int roomUnit, String reservationState) {
		super(name, number);
		this.roomUnit = roomUnit;
		this.reservationState = reservationState;
	}

	
}
