import java.util.List;

public interface IDeskManage {
	// 예약
	void reservation(Room room, Customer cus);
	// 예약취소?
	void cancelReservation(Customer cus);
	// 예약 확인 
	void checkReservation(Customer cus);
	// 방 고객(체크인)
	void checkIn (Customer cus);
	// 체크아웃
	void checkOut(Customer cus);
	// 워크인? 예약?
	void walkeIn(Customer cus);
	// 고객검색
	Customer findCustomer(List<Customer> list, String name, String phone);
	// 명단접근
	int listAccess(List<Customer> list, Customer cus);
	
}
