import java.util.Iterator;
import java.util.List;

public class Desk extends Person implements IDeskManage{
	public Desk() {
		super();
	}
	
	@Override
	void reservation(Room room, Customer cus) {
//		this(); // 왜 생성자가 안되는거죠? 알려주세요..
		if (this.unit == roomunit.getUnit()) {
			if (roomunit.getRoomstatus().equals("예약")) {
				System.out.println("예약되어있는 방입니다.");
			} else if (roomunit.getRoomstatus().equals("빈방")) {
				System.out.println("예약 완료");
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	@Override
	void cancelReservation(Room[][] room, Customer cus) {
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				if(room[i][j].getCustomer ==cus.getunit) {
					System.out.println(room[i][j].getUnit());
					room[i][j].setRoomstatus("빈방");
					cus.setunit(0);
				}
			}
		}
		
	}
	
	@Override
	void checkIn (Room[][] room, Customer cus) {
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				if(room[i][j].getCustomer ==cus.getunit) {
					System.out.println(room[i][j].getUnit());
					room[i][j].setRoomstatus("빈방");
					cus.setunit(0);
				}
			}
		}
	}
	
	@Override
	Customer findCustomer(List<Customer> list, String name, String phone) {
		Iterator<Customer> iterator = list.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getName().equals(name) && iterator.next().getPhone(phone)) {
				return iterator.next();
			}
		} return null;
	}
	
	@Override
	int listAccess(List<Customer> list, Customer cus) {
		for (int i = 0; i < list.size(); i++) {
			if(list.contains(cus)) {
				return i;
			}
		}return -1;
	}
	
}
