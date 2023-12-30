
public class Reservation {
	private String name;
	private String phonenum;
	private String roomType;
	private String reservation;
	
	public Reservation(String name, String phonenum, String roomType, String reservation) {
		super();
		this.name = name;
		this.phonenum = phonenum;
		this.roomType = roomType;
		this.reservation = reservation;
	}

	public String getName() {
		return name;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public String getRoomType() {
		return roomType;
	}

	public String getReservation() {
		return reservation;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setReservation(String reservation) {
		this.reservation = reservation;
	}
	
	
	
	
}
