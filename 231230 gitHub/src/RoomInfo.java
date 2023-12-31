// 수정중이라서.. 팔다리가 없어요
public class RoomInfo {
	private int unit; // 방호수
	private String roomStatus; // 체크인, 체크아웃, 워크인, 예약, 숙박, 예약완료
	private boolean isClean; // 청소유무 체크
	private Person person;

	public RoomInfo(int unit, String roomStatus, boolean isClean, Person person) {
		super();
		this.unit = unit;
		this.roomStatus = roomStatus;
		this.isClean = isClean;
		this.person = person;
	}

	public boolean getCleanFlag() {
		return isClean;
	}

	public void setClean(boolean isClean) {
		this.isClean = isClean;
	}

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
	}
}