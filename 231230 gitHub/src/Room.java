
public class Room {
	private int unit; // 방호수
	private int price; // 방가격
	private String roomtype; // 싱글, 더블
	private String roomStatus; // 체크인, 체크아웃, 워크인, 예약, 숙박, 예약완료
	private boolean isClean; // 청소유무 체크
	
	public Room (int unit, int price, String roomtype, String roomStatus, boolean isClean) {
		super();
		this.unit = unit;
		this.price = price;
		this.roomtype = roomtype;
		this.roomStatus = roomStatus;
		this.isClean = isClean;
	}
	
	public static Room[][] totalRoom() {
		Room[][] Room = new Room[4][20];
		for (int i = 0; i < Room.length; i++) {
			for (int j = 0; j < Room[i].length; j++) {
				if (j % 2 == 0) {
					Room[i][j] = new Room(((i + 2) * 100) + (j + 1), 80000, "싱글", "빈방", true);
				} else if (j % 2 != 0) {
					Room[i][j] = new Room(((i + 2) * 100) + (j + 1), 50000, "더블", "빈방", true);
					
				}
			}
		}
		return Room;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public boolean isClean() {
		return isClean;
	}

	public void setClean(boolean isClean) {
		this.isClean = isClean;
	}
	
	
}