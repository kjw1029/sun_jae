public class ReservationPerson {
	private String name; // 고객이름
	private String phoneNumber; // 고객 전화번호
	public int roomUnit;
	private String reservationState;

	public int getRoomUnit() {
		return RoomUnit;
	}

	public void setRoomUnit(int roomUnit) {
		RoomUnit = roomUnit;
	}

	private int RoomUnit;

	public ReservationPerson(String name, String phoneNumber, String reservationState) {
		this.name = name;
		this.phoneNumber = phoneNumber;

		this.reservationState = reservationState;
	}

	public String getReservationState() {
		return reservationState;
	}

	public void setReservationState(String reservationState) {
		this.reservationState = reservationState;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
