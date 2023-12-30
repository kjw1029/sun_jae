
import java.util.Scanner;

public class ReservationStatus {
	private int reservatedRoom;
	private int stayingRoom;
	private int emptyRoom;
	private boolean bool;// 청소완료
	
	public static void printReservationStatus() {
//		int reservatedRoom =1;
//		int stayingRoom = 2;
//		int emptyRoom = 3;
//		System.out.println("예약현황");
//		int[][] RF = new int[20][4];
//		for (int i = 0; i < RF.length; i++) {
//			for (int j = 0; j < RF[i].length; j++) {
//					System.out.printf("%d%02d  ", j + 2, i +1);
//					
//			}
//			System.out.println();
//		}
	}
	
	public ReservationStatus(int reservatedRoom, int stayingRoom, int emptyRoom) {
		super();
		this.reservatedRoom = reservatedRoom;
		this.stayingRoom = stayingRoom;
		this.emptyRoom = emptyRoom;
	}
	public int getReservatedRoom() {
		return reservatedRoom;
	}
	public int getStayingRoom() {
		return stayingRoom;
	}
	public int getEmptyRoom() {
		return emptyRoom;
	}
	public void setReservatedRoom(int reservatedRoom) {
		this.reservatedRoom = reservatedRoom;
	}
	public void setStayingRoom(int stayingRoom) {
		this.stayingRoom = stayingRoom;
	}
	public void setEmptyRoom(int emptyRoom) {
		this.emptyRoom = emptyRoom;
	}

}
