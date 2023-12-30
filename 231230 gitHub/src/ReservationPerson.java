
public class ReservationPerson {
	private String name; //고객이름
	private String phoneNumber; //고객 전화번호
	private String date;
	private String checkInTime;
	private String workInTime;
	private String checkOutTime;
//	private String roomType;
	public int roomUnit;
	private String reservationState; // 숨어있던게 있었네요...!!
	public int getRoomUnit() {
		return RoomUnit;
	}

	public void setRoomUnit(int roomUnit) {
		RoomUnit = roomUnit;
	}
	private int RoomUnit;
	
	public ReservationPerson(String name, String phoneNumber, String date, String checkInTime, String workInTime,
			String checkOutTime) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.date = date;
		this.checkInTime = checkInTime;
		this.workInTime = workInTime;
		this.checkOutTime = checkOutTime;
	}
	
	public ReservationPerson(String name, String phoneNumber, String reservationState) {
		this.name = name;
		this.phoneNumber = phoneNumber;

		this.reservationState = reservationState;
	}
	
//	public ReservationPerson(String name, String phoneNumber, int roomType, String reservationState) {
//		this.name = name;
//		this.phoneNumber = phoneNumber;
//		this.roomType = roomType;
//		this.reservationState = reservationState;
//	}
	
	public String getReservationState() {
		return reservationState;
	}

	public void setReservationState(String reservationState) {
		this.reservationState = reservationState;
	}

//	public String getRoomType() {
//		return roomType;
//	}
//
//	public void setRoomType(String roomType) {
//		this.roomType = roomType;
//	}

	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getDate() {
		return date;
	}
	public String getCheckInTime() {
		return checkInTime;
	}
	public String getWorkInTime() {
		return workInTime;
	}
	public String getCheckOutTime() {
		return checkOutTime;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	public void setWorkInTime(String workInTime) {
		this.workInTime = workInTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
}
