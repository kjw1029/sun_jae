import java.util.Scanner;

public class Desk extends Employee {
	public static int roomCount = 80;
	public static ReservationPerson[] reservationList = new ReservationPerson[roomCount];
	public static RoomInfo[][] RF = RoomInfo.totalRoom();
	public static int totalAmount[] = new int[4];
	int inputUnit;
	int floor;
	int unit;
	int index;

	public Desk(String name, String number) {
		super(name, number);
	}

	@Override
	public void LoginStart() {
		System.out.println("1.예약관리 2.출퇴근 인증 3.로그아웃 ");
	}
	
	
	

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub
		super.printMenu();
		System.out.println();
		System.out.println("---------------------------- 메뉴 ----------------------------");// 59
		System.out.println("1. 예약");
		System.out.println("2. 고객 상태 확인");
		System.out.println("3. 예약변경");
		System.out.println("4. 워크인/체크인/체크아웃");
		System.out.println("5. 로그아웃");
	}

	// 청소부 유무 체크하는 변수 추가
	public int[] hotel(boolean isCleaner) {

		Scanner scan = new Scanner(System.in);
		int index = 0;
		boolean go = true;
		// 청소부 로그인일 때
		if (isCleaner) {
			try {
				System.out.println("1.청소 필요방 조회 2.나가기");
				int workInfoChk = scan.nextInt();

				if (workInfoChk == 2) {
					return totalAmount;
				} else if (workInfoChk != 1) {
					throw new Exception();
				}
				System.out.println("------------------------ 현재 청소가 필요한 방 ------------------------");
				for (int i = 0; i < RF.length; i++) {
					System.out.print(i + 2 + "층: ");
					for (int j = 0; j < RF[i].length; j++) {
						if (RF != null && RF[i][j].isClean() == false) {
							System.out.print(RF[i][j].getUnit() + "호");
							System.out.print("[" + RF[i][j].getRoomtype() + "] ");
							System.out.print("\t");
						}
					}
					System.out.println();
				}
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------------");
				System.out.println("청소할 호실을 입력하세요[000]");
				System.out.println("돌아가려면 아무거나 입력하세요");
				int cInputUnit = scan.nextInt();
				int cFloor = cInputUnit / 100;
				int cUnit = cInputUnit % 100;
				if (RF[cFloor - 2][cUnit - 1].isClean() == true) {
					System.out.println("현재 사용중인 방 혹은 청소가 불필요한 방입니다.");
					throw new Exception();

				} else if ("".equals(RF[cFloor - 2][cUnit - 1].getRoomStatus())
						|| RF[cFloor - 2][cUnit - 1].getRoomStatus().isEmpty()) {
					System.out.println("현재 입력하신 번호는 잘못된 방 번호입니다.\n다시 입력해 주시길 바랍니다.");
					throw new Exception();
				}
				System.out.println("해당 방의 청소를 완료 처리하시겠습니까?(1.네/2.아니오)");
				int chk = scan.nextInt();
				if (chk == 2) {
					System.out.println("메뉴 처음으로 돌아갑니다.");
					hotel(true);
				} else if (chk != 1 && chk != 2) {
					throw new Exception();
				}

				RF[cFloor - 2][cUnit - 1].setClean(true);
				System.out.println("청소 완료 정상 처리되었습니다.");
				hotel(true);

			} catch (Exception e) {
				System.out.println("올바른 값을 지정해 주시길 바랍니다.\n메뉴 처음으로 돌아갑니다.");
				return totalAmount;
			}

			return totalAmount;

		}
	
		// 데스크 전체적인 메뉴
		while (go) {
			printMenu();
//			System.out.println();
//			System.out.println("---------------------------- 메뉴 ----------------------------");// 59
//			System.out.println("1. 예약");
//			System.out.println("2. 고객 상태 확인");
//			System.out.println("3. 예약변경");
//			System.out.println("4. 워크인/체크인/체크아웃");
//			System.out.println("5. 로그아웃");
			// 예약
			int input = scan.nextInt();
			switch (input) {
			case 1:
				System.out.println();
				System.out.println("1. 예약");
				System.out.print("고객명: ");
				String guestName = scan.next();
				System.out.print("연락처: ");
				String phoneNumber = scan.next();
				System.out.print("방 타입[싱글/더블]: ");

				reservationList[index] = new ReservationPerson(guestName, phoneNumber, "예약");

				String roomType = scan.next();
				// 싱글방 출력
				if (roomType.equals("싱글")) {
					System.out.println("------------------------ 현재 비어있는 방 ------------------------");
					for (int i = 0; i < RF.length; i++) {
						System.out.print(i + 2 + "층: ");
						for (int j = 0; j < RF[i].length; j++) {
							if (RF != null && RF[i][j].getRoomStatus().equals("빈방")
									&& RF[i][j].getRoomtype().equals("싱글")) {
								System.out.print(RF[i][j].getUnit() + "호");
								System.out.print("[" + RF[i][j].getRoomtype() + "] ");
								System.out.print("\t");
							}
						}
						System.out.println();
					}
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------");
					// 호실예약 입력
					System.out.println("예약할 호실을 입력하세요[000]");
					int inputUnit = scan.nextInt();
					int floor = inputUnit / 100;
					int unit = inputUnit % 100;
					// 청소가 안되어있을시
					if (!RF[floor - 2][unit - 1].isClean() && !RF[floor - 2][unit - 1].getRoomStatus().isEmpty()
							&& !"".equals(RF[floor - 2][unit - 1].getRoomStatus())) {
						System.out.println("아직 청소가 완료되지 않은 객실입니다.\n다른 객실로 예약하시길 바랍니다.");
						break;
					}
					// 범위 입력
					if (inputUnit > 520 || inputUnit < 201) {
						System.out.println("올바른 호실을 입력하세요.");
						break;
					} else if (inputUnit > 420 && inputUnit < 501) {
						System.out.println("올바른 호실을 입력하세요.");
						break;
					} else if (inputUnit > 320 && inputUnit < 401) {
						System.out.println("올바른 호실을 입력하세요.");
						break;
					} else if (inputUnit > 220 && inputUnit < 301) {
						System.out.println("올바른 호실을 입력하세요.");
						break;
					} else if (inputUnit % 2 == 0) {
						System.out.println("올바른 호실을 입력하세요.");
						break;
					} else if (RF[floor - 2][unit - 1].getRoomStatus().equals("예약완료")) {
						System.out.println("잘못된 입력입니다.");
						break;
					} else if (RF[floor - 2][unit - 1].getRoomStatus().equals("숙박중")) {
						System.out.println("잘못된 입력입니다.");
						break;
					} else {
						RF[floor - 2][unit - 1].setRoomStatus("예약완료");
						System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
						reservationList[index].setRoomUnit((floor * 100) + unit);
						index++;
						break;
					}
//					 더블 출력
				} else if (roomType.equals("더블")) {
					System.out.println("------------------------ 현재 비어있는 방 ------------------------");
					for (int i = 0; i < RF.length; i++) {
						System.out.print(i + 2 + "층: ");
						for (int j = 0; j < RF[i].length; j++) {
							if (RF != null && RF[i][j].getRoomStatus().equals("빈방")
									&& RF[i][j].getRoomtype().equals("더블")) {
								System.out.print(RF[i][j].getUnit() + "호");
								System.out.print("[" + RF[i][j].getRoomtype() + "] ");
								System.out.print("\t");
							}
						}
						System.out.println();
					}
					System.out.println(
							"-------------------------------------------------------------------------------------------------------------------------");
					// 호실 입력
					System.out.println("예약할 호실을 입력하세요[000]");
					int inputUnit = scan.nextInt();
					int floor = inputUnit / 100;
					int unit = inputUnit % 100;
					if (inputUnit > 520 || inputUnit < 201) {
						System.out.println("올바른 호실을 입력하세요.");
						break;
					} else if (inputUnit > 420 && inputUnit < 501) {
						System.out.println("올바른 호실을 입력하세요.");
						break;
					} else if (inputUnit > 320 && inputUnit < 401) {
						System.out.println("올바른 호실을 입력하세요.");
						break;
					} else if (inputUnit > 220 && inputUnit < 301) {
						System.out.println("올바른 호실을 입력하세요.");
						break;
					} else if (inputUnit % 2 != 0) {
						System.out.println("올바른 호실을 입력하세요.");
						break;
					} else if (RF[floor - 2][unit - 1].getRoomStatus().equals("예약완료")) {
						System.out.println("잘못된 입력입니다.");
						break;
					} else if (RF[floor - 2][unit - 1].getRoomStatus().equals("숙박중")) {
						System.out.println("잘못된 입력입니다.");
						break;
					} else {
						RF[floor - 2][unit - 1].setRoomStatus("예약완료");
						System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
						reservationList[index].setRoomUnit((floor * 100) + unit);
						index++;
						break;
					}

				} else {
					System.out.println("잘못된 입력입니다.");
					break;
				}

			case 2:
				// 예약확인
				System.out.println();
				System.out.println("2. 고객 상태 확인");
				System.out.print("고객명: ");
				String reservationName = scan.next();
				System.out.print("연락처: ");
				String reservationPhoneNumber = scan.next();

				for (int i = 0; i < reservationList.length; i++) {
					if (reservationList[i] != null && reservationList[i].getName().equals(reservationName)
							&& reservationList[i].getPhoneNumber().equals(reservationPhoneNumber)
							&& reservationList[i].getReservationState().equals("예약")) {
						System.out.println("-------------------------- 예약 확인 --------------------------");
						System.out.println("고객명: " + reservationList[i].getName());
						System.out.println("연락처: " + reservationList[i].getPhoneNumber());
						System.out.print(reservationList[i].getRoomUnit() + "호");
						System.out.println("["
								+ RF[reservationList[i].getRoomUnit() / 100 - 2][reservationList[i].getRoomUnit() % 100
										- 1].getRoomtype()
								+ "]");
						System.out.println(
								RF[reservationList[i].getRoomUnit() / 100 - 2][reservationList[i].getRoomUnit() % 100
										- 1].getPrice() + "원");

						// 중복 예약 불가 개선
						// 고객 상태 확인
						if (RF[reservationList[i].getRoomUnit() / 100 - 2][reservationList[i].getRoomUnit() % 100 - 1]
								.getRoomStatus().equals("체크아웃")
								&& RF[reservationList[i].getRoomUnit() / 100 - 2][reservationList[i].getRoomUnit() % 100
										- 1].getRoomStatus().equals("예약완료")) {
							System.out.println("예약완료");
						} else {
							System.out.println(RF[reservationList[i].getRoomUnit() / 100
									- 2][reservationList[i].getRoomUnit() % 100 - 1].getRoomStatus() + " 완료");
						}
					}
				}

				for (int i = 0; i < reservationList.length; i++) {
					if (reservationList[i] != null && reservationList[i].getName().equals(reservationName)
							&& reservationList[i].getPhoneNumber().equals(reservationPhoneNumber)) {
						break;
					} else if (reservationList[i] != null && reservationList[i].getName().equals(reservationName)) {

					} else if (reservationList[i] != null
							&& reservationList[i].getPhoneNumber().equals(reservationPhoneNumber)) {
					} else {/*
							 * if (reservationList[i] == null ||
							 * !reservationList[i].getName().equals(reservationName) ||
							 * !reservationList[i].getPhoneNumber().equals(reservationPhoneNumber) ||
							 * !reservationList[i].getReservationState().equals("예약") ||
							 * reservationList[i].getReservationState().equals("숙박중")) {
							 */
						System.out.println("예약자 정보를 찾을 수 없습니다.");
						break;
					}
				}
				break;

			case 3:
				// 예약 변경(취소)
				System.out.println("3. 예약변경");
				System.out.print("고객명: ");
				reservationName = scan.next();
				System.out.print("연락처: ");
				reservationPhoneNumber = scan.next();

				for (int i = 0; i < reservationList.length; i++) {
					if (reservationList[i] != null && reservationList[i].getName().equals(reservationName)
							&& reservationList[i].getPhoneNumber().equals(reservationPhoneNumber)) {
						int floor = reservationList[i].getRoomUnit() / 100;
						int unit = reservationList[i].getRoomUnit() % 100;
						RF[floor - 2][unit - 1].setRoomStatus("빈방");
						RF[floor - 2][unit - 1].setClean(true);
						reservationList[i] = null;
					}
				}
				System.out.println("취소되었습니다.");
				break;

			case 4:
				System.out.println("1. 워크인 2. 체크인 3. 체크아웃");
				input = scan.nextInt();
				switch (input) {
				case 1:
					// 워크인
					System.out.print("고객명: ");
					guestName = scan.next();
					System.out.print("연락처: ");
					phoneNumber = scan.next();
					System.out.print("방 타입[싱글/더블]: ");

					reservationList[index] = new ReservationPerson(guestName, phoneNumber, "예약");

					roomType = scan.next();
					if (roomType.equals("싱글")) {
						System.out.println("------------------------ 현재 비어있는 방 ------------------------");
						for (int i = 0; i < RF.length; i++) {
							System.out.print(i + 2 + "층: ");
							for (int j = 0; j < RF[i].length; j++) {
								if (RF != null && RF[i][j].getRoomStatus().equals("빈방")
										&& RF[i][j].getRoomtype().equals("싱글")) {
									System.out.print(RF[i][j].getUnit() + "호");
									System.out.print("[" + RF[i][j].getRoomtype() + "] ");
									System.out.print("\t");
								}
							}
							System.out.println();
						}
						System.out.println(
								"-------------------------------------------------------------------------------------------------------------------------");
						System.out.println("숙박할 호실을 입력하세요[000]");
						int inputUnit = scan.nextInt();
						int floor = inputUnit / 100;
						int unit = inputUnit % 100;
						if (inputUnit > 520 || inputUnit < 201) {
							System.out.println("올바른 호실을 입력하세요.");
							break;
						} else if (inputUnit > 420 && inputUnit < 501) {
							System.out.println("올바른 호실을 입력하세요.");
							break;
						} else if (inputUnit > 320 && inputUnit < 401) {
							System.out.println("올바른 호실을 입력하세요.");
							break;
						} else if (inputUnit > 220 && inputUnit < 301) {
							System.out.println("올바른 호실을 입력하세요.");
							break;
						} else if (inputUnit % 2 == 0) {
							System.out.println("올바른 호실을 입력하세요.");
							break;

							// 이미 예약된 방에 중복 예약 가능
						} else if (RF[floor - 2][unit - 1].getRoomStatus().equals("예약완료")) {
							System.out.println("잘못된 입력입니다.");
							break;
						} else if (RF[floor - 2][unit - 1].getRoomStatus().equals("숙박중")) {
							System.out.println("잘못된 입력입니다.");
							break;
						} else {
							RF[floor - 2][unit - 1].setRoomStatus("숙박중");
							RF[floor - 2][unit - 1].setRoomStatus("워크인");
							System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
							System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
							reservationList[index].setRoomUnit((floor * 100) + unit);
							index++;
							break;
						}

					} else if (roomType.equals("더블")) {
						System.out.println("------------------------ 현재 비어있는 방 ------------------------");
						for (int i = 0; i < RF.length; i++) {
							System.out.print(i + 2 + "층: ");
							for (int j = 0; j < RF[i].length; j++) {
								if (RF != null && RF[i][j].getRoomStatus().equals("빈방")
										&& RF[i][j].getRoomtype().equals("더블")) {
									System.out.print(RF[i][j].getUnit() + "호");
									System.out.print("[" + RF[i][j].getRoomtype() + "] ");
									System.out.print("\t");
								}
							}
							System.out.println();
						}
						System.out.println(
								"-------------------------------------------------------------------------------------------------------------------------");
						System.out.println("숙박할 호실을 입력하세요[000]");
						int inputUnit = scan.nextInt();
						int floor = inputUnit / 100;
						int unit = inputUnit % 100;
						if (inputUnit > 520 || inputUnit < 201) {
							System.out.println("올바른 호실을 입력하세요.");
							break;
						} else if (inputUnit > 420 && inputUnit < 501) {
							System.out.println("올바른 호실을 입력하세요.");
							break;
						} else if (inputUnit > 320 && inputUnit < 401) {
							System.out.println("올바른 호실을 입력하세요.");
							break;
						} else if (inputUnit > 220 && inputUnit < 301) {
							System.out.println("올바른 호실을 입력하세요.");
							break;
						} else if (inputUnit % 2 != 0) {
							System.out.println("올바른 호실을 입력하세요.");
							break;

							// 이미 예약된 방에 중복 예약 가능
						} else if (RF[floor - 2][unit - 1].getRoomStatus().equals("예약완료")) {
							System.out.println("잘못된 입력입니다.");
							break;
						} else if (RF[floor - 2][unit - 1].getRoomStatus().equals("숙박중")) {
							System.out.println("잘못된 입력입니다.");
							break;
						} else {
							RF[floor - 2][unit - 1].setRoomStatus("숙박중");
							RF[floor - 2][unit - 1].setRoomStatus("워크인");
							System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
							System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
							reservationList[index].setRoomUnit((floor * 100) + unit);
							index++;
							break;
						}

					} else {
						System.out.println("잘못된 입력입니다.");
						break;
					}

				case 2:
					// 체크인
					System.out.println();
					System.out.println("------- 체크인 --------");
					System.out.print("고객명: ");
					reservationName = scan.next();
					System.out.print("연락처: ");
					reservationPhoneNumber = scan.next();

					int checkIncheck = 0;
					for (int i = 0; i < reservationList.length; i++) {
						if (reservationList[i] != null && reservationList[i].getName().equals(reservationName)
								&& reservationList[i].getPhoneNumber().equals(reservationPhoneNumber)
								&& RF[reservationList[i].getRoomUnit() / 100 - 2][reservationList[i].getRoomUnit() % 100
										- 1].getRoomStatus().equals("예약완료")) {
							System.out.println("-------------------------- 예약 확인 --------------------------");
							System.out.println(i + 1 + "번 고객님");
							System.out.println("고객명: " + reservationList[i].getName());
							System.out.println("연락처: " + reservationList[i].getPhoneNumber());
							System.out.print(reservationList[i].getRoomUnit() + "호");
							System.out
									.println("["
											+ RF[reservationList[i].getRoomUnit() / 100
													- 2][reservationList[i].getRoomUnit() % 100 - 1].getRoomtype()
											+ "]");
							System.out.println(RF[reservationList[i].getRoomUnit() / 100
									- 2][reservationList[i].getRoomUnit() % 100 - 1].getPrice() + "원");
							checkIncheck++;
							// 중복 예약 불가 개선
						}

					}

					if (checkIncheck >= 1) {
						System.out.println("고객번호를 입력하세요.");
						int inputCheckIn = scan.nextInt();
						if (reservationList[inputCheckIn - 1] != null) {
							int checkInRoomUnit = reservationList[inputCheckIn - 1].getRoomUnit();
							int floor = checkInRoomUnit / 100;
							int unit = checkInRoomUnit % 100;
							RF[floor - 2][unit - 1].setRoomStatus("숙박중");
							RF[floor - 2][unit - 1].setRoomStatus("체크인");
							System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
							System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
						} else {
							System.out.println("올바른 고객번호를 입력하세요.");
						}
					}
					// 예약자를 찾아서 없을시 정보없다고 출력
					for (int i = 0; i < reservationList.length; i++) {
						if (reservationList[i] != null && reservationList[i].getName().equals(reservationName)
								&& reservationList[i].getPhoneNumber().equals(reservationPhoneNumber)) {
							break;
						} else if (reservationList[i] != null && reservationList[i].getName().equals(reservationName)) {

						} else if (reservationList[i] != null
								&& reservationList[i].getPhoneNumber().equals(reservationPhoneNumber)) {

						} else {/*
								 * if (reservationList[i] == null ||
								 * !reservationList[i].getName().equals(reservationName) ||
								 * !reservationList[i].getPhoneNumber().equals(reservationPhoneNumber) ||
								 * !reservationList[i].getReservationState().equals("예약") ||
								 * reservationList[i].getReservationState().equals("숙박중")) {
								 */
							System.out.println("예약자 정보를 찾을 수 없습니다.");
							break;
						}
					}

					break;

				case 3:
					// 체크아웃
					System.out.println("체크아웃할 호실을 입력하세요[000]");
					int inputUnit = scan.nextInt();
					int floor = inputUnit / 100;
					int unit = inputUnit % 100;
					if (inputUnit > 520 || inputUnit < 201) {
						System.out.println("올바른 호실을 입력하세요.");
						break;
					} else if (inputUnit > 420 && inputUnit < 501) {
						System.out.println("올바른 호실을 입력하세요.");
						break;
					} else if (inputUnit > 320 && inputUnit < 401) {
						System.out.println("올바른 호실을 입력하세요.");
						break;
					} else if (inputUnit > 220 && inputUnit < 301) {
						System.out.println("올바른 호실을 입력하세요.");
						break;
					}

					RF[floor - 2][unit - 1].setClean(false);
					System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
					System.out.println(RF[floor - 2][unit - 1].getRoomStatus());

					if (RF[floor - 2][unit - 1].getRoomStatus().equals("체크인")
							|| RF[floor - 2][unit - 1].getRoomStatus().equals("워크인")
									&& RF[floor - 2][unit - 1].getRoomStatus().equals("숙박중")) {
						RF[floor - 2][unit - 1].setRoomStatus("체크아웃");
						RF[floor - 2][unit - 1].setClean(false);
						System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
						System.out.println(RF[floor - 2][unit - 1].getRoomStatus());

						if ("싱글".equals(RF[floor - 2][unit - 1].getRoomtype())
								&& "체크아웃".equals(RF[floor - 2][unit - 1].getRoomStatus())) {
							totalAmount[0] = totalAmount[0] + RF[floor - 2][unit - 1].getPrice();
							totalAmount[2] = totalAmount[0] / RF[floor - 2][unit - 1].getPrice();
						} else if ("더블".equals(RF[floor - 2][unit - 1].getRoomtype())
								&& "체크아웃".equals(RF[floor - 2][unit - 1].getRoomStatus())) {
							totalAmount[1] = totalAmount[1] + RF[floor - 2][unit - 1].getPrice();
							totalAmount[3] = totalAmount[1] / RF[floor - 2][unit - 1].getPrice();
						}
					} else {
						System.out.println("오류");

					}

					break;

				default:

					go = false;
					break;
				}
			case 5:

				return totalAmount;

			default:
				System.out.println("올바른 메뉴를 입력하세요.");
				break;
			}
		}
		return totalAmount;
	}
	
	
}

