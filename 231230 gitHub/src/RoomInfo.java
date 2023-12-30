
public class RoomInfo {
	private int unit; // 방호수
	private int amount; // 금액
	private String roomType; // 싱글 더블
	private boolean lostItem; // 분실물?
	private String reservationStatus; // 빈방, 예약완료, 숙박중
	private String roomStatus; // 체크인, 체크아웃, 워크인
	private boolean isClean; // 청소유무 체크 김종희

	public RoomInfo() {
	}
	public RoomInfo(int unit, int amount, String roomType, String reservationStatus, String roomStatus, boolean isClean) {
		this.unit = unit;
		this.amount = amount;
		this.roomType = roomType;
		this.reservationStatus = reservationStatus;
		this.roomStatus = roomStatus;
		this.isClean = isClean; // 김종희
	}

	public RoomInfo(String reservationStatus, String roomStatus, boolean lostItem) {
		this.reservationStatus = reservationStatus;
		this.roomStatus = roomStatus;
		this.lostItem = lostItem;
	}

	public int getUnit() {
		return unit;
	}

	public int getAmount() {
		return amount;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


	 // 김종희 START
	public boolean getCleanFlag() {
		return isClean;
	}
	public void setClean(boolean isClean) {
		this.isClean = isClean;
	}
	 // 김종희 END
	public static RoomInfo[][] totalRoom() {
		RoomInfo[][] RF = new RoomInfo[4][20];
		for (int i = 0; i < RF.length; i++) {
			for (int j = 0; j < RF[i].length; j++) {
				if (j % 2 == 0) {
					RoomInfo fac = new RoomInfo(((i + 2) * 100) + (j + 1), 80000, "싱글", "빈방", "체크아웃", true);
					RF[i][j] = fac;
				} else if (j % 2 != 0) {
					RoomInfo fac = new RoomInfo(((i + 2) * 100) + (j + 1), 50000, "더블", "빈방", "체크아웃", true);
					RF[i][j] = fac;
				}
			}
		}
//		RoomInfo[][] RF = new RoomInfo[20][4];
//		for (int i = 0; i < 20; i++) {
//			for (int j = 0; j < 4; j++) {
//				if (i % 2 == 0) {
//					RoomInfo fac = new RoomInfo(((j + 2) * 100) + (i + 1), 80000, "싱글", "빈방", "체크아웃");
//					RF[i][j] = fac;
////					System.out.print(RF[i][j].getUnit() + "호");
////					System.out.print("  ");
////					System.out.print("[" + RF[i][j].getReservationStatus() + "]");
////					System.out.print(" ");
////					System.out.print(RF[i][j].getAmount() + "원 ");
////					System.out.print("  ");
//				} else if (i % 2 != 0) {
//					RoomInfo fac = new RoomInfo(((j + 2) * 100) + (i + 1), 50000, "더블", "빈방", "체크아웃");
//					RF[i][j] = fac;
////					System.out.print(RF[i][j].getUnit() + "호");
////					System.out.print("  ");
////					System.out.print("[" + RF[i][j].getReservationStatus() + "]");
////					System.out.print(" ");
////					System.out.print(RF[i][j].getAmount() + "원 ");
//
////					System.out.print("  ");
//
//				}
//
//			}
////			System.out.println();
//		}

		return RF;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

}
