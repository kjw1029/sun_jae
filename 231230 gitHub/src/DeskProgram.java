import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DeskProgram {
	public static Room[][] room = Room.totalRoom();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Desk desk = new Desk();

		while (true) {
			System.out.println();
//		    System.out.println("------------------------------------------------------------*------------------------------------------------------------");
			System.out.println("---------------------------- 메뉴 ----------------------------");// 59
			System.out.println("1. 예약");
			System.out.println("2. 고객 상태 확인");
			System.out.println("3. 예약변경");
			System.out.println("4. 워크인/체크인/체크아웃");
			System.out.println("5. 로그아웃");

			int input = scan.nextInt();
			switch (input) {
			case 1:
				System.out.print("고객명: ");
				String guestName = scan.next();
				System.out.print("연락처: ");
				String phoneNumber = scan.next();
				System.out.print("방 타입[싱글/더블]: ");
				String roomType = scan.next();
				// 싱글 더블, 빈방 출력
				desk.emptyRoomPrint(roomType);

				System.out.println("호실 입력");
				int unit = scan.nextInt();
				
				if (roomType.equals("싱글")) {
					for (int i = 0; i < room.length; i++) {
						for (int j = 0; j < room[i].length; j++) {
							if (unit == room[i][j].getUnit() && room[i][j].getRoomtype().endsWith("싱글")) {
								Customer cus = new Customer(guestName, phoneNumber);
								desk.reservation(room[i][j], cus);
								break;
							}else {
								System.out.println("룸타입과 호수가 일치하지않습니다.");
								break;
							}

						}

					}
				}
			}
		}
	}
}