/*
 * public class Hotel { public static int roomCount = 80; public static
 * ReservationPerson[] reservationList = new ReservationPerson[roomCount];
 * public static RoomInfo[][] RF = RoomInfo.totalRoom(); public static int
 * totalAmount[] = new int[4];
 * 
 * // 청소부 유무 체크하는 변수 추가 public int[] hotel(boolean isCleaner) {
 * 
 * Scanner scan = new Scanner(System.in); int index = 0; boolean go = true; //
 * 청소부 로그인일 때 if (isCleaner) { try { System.out.println("1.청소 필요방 조회\n2.나가기");
 * int workInfoChk = scan.nextInt();
 * 
 * if (workInfoChk == 2) { return totalAmount; } else if (workInfoChk != 1) {
 * throw new Exception(); } System.out.
 * println("------------------------ 현재 청소가 필요한 방 ------------------------");
 * for (int i = 0; i < RF.length; i++) { System.out.print(i + 2 + "층: "); for
 * (int j = 0; j < RF[i].length; j++) { if (RF != null && RF[i][j].isClean() ==
 * false) { System.out.print(RF[i][j].getUnit() + "호"); System.out.print("[" +
 * RF[i][j].getRoomtype() + "] "); System.out.print("\t"); } }
 * System.out.println(); } System.out.println(
 * "-------------------------------------------------------------------------------------------------------------------------"
 * ); System.out.println("청소할 호실을 입력하세요[000]");
 * System.out.println("돌아가려면 아무거나 입력하세요"); int cInputUnit = scan.nextInt(); int
 * cFloor = cInputUnit / 100; int cUnit = cInputUnit % 100; if (RF[cFloor -
 * 2][cUnit - 1].isClean() == true) {
 * System.out.println("현재 사용중인 방 혹은 청소가 불필요한 방입니다."); throw new Exception();
 * 
 * } else if ("".equals(RF[cFloor - 2][cUnit - 1].getRoomStatus()) || RF[cFloor
 * - 2][cUnit - 1].getRoomStatus().isEmpty()) {
 * System.out.println("현재 입력하신 번호는 잘못된 방 번호입니다.\n다시 입력해 주시길 바랍니다."); throw new
 * Exception(); } System.out.println("해당 방의 청소를 완료 처리하시겠습니까?(1.네/2.아니오)"); int
 * chk = scan.nextInt(); if (chk == 2) { System.out.println("메뉴 처음으로 돌아갑니다.");
 * hotel(true); } else if (chk != 1 && chk != 2) { throw new Exception(); }
 * 
 * RF[cFloor - 2][cUnit - 1].setClean(true);
 * System.out.println("청소 완료 정상 처리되었습니다."); hotel(true);
 * 
 * } catch (Exception e) {
 * System.out.println("올바른 값을 지정해 주시길 바랍니다.\n메뉴 처음으로 돌아갑니다."); return
 * totalAmount; }
 * 
 * return totalAmount;
 * 
 * } // 데스크 전체적인 메뉴 while (go) { System.out.println(); System.out.
 * println("---------------------------- 메뉴 ----------------------------");// 59
 * System.out.println("1. 예약"); System.out.println("2. 고객 상태 확인");
 * System.out.println("3. 예약변경"); System.out.println("4. 워크인/체크인/체크아웃");
 * System.out.println("5. 로그아웃"); //예약 int input = scan.nextInt(); switch
 * (input) { case 1: System.out.println(); System.out.println("1. 예약");
 * System.out.print("고객명: "); String guestName = scan.next();
 * System.out.print("연락처: "); String phoneNumber = scan.next();
 * System.out.print("방 타입[싱글/더블]: ");
 * 
 * reservationList[index] = new ReservationPerson(guestName, phoneNumber, "예약");
 * 
 * String roomType = scan.next(); // 싱글방 출력 if (roomType.equals("싱글")) {
 * System.out.
 * println("------------------------ 현재 비어있는 방 ------------------------"); for
 * (int i = 0; i < RF.length; i++) { System.out.print(i + 2 + "층: "); for (int j
 * = 0; j < RF[i].length; j++) { if (RF != null &&
 * RF[i][j].getRoomStatus().equals("빈방") && RF[i][j].getRoomtype().equals("싱글"))
 * { System.out.print(RF[i][j].getUnit() + "호"); System.out.print("[" +
 * RF[i][j].getRoomtype() + "] "); System.out.print("\t"); } }
 * System.out.println(); } System.out.println(
 * "-------------------------------------------------------------------------------------------------------------------------"
 * ); // 호실예약 입력 System.out.println("예약할 호실을 입력하세요[000]"); int inputUnit =
 * scan.nextInt(); int floor = inputUnit / 100; int unit = inputUnit % 100; //
 * 청소가 안되어있을시 if (!RF[floor - 2][unit - 1].isClean() && !RF[floor - 2][unit -
 * 1].getRoomStatus().isEmpty() && !"".equals(RF[floor - 2][unit -
 * 1].getRoomStatus())) {
 * System.out.println("아직 청소가 완료되지 않은 객실입니다.\n다른 객실로 예약하시길 바랍니다."); break; } //
 * 범위 입력 if (inputUnit > 520 || inputUnit < 201) {
 * System.out.println("올바른 호실을 입력하세요."); break; } else if (inputUnit > 420 &&
 * inputUnit < 501) { System.out.println("올바른 호실을 입력하세요."); break; } else if
 * (inputUnit > 320 && inputUnit < 401) { System.out.println("올바른 호실을 입력하세요.");
 * break; } else if (inputUnit > 220 && inputUnit < 301) {
 * System.out.println("올바른 호실을 입력하세요."); break; } else if (inputUnit % 2 == 0) {
 * System.out.println("올바른 호실을 입력하세요."); break; } else if (RF[floor - 2][unit -
 * 1].getRoomStatus().equals("예약완료")) { System.out.println("잘못된 입력입니다."); break;
 * } else if (RF[floor - 2][unit - 1].getRoomStatus().equals("숙박중")) {
 * System.out.println("잘못된 입력입니다."); break; } else { RF[floor - 2][unit -
 * 1].setRoomStatus("예약완료"); System.out.println(RF[floor - 2][unit -
 * 1].getRoomStatus()); reservationList[index].setRoomUnit((floor * 100) +
 * unit); index++; break; } // 더블 출력 } else if (roomType.equals("더블")) {
 * System.out.
 * println("------------------------ 현재 비어있는 방 ------------------------"); for
 * (int i = 0; i < RF.length; i++) { System.out.print(i + 2 + "층: "); for (int j
 * = 0; j < RF[i].length; j++) { if (RF != null &&
 * RF[i][j].getRoomStatus().equals("빈방") && RF[i][j].getRoomtype().equals("더블"))
 * { System.out.print(RF[i][j].getUnit() + "호"); System.out.print("[" +
 * RF[i][j].getRoomtype() + "] "); System.out.print("\t"); } }
 * System.out.println(); } System.out.println(
 * "-------------------------------------------------------------------------------------------------------------------------"
 * ); // 호실 입력 System.out.println("예약할 호실을 입력하세요[000]"); int inputUnit =
 * scan.nextInt(); int floor = inputUnit / 100; int unit = inputUnit % 100; if
 * (inputUnit > 520 || inputUnit < 201) { System.out.println("올바른 호실을 입력하세요.");
 * break; } else if (inputUnit > 420 && inputUnit < 501) {
 * System.out.println("올바른 호실을 입력하세요."); break; } else if (inputUnit > 320 &&
 * inputUnit < 401) { System.out.println("올바른 호실을 입력하세요."); break; } else if
 * (inputUnit > 220 && inputUnit < 301) { System.out.println("올바른 호실을 입력하세요.");
 * break; } else if (inputUnit % 2 != 0) { System.out.println("올바른 호실을 입력하세요.");
 * break; } else if (RF[floor - 2][unit - 1].getRoomStatus().equals("예약완료")) {
 * System.out.println("잘못된 입력입니다."); break; } else if (RF[floor - 2][unit -
 * 1].getRoomStatus().equals("숙박중")) { System.out.println("잘못된 입력입니다."); break;
 * } else { RF[floor - 2][unit - 1].setRoomStatus("예약완료");
 * System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
 * reservationList[index].setRoomUnit((floor * 100) + unit); index++; break; }
 * 
 * } else { System.out.println("잘못된 입력입니다."); break; }
 * 
 * case 2: // 예약확인 System.out.println(); System.out.println("2. 고객 상태 확인");
 * System.out.print("고객명: "); String reservationName = scan.next();
 * System.out.print("연락처: "); String reservationPhoneNumber = scan.next();
 * 
 * for (int i = 0; i < reservationList.length; i++) { if (reservationList[i] !=
 * null && reservationList[i].getName().equals(reservationName) &&
 * reservationList[i].getPhoneNumber().equals(reservationPhoneNumber) &&
 * reservationList[i].getReservationState().equals("예약")) { System.out.
 * println("-------------------------- 예약 확인 --------------------------");
 * System.out.println("고객명: " + reservationList[i].getName());
 * System.out.println("연락처: " + reservationList[i].getPhoneNumber());
 * System.out.print(reservationList[i].getRoomUnit() + "호");
 * System.out.println("[" + RF[reservationList[i].getRoomUnit() / 100 -
 * 2][reservationList[i].getRoomUnit() % 100- 1].getRoomtype() + "]");
 * System.out.println( RF[reservationList[i].getRoomUnit() / 100 -
 * 2][reservationList[i].getRoomUnit() % 100 - 1].getPrice() + "원");
 * 
 * // 중복 예약 불가 개선 // 고객 상태 확인 if (RF[reservationList[i].getRoomUnit() / 100 -
 * 2][reservationList[i].getRoomUnit() % 100 - 1].getRoomStatus().equals("체크아웃")
 * && RF[reservationList[i].getRoomUnit() / 100 -
 * 2][reservationList[i].getRoomUnit() % 100- 1].getRoomStatus().equals("예약완료"))
 * { System.out.println("예약완료"); } else {
 * System.out.println(RF[reservationList[i].getRoomUnit() / 100 -
 * 2][reservationList[i].getRoomUnit() % 100 - 1].getRoomStatus() + " 완료"); } }
 * }
 * 
 * for (int i = 0; i < reservationList.length; i++) { if (reservationList[i] !=
 * null && reservationList[i].getName().equals(reservationName) &&
 * reservationList[i].getPhoneNumber().equals(reservationPhoneNumber)) { break;
 * } else if (reservationList[i] != null &&
 * reservationList[i].getName().equals(reservationName)) {
 * 
 * } else if (reservationList[i] != null &&
 * reservationList[i].getPhoneNumber().equals(reservationPhoneNumber)) { } else
 * {/* if (reservationList[i] == null ||
 * !reservationList[i].getName().equals(reservationName) ||
 * !reservationList[i].getPhoneNumber().equals(reservationPhoneNumber) ||
 * !reservationList[i].getReservationState().equals("예약") ||
 * reservationList[i].getReservationState().equals("숙박중")) {
 * 
 * System.out.println("예약자 정보를 찾을 수 없습니다."); break; } } break;
 * 
 * case 3: // 예약 변경(취소) System.out.println("3. 예약변경");
 * System.out.print("고객명: "); reservationName = scan.next();
 * System.out.print("연락처: "); reservationPhoneNumber = scan.next();
 * 
 * for (int i = 0; i < reservationList.length; i++) { if (reservationList[i] !=
 * null && reservationList[i].getName().equals(reservationName) &&
 * reservationList[i].getPhoneNumber().equals(reservationPhoneNumber)) { int
 * floor = reservationList[i].getRoomUnit() / 100; int unit =
 * reservationList[i].getRoomUnit() % 100; RF[floor - 2][unit -
 * 1].setRoomStatus("빈방"); RF[floor - 2][unit - 1].setClean(true);
 * reservationList[i] = null; } } System.out.println("취소되었습니다."); break;
 * 
 * case 4: System.out.println("1. 워크인 2. 체크인 3. 체크아웃"); input = scan.nextInt();
 * switch (input) { case 1: // 워크인 System.out.print("고객명: "); guestName =
 * scan.next(); System.out.print("연락처: "); phoneNumber = scan.next();
 * System.out.print("방 타입[싱글/더블]: ");
 * 
 * reservationList[index] = new ReservationPerson(guestName, phoneNumber, "예약");
 * 
 * roomType = scan.next(); if (roomType.equals("싱글")) { System.out.
 * println("------------------------ 현재 비어있는 방 ------------------------"); for
 * (int i = 0; i < RF.length; i++) { System.out.print(i + 2 + "층: "); for (int j
 * = 0; j < RF[i].length; j++) { if (RF != null &&
 * RF[i][j].getRoomStatus().equals("빈방") && RF[i][j].getRoomtype().equals("싱글"))
 * { System.out.print(RF[i][j].getUnit() + "호"); System.out.print("[" +
 * RF[i][j].getRoomtype() + "] "); System.out.print("\t"); } }
 * System.out.println(); } System.out.println(
 * "-------------------------------------------------------------------------------------------------------------------------"
 * ); System.out.println("숙박할 호실을 입력하세요[000]"); int inputUnit = scan.nextInt();
 * int floor = inputUnit / 100; int unit = inputUnit % 100; if (inputUnit > 520
 * || inputUnit < 201) { System.out.println("올바른 호실을 입력하세요."); break; } else if
 * (inputUnit > 420 && inputUnit < 501) { System.out.println("올바른 호실을 입력하세요.");
 * break; } else if (inputUnit > 320 && inputUnit < 401) {
 * System.out.println("올바른 호실을 입력하세요."); break; } else if (inputUnit > 220 &&
 * inputUnit < 301) { System.out.println("올바른 호실을 입력하세요."); break; } else if
 * (inputUnit % 2 == 0) { System.out.println("올바른 호실을 입력하세요."); break;
 * 
 * // 이미 예약된 방에 중복 예약 가능 } else if (RF[floor - 2][unit -
 * 1].getRoomStatus().equals("예약완료")) { System.out.println("잘못된 입력입니다."); break;
 * } else if (RF[floor - 2][unit - 1].getRoomStatus().equals("숙박중")) {
 * System.out.println("잘못된 입력입니다."); break; } else { RF[floor - 2][unit -
 * 1].setRoomStatus("숙박중"); RF[floor - 2][unit - 1].setRoomStatus("워크인");
 * System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
 * System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
 * reservationList[index].setRoomUnit((floor * 100) + unit); index++; break; }
 * 
 * } else if (roomType.equals("더블")) { System.out.
 * println("------------------------ 현재 비어있는 방 ------------------------"); for
 * (int i = 0; i < RF.length; i++) { System.out.print(i + 2 + "층: "); for (int j
 * = 0; j < RF[i].length; j++) { if (RF != null &&
 * RF[i][j].getRoomStatus().equals("빈방") && RF[i][j].getRoomtype().equals("더블"))
 * { System.out.print(RF[i][j].getUnit() + "호"); System.out.print("[" +
 * RF[i][j].getRoomtype() + "] "); System.out.print("\t"); } }
 * System.out.println(); } System.out.println(
 * "-------------------------------------------------------------------------------------------------------------------------"
 * ); System.out.println("숙박할 호실을 입력하세요[000]"); int inputUnit = scan.nextInt();
 * int floor = inputUnit / 100; int unit = inputUnit % 100; if (inputUnit > 520
 * || inputUnit < 201) { System.out.println("올바른 호실을 입력하세요."); break; } else if
 * (inputUnit > 420 && inputUnit < 501) { System.out.println("올바른 호실을 입력하세요.");
 * break; } else if (inputUnit > 320 && inputUnit < 401) {
 * System.out.println("올바른 호실을 입력하세요."); break; } else if (inputUnit > 220 &&
 * inputUnit < 301) { System.out.println("올바른 호실을 입력하세요."); break; } else if
 * (inputUnit % 2 != 0) { System.out.println("올바른 호실을 입력하세요."); break;
 * 
 * // 이미 예약된 방에 중복 예약 가능 } else if (RF[floor - 2][unit -
 * 1].getRoomStatus().equals("예약완료")) { System.out.println("잘못된 입력입니다."); break;
 * } else if (RF[floor - 2][unit - 1].getRoomStatus().equals("숙박중")) {
 * System.out.println("잘못된 입력입니다."); break; } else { RF[floor - 2][unit -
 * 1].setRoomStatus("숙박중"); RF[floor - 2][unit - 1].setRoomStatus("워크인");
 * System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
 * System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
 * reservationList[index].setRoomUnit((floor * 100) + unit); index++; break; }
 * 
 * } else { System.out.println("잘못된 입력입니다."); break; }
 * 
 * case 2: //체크인 System.out.println();
 * System.out.println("------- 체크인 --------"); System.out.print("고객명: ");
 * reservationName = scan.next(); System.out.print("연락처: ");
 * reservationPhoneNumber = scan.next();
 * 
 * int checkIncheck = 0; for (int i = 0; i < reservationList.length; i++) { if
 * (reservationList[i] != null &&
 * reservationList[i].getName().equals(reservationName) &&
 * reservationList[i].getPhoneNumber().equals(reservationPhoneNumber) &&
 * RF[reservationList[i].getRoomUnit() / 100 -
 * 2][reservationList[i].getRoomUnit() % 100 -
 * 1].getRoomStatus().equals("예약완료")) { System.out.
 * println("-------------------------- 예약 확인 --------------------------");
 * System.out.println(i + 1 + "번 고객님"); System.out.println("고객명: " +
 * reservationList[i].getName()); System.out.println("연락처: " +
 * reservationList[i].getPhoneNumber());
 * System.out.print(reservationList[i].getRoomUnit() + "호");
 * System.out.println("["+ RF[reservationList[i].getRoomUnit() / 100-
 * 2][reservationList[i].getRoomUnit() % 100 - 1].getRoomtype() + "]");
 * System.out.println(RF[reservationList[i].getRoomUnit() / 100 -
 * 2][reservationList[i].getRoomUnit() % 100 - 1].getPrice() + "원");
 * checkIncheck++; // 중복 예약 불가 개선 }
 * 
 * }
 * 
 * if (checkIncheck >= 1) { System.out.println("고객번호를 입력하세요."); int inputCheckIn
 * = scan.nextInt(); if (reservationList[inputCheckIn - 1] != null) { int
 * checkInRoomUnit = reservationList[inputCheckIn - 1].getRoomUnit(); int floor
 * = checkInRoomUnit / 100; int unit = checkInRoomUnit % 100; RF[floor - 2][unit
 * - 1].setRoomStatus("숙박중"); RF[floor - 2][unit - 1].setRoomStatus("체크인");
 * System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
 * System.out.println(RF[floor - 2][unit - 1].getRoomStatus()); } else {
 * System.out.println("올바른 고객번호를 입력하세요."); } } // 예약자를 찾아서 없을시 정보없다고 출력 for (int
 * i = 0; i < reservationList.length; i++) { if (reservationList[i] != null &&
 * reservationList[i].getName().equals(reservationName) &&
 * reservationList[i].getPhoneNumber().equals(reservationPhoneNumber)) { break;
 * } else if (reservationList[i] != null &&
 * reservationList[i].getName().equals(reservationName)) {
 * 
 * } else if (reservationList[i] != null &&
 * reservationList[i].getPhoneNumber().equals(reservationPhoneNumber)) {
 * 
 * } else {/* if (reservationList[i] == null ||
 * !reservationList[i].getName().equals(reservationName) ||
 * !reservationList[i].getPhoneNumber().equals(reservationPhoneNumber) ||
 * !reservationList[i].getReservationState().equals("예약") ||
 * reservationList[i].getReservationState().equals("숙박중")) {
 * 
 * System.out.println("예약자 정보를 찾을 수 없습니다."); break; } }
 * 
 * break;
 * 
 * case 3: // 체크아웃 System.out.println("체크아웃할 호실을 입력하세요[000]"); int inputUnit =
 * scan.nextInt(); int floor = inputUnit / 100; int unit = inputUnit % 100; if
 * (inputUnit > 520 || inputUnit < 201) { System.out.println("올바른 호실을 입력하세요.");
 * break; } else if (inputUnit > 420 && inputUnit < 501) {
 * System.out.println("올바른 호실을 입력하세요."); break; } else if (inputUnit > 320 &&
 * inputUnit < 401) { System.out.println("올바른 호실을 입력하세요."); break; } else if
 * (inputUnit > 220 && inputUnit < 301) { System.out.println("올바른 호실을 입력하세요.");
 * break; }
 * 
 * RF[floor - 2][unit - 1].setClean(false); System.out.println(RF[floor -
 * 2][unit - 1].getRoomStatus()); System.out.println(RF[floor - 2][unit -
 * 1].getRoomStatus());
 * 
 * if (RF[floor - 2][unit - 1].getRoomStatus().equals("체크인") || RF[floor -
 * 2][unit - 1].getRoomStatus().equals("워크인") && RF[floor - 2][unit -
 * 1].getRoomStatus().equals("숙박중")) { RF[floor - 2][unit -
 * 1].setRoomStatus("체크아웃"); RF[floor - 2][unit - 1].setClean(false);
 * System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
 * System.out.println(RF[floor - 2][unit - 1].getRoomStatus());
 * 
 * if ("싱글".equals(RF[floor - 2][unit - 1].getRoomtype()) &&
 * "체크아웃".equals(RF[floor - 2][unit - 1].getRoomStatus())) { totalAmount[0] =
 * totalAmount[0] + RF[floor - 2][unit - 1].getPrice(); totalAmount[2] =
 * totalAmount[0] / RF[floor - 2][unit - 1].getPrice(); } else if
 * ("더블".equals(RF[floor - 2][unit - 1].getRoomtype()) && "체크아웃".equals(RF[floor
 * - 2][unit - 1].getRoomStatus())) { totalAmount[1] = totalAmount[1] + RF[floor
 * - 2][unit - 1].getPrice(); totalAmount[3] = totalAmount[1] / RF[floor -
 * 2][unit - 1].getPrice(); } } else { System.out.println("오류");
 * 
 * }
 * 
 * break;
 * 
 * default:
 * 
 * go = false; break; } case 5:
 * 
 * return totalAmount;
 * 
 * default: System.out.println("올바른 메뉴를 입력하세요."); break; } } return totalAmount;
 * } }
 * 
 * 
 * 
 */
