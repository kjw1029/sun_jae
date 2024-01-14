import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Desk extends Person implements IDeskManage{
	private Scanner scan = new Scanner(System.in);
	public Desk() {
		super();
	}


	@Override
	public void reservation(Room room, Customer cus) {
		if (cus.getUnit() == room.getUnit()) {
			if (room.getRoomStatus().equals("예약")) {
				System.out.println("예약되어있는 방입니다.");
			} else if (room.getRoomStatus().equals("빈방")) {
				System.out.println("예약 완료");
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	@Override
	public void cancelReservation(Room[][] room, Customer cus) {
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				if(room[i][j].getCustomer().getUnit() ==cus.getUnit()) {
					System.out.println(room[i][j].getUnit()+"취소");
					room[i][j].setRoomStatus("빈방");
					cus.setUnit(0);
				}
			}
		}
		
	}
	
	@Override
	public void checkReservation(Room[][] room, Customer cus) {
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				if(room[i][j].getCustomer().getUnit() ==cus.getUnit()) {
					System.out.println(room[i][j].getUnit()+ "예약된방");
					
				}
			}
		}
	}
	
	@Override
	public Customer findCustomer(List<Customer> list, String name, String phone) {
		Iterator<Customer> iterator = list.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getName().equals(name) && iterator.next().getNumber().equals(phone)) {
				return iterator.next();
			}
		} return null;
	}
	
	@Override
	public int listAccess(List<Customer> list, Customer cus) {
		for (int i = 0; i < list.size(); i++) {
			if(list.contains(cus)) {
				return i;
			}
		}return -1;
	}

	@Override
	public void checkOut(Customer cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void walkeIn(Customer cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkIn(Room[][] room, Customer cus) {
		// TODO Auto-generated method stub
		
	}


	public void printMenu() {
		while (true) {
			System.out.println();
//            System.out.println("------------------------------------------------------------*------------------------------------------------------------");
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
					Room room = new Room(roomType);
					Customer cus = new Customer(guestName, phoneNumber);

					reservation(room, cus);
			}
		}
	}
}
