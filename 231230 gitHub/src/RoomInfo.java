
public class RoomInfo {
	private int unit; // 방호수
	private int price; // 방가격
	private String roomStatus; // 체크인, 체크아웃, 워크인, 예약, 숙박, 예약완료
	private boolean isClean; // 청소유무 체크

	public RoomInfo(int unit, int price,  String roomStatus, boolean isClean) {
		super();
		this.unit = unit;
		this.price = price;
		this.roomStatus = roomStatus;
		this.isClean = isClean;
	}

	public static RoomInfo[][] totalRoom() {
		RoomInfo[][] roomInfo = new RoomInfo[4][20];
		for (int i = 0; i < roomInfo.length; i++) {
			for (int j = 0; j < roomInfo[i].length; j++) {
				if (j % 2 == 0) {
					SingleRoom singleRoom = new SingleRoom(((i + 2) * 100) + (j + 1), 80000, "빈방", true);
					roomInfo[i][j] = singleRoom;
				} else if (j % 2 != 0) {
					DoubleRoom doubleRoom = new DoubleRoom(((i + 2) * 100) + (j + 1), 50000, "빈방", true);
					roomInfo[i][j] = doubleRoom;
				}
			}
		}
		return roomInfo;
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