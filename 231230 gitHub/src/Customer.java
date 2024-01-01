
public class Customer extends Person {
	
	public int roomUnit;
	private String reservationState;
	
	public Customer(String name, String number, int roomUnit, String reservationState) {
		super(name, number);
		this.roomUnit = roomUnit;
		this.reservationState = reservationState;
	}
	
	

	public Customer(String name, String number, String reservationState) {
		super(name, number);
		this.reservationState = reservationState;
	}



	public int getRoomUnit() {
		return roomUnit;
	}

	public void setRoomUnit(int roomUnit) {
		this.roomUnit = roomUnit;
	}

	public String getReservationState() {
		return reservationState;
	}

	public void setReservationState(String reservationState) {
		this.reservationState = reservationState;
	}
	

	
}
